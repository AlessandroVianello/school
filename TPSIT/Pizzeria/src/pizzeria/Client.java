package pizzeria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {

    public static void main(String[] args) {
        String host = "localhost";
        final int porta = 8888;
        Scanner in = new Scanner(System.in);
        String ris = "";

        try {
            Socket socket = new Socket(host, porta);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            while (!ris.equalsIgnoreCase("grazie per l'acquisto")) {
                System.out.println(input.readLine());
                ris = in.nextLine();
                output.println(ris);
            }

        } catch (Exception ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
