package es.eight.state;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Insert an alphabet: ");
        String letter = in.nextLine();
        LetterType x = new LetterType();
        System.out.println(x.getType(letter));
    }
}
