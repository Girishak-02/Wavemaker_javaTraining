package Repository;

import Model.Employee;
import Exception.DuplicateEmployeeException;
import Exception.EmployeeNotFoundException;
import java.util.List;

public interface EmployeeRepository {
    void addEmployee(Employee employee) throws DuplicateEmployeeException;

    Employee getEmployeeById(int id) throws EmployeeNotFoundException;

    List<Employee> getAllEmployees();
    void updateEmployee(Employee employee) throws EmployeeNotFoundException;
    boolean deleteEmployee(int id) throws EmployeeNotFoundException;
}

