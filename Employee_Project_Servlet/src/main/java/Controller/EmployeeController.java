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

//    public void addEmployee() {
//        try {
//            int id = (Integer.parseInt(InputUtil.readString("Enter Employee ID: ")));
//            String name = InputUtil.readString("Enter Employee Name: ");
//            String location = InputUtil.readString("Enter Address Location: ");
//            int pin = InputUtil.readInt("Enter Address Pin: ");
//            Employee employee = new Employee(id, name, new Address(location, pin));
//            employeeService.addEmployee(employee);
//            System.out.println("Employee added successfully.");
//            System.out.println(employee);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
    public void addEmployee(Employee employee) {
        try {

            System.out.println("*************before adding........" + employee);
            employeeService.addEmployee(employee);
            System.out.println("Employee added successfully.");
            System.out.println(employee);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public Employee getEmployeeById(int id) {
        try {
//            id = Integer.parseInt(InputUtil.readString("Enter Employee ID: "));
            Employee employee = employeeService.getEmployeeById(Integer.parseInt(String.valueOf(id)));
            System.out.printf("%-10s %-20s %-30s %-10s\n", "ID", "Name", "Address", "pin code");
            System.out.println(employee);
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        System.out.printf("%-10s %-20s %-30s %-10s\n", "ID", "Name", "Address", "pin code");
        return employees;
    }

//    public void updateEmployee() {
//        try {
//            int id = Integer.parseInt(InputUtil.readString("Enter Employee ID to update: "));
//            Employee employee = employeeService.getEmployeeById(Integer.parseInt(String.valueOf(id)));
//            String name = InputUtil.readString("Enter Employee Name: ");
//            String location = InputUtil.readString("Enter Address Location: ");
//            int pin = InputUtil.readInt("Enter Address Pin: ");
//            employee.setName(name);
//            employee.getAddress().setLocation(location);
//            employee.getAddress().setPin(pin);
//            employeeService.updateEmployee(employee);
//            System.out.println("Employee updated successfully.");
//            System.out.println(employee);
//        } catch (EmployeeNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//    }
    public void updateEmployee(int id, String name, String location, int pin) {
        try {
            Employee employee = employeeService.getEmployeeById(id);
            if (employee == null) {
                throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
            }
            employee.setName(name);
            employee.getAddress().setLocation(location);
            employee.getAddress().setPin(pin);
            employeeService.updateEmployee(employee);
            System.out.println("Employee updated successfully.");
            System.out.println(employee);
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred while updating the employee: " + e.getMessage());
        }
    }
    public void deleteEmployee(int id) {
        try {
            Employee employee = employeeService.getEmployeeById(id);
            if (employee == null) {
                throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
            }
            employeeService.deleteEmployee(id);
            System.out.println("Employee deleted successfully.");
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred while deleting the employee: " + e.getMessage());
        }
    }
}