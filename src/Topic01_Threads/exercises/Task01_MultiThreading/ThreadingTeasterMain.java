package Topic01_Threads.exercises.Task01_MultiThreading;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by tilli_000 on 02.05.2017.
 */
public class ThreadingTeasterMain {

    static Random random = new Random();

    public static void main(String[] args){
        ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();
        int n = 100;
        int m = 100;
        for(int i = 0;i<n;i++){
            bankAccounts.add(new BankAccount(100));
        }
        for (int i = 0;i<m;i++){
            Thread thread = new Thread(() ->{
               try{
                   BankAccount o1 = bankAccounts.get(random.nextInt(n));
                   BankAccount o2 = bankAccounts.get(random.nextInt(n));
                   if(!o1.equals(o2)) {
                       o1.randomTransfer(o2);
                   }
                   }catch(Exception e){

                   }


            });
            thread.start();

        }
    }
}
