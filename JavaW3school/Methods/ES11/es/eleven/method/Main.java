package es.eleven.method;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("1. A password must have at least eight characters.\n" +
            "2. A password consists of only letters and digits.\n" +
            "3. A password must contain at least two digits.\n" +
            "Input a password (You are agreeing to the above Terms and Conditions.): ");
        System.out.println(new PasswordHandler(new Scanner(System.in).nextLine()).checkPassword());
    }
}
