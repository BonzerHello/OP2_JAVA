package Topic00_Recursion.exercises.task01;

/**
 * Created by tilli_000 on 06.05.2017.
 */
public class RecursionImplement {

    public static void main(String[] args){
        RecursionImplement ri = new RecursionImplement();
        //ri.printInteger(61,10);
        ri.hanoi(4);

    }


    public void printInteger(int n, int b){
        if(n<b){
            System.out.print(n);
        }else{
            printInteger((n/b),b);
            System.out.print(n%b);
        }
    }


    public void hanoi(int n){
        recHanoi(n,1,3);
    }

    private void recHanoi(int n, int from, int to) {
        if( n == 1){
            System.out.println(from+" => "+to);
        }else{
            int other = 6-(from+to);
            recHanoi(n-1,from,other);
            recHanoi(1,from,to);
            recHanoi(n-1,other,to);
        }
    }


}
