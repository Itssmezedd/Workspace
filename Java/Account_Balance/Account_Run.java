package Account_Balance;

import java.util.*;
import java.text.*;
public class Account_Run {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DecimalFormat f = new DecimalFormat("#,###,###.00");
        float balance_1, balance_2, withdraw1 = 0, withdraw2 = 0;
        float total;
        for (int i = 0; i < 2; i++) {
            System.out.print("account1 balance: $");
            balance_1 = input.nextFloat();
            System.out.print("account2 balance: $");
            balance_2 = input.nextFloat();
            System.out.println();

            // for Account1
            System.out.print("Enter withdrawal amount for account 1: ");
            withdraw1 = input.nextFloat();
            System.out.println("\n\nsubtracting " + withdraw1 + " from account1 balance");
            total = Account.Debit(balance_1, withdraw1);
            if (total < 0) {
                 System.out.println("Debit amount exceeded account balance.");
                 System.out.println("account1 balance: $" + f.format(balance_1));
                 System.out.println("account2 balance: $" + f.format(balance_1));
            } 
            else {
                System.out.println("account1 balance: $" + f.format(Account.Debit(balance_1, withdraw1)));
                System.out.println("account2 balance: $" + f.format(Account.Debit(balance_2, withdraw2)));
            }
            System.out.println();

            // for Account2
            System.out.print("Enter withdrawal amount for account 2: ");
            withdraw2 = input.nextFloat();
            total = Account.Debit(balance_1, withdraw2);
            if (total < 0) {
                 System.out.println("Debit amount exceeded account balance.");
                 System.out.println("account1 balance: $" + f.format(balance_1));
                 System.out.println("account2 balance: $" + f.format(balance_2));
            } 
            else {
                System.out.println("account1 balance: $" + f.format(Account.Debit(balance_1, withdraw1)));
                System.out.println("account2 balance: $" + f.format(Account.Debit(balance_2, withdraw2)));
            }
            System.out.println();
            System.out.println();
        }
        input.close();
    }
}

