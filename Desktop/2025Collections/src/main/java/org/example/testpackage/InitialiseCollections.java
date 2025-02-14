package org.example.testpackage;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class InitialiseCollections {

    public static void main(String[] args) {

        // HashMap: No specific order of elements, faster for general use.


        Map<String, Integer> map = new HashMap<>();
        map.put("c", 3);
        map.put("b", 2);
        map.put("a", 1);
        System.out.println("HashMap: " + map); // Output will not guarantee insertion order

        //using foreach

        map.forEach((key,value) -> System.out.println(key + " : " + value) );



//using entryset



        for(Map.Entry<String,Integer> entry : map.entrySet()){

            entry.getKey();
            entry.getValue();

        }


        //keyset
        for(String key: map.keySet()){
            System.out.println(key + " : " + map.get(key));

        }


        //values

        for(Integer value: map.values()){

            System.out.println(value);
        }


        Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();

        while(iterator.hasNext()){
      Map.Entry<String,Integer> entry   =  iterator.next();

      entry.getKey();
      entry.getValue();

      System.out.println(entry.getKey() + " : " + entry.getValue());
        }




        // LinkedHashMap: Maintains the insertion order of the elements.


        Map<String, Integer> map2 = new LinkedHashMap<>();
        map2.put("c", 3);
        map2.put("b", 2);
        map2.put("a", 1);
        System.out.println("LinkedHashMap: " + map2); // Output will maintain insertion order

        // TreeMap: Stores keys in a sorted order (natural order or using a comparator).


        Map<String, Integer> map3 = new TreeMap<>();
        map3.put("c", 3);
        map3.put("b", 2);
        map3.put("a", 1);
        System.out.println("TreeMap: " + map3); // Output will be sorted by key (alphabetical order)

        // Hashtable: No specific order, similar to HashMap but is thread-safe.



        Map<String, Integer> map4 = new Hashtable<>();
        map4.put("c", 3);
        map4.put("b", 2);
        map4.put("a", 1);
        System.out.println("Hashtable: " + map4); // Output will not guarantee insertion order

        // ConcurrentHashMap: No specific order, like HashMap, but it is thread-safe.



        Map<String, Integer> map5 = new ConcurrentHashMap<>();
        map5.put("c", 3);
        map5.put("b", 2);
        map5.put("a", 1);
        System.out.println("ConcurrentHashMap: " + map5); // Output will not guarantee insertion order
    }





}
