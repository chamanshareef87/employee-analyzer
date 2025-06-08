package com.bigcompany.employeeanalyzer.service;

import com.bigcompany.employeeanalyzer.entity.Employee;

import java.util.*;

public class EmployeeAnalyzer {

    private final Map<Integer, Employee> employees;

    public EmployeeAnalyzer(Map<Integer, Employee> employees) {
        this.employees = employees;
    }

    public void analyzeSalaries() {
        for (Employee manager : employees.values()) {
            List<Employee> subs = manager.getSubordinates();
            if (!subs.isEmpty()) {
                double avg = subs.stream().mapToDouble(Employee::getSalary).average().orElse(0);
                double min = avg * 1.2;
                double max = avg * 1.5;
                double salary = manager.getSalary();

                if (salary < min) {
                    System.out.printf("Manager %s earns %.2f less than required minimum %.2f%n",
                            manager, min - salary, min);
                } else if (salary > max) {
                    System.out.printf("Manager %s earns %.2f more than allowed maximum %.2f%n",
                            manager, salary - max, max);
                }
            }
        }
    }

    public void analyzeReportingDepth() {
        Employee ceo = employees.values().stream()
                .filter(e -> e.getManagerId() == null)
                .findFirst()
                .orElse(null);


        if (ceo == null) {
            System.out.println("No CEO found.");
            return;
        } else {
            System.out.println("CEO found: " + ceo);
        }

        Map<Employee, Integer> depthMap = new HashMap<>();
        dfs(ceo, 0, depthMap);

        for (Map.Entry<Employee, Integer> entry : depthMap.entrySet()) {
            if (entry.getValue() > 4) {
                System.out.printf("Employee %s has reporting depth %d (exceeds by %d)%n",
                        entry.getKey(), entry.getValue(), entry.getValue() - 4);
            }
        }
    }

    private void dfs(Employee e, int depth, Map<Employee, Integer> depthMap) {
        depthMap.put(e, depth);
        for (Employee sub : e.getSubordinates()) {
            dfs(sub, depth + 1, depthMap);
        }
    }
}
