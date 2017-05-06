package Kapitel_7.exercises.task3DateFormatting;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by tilli_000 on 31.03.2017.
 */
public class DateFormatTesting {

    public static void main(String[] args){
        DateFormat timeFormatterMediumGerman = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM,Locale.GERMAN);
        DateFormat timeFormatterShortGerman = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT,Locale.GERMAN);
        DateFormat timeFormatterLongGerman = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG,Locale.GERMAN);
        DateFormat timeFormatterFullGerman = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL,Locale.GERMAN);
       // String myText = timeFormatterMediumGerman.format(new Date());// or StringBuffer myTextBuffer = timeFormatter.format(myDate, buffer, fieldPosition);

        System.out.println("MyDate: "+timeFormatterShortGerman.format(new Date()));
        System.out.println("MyDate: "+timeFormatterMediumGerman.format(new Date()));
        System.out.println("MyDate: "+timeFormatterLongGerman.format(new Date()));
        System.out.println("MyDate: "+timeFormatterFullGerman.format(new Date()));

        DateFormat timeFormatterMediumJapan = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM,Locale.JAPAN);
        DateFormat timeFormatterShortJapan = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT,Locale.JAPAN);
        DateFormat timeFormatterLongJapan = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG,Locale.JAPAN);
        DateFormat timeFormatterFullJapan = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL,Locale.JAPAN);
        // String myText = timeFormatterMediumGerman.format(new Date());// or StringBuffer myTextBuffer = timeFormatter.format(myDate, buffer, fieldPosition);

        System.out.println("MyDate: "+timeFormatterMediumJapan.format(new Date()));
        System.out.println("MyDate: "+timeFormatterShortJapan.format(new Date()));
        System.out.println("MyDate: "+timeFormatterLongJapan.format(new Date()));
        System.out.println("MyDate: "+timeFormatterFullJapan.format(new Date()));
    }
}
