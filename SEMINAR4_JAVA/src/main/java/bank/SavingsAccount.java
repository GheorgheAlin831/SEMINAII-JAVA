package bank;

import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountException;

public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("S-a aplicat dobanda de " + interest + " RON. Sold cont economii: " + balance);
    }

    @Override
    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        System.out.println("[Cont Economii] Se incearca o retragere...");
        super.withdraw(amount);
    }
}