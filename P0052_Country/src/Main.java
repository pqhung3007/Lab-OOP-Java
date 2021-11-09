
import java.util.ArrayList;
import models.EastAsiaCountries;

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

    final static ArrayList<EastAsiaCountries> countryList;

    static {
        countryList = new ArrayList<>();
        countryList.add(new EastAsiaCountries("MAL", "Malaysia", 25000, "good"));
        countryList.add(new EastAsiaCountries("SIN", "Singapore", 1000, "beautiful"));
        countryList.add(new EastAsiaCountries("AUS", "Australia", 70000, "nice"));
        countryList.add(new EastAsiaCountries("USA", "United States", 120000, "beautiful"));
        countryList.add(new EastAsiaCountries("GBR", "Great Britain", 40000, "beautiful"));
        countryList.add(new EastAsiaCountries("FRA", "France", 66000, "gorgeous"));
        countryList.add(new EastAsiaCountries("HKG", "Hong Kong", 2000, "nah"));
        countryList.add(new EastAsiaCountries("JPN", "Japan", 33000, "nice"));
    }

    public static void main(String[] args) {
        EastAsiaCountriesManager manager = new EastAsiaCountriesManager();

        while (true) {
            // Step 1: display menu of options
            manager.displayMenu();

            // Step 2: prompt user to make option
            int option = InputData.getOption("Enter your option: ", "Option out of range. Reenter!", 1, 5);
            switch (option) {
                // Step 3: add country info 
                case 1:
                    manager.addCountryInfo(countryList);
                    break;
                // Step 4: display recently entered country info 
                case 2:
                    manager.getCountryInfo(countryList);
                    break;
                // Step 5: search for country info by its name 
                case 3:
                    manager.searchCountryByName(countryList);
                    break;
                // Step 6: sort country by name (alphabetically ascending) 
                case 4:
                    manager.sortCountryByName(countryList);
                    break;
                // Step 7: exit program
                case 5:
                    System.exit(0);

            }
        }
    }
}
