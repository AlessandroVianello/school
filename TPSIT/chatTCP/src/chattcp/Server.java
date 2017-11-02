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
			Chat chat = new Chat();
			ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

			while (true)
			{
				client = server.accept();
				chat.add(client);
				executor.execute(new Execute(client, chat));
				//SQLHelper help=new SQLHelper(client);

			}
		} catch (IOException ex)
		{
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
