package chattcp;

import java.net.Socket;

public class SQL implements Runnable
{
	Socket client;
	public SQL(Socket client){
		this.client=client;
	}

	@Override
	public void run()
	{
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
