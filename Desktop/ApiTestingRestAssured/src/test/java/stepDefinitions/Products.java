package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Products {

    RequestSpecification httpRequest;
    Response response;

    @Given("I set the base URI to {string}")
    public void setBaseURI(String baseURI) {
        RestAssured.baseURI = baseURI;
        httpRequest = given();
        httpRequest.header("Content-Type", "application/json");
    }

    @When("I send a POST request to \\/products with product title {string}") // Escaped '/'
    public void createProduct(String productTitle) {
        JSONObject product = new JSONObject();
        product.put("title", productTitle);
        product.put("price", 13.5);
        product.put("description", "lorem ipsum set");
        product.put("image", "https://i.pravatar.cc");
        product.put("category", "electronic");

        httpRequest.body(product.toString());
        response = httpRequest.post("/products");
    }

    @Then("I receive a response with status code {int}")
    public void verifyStatusCode(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @Then("the response body should contain the following title: {string}")
    public void verifyResponseBody(String expectedTitle) {
        response.then().body("title", equalTo(expectedTitle));
     /*   response.then().body("id", notNullValue()); //Very Important to check ID after POST
        //Add more assertions here for other fields if needed, like price, description, etc.
        response.then().body("price", equalTo(13.5)); //Example: Assert price
        response.then().body("description", equalTo("lorem ipsum set")); //Example: Assert description
        response.then().body("category", equalTo("electronic")); //Example: Assert category
        response.then().body("image", notNullValue()); //Example: Assert image (just check it's present)
*/
    }
}