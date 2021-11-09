
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

    // return option user has made
    public static int getOption() {
        while (true) {
            try {
                System.out.println("Choose your option: ");
                int choice = Integer.parseInt(br.readLine());
                if (choice >= 1 && choice <= 4) {
                    return choice;
                } else {
                    System.out.println("Option unavailable");
                }
                if (br.readLine().isEmpty()) {
                    System.out.println("Field empty!");
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("You must enter a number");
            }
        }
    }

    // return doctor info in string type 
    public static String getString(String msg, String err, String regex) {
        while (true) {

            try {
                System.out.println(msg);
                String str = br.readLine();
                if (str.matches(regex)) {
                    return str;
                }
                if (str.isEmpty()) {
                    System.out.println("Field empty!");
                } else {
                    System.out.println(err);
                }
            } catch (IOException ex) {
                Logger.getLogger(InputData.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public static int getInt(String msg, String err, int min, int max) {
        while (true) {
            try {
                System.out.println(msg);
                String str = br.readLine();
                int num = Integer.parseInt(str);
                if (num <= 0) {
                    System.out.println("Number should be > 0");
                } else {
                    if (num >= min && num <= max) {
                        return num;
                    } else {
                        System.out.println(err);
                    }
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("You must enter a valid number");
            }
        }
    }


}
