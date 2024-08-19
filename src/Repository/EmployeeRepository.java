package Repository;

import Model.Employee;

import java.util.List;

public interface EmployeeRepository {

    void addEmployee(Employee employee);
    Employee getEmployeeById(String id);
    List<Employee> getAllEmployees();
    void updateEmployee(Employee employee);
    void deleteEmployee(String id);

}
