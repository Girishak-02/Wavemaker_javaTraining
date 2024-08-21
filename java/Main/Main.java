package Main;

import Controller.EmployeeController;
import Model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.InputUtil;
import java.util.List;

public class Main {
    public static Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        System.out.println("Welcome to Employee CRUD CLI");
        String repoType = InputUtil.readString("Choose repository type (memory/file/DataBase): ");
        EmployeeController employeeController = new EmployeeController(repoType);
        while(true) {
            System.out.println("1. Add Employee");
            System.out.println("2. Get Employee by ID");
            System.out.println("3. Get All Employees");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            int choice = InputUtil.readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    employeeController.addEmployee();
                    break;
                case 2:
                    employeeController.getEmployeeById();
                    break;
                case 3:
                  List<Employee> employeeList =  employeeController.getAllEmployees();
                    System.out.println(employeeList);
                    break;
                case 4:
                    employeeController.updateEmployee();
                    break;
                case 5:
                    employeeController.deleteEmployee();
                    break;
                case 6:

                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}