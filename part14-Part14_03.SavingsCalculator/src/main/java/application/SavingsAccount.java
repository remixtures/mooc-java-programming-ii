/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author miguel
 */
public class SavingsAccount {
    
    private double balance;
    private double balanceWithoutInterest;
    private double monthlyRecord;
    private double annualInterestRate;

    public SavingsAccount(double monthlyRecord, double annualInterestRate) {
        this.monthlyRecord = monthlyRecord;
        this.annualInterestRate = annualInterestRate;
    }

    public double getInterestRate() {
        return this.annualInterestRate;
    }

    public double getMonthlyRecord() {
        return this.monthlyRecord;
    }

    public void increaseYear() {
        this.balance += 12 * monthlyRecord;
        this.balance += (double) balance * (this.annualInterestRate / 100);
        this.balanceWithoutInterest += 12 * monthlyRecord;
    }

    public double getBalance() {
        return balance;
    }

    public double getBalanceWithoutInterest() {
        return this.balanceWithoutInterest;
    }

    public void setInterestRate(double annualRate) {
        this.balance = 0;
        this.annualInterestRate = annualRate;
        this.balanceWithoutInterest = 0;
    }

    public void setMonthlyRecord(double monthlyRecord) {
        this.balance = 0;
        this.monthlyRecord = monthlyRecord;
        this.balanceWithoutInterest = 0;
    }
}
