package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.util.List;
import static org.junit.Assert.*;

public class Animals {

    private String accessToken;
    private Response response;

    @Given("I am an authenticated user")
    public void iAmAnAuthenticatedUser() {
        RestAssured.baseURI = "https://api.petfinder.com/v2";
        response = RestAssured.given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("grant_type", "client_credentials")
                .formParam("client_id", "Le5c1q4Hebl7qDhYb1MVwhiYrAE4TJvkzSJrua5ncLomWr2CUC") // **REPLACE WITH YOUR CLIENT ID**
                .formParam("client_secret", "chlNS5sbhmgjlA2QftZyfvw7muJ8jmhug2pz9zIG") // **REPLACE WITH YOUR CLIENT SECRET**
                .when()
                .post("/oauth2/token");

        System.out.println("Authentication Response:"); // Print the entire auth response for debugging
        response.prettyPrint(); // Print the response body in a readable format

        assertEquals(200, response.getStatusCode());

        JsonPath jsonPath = response.jsonPath();
        accessToken = jsonPath.getString("access_token");

        System.out.println("Access Token: " + accessToken); // Print the access token
        assertNotNull("Access Token should not be null", accessToken);
    }

    @When("I hit the get animals API URL")
    public void iHitTheGetAnimalsAPIURL() {
        response = RestAssured.given()
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get("/types");

        System.out.println("Get Animals Response:"); // Print the entire get animals response
        response.prettyPrint();
    }

    @Then("I get {int} as response code")
    public void iGetAsResponseCode(int expectedResponseCode) {
        assertEquals(expectedResponseCode, response.getStatusCode());
    }

    @Then("I get animals in the response body of the API")
    public void iGetAnimalsInTheResponseBodyOfTheAPI() {
        JsonPath jsonPath = response.jsonPath();
        List<String> types = jsonPath.getList("types.name");

        System.out.println("Animal Types: " + types); // Print the retrieved types

        assertNotNull("Types array should not be null", types);
        assertFalse("Types array should not be empty", types.isEmpty());
    }

    @Given("I am an unauthenticated user")
    public void iAmAnUnauthenticatedUser() {
        RestAssured.baseURI = "https://api.petfinder.com/v2";
        response = RestAssured.given()
                .when()
                .get("/types");

        System.out.println("Unauthenticated Get Animals Response:"); // Print the response
        response.prettyPrint();
    }

    @When("I hit the get animals API URL without authentication")
    public void iHitTheGetAnimalsAPIURLWithoutAuthentication() {
        // API call is now in the @Given, so this can be empty or removed.
    }

    @Then("I get {int} as the response code")
    public void iGetAsTheResponseCode(int expectedResponseCode) {
        assertEquals(expectedResponseCode, response.getStatusCode());
    }

    @Then("I do not get animals in the response body of the API")
    public void iDoNotGetAnimalsInTheResponseBodyOfTheAPI() {
        JsonPath jsonPath = response.jsonPath();
        List<String> types = jsonPath.getList("types.name");

        System.out.println("Unauthenticated Animal Types: " + types); // Print (might be null)

        if (types != null) {
            assertTrue("Types array should be empty", types.isEmpty());
        }
    }
}