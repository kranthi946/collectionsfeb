package org.example.testpackage;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCollectordemo2 {

    public static void main(String[] args) {
        // Get the list of students
        List<Student> students = Student.getStudentList();

        // Group students by year and map each student to their projects
        Map<Integer, List<List<Student.Project>>> groupedByYear = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getYear,  // Group by year
                        Collectors.mapping(
                                student -> student.getProjects(),  // For each student, get the list of projects
                                Collectors.toList()  // Collect the list of projects
                        )
                ));

        System.out.println(groupedByYear);


        Map<Integer, List<Student.Project>> newlist = students.stream().collect(Collectors.groupingBy(
                Student::getYear,

                Collectors.flatMapping(

                        s -> s.getProjects().stream(), Collectors.toList()
                )

        ));


        System.out.println(newlist);
    }
}
