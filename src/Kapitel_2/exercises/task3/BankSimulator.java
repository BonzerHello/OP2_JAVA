package Kapitel_2.exercises.task3;

import java.io.IOException;
import java.util.Scanner;

/**
   This program demonstrates random access. You can access existing
   accounts and deposit money, or create new accounts. The
   accounts are saved in a random access file.
*/
public class BankSimulator
{  
   public static void main(String[] args)
         throws IOException
   {  
      Scanner in = new Scanner(System.in);
	  //BankDataInterface data = new BankData();
	  BankDataInterface data = new NIOBankData();
      try
      {  
         data.open("bank1.dat");

         boolean done = false;
         while (!done)
         {  
            System.out.print("Account number (negative number to delete account): ");
            int accountNumber = in.nextInt();
            int position = data.find(Math.abs(accountNumber));
            BankAccount account = null;
            double amount = 0;
            if (accountNumber > 0)
            {
               System.out.print("Amount to deposit: ");
               amount = in.nextDouble();
            }
            if (accountNumber != 0 && position >= 0)
            {
               if (accountNumber > 0)
               {
                  account = data.read(position);
                  System.out.println("Old balance: " 
                          + account.getBalance());
                  account.deposit(amount);
                  data.write(position, account);
                  System.out.println("New balance: " 
                     + account.getBalance());
                  System.out.println("Interest Rate: " + account.getInterestRate());
                  System.out.println("Owner: " + account.getOwner()+"");
               }
               else
               {
                  data.delete(position);
                  System.out.println("Account deleted.");
               }
            }
            else if (accountNumber > 0) // Add account
            {  
            	System.out.print("Account owner: ");
                String name = in.next();
                System.out.print("Interest Rate: ");
                float rate = in.nextFloat();
               account = new BankAccount(accountNumber, amount, name, rate);            	
               position = data.size();
               data.write(position, account);
               System.out.println("Adding new account.");
            }
            else 
               System.out.println("No such account.");

            System.out.print("Done? (Y/N) ");
            String input = in.next();
            if (input.equalsIgnoreCase("Y")) done = true;
         }      
      }
      finally
      {
         data.close();
         in.close();
      }
   }
}
