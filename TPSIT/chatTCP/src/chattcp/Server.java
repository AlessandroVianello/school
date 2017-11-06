package chattcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server
{
	public static void main(String[] args)
	{
		int porta = 9999;
		try
		{
			ServerSocket server = new ServerSocket(porta);
			Socket client;
			Chat chat = new Chat();
			boolean register = false;
			PrintWriter out;
			BufferedReader in;
			Integer scelta;
			ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
			DatabaseSQL database = new DatabaseSQL();
			database.newDatabase("database.sqlite3");
			database.createTable("database.sqlite3");

			while (true)
			{
				client = server.accept();
				chat.add(client);
				out=new PrintWriter(client.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				while (!register)
				{
					out.println("1) Registrazione");
					out.println("2) Accedi");
					out.print("La tua scelta: ");
					scelta=in.read();
					
					if(scelta==1){
						
					}
				}
				executor.execute(new Execute(client, chat));

			}
		} catch (IOException ex)
		{
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
