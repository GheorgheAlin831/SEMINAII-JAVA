package bank;

import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountException;

public class BankApp {
    public static void main(String[] args) {
        System.out.println("--- Sistem Bancar - Pornit ---\n");

        BankAccount contCurent = new BankAccount("RO12BANC0001", 500.0);
        SavingsAccount contEconomii = new SavingsAccount("RO55SAVINGS002", 1000.0, 0.05);

        try {
            System.out.println("--- Operatiuni Corecte ---");
            contCurent.deposit(200);
            contCurent.withdraw(300);

            contEconomii.deposit(500);
            contEconomii.applyInterest();
            System.out.println();
        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("--- Test: Depunere suma invalida ---");
            contCurent.deposit(-50);
        } catch (InvalidAmountException e) {
            System.out.println("Exceptie prinsa cu succes -> " + e.getMessage());
            System.out.println();
        }

        try {
            System.out.println("--- Test: Retragere peste limita soldului ---");
            contEconomii.withdraw(5000);
        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println("Exceptie prinsa cu succes -> " + e.getMessage());
        }

        System.out.println("\n--- Program finalizat cu succes ---");
    }
}