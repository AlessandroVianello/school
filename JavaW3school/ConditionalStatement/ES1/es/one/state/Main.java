package es.one.state;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Insert number to identify: ");
        int number = in.nextInt();
        PosOrNeg x = new PosOrNeg();
        if (x.isPosOrNeg(number))
            System.out.println("The number "+number+" is positive");
        else
            System.out.println("The number "+number+" is negative");
    }
}
