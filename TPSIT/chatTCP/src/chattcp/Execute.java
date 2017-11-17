package chattcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Execute implements Runnable {

    Chat chat;
    BufferedReader in;
    PrintWriter out;
    String mes;
    Socket s;
    DatabaseSQL database;

    public Execute(Socket s, Chat chat, DatabaseSQL database) {
        this.s = s;
        this.database = database;
        this.chat = chat;
        try {
            in = new BufferedReader(new InputStreamReader(chat.getSocket(this.s).getInputStream()));
            out = new PrintWriter(chat.getSocket(this.s).getOutputStream(), true);
        } catch (IOException ex) {
            Logger.getLogger(Execute.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public synchronized void run() {
        boolean x = false;
        while (true) {
            if (!x) {
                out.println("Benvenuto");
                out.println("Sono online:");
                chat.printAllSocket();
                x = true;
            }
            try {
                mes = in.readLine();
                if (mes.equals("!esci")) {
                    s.close();
                } else {
                    System.out.println("passato");
                    chat.notify(mes, s);
                }
            } catch (IOException ex) {
                Logger.getLogger(Execute.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
