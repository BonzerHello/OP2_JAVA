package Kapitel_7.exercises.task2MyLocal;

/**
 * Created by tilli_000 on 31.03.2017.
 */
import java.util.Locale;
public class MyLocale {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        System.out.println("Land:" + locale.getCountry());
        System.out.println("Sprache:" + locale.getCountry());
        System.out.println("Variante:" + locale.getVariant());
    }
}