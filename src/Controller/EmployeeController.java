// src/main/java/Controller/EmployeeController.java
package Controller;

import Model.Address;
import Model.Employee;
import Service.EmployeeService;
import util.InputReader;

import java.util.List;

public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void getEmployee() {
        List<Employee> employees = employeeService.getAllEmployees();
        if (employees != null) {
//            System.out.printf("%-10s %-20s %-30s\n", "ID", "Name", "Address");
            System.out.println("\t\tID \t\t\t\t Name \t\t\t\t Address");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    public void addEmployee() {
        String id = InputReader.readString("Enter Employee ID: ");
        String name = InputReader.readString("Enter Employee Name: ");
        String location = InputReader.readString("Enter location: ");
        int pin = InputReader.readInt("Enter pin: ");
        Employee employee = new Employee(id, name, new Address(location, pin));
        System.out.println("Employee object");
        System.out.println(employee);
        employeeService.addEmployee(employee);
    }

    public void updateEmployee() {
        String id = InputReader.readString("Enter Employee ID to update: ");
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            String name = InputReader.readString("Enter Employee Name: ");
            String location = InputReader.readString("Enter location: ");
            int pin = InputReader.readInt("Enter pin: ");
            employee.setName(name);
            employee.getAddress().setLocation(location);
            employee.getAddress().setPin(pin);
            employeeService.updateEmployee(employee);
        }
    }

    public void deleteEmployee() {
        String id = InputReader.readString("Enter Employee ID to delete: ");
        employeeService.deleteEmployee(id);
    }

    public void getEmployeeById() {
        String id = InputReader.readString("Enter Employee ID: ");
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            System.out.printf("%-10s %-20s %-30s\n", "ID", "Name", "Address");
            System.out.println(employee);
        }
    }
}