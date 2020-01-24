package es.eighteen.state;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input number of rows: ");
        int rows = in.nextInt();
        int n = 1;
        int k = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < k; j++){
                System.out.print(n+" ");
                n++;
            }
            System.out.println();
            k++;
        }
    }
}
