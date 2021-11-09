
import models.EastAsiaCountries;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class EastAsiaCountriesManager {

    public void displayMenu() {
        System.out.println("                               MENU\n"
                + "==========================================================================\n"
                + "1. Input the information of 11 countries in East Asia\n"
                + "2. Display the information of country you've just input\n"
                + "3. Search the information of country by user-entered name\n"
                + "4. Display the information of countries sorted name in ascending order  \n" + "5. Exit ");
    }

    public void addCountryInfo(ArrayList<EastAsiaCountries> countryList) {
        // keep adding until there are enough 11 countries
        while (countryList.size() < 11) {
            String code = "";
            while (true) {
                // only capital characters allowed and length = 3
                code = InputData.getString("Enter code of country", "Invalid code input!", "^[A-Z]{3}$");
                // country code must be unique
                if (isExisted(countryList, code)) {
                    System.out.println("Country code is duplicated.");
                } else {
                    break;
                }
            }
            String name = "";
            while (true) {
                // first letter must be capitalized, only letters & space allowed
                name = InputData.getString("Enter name of country", "Invalid name input!", "^[A-Z][a-zA-Z ]+$");
                // country name must be unique
                if (isAdded(countryList, name)) {
                    System.out.println("This country is already added.");
                } else {
                    break;
                }
            }
            // area should be > 0
            int area = InputData.getArea("Enter total area", "Area must be greater than 0!");
            // only letters & space allowed
            String terrain = InputData.getString("Enter terrain of country", "Invalid terrain input!", "^[a-zA-Z ]+$");

            EastAsiaCountries countries = new EastAsiaCountries(code, name, area, terrain);
            countryList.add(countries);
        }

        if (countryList.size() >= 11) {
            System.out.println("All 11 countries are added");
        }
    }

    // display info of all countries
    public void getCountryInfo(ArrayList<EastAsiaCountries> countryList) {
        displayHeader();
        for (EastAsiaCountries country : countryList) {
            country.display();
        }

    }

    // search country by its name
    public void searchCountryByName(ArrayList<EastAsiaCountries> countryList) {
        String enteredName = InputData.getString("Enter the name you want to search for", "Can't find country",
                "^[a-zA-Z ]+$");
        // traverse through list and find country whose name matches entered name
        boolean isExisted = false;
        for (EastAsiaCountries country : countryList) {
            if (country.getCountryName().contains(enteredName)) {
                // ensure header only display once before the first object
                if (!isExisted) {
                    displayHeader();
                }
                isExisted = true;
                country.display();
            }
        }
        // alert if no country name matches
        if (!isExisted) {
            System.out.println("Can't find country");
        }

    }

    // sort country by its name (ascending order)
    public void sortCountryByName(ArrayList<EastAsiaCountries> countryList) {
        Collections.sort(countryList, new Comparator<EastAsiaCountries>() {
            @Override
            public int compare(EastAsiaCountries c1, EastAsiaCountries c2) {
                return c1.getCountryName().compareTo(c2.getCountryName());
            }
        });
        getCountryInfo(countryList);
        System.out.println("The country list has been sorted.");
    }

    private boolean isExisted(ArrayList<EastAsiaCountries> countryList, String code) {
        for (EastAsiaCountries country : countryList) {
            // return true if country code in list match entered code
            if (country.getCountryCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }

    private boolean isAdded(ArrayList<EastAsiaCountries> countryList, String name) {
        for (EastAsiaCountries country : countryList) {
            // return true if country name in list match entered name
            if (country.getCountryName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    private void displayHeader() {
        System.out.format("%-20s%-20s%-20s%-20s\n", "ID", "Name", "Total Area", "Terrain");
    }

}
