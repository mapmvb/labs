package com.luxoft.lab9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

public class SpisPokTest {
    private static ProductList productList;

    @BeforeAll
    static void setUp(){
        productList = new ProductList();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
    void fillData(String byerName, String productName, int qty) {
        productList.addProduct(byerName,productName, qty);
        System.out.println("Fill finished!");
    }

    @Test
    void checkStat(){
        productList.printStat();
    }
}
