package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputReader {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int readInt(String prompt) {
        int value = 0;
        boolean valid = false;
        while (!valid) {
            System.out.print(prompt);
            try {
                value = scanner.nextInt();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Clear the invalid input
            }
            scanner.nextLine(); // Consume the newline character
        }
        return value;
    }
}



