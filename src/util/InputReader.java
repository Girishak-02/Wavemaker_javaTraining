package util;
import java.util.Scanner;
public class InputReader {

    private static Scanner sc = new Scanner(System.in);
    public static String readString(String prompt)
    {
        System.out.print(prompt);
        return sc.nextLine();
    }
    public static int readInt(String prompt)
    {
        System.out.print(prompt);
        int value = sc.nextInt();
        sc.nextLine();
        // Consume the newline character
        return value;
    }
}
