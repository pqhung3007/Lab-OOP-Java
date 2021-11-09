
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class EBankManager {

    ResourceBundle bundle;

    public void displayMenu() {
        System.out.println("Login function of Ebank system includes:\n"
                + "1. Vietnamese\n"
                + "2. English\n"
                + "3. Exit");
    }

    public void login(Locale locale, HashMap<String, String> account) {
        setLocale(locale);

        // regex: acc num must be a 10-digit string
        String accNum = InputData.getAccNum(bundle.getString("account"), bundle.getString("string.empty"),
                bundle.getString("acc.error"), "^\\d{10}$");
        String password = InputData.getPassword(bundle.getString("password"), bundle.getString("string.empty"),
                bundle.getString("password.error"));

        // check if there's accNum registered
        if (!account.containsKey(accNum)) {
            System.out.println(bundle.getString("inexisted.account"));
            return;
        }
        // check if acc num and password is a pair
        if (!password.equals(account.get(accNum))) {
            System.out.println(bundle.getString("login.failed"));
            return;
        }

        while (true) {
            String generatedCapcha = generateCapcha();
            System.out.println("Capcha: " + generatedCapcha);
            String enteredCapcha = InputData.getCapcha(bundle.getString("capcha"),
                    bundle.getString("string.empty"));
            // ensure user enter correct capcha
            if (enteredCapcha.equals(generatedCapcha)) {
                System.out.println(bundle.getString("login.success"));
                break;
            } else {
                System.out.println(bundle.getString("capcha.error"));
            }

        }
    }

    private void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle("languages/lang", locale);
    }

    private String generateCapcha() {
        Random rand = new Random();
        String symbols = "abcdefghijklmnopqrstuvxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder capchaCode = new StringBuilder();

        // loop 5 times to create capchaCode
        for (int i = 0; i < 5; i++) {
            int randIndex = rand.nextInt(symbols.length());
            capchaCode.append(symbols.charAt(randIndex));
        }
        return capchaCode.toString();
    }

}
