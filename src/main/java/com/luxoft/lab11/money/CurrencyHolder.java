package com.luxoft.lab11.money;

import com.luxoft.lab11.money.Currency;

import java.util.HashMap;
import java.util.Map;

public class CurrencyHolder {
    private static final Map<String, com.luxoft.lab11.money.Currency> currencies = new HashMap<>();
    static {
        currencies.put("USD", new com.luxoft.lab11.money.Currency("USD",1));
        currencies.put("RUR", new com.luxoft.lab11.money.Currency("RUR",75));
    }

    public static Currency getCurrencyByName(String name){
        return currencies.get(name);
    }
}
