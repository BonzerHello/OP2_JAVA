package Kapitel_2.exercises.task1;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by tilli_000 on 22.02.2017.
 */
public class FileAnalyzer {

    public static void main(String[] args) throws Exception{

        Scanner console = new Scanner(System.in);
        System.out.print("Filename: ");
        String inputFileName = console.next();

        FileReader reader = new FileReader(inputFileName);
        Scanner in = new Scanner(reader);
        //Characters
        int characters = 0;
        int nbrLines = 0;
        int words = 0;
        while(in.hasNextLine()){
            nbrLines ++;
            String line = in.nextLine();
            characters += line.length();
            words += new StringTokenizer(line, " ").countTokens();

        }

        


        System.out.println("Characters: "+characters);
        System.out.println("Words: "+words);
        System.out.println("Lines: "+nbrLines);







    }
}
