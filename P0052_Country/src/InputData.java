
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class InputData {

    static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

    // ensure user choice is in allowed range
    public static int getOption(String msg, String err, int min, int max) {
        while (true) {
            try {
                System.out.println(msg);
                int num;
                num = Integer.parseInt(sc.readLine());
                if (min <= num && num <= max) {
                    return num;
                } else {
                    System.out.println(err);
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("You must enter a number");
            }
        }
    }

    // ensure input area is > 0
    public static int getArea(String msg, String err) {
        while (true) {
            try {
                System.out.println(msg);
                int area;
                area = Integer.parseInt(sc.readLine());
                if (area > 0) {
                    return area;
                } else {
                    System.out.println(err);
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("You must enter a number");
            }
        }

    }

    // ensure input string doesn't contain numbers & special characters
    public static String getString(String msg, String err, String regex) {
        while (true) {
            try {
                System.out.println(msg);
                String name = sc.readLine();
                if (name.matches(regex)) {
                    return name;
                }
                if (name.isEmpty()) {
                    System.out.println("Can't leave this field blank");
                } else {
                    System.out.println(err);
                }

            } catch (IOException e) {
                System.out.println("Invalid string type");
            }
        }
    }
}
