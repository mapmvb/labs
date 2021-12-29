package com.luxoft.lab11.money;

import com.luxoft.lab11.money.Money;

public interface MoneyInterface {
    void addMoney(com.luxoft.lab11.money.Money money);
    com.luxoft.lab11.money.Money getMoney(double balanceLess);
    Money getMoneyWithoutLess();
}
