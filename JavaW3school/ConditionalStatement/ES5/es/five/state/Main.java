package es.five.state;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        FindWeek x = new FindWeek();
        System.out.print("Insert number from 1 to 7: ");
        System.out.println(x.weekday(in.nextInt()));
    }
}
