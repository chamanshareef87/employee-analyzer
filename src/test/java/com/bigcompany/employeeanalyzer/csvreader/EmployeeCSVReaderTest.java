package com.bigcompany.employeeanalyzer.csvreader;

import com.bigcompany.employeeanalyzer.csvreader.EmployeeCSVReader;
import com.bigcompany.employeeanalyzer.entity.Employee;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeCSVReaderTest {

    @Test
    void testReadEmployees() throws Exception {
        // Place a test CSV file named "test-employees.csv" in src/test/resources
        Map<Integer, Employee> employees = EmployeeCSVReader.readEmployees("test-employees.csv");
        assertFalse(employees.isEmpty());
        assertTrue(employees.values().stream().anyMatch(e -> e.getFirstName().equals("Bob")));
    }
}