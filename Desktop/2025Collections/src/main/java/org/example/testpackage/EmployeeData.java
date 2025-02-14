package org.example.testpackage;

import java.util.ArrayList;

public class EmployeeData {

    public static ArrayList<Employee> get() {
        ArrayList<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(1, "Kranthi", "Reddy", "Development1", "Software Engineer", 1000.00, 30));
        employeeList.add(new Employee(2, "John", "Doe", "HR", "HR Manager", 1200.00, 35));
        employeeList.add(new Employee(3, "Alice", "Smith", "Finance1", "Financial Analyst", 1100.00, 28));
        employeeList.add(new Employee(4, "Bob", "Johnson", "Marketing", "Marketing Director", 1500.00, 40));
        employeeList.add(new Employee(5, "Eva", "Brown", "Finance", "Sales Manager", 1300.00, 32));
        employeeList.add(new Employee(6, "Charlie", "Davis", "Engineering", "DevOps Engineer", 1150.00, 27));
        employeeList.add(new Employee(7, "David", "Martinez", "Development", "Software Developer", 1050.00, 25));
        employeeList.add(new Employee(8, "Grace", "Garcia", "Product", "Product Manager", 1400.00, 33));
        employeeList.add(new Employee(9, "Hannah", "Lee", "IT Support", "IT Support Specialist", 950.00, 29));
        employeeList.add(new Employee(10, "Zack", "Miller", "Operations", "Operations Manager", 1450.00, 38));

        return employeeList;
    }
}
