package Topic01_Threads.exercises.Task01_MultiThreading;

import java.util.Random;

/**
 * Created by tilli_000 on 02.05.2017.
 */
public class BankAccount {


    private int balance;

    public BankAccount(){
        this.balance = 0;
    }

    public BankAccount(int amount){
        this.balance = amount;
    }


    /**
     * Geld einbezahlen
     * @param amount
     */
    public void deposit(int amount){
        this.balance += amount;
    }

    /**
     * Geld abheben
     * @param amount
     */
    public void withdraw(int amount) throws Exception{
        if(amount>this.balance){
            throw new Exception("Amount bigger than Balance");
        }
        else{
            this.balance -=amount;
        }
    }


    public int getBalance(){
        return this.balance;
    }


    public void randomTransfer(BankAccount other) throws Exception{
        int otherAccountBalance = other.getBalance();
        Random random = new Random();
        int randomAmmount = random.nextInt(otherAccountBalance);
        if(randomAmmount >= 0 && randomAmmount <=this.balance);{
            other.withdraw(randomAmmount);
            deposit(randomAmmount);
        }

    }
}
