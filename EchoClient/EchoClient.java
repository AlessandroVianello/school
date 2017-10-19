
import java.io.*;
import java.net.*;
import java.lang.Thread;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EchoClient {
	static String host = "localhost";

	public static void main(String args[]) {
		try {
			Scanner input = new Scanner(System.in);
			Socket socket = new Socket(host, 9999);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintStream out = new PrintStream(socket.getOutputStream());

			System.out.print("Inserire frase: ");
			out.print(input.nextLine());
			System.out.println(in.readLine());
		} catch (IOException ex) {
			Logger.getLogger(EchoClient.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
