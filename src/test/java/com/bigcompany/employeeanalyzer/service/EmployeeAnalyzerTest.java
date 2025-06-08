package com.bigcompany.employeeanalyzer.service;

import com.bigcompany.employeeanalyzer.entity.Employee;
import com.bigcompany.employeeanalyzer.service.EmployeeAnalyzer;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

class EmployeeAnalyzerTest {

    @Test
    void testAnalyzeSalariesAndReportingDepth() {
        Employee ceo = new Employee(1, "CEO", "Boss", 200000, null);
        Employee mgr = new Employee(2, "Manager", "One", 100000, 1);
        Employee emp = new Employee(3, "Worker", "Bee", 50000, 2);

        ceo.addSubordinate(mgr);
        mgr.addSubordinate(emp);

        Map<Integer, Employee> employees = new HashMap<>();
        employees.put(1, ceo);
        employees.put(2, mgr);
        employees.put(3, emp);

        EmployeeAnalyzer analyzer = new EmployeeAnalyzer(employees);

        // These just check that the methods run without exceptions
        analyzer.analyzeSalaries();
        analyzer.analyzeReportingDepth();
    }
}