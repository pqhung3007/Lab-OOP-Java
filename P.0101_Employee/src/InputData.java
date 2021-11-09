
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static Integer getOption(String msg, String err, int min, int max, String neglect) {
        while (true) {
            try {
                System.out.println(msg);
                String str = br.readLine();
                int num;
                // if neglect & input string is assigned a value and input string is same as neglect
                // this field is neglected (null returned value)
                if (neglect != null && str != null && str.trim().equals(neglect)) {
                    return null;
                }

                num = Integer.parseInt(str);
                if (min <= num && num <= max) {
                    return num;
                } else {
                    System.out.println(err);
                }
            } catch (IOException | NumberFormatException ex) {
                System.out.println("You must input a number");
            }
        }
    }

    public static Double getDouble(String msg, String err, String neglect) {
        while (true) {
            try {
                System.out.println(msg);
                String str = br.readLine();
                // ensure if neglect, str have input or string = neglect, return null
                if (neglect != null && str != null && str.trim().equals(neglect)) {
                    return null;
                }

                double num;
                num = Double.parseDouble(str);
                if (num > 0) {
                    return num;
                } else {
                    System.out.println(err);
                }
            } catch (IOException | NumberFormatException ex) {
                System.out.println("Invalid input type (double)");
            }
        }
    }

    public static String getString(String msg, String err, String regex, String neglect) {
        while (true) {
            try {
                System.out.println(msg);
                String str = br.readLine();
                // ensure if neglect and str have input or string = neglect, return null
                if (neglect != null && str != null && str.trim().equals(neglect)) {
                    return null;
                }
                if (str.isEmpty()) {
                    System.out.println("Can't leave this field blank");
                } else {
                    if (str.matches(regex)) {
                        return str;
                    } else {
                        System.out.println(err);
                    }
                }

            } catch (IOException ex) {
                Logger.getLogger(InputData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static Date getDate(String msg, String err, String format, String neglect) {
        while (true) {
            try {
                System.out.println(msg);
                String str = br.readLine();
                // ensure if neglect, str have input or string = neglect, return null
                if (neglect != null && str != null && str.trim().equals(neglect)) {
                    return null;
                }
                if (str.isEmpty()) {
                    System.out.println("Can't leave this field blank");
                } else {
                    SimpleDateFormat sdf = new SimpleDateFormat(format);
                    sdf.setLenient(false);
                    Date date = sdf.parse(str);
                    Date todayDate = sdf.parse(sdf.format(new Date()));
                    
                    // ensure dob is after current date
                    if (date.before(todayDate)) {
                        return date;
                    } else {
                        System.out.println("Error: DOB is after current date");
                    }
                    
                }
            } catch (IOException | ParseException ex) {
                System.out.println(err);
            }
        }
    }
   

}
