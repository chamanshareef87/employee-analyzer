package com.bigcompany.employeeanalyzer.csvreader;

import com.bigcompany.employeeanalyzer.entity.Employee;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class EmployeeCSVReader {

    public static Map<Integer, Employee> readEmployees(String fileName) throws Exception {
        Map<Integer, Employee> employeeMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                EmployeeCSVReader.class.getClassLoader().getResourceAsStream(fileName)))) {

            String line = reader.readLine(); // skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String firstName = parts[1];
                String lastName = parts[2];
                double salary = Double.parseDouble(parts[3]);
                Integer managerId = parts.length > 4 && !parts[4].isEmpty() ? Integer.parseInt(parts[4]) : null;

                Employee emp = new Employee(id, firstName, lastName, salary, managerId);
                employeeMap.put(id, emp);
            }
        }

        // Build manager-subordinate relationships
        for (Employee emp : employeeMap.values()) {
            if (emp.getManagerId() != null) {
                Employee manager = employeeMap.get(emp.getManagerId());
                if (manager != null) {
                    manager.addSubordinate(emp);
                }
            }
        }

        return employeeMap;
    }
}
