package com.luxoft.lab5.score;

import com.luxoft.lab5.account.Account;
import com.luxoft.lab5.money.Money;

public class CreditScore extends Score {
    public CreditScore(Money balance, Account owner, Integer number) {
        super(balance, owner, number);
    }

    @Override
    public void addMoney(Money money) {
        super.addMoney(money);
    }

    @Override
    public Money getMoney(double balanceLess) {
        return super.getMoney(balanceLess);
    }

    @Override
    public Money getMoneyWithoutLess() {
        return super.getMoneyWithoutLess();
    }

    @Override
    boolean checkBefore() {
        return true;
    }
}
