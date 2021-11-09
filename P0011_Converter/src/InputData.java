
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class InputData {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // check if base that user enters is valid (either 2, 10 or 16)
    public static int getBaseNumber(String msg, String err) {
        // loop until correct input is confirmed
        while (true) {
            try {
                System.out.println(msg);
                System.out.println("1. Binary\n"
                        + "2. Decimal\n"
                        + "3. Hexadecimal");
                int choice = Integer.parseInt(br.readLine());
                int base = 0;
                if (choice < 0 || choice > 3) {
                    System.out.println("Only choose 1,2 or 3");
                } else {
                    switch (choice) {
                        case 1 ->
                            base = 2;
                        case 2 ->
                            base = 10;
                        case 3 ->
                            base = 16;
                    }
                return base;
                }
            } catch (IOException | NumberFormatException ex) {
                System.out.println(err);
            }
        }
    }

    // check if input value is valid
    public static String getValue(int baseIn) {
        // loop until correct input is confirmed
        while (true) {
            try {
                System.out.println("Enter input value: ");
                String value = br.readLine();
                // alert when no input is detected
                if (value.isBlank()) {
                    System.out.println("No value registered. Please enter value!");
                } else {
                    switch (baseIn) {
                        case 2:
                            if (value.matches("[0-1]+")) { // only 0 & 1 allowed
                                return value;
                            }
                            break;
                        case 10:
                            if (value.matches("[0-9]+")) { // only 0 to 9 allowed
                                return value;
                            }
                            break;
                        case 16:
                            if (value.matches("[0-9A-F]+")) { // only 0 to 9 & A to F allowed
                                return value;
                            }
                            break;
                    }
                    System.out.println("Invalid input value!");
                }
            } catch (IOException ex) {
                Logger.getLogger(InputData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
