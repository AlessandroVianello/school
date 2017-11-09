package chattcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client
{

	public static void main(String[] args)
	{
		int porta = 9999;
		String host = "localhost";
		//Scanner sc = new Scanner(System.in);
		try
		{
			Socket s = new Socket(host, porta);
			ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
			Listen listen = new Listen(s);
			Write write = new Write(s);

			executor.execute(listen);
			executor.execute(write);

			/*while (true)
			{
			
				System.out.println(in.readLine());
				out.println(sc.nextLine());
			}*/
		} catch (IOException ex)
		{
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}

class Listen implements Runnable
{
	BufferedReader in;

	public Listen(Socket s)
	{
		try
		{
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		} catch (IOException ex)
		{
			Logger.getLogger(Listen.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public synchronized void run()
	{
		while (true)
		{
			try
			{
				System.out.println(in.readLine());
			} catch (IOException ex)
			{
				Logger.getLogger(Listen.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}

class Write implements Runnable
{
	PrintWriter out;
	Scanner sc = new Scanner(System.in);

	public Write(Socket s)
	{
		try
		{
			out = new PrintWriter(s.getOutputStream(), true);
		} catch (IOException ex)
		{
			Logger.getLogger(Write.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public synchronized void run()
	{
		while (true)
		{
			out.println(sc.nextLine());
		}
	}
}
