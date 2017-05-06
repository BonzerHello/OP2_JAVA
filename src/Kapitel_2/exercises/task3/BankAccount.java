package Kapitel_2.exercises.task3;

/**
 * A bank account has a balance that can be changed by deposits and withdrawals.
 */
public class BankAccount {
	private int accountNumber;
	private double balance;
	private String owner = "";
	private float interestRate = 0.0f;

	/**
	 * Constructs a bank account with a zero balance.
	 * 
	 * @param anAccountNumber
	 *            the account number for this account
	 */
	public BankAccount(int anAccountNumber) {
		accountNumber = anAccountNumber;
		balance = 0;
	}

	/**
	 * Constructs a bank account with a given balance.
	 * 
	 * @param anAccountNumber
	 *            the account number for this account
	 * @param initialBalance
	 *            the initial balance
	 */
	public BankAccount(int anAccountNumber, double initialBalance) {
		accountNumber = anAccountNumber;
		balance = initialBalance;
	}

	/**
	 * Constructs a bank account with a given balance.
	 * 
	 * @param anAccountNumber
	 *            the account number for this account
	 * @param initialBalance
	 *            the initial balance
	 * @param aName
	 *            the name of the owner of this account
	 * @param aRate
	 *            the interest rate for the account
	 */
	public BankAccount(int anAccountNumber, double initialBalance, String aName, float aRate)
{   
   accountNumber = anAccountNumber;
   balance = initialBalance;
   owner = aName;
   interestRate = aRate;
}

	/**
	 * Gets the account number of this bank account.
	 * 
	 * @return the account number
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Deposits money into the bank account.
	 * 
	 * @param amount
	 *            the amount to deposit
	 */
	public void deposit(double amount) {
		double newBalance = balance + amount;
		balance = newBalance;
	}

	/**
	 * Withdraws money from the bank account.
	 * 
	 * @param amount
	 *            the amount to withdraw
	 */
	public void withdraw(double amount) {
		double newBalance = balance - amount;
		balance = newBalance;
	}

	/**
	 * Gets the current balance of the bank account.
	 * 
	 * @return the current balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Gets the owner of the bank account.
	 * 
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Gets the current interest rate of the bank account.
	 * 
	 * @return the interest rate
	 */
	public float getInterestRate() {
		return interestRate;
	}

}
