package chattcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Chat
{
	public LinkedList<Socket> list = new LinkedList<Socket>();
	PrintWriter out;

	public void notify(String s, Socket socket)
	{
		if (s.equalsIgnoreCase("Fine chat"))
		{
			this.remove(socket);
		}
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) != socket)
			{

				try
				{
					out = new PrintWriter(list.get(i).getOutputStream());
					out.println(s);

				} catch (IOException ex)
				{
					Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}

	

	public void add(Socket s)
	{
		list.add(s);
	}

	public void remove(Socket s)
	{
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) == s)
			{
				list.remove(i);
			}
		}
	}

	public Socket getSocket(Socket s)
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
