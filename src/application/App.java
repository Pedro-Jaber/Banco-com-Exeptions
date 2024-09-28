package application;

import java.util.Scanner;
import model.entities.Account;
import model.exceptions.WithdrawException;

public class App {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            // * Creating account

            System.out.println("Enter account data:");

            System.out.print("Number: ");
            int number = sc.nextInt();

            System.out.print("Holder: ");
            String holder = sc.next();

            System.out.print("Balance: ");
            Double balance = sc.nextDouble();

            System.out.print("Withdraw Limit: ");
            Double withdrawLimit = sc.nextDouble();

            Account acc = new Account(number, holder, balance, withdrawLimit);

            // * Withdraw

            System.out.print("Enter amount fot withdraw: ");
            Double amount = sc.nextDouble();

            try {
                acc.withdraw(amount);
                System.out.println("New balance: " + acc.getBalance());

            } catch (WithdrawException e) {
                System.out.println("Withdraw error: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
