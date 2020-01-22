package es.fifteen.state;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Insert number of terms: ");
        int terms = in.nextInt();
        if (terms <= 0)
            System.out.println("Number of terms must be higher than '0'");
        else {
            int[] oddNumbers = new int[terms];
            oddNumbers[0] = 1;
            int n = 2;
            int sum = 0;
            for (int i = 1; i < terms; ) {
                if (n % 2 != 0) {
                    oddNumbers[i] = n;
                    i++;
                }
                n++;
            }
            for (int number : oddNumbers) {
                System.out.println("The odd numbers are: ");
                System.out.println(number);
            }
            for (int oddNumber : oddNumbers)
                sum += oddNumber;
            System.out.println("The sum of odd numbers up to " + terms + " is: " + sum);
        }
    }
}
