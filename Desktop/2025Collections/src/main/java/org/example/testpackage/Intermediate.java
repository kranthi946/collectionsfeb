package org.example.testpackage;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Intermediate {

    public static void main(String[] args) {

        // 1. Counting Word Frequencies (Case-Insensitive)
        System.out.println("1. Counting Word Frequencies (Case-Insensitive)");
        String sentence = "Java is a programming . Java is versatile";
        String[] words = sentence.split("\\s+");
      //  Map<String, Long> wf = Stream.of(words) // Convert array to stream



        Map<String, Long> wf = Arrays.stream(words) .collect(Collectors.groupingBy(String::toUpperCase, Collectors.counting()));
        System.out.println(wf);
        System.out.println();

        // 2. Filtering Numbers Starting with '4'
        System.out.println("2. Filtering Numbers Starting with '4'");
        List<Integer> nums = Arrays.asList(11, 12, 12, 24, 323, 4, 333, 4, 3, 444);

        //convert the number to string and collect to list
        nums.stream().filter(n -> String.valueOf(n).startsWith("4"))
                .collect(Collectors.toList()).forEach(System.out::println);


        System.out.println();

        // 3. Grouping Names by First Character and Counting
        System.out.println("3. Grouping Names by First Character and Counting");
        String[] names = {"Alice", "Bob", "Amy", "Anna"};
        Map<Character, Long> nm = Arrays.stream(names)
                .collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.counting()));
        System.out.println(nm);
        System.out.println();

        // 4. Grouping and Counting Elements in an Array (with Occurrence > 1)
        System.out.println("4. Grouping and Counting Elements in an Array (with Occurrence > 1)");


        int[] arr = {11, 12, 12, 24, 323, 4, 333, 1, 2, 3, 1, 1, 1, 1, 1, 2, 4, 3, 444};
        Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .sorted()  // Sorting the elements in ascending order
                .collect(Collectors.toList()).forEach(System.out::println);
        System.out.println();


        // 4. Grouping and Counting Elements in an Array (with Occurrence > 1)
        System.out.println("---- banana ----");

        // Example string array
        String[] arr7 = {"apple", "banana", "blueberry", "orange", "banana", "grape", "apple", "kiwi"};

        // Grouping, counting, and filtering strings that start with 'b'


        Arrays.stream(arr7)
                .filter(e -> e.startsWith("b"))  // Filter to include only strings starting with 'b'
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))  // Grouping by each string and counting occurrences
                .entrySet().stream()  // Stream the map entries
//                .filter(e -> e.getValue() > 1)  // Filter for elements that occur more than once
                .map(Map.Entry::getKey)  // Extract the key (the element itself)
                .sorted()  // Sorting the elements in ascending order
                .collect(Collectors.toList())  // Collect the sorted result into a list
                .forEach(System.out::println);  // Print each element

        System.out.println();


        // 5. Removing Duplicates from an Array
        System.out.println("5. Removing Duplicates from an Array");
        int[] arr2 = Arrays.stream(arr).distinct().toArray();
        System.out.println(Arrays.toString(arr2));
        System.out.println();



        //practise this




        // 6. Finding Palindromes from a List of Strings
        System.out.println("6. Finding Palindromes from a List of Strings");
        List<String> strings = List.of("level", "hello", "radar");
        strings.stream().filter(str -> str.equals(new StringBuilder(str).reverse().toString()))
                .collect(Collectors.toList()).forEach(System.out::println);
        System.out.println();

        // 7. Checking If a String Is a Palindrome
        System.out.println("7. Checking If a String Is a Palindrome");
        String s = "madam madam";


        boolean isPalindrome = s.equals(


                Arrays.stream(s.split(""))
                        .collect(Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> {
                                    Collections.reverse(list);
                                    return list.stream();
                                }
                        ))
                        .collect(Collectors.joining())
        );
        System.out.println(isPalindrome ? "is palindrome" : "is not palindrome");
        System.out.println();

        // 8. Merging and Sorting Two Arrays
        System.out.println("8. Merging and Sorting Two Arrays");
        int[] ar1 = {1, 3, 5, 7};
        int[] ar2 = {2, 3, 4, 5};
        int[] sortedArray = IntStream.concat(Arrays.stream(ar1), Arrays.stream(ar2))
                .sorted().toArray();
        System.out.println(Arrays.toString(sortedArray));
        System.out.println();

        // 9. Merging Two Lists and Removing Duplicates
        System.out.println("9. Merging Two Lists and Removing Duplicates");
        List<String> list1 = List.of("aple", "banana", "oranga");
        List<String> list2 = List.of("apple", "kiwi", "grape");
        List<String> uniquelist = Stream.concat(list1.stream(), list2.stream())
                .distinct().collect(Collectors.toList());
        System.out.println(uniquelist);
        System.out.println();

        // 10. Sorting Strings in a List by Length
        System.out.println("10. Sorting Strings in a List by Length");
        list1.stream().sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);






    }
}
