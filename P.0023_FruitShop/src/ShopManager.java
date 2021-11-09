
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Set;
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
public class ShopManager {

    public void displayMenu() {
        System.out.println("FRUIT SHOP SYSTEM\n"
                + "1.	Create Fruit\n"
                + "2.	View orders\n"
                + "3.	Shopping (for buyer)\n"
                + "4.	Exit\n"
                + " (Please choose 1 to create product, 2 to view order, 3 for shopping, 4 to Exit program).");
    }

    public void createFruit(ArrayList<Fruit> fruitList) {
        int id = 1;
        while (true) {
            if (!fruitList.isEmpty()) {
                id = fruitList.get(fruitList.size() - 1).getId() + 1;
            }
            // string type input regex: only characters allowed
            String fruitName = InputData.getString("Enter fruit name: ", "Invalid name", 
                    "^[a-zA-Z ]+$");
            int price = InputData.getInt("Enter fruit price: ", "Invalid price number", 
                    0, Integer.MAX_VALUE);
            int quantity = InputData.getInt("Enter quantity: ", "Invalid quantity", 
                    1, Integer.MAX_VALUE);
            String origin = InputData.getString("Enter fruit origin: ", "Invalid origin", 
                    "^[a-zA-Z ]+$");

            fruitList.add(new Fruit(id, fruitName, price, quantity, origin));
            System.out.println("Successfully add new fruit!");

            // choice: only y, n, Y, N allowed
            String choice = InputData.getString("Do you want to continue? (Y/N)",
                    "Only answer yes or no", "^(y|Y|n|N)$");

            // stop adding fruit and display all fruits if user choose no
            if (choice.equalsIgnoreCase("n")) {
                displayAllFruits(fruitList);
                break;
            }
        }
    }

    public void viewOrder(Hashtable<Integer, Order> orderTable) {
        // alert if hashtable has nothing in it
        if (orderTable.isEmpty()) {
            System.out.println("You have nothing in the cart");
        }

        Set<Integer> keys = orderTable.keySet();
        // traverse through each order corresponding to each key
        for (Integer key : keys) {
            System.out.println("Customer: " + orderTable.get(key).getCustomerName());
            System.out.println("Product | Quantity | Price | Amount");
            ArrayList<Fruit> product = orderTable.get(key).getProductList();

            int total = 0;
            // traverse through bought product list
            for (int i = 0; i < product.size(); i++) {
                Fruit fruit = (Fruit) product.get(i);
                int amount = fruit.getPrice() * fruit.getQuantity();
                total += amount;
                System.out.format("%-12s%-10s%-8s%-8s", (i + 1) + "." + fruit.getName(),
                        fruit.getQuantity(), fruit.getPrice() + "$", amount + "$");
                System.out.println();
            }

            System.out.println("Total: " + total + "$");
            System.out.println();
        }

    }

    public void shopping(ArrayList<Fruit> fruitList, Hashtable<Integer, Order> orderTable) {
        ArrayList<Fruit> productList = new ArrayList<>();
        // alert if shop is currently having no fruit
        if (fruitList.isEmpty()) {
            System.out.println("Shop is having no fruits");
            return;
        }
        
        while (true) {
            System.out.println("List of fruit: ");
            displayAllFruits(fruitList);

            int id = InputData.getInt("Select id of item: ", "Id out of range", 1, 4);
            Fruit fruit = findFruitById(fruitList, id);

            // alert if fruit is out of stock
            if (fruit == null) {
                System.out.println("This fruit is out of stock");
                continue;
            }
            System.out.println("You selected: " + fruit.getName());
            int boughtQuantity = InputData.getInt("Enter quantity you want to buy: ",
                    "Sorry, we only have " + fruit.getQuantity() + " fruits left", 1, fruit.getQuantity());
            String choice = InputData.getString("Do you want to order now? (Y/N)", 
                    "Only answer yes or no", "^(y|Y|n|N)$");

            boolean isFruitAlreadyBought = false;
            for (Fruit orderedFruit : productList) {
                // if newly bought fruit name is already in the order, 
                // update new qty directly to existing fruit product
                if (orderedFruit.getId() == id) {
                    orderedFruit.setQuantity(boughtQuantity + orderedFruit.getQuantity());
                    isFruitAlreadyBought = true;
                    fruit.setQuantity(fruit.getQuantity() - boughtQuantity);
                }
            }
            // if fruit is bought first time
            if (!isFruitAlreadyBought) {
                Fruit boughtFruit = new Fruit(fruit.getId() ,fruit.getName(), fruit.getPrice(), 
                        boughtQuantity, fruit.getOrigin());
                productList.add(boughtFruit);
                fruit.setQuantity(fruit.getQuantity() - boughtQuantity);
            }
            // if a product is out of stock, remove it from menu
            if (fruit.getQuantity() == 0) {
                fruitList.remove(fruit);
            }
            // stop adding fruit and display bought products if user choose yes
            if (choice.equalsIgnoreCase("y")) {
                displayOrder(productList);
                break;
            }
        }
        // only accept letters and spaces 
        String customerName = InputData.getString("Enter your name: ", "Invalid name", "^[a-zA-Z ]+$");

        Order newOrder = new Order(customerName, productList);
        orderTable.put(Order.getId(), newOrder);
        System.out.println("Products added to cart");

    }

    private Fruit findFruitById(ArrayList<Fruit> fruitList, int id) {
        for (Fruit fruit : fruitList) {
            if (fruit.getId() == id) {
                return fruit;
            }
        }
        return null;
    }

    // display all fruits in stock
    private void displayAllFruits(ArrayList<Fruit> fruitList) {
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |  ");
        for (Fruit fruit : fruitList) {
            System.out.println(fruit);
        }
    }

    // display order in a single purchase
    private void displayOrder(ArrayList<Fruit> productList) {
        System.out.println("Product | Quantity  | Price | Amount");
        int total = 0;
        for (Fruit fruit : productList) {
            int amount = fruit.getQuantity() * fruit.getPrice();
            System.out.format("%-12s%-10s%-8s%-8s\n", fruit.getName(),
                    fruit.getQuantity(), fruit.getPrice() + "$", amount + "$");
            total += amount;
        }
        System.out.println("Total: " + total + "$");
    }

}
