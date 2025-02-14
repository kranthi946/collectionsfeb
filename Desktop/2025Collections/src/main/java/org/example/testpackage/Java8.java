package org.example.testpackage;

import java.util.stream.IntStream;

public class Java8 {

  //  print 1 to 100

    public static void main(String[] args) {


        IntStream.rangeClosed(2, 100)


                .filter(n -> n>1 && IntStream.rangeClosed(2,(int)Math.sqrt(n))

                .noneMatch(i -> n % i == 0))
                .forEach(System.out::println);


    }
}