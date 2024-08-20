package Main;

import Controller.EmployeeController;
import util.InputUtil;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee CRUD CLI");
        String repoType = InputUtil.readString("Choose repository type (memory/file): ");

        EmployeeController employeeController = new EmployeeController(repoType);

        while (true) {
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
                    employeeController.getAllEmployees();
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