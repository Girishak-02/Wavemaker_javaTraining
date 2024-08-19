package Service.Impl;

import Model.Employee;
import Repository.EmployeeRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryEmployeeRepository implements EmployeeRepository {
    private Map<String, Employee> employeeMap = new HashMap<>();

    @Override
    public void addEmployee(Employee employee) {
        employeeMap.put(employee.getId(), employee);
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employeeMap.get(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeMap.put(employee.getId(), employee);
    }

    @Override
    public void deleteEmployee(String id) {
        employeeMap.remove(id);

    }
}
