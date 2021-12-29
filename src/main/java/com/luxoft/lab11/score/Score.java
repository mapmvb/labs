package com.luxoft.lab11.score;

import com.luxoft.lab11.Loggable;
import com.luxoft.lab11.MethodLimit;
import com.luxoft.lab11.account.Account;
import com.luxoft.lab11.money.Money;
import com.luxoft.lab11.money.MoneyInterface;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public abstract class Score implements MoneyInterface {
    private Money balance;
    private Account owner;
    private Integer number;
    private Map<String,Integer> methodConstrainMap;
    private Map<String,Integer> methodCallMap;

    public Score(Money balance, Account owner, Integer number) {
        this.balance = balance;
        this.owner = owner;
        this.number = number;
        this.methodConstrainMap = new HashMap<>();
        this.methodCallMap = new HashMap<>();

        Class<? extends Score> thisClass = this.getClass();
        for (Method method:
             thisClass.getDeclaredMethods()) {
            for (Annotation annotation:
             method.getDeclaredAnnotations()){
                if(annotation instanceof MethodLimit){
                    int limit = ((MethodLimit) annotation).limit();
                    methodConstrainMap.put(method.getName(), limit);
                    methodCallMap.put(method.getName(),0);
                    System.out.println("ctor- method " + method.getName() + " added to MethodLimit");
                }
            }
        }
    }

    public Money getBalance() {
        if (!isMethodAvailableByOperLimit("getBalance")) {
            System.out.println("  Method limit for getBalance is over!");
            return null;
        }
        logIfNeeded("getBalance");
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public void addMoney(Money money) {
        if (!isMethodAvailableByOperLimit("addMoney")) {
            System.out.println("  Method limit for addMoney is over!");
            return;
        }
        logIfNeeded("addMoney");
        double usdValueIn = money.getValue() * money.getCurrency().getUsdCourse();
        double usdValueThis = this.balance.getValue() * this.balance.getCurrency().getUsdCourse();
        if( usdValueThis < usdValueIn){
            System.out.println("You have no so money!");
            return;
        }

        if (checkBefore()){
            this.balance.setValue((usdValueIn+usdValueThis) *
                    this.balance.getCurrency().getUsdCourse());
        } else {
            System.out.println("No check");
        }
    }

    @Override
    public Money getMoney(double balanceLess) {
        if (!isMethodAvailableByOperLimit("getMoney")) {
            System.out.println("  Method limit for getMoney is over!");
            return null;
        }

        logIfNeeded("getMoney");

        if (balanceLess > 30000){
            throw new IllegalArgumentException("Wrong balance less");
        }
        this.balance.setValue(this.balance.getValue() - balanceLess);
        return this.balance;
    }

    @Override
    public Money getMoneyWithoutLess() {
        if (!isMethodAvailableByOperLimit("getMoneyWithoutLess")) {
            System.out.println("  Method limit for getMoneyWithoutLess is over!");
            return null;
        }

        logIfNeeded("getMoneyWithoutLess");
        return this.balance;
    }

    abstract boolean checkBefore();

    protected void logIfNeeded(String methodName){
        Class<? extends Score> thisClass = this.getClass();
        for (Annotation annotation :
                thisClass.getAnnotations()) {
            if(annotation instanceof Loggable){
                System.out.println("We call method: " + methodName);
            }
        }
    }

    protected boolean isMethodAvailableByOperLimit(String methodName){
        if(methodConstrainMap.containsKey(methodName)){
            int currentCalls = methodCallMap.get(methodName);
            int limitCalls = methodConstrainMap.get(methodName);

            if (currentCalls > limitCalls){
                return false;
            }
            currentCalls++;
            methodCallMap.put(methodName,currentCalls);
        }
        return true;
    }
}
