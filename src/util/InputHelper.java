
package util;

import java.util.Scanner;
public class InputHelper {
    
    // Ham check integer data
    public static int readInt (Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } 
            catch (NumberFormatException e) {
                System.out.print("Invalid number. Enter again: ");
            }  
        }
    }
    
    public static int readInt(Scanner scanner, int min) {

        while (true) {

            int value = readInt(scanner);

            if (value >= min) {
                return value;
            }

            System.out.print("Value must be >= " + min + ". Enter again: ");
        }
    }
    
    public static int readInt(Scanner scanner, int min, int max) {

        while (true) {

            int value = readInt(scanner);

            if (value >= min && value <= max) {
                return value;
            }

            System.out.print(
                    "Value must be between "
                    + min + " and "
                    + max
                    + ". Enter again: "
            );
        }
    }
    
    // Ham check double number
    
    public static double readDouble(Scanner scanner) {

        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Enter again: ");
            }
        }
    }
    
    public static double readDouble(Scanner scanner, double min) {

        while (true) {

            double value = readDouble(scanner);

            if (value >= min) {
                return value;
            }

            System.out.print("Value must be >= " + min + ". Enter again: ");
        }
    }
    
        // Ham tao khung cho tieu de Menu
    public static String repeatChar (String s, int count) {
        String result = "";
        for (int i=0; i<count; i++) {
            result+=s;
        }
        return result;
    }
}
