
import java.util.ArrayList;
import java.util.Hashtable;
import models.Fruit;
import models.Order;

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

    public static void main(String[] args) {
        ShopManager manager = new ShopManager();
        ArrayList<Fruit> fruitList = new ArrayList<>();
        Hashtable<Integer, Order> orderTable = new Hashtable<>();

        while (true) {
            // Step 1: Display menu
            manager.displayMenu();

            // Step 2: Prompt user to make option
            int option = InputData.getOption();
            switch (option) {
                // Step 3: create fruit product for shop
                case 1:
                    manager.createFruit(fruitList);
                    break;

                // Step 4: view shopping cart of customer
                case 2:
                    manager.viewOrder(orderTable);
                    break;

                // Step 5: allow customer to shop
                case 3:
                    manager.shopping(fruitList, orderTable);
                    break;

                // Step 6: exit program
                case 4:
                    System.exit(0);
            }
        }
    }

}
