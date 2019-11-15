package es.seven.collection;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Integer> n;
    private static Scanner in;

    private static String find(Integer number){
        for(Integer num:n) if (num.equals(number)) return "Number found";
        return "Number not found";
    }

    public static void main(String[] args) {
        n=new ArrayList<>();
        in=new Scanner(System.in);
        for(int i=0;i<10;i++)
            n.add((i+1));
        System.out.print("Insert number to find: ");
        int number=in.nextInt();
        System.out.println(find(number));
    }
}
