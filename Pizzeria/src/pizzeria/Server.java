package pizzeria;

import java.io.IOException;
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
		final int porta = 8888;
		Socket client;
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

		try
		{
			ServerSocket server = new ServerSocket(porta);
			System.out.println("Server nella porta " + porta);
			while (true)
			{
				System.out.println("Attesa client");
				client = server.accept();
				System.out.println("Client accettato");
				System.out.println();
				System.out.println();
				System.out.println();

				Pizzeria ris;
				ris = new Pizzeria(client);
				executor.execute(ris);

			}

		} catch (IOException ex)
		{
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

}
