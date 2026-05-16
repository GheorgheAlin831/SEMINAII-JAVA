package bank;

import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountException;

public class BankAccount {
    private String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Eroare: Suma depusa trebuie sa fie mai mare decat 0! (Suma introdusa: " + amount + ")");
        }
        balance += amount;
        System.out.println("S-au depus " + amount + " RON in contul " + accountNumber + ". Sold curent: " + balance);
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException("Eroare: Suma retrasa trebuie sa fie mai mare decat 0!");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Eroare: Fonduri insuficiente in contul " + accountNumber + "! Sold disponibil: " + balance);
        }
        balance -= amount;
        System.out.println("S-au retras " + amount + " RON din contul " + accountNumber + ". Sold curent: " + balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}