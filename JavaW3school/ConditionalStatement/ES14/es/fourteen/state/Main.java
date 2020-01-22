package es.fourteen.state;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input the number: ");
        int n = in.nextInt();
        System.out.print("Input number of terms: ");
        int terms = in.nextInt();
        if (terms < 0)
            for (int i = 0;i>=terms;i--)
                System.out.println(n+" X "+i+" = "+n*i);
        else
            for (int i=0;i<=terms;i++)
                System.out.println(n+" X "+i+" = "+n*i);
    }
}
