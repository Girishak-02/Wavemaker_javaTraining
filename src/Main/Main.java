//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
package Main;

import Controller.EmployeeController;
import Repository.EmployeeRepository;
import Repository.SingletonEmployeeRepository;
import Service.EmployeeService;
import util.InputReader;

public class Main {
    public static void main(String[] args) {
        String repositoryType = InputReader.readString("Enter repository type (memory/file): ");
        EmployeeService employeeService = new EmployeeService(SingletonEmployeeRepository.getInstance(repositoryType));
        EmployeeController employeeController = new EmployeeController(employeeService);
        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. Get Employee by ID");
            System.out.println("3. Get All Employees");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            int choice = InputReader.readInt( "Enter your choice: ");
            switch (choice) {
                case 1:
                    employeeController.addEmployee();
                    break;
                case 2:
                    employeeController.getEmployeeById();
                    break;
                case 3:
                    employeeController.getEmployee();
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