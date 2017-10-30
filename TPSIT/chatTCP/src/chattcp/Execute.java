package chattcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Execute implements Runnable
{
	Chat chat = new Chat();
	BufferedReader in;
	PrintWriter out;
	String mes;
	Socket s;

	public Execute(Socket s,Chat chat)
	{
		this.s = s;
		this.chat=chat;
		this.chat.add(this.s);
		try
		{
			in = new BufferedReader(new InputStreamReader(chat.getSocket(this.s).getInputStream()));
			out=new PrintWriter(chat.getSocket(this.s).getOutputStream(),true);
		} catch (IOException ex)
		{
			Logger.getLogger(Execute.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void run()
	{
		boolean x = false;
		while (true)
		{
			if (!x)
			{
				out.println("Benvenuto");
				x = true;
			}
			try
			{
				mes = in.readLine();
				chat.notify(mes, s);
			} catch (IOException ex)
			{
				Logger.getLogger(Execute.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

}