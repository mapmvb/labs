package com.luxoft.lab11.score;

import com.luxoft.lab11.Loggable;
import com.luxoft.lab11.MethodLimit;
import com.luxoft.lab11.account.Account;
import com.luxoft.lab11.money.Money;
import com.luxoft.lab11.score.Score;
@Loggable
public class CreditScore extends Score {
    public CreditScore(Money balance, Account owner, Integer number) {
        super(balance, owner, number);
    }

    @Override
    @MethodLimit(limit = 3)
    public void addMoney(Money money) {
        super.addMoney(money);
    }

    @Override
    @MethodLimit(limit = 2)
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
