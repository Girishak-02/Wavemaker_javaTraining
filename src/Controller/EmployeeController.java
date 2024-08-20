// src/main/java/Controller/EmployeeController.java
package Controller;

import Exception.EmployeeNotFoundException;
import Model.Address;
import Model.Employee;
import Service.EmployeeService;
import util.InputUtil;

import java.util.List;

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(String repoType) {
        this.employeeService = new EmployeeService(repoType);
    }

    public void addEmployee() {
        try {
            String id = String.valueOf(Integer.parseInt(InputUtil.readString("Enter Employee ID: ")));
            String name = InputUtil.readString("Enter Employee Name: ");
            String location = InputUtil.readString("Enter Address Location: ");
            int pin = InputUtil.readInt("Enter Address Pin: ");
            Employee employee = new Employee(id, name, new Address(location, pin));
            employeeService.addEmployee(employee);
            System.out.println("Employee added successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void getEmployeeById() {
        try {
            String id = InputUtil.readString("Enter Employee ID: ");
            Employee employee = employeeService.getEmployeeById(id);
            System.out.printf("%-10s %-20s %-30s\n", "ID", "Name", "Address");
            System.out.println(employee);
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        System.out.printf("%-10s %-20s %-30s\n", "ID", "Name", "Address");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void updateEmployee() {
        try {
            String id = InputUtil.readString("Enter Employee ID to update: ");
            Employee employee = employeeService.getEmployeeById(id);
            String name = InputUtil.readString("Enter Employee Name: ");
            String location = InputUtil.readString("Enter Address Location: ");
            int pin = InputUtil.readInt("Enter Address Pin: ");
            employee.setName(name);
            employee.getAddress().setLocation(location);
            employee.getAddress().setPin(pin);
            employeeService.updateEmployee(employee);
            System.out.println("Employee updated successfully.");
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteEmployee() {
        try {
            String id = InputUtil.readString("Enter Employee ID to delete: ");
            employeeService.deleteEmployee(id);
            System.out.println("Employee deleted successfully.");
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getEmployee() {
    }
}