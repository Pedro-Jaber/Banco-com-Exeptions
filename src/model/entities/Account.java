package model.entities;

import model.exceptions.WithdrawException;

public class Account {

    private Integer number;
    private String holder;
    protected Double balance;
    private Double withdrawLimit;

    public Account() {
    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    private void validateWithdraw(double amount) throws WithdrawException {
        // Verifica se o valor esteja > que o limite de saque:
        if (amount > getWithdrawLimit()) {
            throw new WithdrawException("The amount exceeds withdraw limit");
        }

        // Verifica se o valor é > que o saldo na conta:
        if (amount > getBalance()) {
            throw new WithdrawException("Not enough balance");
        }

        // Caso
        // o valor seja <= que o limite de saque e
        // o valor seja <= ao saldo da conta
        // Segue o baile
    }

    public void withdraw(double amount) throws WithdrawException {

        // Valida condições de saque
        validateWithdraw(amount);

        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }

}
