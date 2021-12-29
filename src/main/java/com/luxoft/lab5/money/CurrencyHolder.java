package com.luxoft.lab5.money;

import java.util.HashMap;
import java.util.Map;

public class CurrencyHolder {
    private static final Map<String,Currency> currencies = new HashMap<>();
    static {
        currencies.put("USD", new Currency("USD",1));
        currencies.put("RUR", new Currency("RUR",75));
    }

    public static Currency getCurrencyByName(String name){
        return currencies.get(name);
    }
}
