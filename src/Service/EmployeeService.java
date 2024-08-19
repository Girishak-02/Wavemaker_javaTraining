
package Service;

import Model.Employee;
import Repository.EmployeeRepository;

import java.util.List;

public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployee(Employee employee) {
        try {
            employeeRepository.addEmployee(employee);
        } catch (Exception e) {
            System.out.println("Error adding employee: " + e.getMessage());
        }
    }

    public Employee getEmployeeById(String id) {
        try {
            return employeeRepository.getEmployeeById(id);
        } catch (Exception e) {
            System.out.println("Error fetching employee: " + e.getMessage());
            return null;
        }
    }

    public List<Employee> getAllEmployees() {
        try {
            return employeeRepository.getAllEmployees();
        } catch (Exception e) {
            System.out.println("Error fetching employees: " + e.getMessage());
            return null;
        }
    }

    public void updateEmployee(Employee employee) {
        try {
            employeeRepository.updateEmployee(employee);
        } catch (Exception e) {
            System.out.println("Error updating employee: " + e.getMessage());
        }
    }

    public void deleteEmployee(String id) {
        try {
            employeeRepository.deleteEmployee(id);
        } catch (Exception e) {
            System.out.println("Error deleting employee: " + e.getMessage());
        }
    }
}