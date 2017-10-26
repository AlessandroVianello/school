import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DateClient {
	static String localhost="localhost";
	public static void main (String[] args) {
		try {
			Socket socket=new Socket(localhost,9090);
			BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String data=in.readLine();
			System.out.println(data);
			socket.close();
			
		} catch (IOException ex) {
			Logger.getLogger(DateClient.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}

