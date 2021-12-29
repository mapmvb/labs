package com.luxoft.lab11;

import com.luxoft.lab11.ATM;
import com.luxoft.lab11.score.CreditScore;
import com.luxoft.lab11.score.CurrentScore;
import com.luxoft.lab11.score.DebetScore;
import org.junit.jupiter.api.Test;

public class LogATMTest {

    private static com.luxoft.lab11.ATM atm;

    @Test
    void TestATM1(){
        atm= new ATM();
        CreditScore creditScore = atm.getCreditScore();
        DebetScore debetScore = atm.getDebetScore();
        CurrentScore currentScore = atm.getCurrentScore();

        atm.addToCredit(1000);
        atm.addToCredit(2000);
        atm.addToCredit(3000);
        atm.addToCredit(4000);
        atm.addToCredit(5000);
        atm.addToCredit(5000);

        creditScore.getMoney(3000);
        creditScore.getMoney(2000);
        creditScore.getMoney(1000);
        creditScore.getMoney(4000);
        creditScore.getMoney(4000);
        creditScore.getMoney(4000);
    }
}
