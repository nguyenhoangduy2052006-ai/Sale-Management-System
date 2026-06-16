
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
    
        // Ham tao khung cho tieu de Menu
    public static String repeatChar (String s, int count) {
        String result = "";
        for (int i=0; i<count; i++) {
            result+=s;
        }
        return result;
    }
}
