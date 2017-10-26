package pizzeria;

import java.net.Socket;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pizzeria_NON_USARE implements Runnable {

    Socket client;
    String ris = "";

    public Pizzeria_NON_USARE(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        String s;
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter output = new PrintWriter(client.getOutputStream(), true);
            while (true) {
                output.println("Salve!\tEcco le pizze che puoi ordinare: [Margherita/Marinara/Diavola/Quattro Stagioni/Porcini/Tonno e Cipolle/Prosciutto e Funghi]");
                s = input.readLine();

                if (s.equalsIgnoreCase("margherita")) {
                    output.println("Sono 5€.\tVuoi pagare? Si o No.");
                    ris = input.readLine();
                    if (ris.equalsIgnoreCase("Si")) {
                        output.println("Grazie per l'acquisto.");
                        ris="fine";
                    }
                }
                
                if (s.equalsIgnoreCase("marinara")) {
                    output.println("Sono 4€.\tVuoi pagare? Si o No.");
                    ris = input.readLine();
                    if (ris.equalsIgnoreCase("Si")) {
                        output.println("Grazie per l'acquisto.");
                        ris="fine";
                    }
                }
                
                if (s.equalsIgnoreCase("diavola")) {
                    output.println("Sono 7€.\tVuoi pagare? Si o No.");
                    ris = input.readLine();
                    if (ris.equalsIgnoreCase("Si")) {
                        output.println("Grazie per l'acquisto.");
                        ris="fine";
                    }
                }
                
                if (s.equalsIgnoreCase("quattro stagioni")||s.equalsIgnoreCase("quattrostagioni")) {
                    output.println("Sono 7,50€.\tVuoi pagare? Si o No.");
                    ris = input.readLine();
                    if (ris.equalsIgnoreCase("Si")) {
                        output.println("Grazie per l'acquisto.");
                        ris="fine";
                    }
                }
                
                if (s.equalsIgnoreCase("porcini")) {
                    output.println("Sono 7€.\tVuoi pagare? Si o No.");
                    ris = input.readLine();
                    if (ris.equalsIgnoreCase("Si")) {
                        output.println("Grazie per l'acquisto.");
                        ris="fine";
                    }
                }
                
                if (s.equalsIgnoreCase("Tonno e Cipolle")||s.equalsIgnoreCase("TonnoeCipolle")||s.equalsIgnoreCase("tonnocipolle")||s.equalsIgnoreCase("tonno cipolle")) {
                    output.println("Sono 7€.\tVuoi pagare? Si o No.");
                    ris = input.readLine();
                    if (ris.equalsIgnoreCase("Si")) {
                        output.println("Grazie per l'acquisto.");
                        ris="fine";
                    }
                }
                
                if (s.equalsIgnoreCase("Prosciutto e Funghi")||s.equalsIgnoreCase("prosciuttoefunghi")||s.equalsIgnoreCase("prosciuttofunghi")||s.equalsIgnoreCase("prosciutto funghi")) {
                    output.println("Sono 7€.\tVuoi pagare? Si o No.");
                    ris = input.readLine();
                    if (ris.equalsIgnoreCase("Si")) {
                        output.println("Grazie per l'acquisto.");
                        ris="fine";
                    }
                }
                if (ris.equalsIgnoreCase("fine")) {
                    break;
                }
            }
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(Pizzeria_NON_USARE.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
