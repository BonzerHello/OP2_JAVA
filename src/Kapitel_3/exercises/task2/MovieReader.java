package Kapitel_3.exercises.task2;


import com.opencsv.CSVReader;

import javax.imageio.IIOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/**
 * Created by tilli_000 on 03.03.2017.
 */
public class MovieReader {

    public static String ID = "id";
    public static String TITLE = "title";
    public static String COUNTRY = "country";
    public static String YEAR = "year";

    ArrayList<String> columns = new ArrayList<String>(){
        {
            add(ID);
            add(TITLE);
            add(COUNTRY);
            add(YEAR);
        }
    };


    public static void main(String[] args){

        boolean finish = false;

        ArrayList<Movie> movies = new ArrayList<Movie>();
        while (!finish){

            try{
                Scanner input = new Scanner(System.in);
                System.out.println("Enter File Name: ");
                String fileName = input.next();

                CSVReader reader = new CSVReader(new FileReader(fileName), ',');
                String[] nextLine;
                boolean firstLine = true;

                HashMap<Integer,String> map = new HashMap<Integer,String>();
                while((nextLine = reader.readNext()) != null){
                    int lengthNextLine = nextLine.length;
                    if(firstLine){
                        map = extractFirstLine(lengthNextLine,nextLine);
                        firstLine = false;
                    }else{
                        //Zeilen auslesen
                        Movie m = extractMovie(lengthNextLine,nextLine,map);
                        movies.add(m);
                    }
                }
                finish = true;
            }catch (FileNotFoundException e){
                System.err.println("File Not Found");
            }catch (NumberFormatException e){
                System.err.println("NumberFormatException");
            }
            catch (IOException e){
                System.err.println("IOException");
            }
        }

        for(Movie m:movies){
            System.out.println(m.getDescriptiom());
        }

    }

    private static Movie extractMovie(int lengthNextLine, String[] nextLine, HashMap<Integer,String> map) {
        Movie m = new Movie();
        for(int i = 0;i<lengthNextLine;i++){
            String val = nextLine[i].trim();
            String column = map.get(i);
            if(column.equals(ID)){
                m.setId(val);
            }else if(column.equals(TITLE)){
                m.setTitle(val);
            }else if(column.equals(COUNTRY)){
                m.setCountry(val);
            }else if(column.equals(YEAR)){
                m.setYear(Integer.parseInt(val));
            }
        }
        return m;
    }

    private static HashMap<Integer, String> extractFirstLine(int lengthNextLine, String[] nextLine) {
        HashMap<Integer,String> map = new HashMap<Integer,String>();
        for(int i = 0;i<lengthNextLine;i++){
            if(nextLine[i].equals(ID)){
                map.put(i,ID);
            }else if(nextLine[i].equals(TITLE)){
                map.put(i,TITLE);
            }else if(nextLine[i].equals(COUNTRY)){
                map.put(i,COUNTRY);
            }else if(nextLine[i].equals(YEAR)){
                map.put(i,YEAR);
            }
        }

        return map;
    }
}
