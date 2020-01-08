package es.three.state;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int number1,number2,number3;
        number1=0;
        number2=0;
        number3=0;
        for (int i=0; i<3; i++) {
            if (i == 0) {
                System.out.print("Insert number: ");
                number1 = in.nextInt();
            }
            if (i == 1) {
                System.out.print("Insert number: ");
                number2 = in.nextInt();
            }
            if (i == 2) {
                System.out.print("Insert number: ");
                number3 = in.nextInt();
            }
        }
        SearchMax x = new SearchMax();
        System.out.println("The greatest: "+x.findMax(number1,number2,number3));

    }
}
