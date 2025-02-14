package org.example.testpackage;

import java.util.Arrays;
import java.util.List;

public class Student {
    private String studentName;
    private int year;
    private List<Project> projects;



    // Constructor for Student
    public Student(String studentName, int year, List<Project> projects) {
        this.studentName = studentName;
        this.year = year;
        this.projects = projects;
    }

    // Getter methods
    public String getStudentName() {
        return studentName;
    }

    public int getYear() {
        return year;
    }

    public List<Project> getProjects() {
        return projects;
    }
    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", year=" + year +
                ", projects=" + projects +
                '}';
    }

    // Method to return the list of students
    public static List<Student> getStudentList() {
        return Arrays.asList(
                new Student("MIKE", 2021, Arrays.asList(new Project("Project 1"), new Project("Project 2"))),
                new Student("ALICE", 2022, Arrays.asList(new Project("Project 3"), new Project("Project 4"))),
                new Student("BOB", 2023, Arrays.asList(new Project("Project 5"), new Project("Project 6"))),
                new Student("CHARLIE", 2024, Arrays.asList(new Project("Project 7"), new Project("Project 8"))),
                new Student("DAVID", 2021, Arrays.asList(new Project("Project 9"), new Project("Project 10"))),
                new Student("EVE", 2022, Arrays.asList(new Project("Project 11"), new Project("Project 12"))),
                new Student("FRANK", 2023, Arrays.asList(new Project("Project 13"), new Project("Project 14"))),
                new Student("GRACE", 2024, Arrays.asList(new Project("Project 15"), new Project("Project 16"))),
                new Student("HEIDI", 2021, Arrays.asList(new Project("Project 17"), new Project("Project 18"))),
                new Student("IVAN", 2022, Arrays.asList(new Project("Project 19"), new Project("Project 20")))
        );
    }

    // Project class to represent individual projects
    public static class Project {
        private String projectName;

        // Constructor for Project
        public Project(String projectName) {
            this.projectName = projectName;
        }

        // Getter method
        public String getProjectName() {
            return projectName;
        }
        @Override
        public String toString() {
            return "Project{" +
                    "projectName='" + projectName + '\'' +
                    '}';
        }

    }

    // Main method to test the functionality
    public static void main(String[] args) {
        List<Student> studentList = Student.getStudentList();

        // Printing the list of students and their projects
        for (Student student : studentList) {
            System.out.println("Student: " + student.getStudentName() + " (" + student.getYear() + ")");
            for (Project project : student.getProjects()) {
                System.out.println("  Project: " + project.getProjectName());
            }
        }
    }
}
