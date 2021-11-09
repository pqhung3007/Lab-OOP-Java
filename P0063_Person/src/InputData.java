
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    // check name and address validity
    public static String getString(String msg, String err, String regex) {
        while (true) {
            try {
                System.out.print(msg);
                String name = br.readLine();
                if (name.isEmpty()) {
                    System.out.println("Can't leave this field blank");
                } else {
                    if (name.matches(regex)) {
                        return name;
                    } else {
                        System.out.println(err);
                    }
                }
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        }
    }

    // check validity of salary amount
    public static double getDouble(String msg, String err) {
        while (true) {
            try {
                System.out.print(msg);
                String amount;
                amount = br.readLine();
                if (amount.isEmpty()) {
                    System.out.println("Can't leave this field blank");
                } else {
                    if (Double.parseDouble(amount) > 0) {
                        return Double.parseDouble(amount);
                    } else {
                        System.out.println(err);
                    }
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("You must input digit");
            }
        }
    }
}
