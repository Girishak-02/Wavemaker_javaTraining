// src/main/java/Repository/InMemoryEmployeeRepository.java
package Service.Impl;

import Exception.DuplicateEmployeeException;
import Exception.EmployeeNotFoundException;
import Model.Employee;
import Repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryEmployeeRepository implements EmployeeRepository {
    private final Map<String, Employee> employeeMap = new HashMap<>();

    @Override
    public void addEmployee(Employee employee) throws DuplicateEmployeeException {
        if (employeeMap.containsKey(employee.getId())) {
            throw new DuplicateEmployeeException("Employee with ID " + employee.getId() + " already exists.");
        }
        employeeMap.put(employee.getId(), employee);
    }

    @Override
    public Employee getEmployeeById(String id) throws EmployeeNotFoundException {
        Employee employee = employeeMap.get(id);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeMap.values());
    }

    @Override
    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        if (!employeeMap.containsKey(employee.getId())) {
            throw new EmployeeNotFoundException("Employee with ID " + employee.getId() + " not found.");

        }
        else
            employeeMap.put(employee.getId(), employee);
    }

    @Override
    public void deleteEmployee(String id) throws EmployeeNotFoundException {
        if (!employeeMap.containsKey(id)) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
        }
        employeeMap.remove(id);
    }
}