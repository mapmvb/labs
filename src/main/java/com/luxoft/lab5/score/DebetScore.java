package com.luxoft.lab5.score;

import com.luxoft.lab5.account.Account;
import com.luxoft.lab5.money.Money;

public class DebetScore extends Score {
    private CreditScore creditScore;

    public DebetScore(Money balance, Account owner, Integer number, CreditScore creditScore) {
        super(balance, owner, number);
        this.creditScore = creditScore;
    }

    @Override
    public void addMoney(Money money) {
        if( creditScore.getMoneyWithoutLess().getValue() < -20000){
            System.out.println("No Money on Credit Score!");
        }
        super.addMoney(money);
    }

    @Override
    public Money getMoney(double balanceLess) {
        if( creditScore.getMoneyWithoutLess().getValue() < -20000){
            System.out.println("No Money on Credit Score!");
            return null;
        }
        if (this.getBalance().getValue() <= 0){
            System.out.println("No money on Debet score!");
            return null;
        }
        return super.getMoney(balanceLess);
    }

    @Override
    public Money getMoneyWithoutLess() {
        if( creditScore.getMoneyWithoutLess().getValue() < -20000){
            System.out.println("No Money on Credit Score!");
        }
        return super.getMoneyWithoutLess();
    }

    @Override
    boolean checkBefore() {
        return true;
    }
}
