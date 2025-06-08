# Employee Analyzer

Employee Analyzer is a Spring Boot application that analyzes employee data from a CSV file. It performs salary analysis for managers and checks the reporting depth of employees in an organization.

## Features

- Reads employee data from a CSV file.
- Builds a manager-subordinate hierarchy.
- Analyzes manager salaries to ensure they are within a specified range compared to their subordinates.
- Checks reporting depth for each employee and flags those exceeding a depth of 4.

## Project Structure

```
employee-analyzer/
├── src/
│   ├── main/
│   │   ├── java/com/bigcompany/employeeanalyzer/
│   │   │   ├── EmployeeAnalyzerApplication.java
│   │   │   ├── csvreader/EmployeeCSVReader.java
│   │   │   ├── entity/Employee.java
│   │   │   └── service/EmployeeAnalyzer.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── employees.csv
│   └── test/
│       ├── java/com/bigcompany/employeeanalyzer/
│       │   ├── EmployeeAnalyzerApplicationTests.java
│       │   ├── csvreader/EmployeeCSVReaderTest.java
│       │   ├── entity/EmployeeTest.java
│       │   └── service/EmployeeAnalyzerTest.java
│       └── resources/
│           └── test-employees.csv
├── pom.xml
└── ...
```

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven

### Build and Run

1. **Clone the repository**  
   ```
   git clone <repository-url>
   cd employee-analyzer
   ```

2. **Build the project**  
   ```
   ./mvnw clean package
   ```

3. **Run the application**  
   ```
   ./mvnw spring-boot:run
   ```

   The application will read `employees.csv` from `src/main/resources` and print analysis results to the console.

### Running Tests

To run all tests:

```
./mvnw test
```

## Example Output

```
=== Salary Analysis ===
Manager Joe Doe (ID: 123) earns 12000.00 less than required minimum 72000.00

=== Reporting Depth Analysis ===
CEO found: Joe Doe (ID: 123)
Employee Eli Deepest (ID: 402) has reporting depth 5 (exceeds by 1)
```

## File Descriptions

- [`EmployeeAnalyzerApplication.java`](src/main/java/com/bigcompany/employeeanalyzer/EmployeeAnalyzerApplication.java): Main Spring Boot entry point.
- [`EmployeeCSVReader.java`](src/main/java/com/bigcompany/employeeanalyzer/csvreader/EmployeeCSVReader.java): Reads employees from a CSV file and builds the hierarchy.
- [`Employee.java`](src/main/java/com/bigcompany/employeeanalyzer/entity/Employee.java): Employee entity with fields and relationships.
- [`EmployeeAnalyzer.java`](src/main/java/com/bigcompany/employeeanalyzer/service/EmployeeAnalyzer.java): Contains business logic for salary and reporting depth analysis.

## License

This project is for demonstration.