package Kapitel_2.exercises.task4;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by tilli_000 on 01.03.2017.
 */
public class ProductTester {

    public static void main(String[] args) throws Exception{


        ArrayList<Product> res;

        File f = new File("product.dat");
        if (f.exists()) {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
            res = (ArrayList<Product>) in.readObject();
            in.close();
        } else {
            res = new ArrayList<Product>();
            res.add(new Product("test1",25.0,2));
            res.add(new Product("test2",23.0,4));
            res.add(new Product("test3",12.0,5));
            res.add(new Product("test4",567.0,8));
        }


        for(Product p:res){
            p.setQuantity(p.getQuantity() + 1);
        }

        for(Product p:res){
            System.out.println(p.toString());
        }

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("product.dat"));
        out.writeObject(res);




    }
}
