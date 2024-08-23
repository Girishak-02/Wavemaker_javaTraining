
package Service.Impl;

import Model.Address;
import Model.Employee;
import Repository.EmployeeRepository;
import Exception.EmployeeNotFoundException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataBaseEmployeeRepository implements EmployeeRepository {

    private static final String URL = "jdbc:mysql://localhost:3307/employeedatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "Girish@02";

    public DataBaseEmployeeRepository() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addEmployee(Employee employee) {
        String query = "INSERT INTO employees (id, name, address, pin) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            connection.setAutoCommit(true); // Ensure auto-commit is enabled

            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getName());
            statement.setString(3, employee.getAddress().getLocation());
            statement.setInt(4, employee.getAddress().getPin());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new employee was inserted successfully!");
            } else {
                System.out.println("No rows inserted.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getEmployeeById(int id) throws EmployeeNotFoundException {
        String query = "SELECT * FROM employees WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next() ) {
                String name = resultSet.getString("name");
                String location = resultSet.getString("location");
                int pin = resultSet.getInt("pin");

                Address address = new Address(location, pin);
                return new Employee(id, name, address);
            } else {
                throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new EmployeeNotFoundException("An error occurred while retrieving employee.");
        }
    }


    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employees";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String location = resultSet.getString("location");
                int pin = resultSet.getInt("pin");

                Address address = new Address(location, pin);
                Employee employee = new Employee(id, name, address);
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void updateEmployee() throws EmployeeNotFoundException {

    }
    @Override
    public void updateEmployee(Employee employee) {
        String query = "UPDATE employees SET name = ?, location = ?, pin = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getAddress().getLocation());
            statement.setInt(3, employee.getAddress().getPin());
            statement.setInt(4, employee.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteEmployee(int id) throws EmployeeNotFoundException {
        String query = "DELETE FROM employees WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 0) {
                throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();

            throw new EmployeeNotFoundException("An error occurred while deleting employee.");
        }
    }
}
