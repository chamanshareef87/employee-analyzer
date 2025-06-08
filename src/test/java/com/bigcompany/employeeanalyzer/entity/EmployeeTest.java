package com.bigcompany.employeeanalyzer.entity;

import com.bigcompany.employeeanalyzer.entity.Employee;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void testEmployeeCreationAndGetters() {
        Employee emp = new Employee(1, "John", "Doe", 50000, null);
        assertEquals(1, emp.getId());
        assertEquals("John", emp.getFirstName());
        assertEquals("Doe", emp.getLastName());
        assertEquals(50000, emp.getSalary());
        assertNull(emp.getManagerId());
        assertTrue(emp.getSubordinates().isEmpty());
    }

    @Test
    void testAddSubordinate() {
        Employee manager = new Employee(1, "Jane", "Smith", 80000, null);
        Employee subordinate = new Employee(2, "Bob", "Brown", 40000, 1);
        manager.addSubordinate(subordinate);
        assertEquals(1, manager.getSubordinates().size());
        assertEquals(subordinate, manager.getSubordinates().get(0));
    }

    @Test
    void testToString() {
        Employee emp = new Employee(3, "Alice", "White", 60000, null);
        assertTrue(emp.toString().contains("Alice White"));
    }
}