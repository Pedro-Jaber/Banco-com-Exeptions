package model.entities;

import model.exceptions.WithdrawException;

public class BusinessAccount extends Account {

    private Double loanLimit;

    public BusinessAccount() {
        super();
    }

    public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
        super(number, holder, balance, 1000.0);
        this.loanLimit = loanLimit;
    }

    public Double getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(Double loanLimit) {
        this.loanLimit = loanLimit;
    }

    public void loan(double amount) {
        if (amount <= loanLimit) {
            // deposit(amount);
            balance += amount - 10.0;
        }
    }

    @Override
    public void withdraw(double amount) throws WithdrawException {
        super.withdraw(amount + 2.0);
    }

}
