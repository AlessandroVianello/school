package chattcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client
{

	public static void main(String[] args)
	{
		int porta = 9999;
		String host = "localhost";
		Scanner sc=new Scanner(System.in);
		try
		{
			Socket s = new Socket(host, porta);
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			
			while(true){
				
				System.out.println(in.readLine());
				out.println(sc.nextLine());
			}
		} catch (IOException ex)
		{
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}