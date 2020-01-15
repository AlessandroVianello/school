package es.nine.state;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Insert year: ");
        int year = in.nextInt();
        LeapYear x = new LeapYear();
        System.out.println(x.isLeap(year));
    }
}
