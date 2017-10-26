package pizzeria;

import java.net.Socket;
import java.util.Scanner;

public class Pizzeria implements Runnable
{

	Socket client;
	String ris = "";
	BTree tree;
	Scanner sc = new Scanner(System.in);

	public Pizzeria(Socket client)
	{
		this.client = client;
		tree = new BTree(this.client);
		System.out.print("Inserire n° domande: ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++)
		{
			System.out.println("Inserire domanda.");
			String dom = sc.nextLine();
			System.out.println("Inserire se posizionato in caso di si o no----[SI/NO]");
			String si_no = sc.next();
			tree.addNode(dom, si_no);
		}
	}

	@Override
	public void run()
	{
		tree.solution();
	}
}
