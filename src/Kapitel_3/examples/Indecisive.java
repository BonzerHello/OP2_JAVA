package Kapitel_3.examples;

/**
 * Created by tilli_000 on 03.03.2017.
 */
public class Indecisive {
    public static void main(String[] args) {
        System.out.println(decision());
    }
    private static boolean decision() {
        try {
            return true;
        } finally {
            return false;
        }
    }
}
