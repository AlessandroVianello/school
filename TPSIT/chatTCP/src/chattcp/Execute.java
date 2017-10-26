package chattcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Execute implements Runnable
{
	Chat chat = new Chat();
	BufferedReader in;
	String mes;
	Socket s;

	public Execute(Socket s)
	{
		this.s = s;
		chat.add(s);
		try
		{
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
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
				chat.notify("Benvenuti", s);
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
