package chattcp;

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
		int porta = 9999;
		try
		{
			ServerSocket server = new ServerSocket(porta);
			Socket client;
			ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

			while (true)
			{
				client = server.accept();
				SQLHelper help=new SQLHelper(client);
				executor.execute(help);
			}
		} catch (IOException ex)
		{
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
