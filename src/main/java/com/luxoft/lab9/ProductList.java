package com.luxoft.lab9;

import java.util.Map;
import java.util.TreeMap;

public class ProductList {
    TreeMap<String, TreeMap<String,Integer>> clients = new TreeMap<>();

    public ProductList() {
    }

    public void addProduct(String name, String productName, int count) {
        if(!clients.containsKey(name)) {
            clients.put(name, new TreeMap<>());
        }
        TreeMap<String, Integer> temp = clients.get(name);
        if(!temp.containsKey(productName)) {
            temp.put(productName,0);
        }
        Integer oldCount = temp.get(productName);
        temp.put(productName, oldCount+count);
    }

    public void printStat(){
        System.out.println("------Stats-------");
        for (Map.Entry<String, TreeMap<String,Integer>> clientEntry: clients.entrySet()) {
            String name = clientEntry.getKey();
            System.out.println("Client:" + name);
            TreeMap<String,Integer> product = clientEntry.getValue();
            for(Map.Entry<String,Integer> productEntry: product.entrySet()) {
                String prodName = productEntry.getKey();
                Integer count = productEntry.getValue();
                System.out.println(" Product:"+prodName+ " Count:"+count);
            }
        }
    }
}
