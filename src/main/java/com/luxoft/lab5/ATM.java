package com.luxoft.lab5;

import com.luxoft.lab5.money.*;
import com.luxoft.lab5.money.Money;
import com.luxoft.lab5.score.*;

public class ATM {
    private CurrentScore currentScore;
    private DebetScore debetScore;
    private CreditScore creditScore;

    public ATM() {
        this.creditScore =
                new CreditScore(
                        new Money(1000.0d,
                                CurrencyHolder.getCurrencyByName("RUR").getName()
                        ), null, 1);
        this.debetScore =
                new DebetScore(
                        new Money(1000.0d,
                                CurrencyHolder.getCurrencyByName("RUR").getName()
                        ), null, 1, this.creditScore);
        this.currentScore =
                new CurrentScore(
                        new Money(1000.0d,
                                CurrencyHolder.getCurrencyByName("RUR").getName()
                        ), null, 1, this.debetScore);
    }

    public void addToCredit(double amount){
        this.creditScore.addMoney( new Money(amount,CurrencyHolder.getCurrencyByName("RUR").getName()));
    }

    public void addToDebet(double amount){
        this.debetScore.addMoney( new Money(amount,CurrencyHolder.getCurrencyByName("RUR").getName()));
    }

    public void addToCurrent(double amount){
        this.currentScore.addMoney( new Money(amount,CurrencyHolder.getCurrencyByName("RUR").getName()));
    }

    public CurrentScore getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(CurrentScore currentScore) {
        this.currentScore = currentScore;
    }

    public DebetScore getDebetScore() {
        return debetScore;
    }

    public void setDebetScore(DebetScore debetScore) {
        this.debetScore = debetScore;
    }

    public CreditScore getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(CreditScore creditScore) {
        this.creditScore = creditScore;
    }
}


