package Kapitel_3.examples.bank_with_excep;

import java.util.Scanner;

/**
 * With this program you can create new accounts, access existing accounts and
 * deposit money.
 */
public class BankSimulator {
	public static void main(String[] args) {

		Bank myBank = new Bank();
		Scanner in = new Scanner(System.in);

		boolean done = false;
		while (!done) {
			System.out.print("Account number: ");
			int accountNumber = in.nextInt();
			System.out.print("Amount to deposit/withdraw: ");
			double amount = in.nextDouble();

			BankAccount account = myBank.find(accountNumber);
			if (account != null) {
				try {
					if (amount > 0) {
						account.deposit(amount);
					} else {
						account.withdraw(Math.abs(amount));
					}
				} catch (IllegalArgumentException e) {
					System.out.println("Transaction failed: " + e.getMessage());
				}

				System.out.println("New balance: " + account.getBalance());
			} else // Add account
			{
				account = new BankAccount(accountNumber, amount);
				System.out.println("Adding new account.");
				System.out.println("Balance: " + account.getBalance());
			}
			myBank.addAccount(account);

			System.out.print("Done? (Y/N) ");
			String input = in.next();
			if (input.equalsIgnoreCase("Y"))
				done = true;
		}
		in.close();
	}
}
