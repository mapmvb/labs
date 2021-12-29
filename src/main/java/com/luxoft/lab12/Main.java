package com.luxoft.lab12;

import java.sql.Connection;

public class Main {
    static ProductDAO dao = new ProductDAO();

    public static void main(String[] args) {
        dao.dropTable();
        dao.createTable();
        fillProductList();
        updateProducts();
        printProducts();
    }



    public static void fillProductList() {

        Product product1 = new Product(1, "Bread", 1.0f, 100);
        Product product2 = new Product(2, "Milk", 2.5f, 200);
        Product product3 = new Product(3, "Meat", 15.8f, 350);
        Product product4 = new Product(4, "Soap", 100.0f, 1500);
        Product product5 = new Product(5, "Silk", 4058.3f, 10000);
        Product product6 = new Product(6, "Fruits", 2.0f, 200);

        try {
            dao.addProduct(product1);
            dao.addProduct(product2);
            dao.addProduct(product3);
            dao.addProduct(product4);
            dao.addProduct(product5);
            dao.addProduct(product6);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateProducts() {
        Product product1 = new Product(1, "Bread+", 1.0f, 101);
        Product product2 = new Product(3, "Milk+", 2.5f, 201);
        Product product3 = new Product(5, "Meat+", 15.8f, 351);

        try {
            dao.setProduct(product1);
            dao.setProduct(product2);
            dao.setProduct(product3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void printProducts() {
        for (int i =1; i <7 ; i++) {
            try {
                System.out.println(dao.getProductById(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
