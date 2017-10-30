package chattcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Chat
{
	public List<Socket> list = new LinkedList<Socket>();
	PrintWriter out;

	public synchronized void notify(String s, Socket socket)
	{
		System.out.println("prova");
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) != socket)
			{

				try
				{
					out = new PrintWriter(list.get(i).getOutputStream(),true);
					out.println(s);
					System.out.println("inviato");

				} catch (IOException ex)
				{
					Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}

	

	public synchronized void add(Socket s)
	{
		list.add(s);
	}

	public synchronized void remove(Socket s)
	{
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) == s)
			{
				list.remove(i);
			}
		}
	}

	public synchronized Socket getSocket(Socket s)
	{
		Socket so = s;
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) == s)
			{
				so = list.get(i);
			}
		}
		return so;
	}

}
