package Service.Impl;
import Model.Employee;
import Model.Address;
import java.io.*;
import java.util.*;
import Exception.DuplicateEmployeeException;
import Exception.EmployeeNotFoundException;
import Repository.EmployeeRepository;

public class FileEmployeeRepository implements EmployeeRepository {
    private static final String FILE_PATH = "employees.txt";
    private final Map<String, Employee> employeeMap = new HashMap<>();

    public FileEmployeeRepository() {
    }

    @Override
    public void addEmployee(Employee employee) throws DuplicateEmployeeException {
        if (employeeMap.containsKey(employee.getId())) {
            throw new DuplicateEmployeeException("Employee with ID " + employee.getId() + " already exists.");
        }
        employeeMap.put(employee.getId(), employee);
        saveEmployees();
    }

    @Override
    public Employee getEmployeeById(String id) throws EmployeeNotFoundException {
        loadEmployees();
        Employee employee = employeeMap.get(id);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        loadEmployees();
        return new ArrayList<>(employeeMap.values());
    }

    @Override
    public void updateEmployee(Employee employee) {
        if (!employeeMap.containsKey(employee.getId())) {
            return;
        }
        employeeMap.put(employee.getId(), employee);
        saveEmployees();
    }

    @Override
    public void deleteEmployee(String id) throws EmployeeNotFoundException {
        Employee employee = employeeMap.remove(id);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
        }
        saveEmployees();
    }

    private void saveEmployees() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Employee employee : employeeMap.values()) {
                writer.write(employee.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadEmployees() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Employee employee = parseEmployee(line);
                if (employee != null) {
                    employeeMap.put(employee.getId(), employee);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Employee parseEmployee(String line) {
        String[] parts = line.split(",");
        if (parts.length != 4) {
            System.out.println("Invalid employee data: " + line);
            return null;
        }
        String id = parts[0].trim();
        String name = parts[1].trim();
        String location = parts[2].trim();
        int pin = Integer.parseInt(parts[3].trim());
        return new Employee(id, name, new Address(location,pin));
    }
}