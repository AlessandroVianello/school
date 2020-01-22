package es.thirteen.state;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input number of terms: ");
        int terms = in.nextInt();
        for (int i=1;i<=terms;i++){
            int n3 = i*i*i;
            System.out.println("Number is: "+i+" and cube of "+i+" is "+n3);
        }
    }
}
