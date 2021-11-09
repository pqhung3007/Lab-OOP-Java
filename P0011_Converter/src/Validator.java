
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
public class Validator {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static boolean checkRepeat() {
        while (true) {
            try {
                System.out.println("Do you want to repeat the process? (Y/N) ");
                String choice = br.readLine();
                if (choice.isEmpty()) {
                    System.out.println("You must provide an answer");
                } else {
                    if (choice.equalsIgnoreCase("n")) {
                        break;
                    } else if (choice.equalsIgnoreCase("y")) {
                        return true;
                    } else {
                        System.out.println("Only answer yes or no");
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(InputData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

}
