package Repository;

import Model.Employee;
import Exception.DuplicateEmployeeException;
import Exception.EmployeeNotFoundException;
import java.util.List;

public interface EmployeeRepository {
    void addEmployee(Employee employee) throws DuplicateEmployeeException;
    Employee getEmployeeById(String id) throws EmployeeNotFoundException;
    List<Employee> getAllEmployees();
    void updateEmployee(Employee employee) throws EmployeeNotFoundException;
    void deleteEmployee(String id) throws EmployeeNotFoundException;
}