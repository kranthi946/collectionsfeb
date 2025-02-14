package org.example.testpackage;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DupCharString {


    public static void main(String[] args) {




        String s = "kranrthikkatta";

      String[]  d =   s.split("");

      System.out.println(Arrays.toString(d));


        Map<String, Long> filtered =   Arrays.stream(d)

              .collect(Collectors.groupingBy(e -> e, Collectors.counting()))


              .entrySet()
              .stream()

//              .filter(v -> v.getValue()>1)

                      .sorted(Map.Entry.comparingByKey())

                              .collect(Collectors.toMap(

                                      Map.Entry::getKey,
                                      Map.Entry::getValue,
                                      (e1, e2) -> e1,

                                      LinkedHashMap::new


                              ));


    System.out.println(filtered);


        byte b = 5;
        char c = 'A';  // 65 in ASCII
        int i = 10;
        long l = 100L;

        long result = b + c - i + l + 1;

        System.out.println(result);
/*Step 1 (b + c): 70
Step 2 (b + c - i): 60
Step 3 (b + c - i + l): 160
Step 4 (b + c - i + l + 1): 161
Final Result: 161*/



                int[] numbers = {1, 2, 3, 5};  // Given numbers
                int n = 5;  // Largest number in the sequence

                // Calculate the expected sum using IntStream
                int expectedSum = java.util.stream.IntStream.rangeClosed(1, n)
                        .sum();

                // Calculate the actual sum of the given numbers using Arrays.stream
                int actualSum = Arrays.stream(numbers)
                        .sum();

                // The missing number is the difference
                int missingNumber = expectedSum - actualSum;

                System.out.println("The missing number is: " + missingNumber);


        List<Integer> numberList = Arrays.asList(1, 2, 3,0,-1,0,2, 5);

      List<Integer> F =   Stream.concat(numberList.stream().filter(p->p!=0),numberList.stream().filter(p->p==0)).collect(Collectors.toUnmodifiableList());
        System.out.println(F);


            }

        }






