package es.twentyeight.state;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Insert number: ");
        float n = in.nextFloat();
        InfoNumber x = new InfoNumber();
        System.out.println(x.getInfo(n));
    }
}
