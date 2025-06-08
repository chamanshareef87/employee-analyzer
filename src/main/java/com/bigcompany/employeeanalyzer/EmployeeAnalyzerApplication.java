package com.bigcompany.employeeanalyzer;

import com.bigcompany.employeeanalyzer.csvreader.EmployeeCSVReader;
import com.bigcompany.employeeanalyzer.entity.Employee;
import com.bigcompany.employeeanalyzer.service.EmployeeAnalyzer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class EmployeeAnalyzerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeAnalyzerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String fileName = "employees.csv";
		Map<Integer, Employee> employees = EmployeeCSVReader.readEmployees(fileName);

		EmployeeAnalyzer analyzer = new EmployeeAnalyzer(employees);
		System.out.println("=== Salary Analysis ===");
		analyzer.analyzeSalaries();

		System.out.println("\n=== Reporting Depth Analysis ===");
		analyzer.analyzeReportingDepth();
	}
}
