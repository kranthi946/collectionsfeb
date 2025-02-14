package org.example.testpackage;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class practise {


    public static void main(String[] args) {




        String s = "kranrthiatta";


      String[]  f =   s.split("");

        LinkedHashMap<String, Long> filtered = Arrays.stream(f).collect(Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting()));


        String noRepeated = Arrays.stream(f).filter(c -> filtered.get(c) > 1)


                .distinct()
                .findFirst()
                .orElse("no repeated");


        System.out.println(noRepeated);

    }
}
