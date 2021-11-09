
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

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int getOption() {
        // loop until if condition is met
        while (true) {
            try {
                System.out.println("Enter your option: ");
                int option;
                option = Integer.parseInt(br.readLine());
                if (option >= 1 && option <= 3) {
                    return option;
                } else {
                    System.out.println("Option out of range. Enter again!");
                }

            } catch (IOException | NumberFormatException ex) {
                System.out.println("You must enter a number");
            }
        }
    }

    public static String getAccNum(String msg, String empty, String err, String regex) {
        // loop until if condition is met
        while (true) {
            try {
                System.out.println(msg);
                String str = br.readLine();
                if (str.isEmpty()) {
                    System.out.println(empty);
                } else {
                    if (str.matches(regex)) {
                        return str;
                    }
                    System.out.println(err);
                }
            } catch (IOException ex) {
                Logger.getLogger(InputData.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public static String getPassword(String msg, String empty, String err) {
        // loop until if condition is met
        while (true) {
            try {
                System.out.println(msg);
                String str = br.readLine();
                if (str.isEmpty()) {
                    System.out.println(empty);
                } else {
                    boolean isMatchedRegex1 = str.matches("^[a-zA-Z0-9]*[a-zA-Z]+[a-zA-Z0-9]*$");
                    boolean isMatchedRegex2 = str.matches("^[a-zA-Z0-9]*[0-9]+[a-zA-Z0-9]*$");
                    // ensure password must have at least a letter (regex 1) and a digit (regex 2)
                    // and have sufficient length
                    if (isMatchedRegex1 && isMatchedRegex2 && 
                            (str.length() >= 8 && str.length() <= 31)) {
                        return str;
                    }
                    else {
                        System.out.println(err);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(InputData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static String getCapcha(String msg, String empty) {
        // loop until if condition is met
        while (true) {
            try {
                System.out.println(msg);
                String str = br.readLine();
                if (str.isEmpty()) {
                    System.out.println(empty);
                } else {
                    return str;
                }
            } catch (IOException ex) {
                Logger.getLogger(InputData.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
