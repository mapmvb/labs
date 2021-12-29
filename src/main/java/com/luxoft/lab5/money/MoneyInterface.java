package com.luxoft.lab5.money;

public interface MoneyInterface {
    void addMoney(Money money);
    Money getMoney(double balanceLess);
    Money getMoneyWithoutLess();
}
