
import java.util.HashMap;
import java.util.Locale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class Main {

    public final static HashMap<String, String> account;
    static {
        account = new HashMap<>();
        account.put("0123456789", "ab123456");
        account.put("0111111111", "hung3007");
    }

    public static void main(String[] args) {
        EBankManager manager = new EBankManager();

        while (true) {
            // Step 1: Display bank's menu
            manager.displayMenu();

            // Step 2: Prompt user to make option
            int option = InputData.getOption();
            switch (option) {
                // Step 3: display interface in Vietnamese and perform login
                case 1:
                    Locale localeVi = new Locale("vi", "VN");
                    manager.login(localeVi, account);
                    break;

                // Step 4: display interface in English and perform login
                case 2:
                    Locale localeUs = new Locale("en", "US");
                    manager.login(localeUs, account);
                    break;

                // Step 5: exit program
                case 3:
                    return;
            }
        }
    }

}
