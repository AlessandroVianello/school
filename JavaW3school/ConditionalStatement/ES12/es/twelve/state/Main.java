package es.twelve.state;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] array = new double[5];
        System.out.println("Insert the 5 numbers: ");
        for (int i=0 ; i < 5;i++)
            array[i] = in.nextDouble();
        SumAndAverage x = new SumAndAverage();
        System.out.println("The sum of the 5 numbers is: "+x.getSum(array));
        System.out.println("The average is: "+x.getAverage(array));
    }
}
