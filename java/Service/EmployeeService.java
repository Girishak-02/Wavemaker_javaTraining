package Service;

import Factory.RepositoryFactory;
import Model.Employee;
import Repository.EmployeeRepository;
import Exception.*; // Ensure this is imported

import java.util.List;

public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(String employeeRepository) {
        this.employeeRepository = RepositoryFactory.getEmployeeRepository(employeeRepository);
    }

    public void addEmployee(Employee employee) throws DuplicateEmployeeException {
        employeeRepository.addEmployee(employee);
    }

    public Employee getEmployeeById(int id) throws EmployeeNotFoundException {
        Employee employee = employeeRepository.getEmployeeById(id);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee not found with ID: " + id);
        }
        return employee;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees(); // Let exceptions propagate
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.updateEmployee(employee); // Let exceptions propagate
    }

    public void deleteEmployee(int id) throws EmployeeNotFoundException {
        try {
            if (!employeeRepository.deleteEmployee(id)) {
                throw new EmployeeNotFoundException("Employee not found with ID: " + id);
            }
        } catch (EmployeeNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
