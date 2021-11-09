/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Order {

    private static int orderId = 0;
    private String customerName;
    private ArrayList<Fruit> productList;

    public Order() {
    }

    public Order(String customerName, ArrayList productList) {
        this.customerName = customerName;
        this.productList = productList;
        this.orderId = ++orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList getProductList() {
        return productList;
    }

    public static int getId() {
        return orderId;
    }

}
