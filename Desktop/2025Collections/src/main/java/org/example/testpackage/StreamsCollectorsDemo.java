package org.example.testpackage;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class StreamsCollectorsDemo {


    public static void main(String[] args) {


      List<Employee> employees =  EmployeeData.get();

/*


     String empjoined =  employees.stream().map(Employee::getFirstname)
              .collect(Collectors.joining(","));


     System.out.println(empjoined);




   Map<Boolean,List<Employee>> empsal25k = employees.stream()

             .collect(Collectors.partitioningBy(e -> e.getSalary()>500.00));

//   System.out.println(empsal25k);
// Print employees with salary greater than 500
        System.out.println("Employees with salary greater than 500:");
        empsal25k.get(true).forEach(e -> System.out.println("Name: " + e.getFirstname() + " " + e.getLastname() + ", Salary: " + e.getSalary()));

        // Print employees with salary less than or equal to 500
        System.out.println("\nEmployees with salary less than or equal to 500:");
        empsal25k.get(false).forEach(e -> System.out.println("Name: " + e.getFirstname() + " " + e.getLastname() + ", Salary: " + e.getSalary()));


        Map<Boolean, Set<Employee>> collect = employees.stream()

                .collect(Collectors.partitioningBy(e -> e.getSalary() > 500.00, Collectors.toSet()));

       System.out.println("Employees with salary greater than 500:" +  collect);



        Map<Boolean, List<String>> collect1 = employees.stream()

                .collect(Collectors.partitioningBy(e -> e.getSalary() > 500.00, Collectors.mapping(Employee::getFirstname, Collectors.toList())));


        String x = "Employees with salary greater than 500:" + collect1;
        System.out.println(x);
*/


        Map<String, List<String>> collect2 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getFirstname, Collectors.toList())));

      //  System.out.println(collect2);


      /*  Map<String, Optional<Double>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getSalary, Collectors.reducing((a, b) -> a + b))));

       // System.out.println(collect);

        //instead of above we can do like this

//instead of optional this is more clear
        Map<String, Double> collect1 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.summingDouble(Employee::getSalary)
                ));

      //  System.out.println(collect1);


        Map<String, DoubleSummaryStatistics> collect3 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summarizingDouble(Employee::getSalary)));


       // System.out.println(collect3);


        DoubleSummaryStatistics dev = employees.stream().collect(Collectors.filtering(e -> e.getDepartment().equalsIgnoreCase("development"), Collectors.summarizingDouble(Employee::getSalary)));


        System.out.println(dev);*/



       employees.stream()

               .filter(e -> e.getDepartment().toLowerCase().startsWith("f"))
               .collect(Collectors.groupingBy(

e -> e.getDepartment().charAt(0),


               LinkedHashMap::new,     // this map contains key as  department first letter and values as filtered employee right??

               Collectors.collectingAndThen(

                       Collectors.toMap(


                               Employee::getDepartment,  // from hashmap we are getting this ?? or from employee class

                               Employee::getSalary, // same question

                               (a, b) -> a + b),  // what we do here

                       m -> m.entrySet().stream()   // where this m getting called from abovr linked hashmap ???

                               .sorted(Map.Entry.<String, Double>comparingByValue().reversed())

                               .collect(Collectors.toMap(


                                       Map.Entry::getKey,
                                       Map.Entry::getValue,

                                       (e1,e2) -> e2,
                                       LinkedHashMap::new)
                               )
               )));


        Optional<Employee> collect = employees.stream().collect(Collectors.maxBy((e1, e2) -> e1.getAge() - e2.getAge()));

       // System.out.println(collect.get());

        collect.ifPresent(e -> System.out.println(e.getFirstname() + " " + e.getSalary() + " " + e.getAge()));


        Optional<Employee> collect1 = employees.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getAge)));

        // System.out.println(collect.get());

        collect.ifPresent(e -> System.out.println(e.getFirstname() + " " + e.getSalary() + " " + e.getAge()));


        String notFound = employees.stream()
                .collect(Collectors.collectingAndThen(


                        Collectors.maxBy(Comparator.comparing(Employee::getSalary)),

                        empopt -> empopt.map(e -> e.getFirstname()).orElse("not found")


                ));

        System.out.println(notFound);


    }




}
