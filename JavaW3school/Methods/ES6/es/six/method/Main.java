package es.six.method;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in;
        System.out.print("Insert number: ");
        in=sc.nextLine();

        SumNumbers s = new SumNumbers(in);
        int x = s.sum();

        System.out.println(x);

    }
}
