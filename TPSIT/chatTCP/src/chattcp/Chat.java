package chattcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Chat {

    public List<Socket> list = new LinkedList<Socket>();
    PrintWriter out;
    DatabaseSQL database;
    
    public Chat(DatabaseSQL database){
        this.database=database;
    }

    /*public synchronized void notify(String s, Socket socket) {
        System.out.println("prova");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != socket) {

                try {
                    out = new PrintWriter(list.get(i).getOutputStream(), true);
                    out.println(s);
                    System.out.println("inviato");

                } catch (IOException ex) {
                    Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }*/
	public synchronized void notify(String s, Socket socket) {
		PrintWriter out=null;
		try
		{
			System.out.println("prova");
			Scanner sc=new Scanner (System.in);
			boolean x=false;
			out = new PrintWriter(socket.getOutputStream(), true);
			out.print("Inserire user per iniziare chat: ");
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String user=in.readLine();
			while(!x){
				
			}
		} catch (IOException ex)
		{
			Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
		} 
    }

    public synchronized void add(Socket s) {
        list.add(s);
    }

    public synchronized void remove(Socket s) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == s) {
                list.remove(i);
            }
        }
    }

    public synchronized Socket getSocket(Socket s) {
        Socket so = s;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == s) {
                so = list.get(i);
            }
        }
        return so;
    }

    public synchronized void printAllSocket() {
        for (Integer i = 0; i < list.size(); i++) {
            try {
                out = new PrintWriter(list.get(i).getOutputStream(), true);
                database.printUser("database.sqlite",list.get(i));
            } catch (IOException ex) {
                Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
