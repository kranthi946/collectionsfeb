package org.example.testpackage;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Interviewstreams {

    public static void main(String[] args) {

        String s = "world hello";

        Stream<String> stream = Arrays.stream(s.split(" "));





      boolean isPalindrome  = s.equals(stream.collect(Collectors.collectingAndThen(


              Collectors.toList(),


              list -> {
                  Collections.reverse(list);


                  return list.stream();
              }

              ))

              .collect(Collectors.joining(" "))) ;



      System.out.println(isPalindrome);







    int[] ar = {1,2,3,4,5};

   IntStream stream2 =  Arrays.stream(ar);

        String reversedarray  = stream2.boxed().collect(Collectors.collectingAndThen(

            Collectors.toList(),


            list -> {

                Collections.reverse(list);

                return list.stream();

            }


    )).map(String::valueOf)
            .collect(Collectors.joining(", ", "{", "}"));


        System.out.println("reversed array : " + reversedarray);


        int[] k = {3,1,2,3,4,5};



     int  target = 3;


 IntStream.range(0,k.length)

             .filter(i -> k[i] == target)

                     .forEach(i -> System.out.println("Target found : " + i ));



        // Find the last occurrence of the target

        OptionalInt lastIndex = IntStream.range(0, k.length)
                .filter(i -> k[i] == target)
                .reduce((first, second) -> second); // Keep the last index

        lastIndex.ifPresent(i -> System.out.println("Last target found at index: " + i));


                // Step 1: Filter indices where target occurs
                List<Integer> targetIndices = IntStream.range(0, k.length)
                        .filter(i -> k[i] == target)
                        .boxed()
                        .collect(Collectors.toList());

                // Step 2: Calculate the middle index of the target indices list
                if (!targetIndices.isEmpty()) {
                    int middleIndex = targetIndices.size() / 2;
                    System.out.println("Middle target found at index: " + targetIndices.get(middleIndex));
                } else {
                    System.out.println("Target not found.");
                }






/*
System.out.println(index);

// Output the result
        if (index.isPresent()) {
            System.out.println("Target found at index: " + index.getAsInt());
        } else {
            System.out.println("Target not found");
        }*/




        int[] ar3 = {3,1,2,3,4,5};



        IntSummaryStatistics stats =     Arrays.stream(ar3).boxed().collect(Collectors.summarizingInt( e -> e));

        System.out.println(stats);
        // Output the summary statistics
        System.out.println("Max value: " + stats.getMax());
        System.out.println("Min value: " + stats.getMin());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Count: " + stats.getCount());
        System.out.println("Average: " + stats.getAverage());






        int[] arr = {11, 12, 12, 24, 323, 4, 333, 1, 2, 3, 1, 1, 1, 1, 1, 2, 4, 3, 444};



        Arrays.stream(arr)

                .boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue()>1)

                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList())
                .forEach(System.out::println);



        String sentence = "kranthi k kranthi";

     String[] sa =    sentence.split("\\s+");


     System.out.println(Arrays.toString(sa));


   String[] a =   Arrays.stream(sa)

                   .map(String::toLowerCase)   // here we need convert all words to upper or lower case senstive


           .distinct()
           .toArray(String[] ::new);

        System.out.println(Arrays.toString(a));




        String f = "Java is fun";

      String[]  x =   f.split("");

      System.out.println(Arrays.toString(x));
      Stream<String> stream4 = Arrays.stream(x);


      Map<String,Long>   fd =   stream4.collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));


      System.out.println(fd);





     List<Integer> d =  List.of(1,2,3,4,5,6,8);

     d.stream().map(n -> n % 2 == 0 ? "even is " + n :"odd is " + n ).forEach(System.out::println);

    }







}