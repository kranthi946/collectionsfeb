package org.example.testpackage;

import java.sql.Struct;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Programs {

    public static void main(String[] args) {

        List<Integer> nums = List.of(1, 2, 3, 4 ,3,4,3,3,2,3,5, 6, 7, 8, 9, 10);


        // we need to map to int because integer to int we need to convert
       int sum =  nums.stream().mapToInt(Integer::intValue).sum();

       System.out.println(sum);

     int max =   nums.stream().max(Comparator.naturalOrder()).get();

     System.out.println(max);

     List<String> fruits = List.of("apple", "orange", "banana");

    long count =  fruits.stream().filter(fruit -> fruit.startsWith("o")).count();
    System.out.println(count);


    fruits.stream().map(String::toUpperCase).forEach(System.out::println);

   long countofeven =  nums.stream().filter(num -> num% 2 == 0).count();
   System.out.println(countofeven);


   List<Double> doublenums = List.of(2.2,3.3,4.4);
     double avg =    doublenums.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
     System.out.println(avg);


    String concatenatedFruits =  fruits.stream().collect(Collectors.joining(","));

    System.out.println(concatenatedFruits);



    nums.stream().distinct().forEach(System.out::println);


    }
}
