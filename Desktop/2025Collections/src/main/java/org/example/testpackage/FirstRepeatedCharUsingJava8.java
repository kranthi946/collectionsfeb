package org.example.testpackage;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FirstRepeatedCharUsingJava8 {

    public static void main(String[] args) {

        String s = "kranrthiatta";

        // Convert string to an array of characters
        String[] d = s.split("");

        // Print the array of characters (just for visualization)
        System.out.println(Arrays.toString(d));

//        // Group characters by their occurrences and count them, using LinkedHashMap to preserve order
        Map<String, Long> filtered = Arrays.stream(d)
                .collect(Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting()));

        // Find the first character that repeats (occurs more than once)
        String firstRepeatedChar = Arrays.stream(d)  // Stream the original character array
                .filter(c -> filtered.get(c) > 1)   // Filter only repeated characters
                .distinct()  // Ensure only the first occurrence of each repeated character is considered
                .findFirst()  // Get the first repeated character
                .orElse("No repeated character");  // If no repeated character is found, return a default message

        // Output the result
        System.out.println("First repeated character: " + firstRepeatedChar);
    }
}
