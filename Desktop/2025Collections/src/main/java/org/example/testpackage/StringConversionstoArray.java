package org.example.testpackage;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringConversionstoArray {


    public static void main(String[] args) {


        String s = "hello world";


        s.chars().mapToObj(c -> (char)c).forEach(System.out::println);



       String[]    result =  s.split("");

       Stream<String>   stream = Arrays.stream(result);

      System.out.println(Arrays.toString(result));


     String cs =  s
              .replaceAll("\\s","")
              .toLowerCase();

    String[] sa =  cs.split("");

   Stream<String> stream1 =  Arrays.stream(sa);
   System.out.println(Arrays.toString(sa));




    }
}
