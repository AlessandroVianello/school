package es.thirtyone.state;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input first number: ");
        int n1 = in.nextInt();
        System.out.print("Input second number: ");
        int n2 = in.nextInt();
        System.out.print("Input third number: ");
        int n3 = in.nextInt();
        CheckOrder x = new CheckOrder();
        System.out.println(x.checkOrder(n1,n2,n3));
    }
}
