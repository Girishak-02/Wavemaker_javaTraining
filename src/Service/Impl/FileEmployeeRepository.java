package Service.Impl;

import Model.Employee;
import Repository.EmployeeRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileEmployeeRepository implements EmployeeRepository {
    private static final String FILE_PATH = "employee1.txt";

    @Override
    public void addEmployee(Employee employee) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
//            System.out.println("Employee object in repository");
//            System.out.println(employee);
            System.out.println(employee.toString());
            writer.write(employee.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getEmployeeById(String id) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Employee employee = parseEmployee(line);
                if (employee.getId().equals(id)) {
                    return employee;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                employees.add(parseEmployee(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void updateEmployee(Employee employee) {
//        Employee employee1 = getEmployeeById(employee.getId());
        List<Employee> employees = getAllEmployees();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Employee e : employees) {
                if (e.getId().equals(e.getId())) {
                    writer.write(e.toString());
                } else {
                    writer.write(e.toString());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteEmployee(String id) {
        List<Employee> employees = getAllEmployees();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Employee employee : employees) {
                if (!employee.getId().equals(id)) {
                    writer.write(employee.toString());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Employee parseEmployee(String line) {
        // Parse employee from line
        return null;
    }
}
