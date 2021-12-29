package com.luxoft.lab5;

import com.luxoft.lab5.money.Money;
import com.luxoft.lab5.score.CreditScore;
import com.luxoft.lab5.score.CurrentScore;
import com.luxoft.lab5.score.DebetScore;
import org.junit.jupiter.api.Test;

public class ATMTest {
    private static ATM atm;

    @Test
    void TestATM1(){
        atm= new ATM();
        CreditScore creditScore = atm.getCreditScore();
        DebetScore debetScore = atm.getDebetScore();
        CurrentScore currentScore = atm.getCurrentScore();

        atm.addToCredit(1000);
        creditScore.getMoney(1000);
    }
}
