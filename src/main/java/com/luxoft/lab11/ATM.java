package com.luxoft.lab11;

import com.luxoft.lab11.money.CurrencyHolder;
import com.luxoft.lab11.money.Money;
import com.luxoft.lab11.score.CreditScore;
import com.luxoft.lab11.score.CurrentScore;
import com.luxoft.lab11.score.DebetScore;

import java.lang.annotation.Annotation;

@OperLimitATM(value = 5)
public class ATM {
    private CurrentScore currentScore;
    private DebetScore debetScore;
    private CreditScore creditScore;
    private int operLimit;
    private int currentOpers;
    private boolean operLimitToggl;

    public ATM() {
        this.operLimit = 0;
        this.currentOpers = 0;
        this.operLimitToggl = false;
        Class<? extends ATM> thisClass = this.getClass();
        for (Annotation annotation: thisClass.getAnnotations()){
            if (annotation instanceof OperLimitATM) {
                this.operLimit = ((OperLimitATM)annotation).value();
                this.operLimitToggl = true;
            }
        }

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
        if(operLimitToggl&&(currentOpers >= operLimit)){
            System.out.println("Oper limit ends!");
            return;
        }
        this.creditScore.addMoney( new Money(amount,CurrencyHolder.getCurrencyByName("RUR").getName()));
        currentOpers++;
    }

    public void addToDebet(double amount){
        this.debetScore.addMoney( new Money(amount,CurrencyHolder.getCurrencyByName("RUR").getName()));
    }

    public void addToCurrent(double amount){
        this.currentScore.addMoney( new Money(amount,CurrencyHolder.getCurrencyByName("RUR").getName()));
    }

    public CurrentScore getCurrentScore() {
        if(operLimitToggl&&(currentOpers >= operLimit)){
            System.out.println("Oper limit ends!");
            return null;
        }
        currentOpers++;
        return currentScore;
    }

    public void setCurrentScore(CurrentScore currentScore) {
        this.currentScore = currentScore;
    }

    public DebetScore getDebetScore() {
        if(operLimitToggl&&(currentOpers >= operLimit)){
            System.out.println("Oper limit ends!");
            return null;
        }
        currentOpers++;
        return debetScore;
    }

    public void setDebetScore(DebetScore debetScore) {
        this.debetScore = debetScore;
    }

    public CreditScore getCreditScore() {
        if(operLimitToggl&&(currentOpers >= operLimit)){
            System.out.println("Oper limit ends!");
            return null;
        }
        currentOpers++;
        return creditScore;
    }

    public void setCreditScore(CreditScore creditScore) {
        if(operLimitToggl&&(currentOpers >= operLimit)){
            System.out.println("Oper limit ends!");
            return;
        }
        this.creditScore = creditScore;
        currentOpers++;
    }
}


