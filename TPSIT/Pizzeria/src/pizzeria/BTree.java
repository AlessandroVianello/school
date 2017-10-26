package pizzeria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BTree
{
	Node root;
	Socket client;
	BufferedReader in;
	PrintWriter out;
	int depth = 0;

	public BTree(Socket client)
	{
		root = new Node("Salve! Vuole ordinare?");
		this.client = client;
		try
		{
			in = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
			out = new PrintWriter(this.client.getOutputStream(), true);
		} catch (IOException ex)
		{
			Logger.getLogger(BTree.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void solution()
	{
		try
		{
			Node sol = root;
			out.println(sol.element);
			String ris = in.readLine();
			boolean end = false;
			while (!end)
			{
				if (ris.equalsIgnoreCase("no") && sol.rightChild != null && sol.parent == null)
				{
					sol.rightChild.parent = sol;
					sol = sol.rightChild;
					out.println(sol.element);
					depth++;
					end = true;
				}
				if (ris.equalsIgnoreCase("si") && sol.leftChild != null && sol.parent == null)
				{
					sol.leftChild.parent = sol;
					sol = sol.leftChild;
					out.println(sol.element);
					depth++;
				}
				if (ris.equalsIgnoreCase("no") && sol.rightChild != null && sol.parent != null)
				{
					sol.leftChild.parent = sol;
					sol = sol.leftChild;
					out.println(sol.element);
					depth++;
				}
				if (ris.equalsIgnoreCase("si") && sol.leftChild != null && sol.parent != null)
				{
					sol.leftChild.parent = sol;
					sol = sol.leftChild;
					out.println(sol.element);
					depth++;
				}
				if (ris.equalsIgnoreCase("si") && sol.leftChild == null && sol.parent != null)
				{
					sol.leftChild.parent = sol;
					sol = sol.leftChild;
					out.println(sol.element);
					depth++;
					end = true;
				}
				if (ris.equalsIgnoreCase("no") && sol.rightChild == null && sol.parent != null)
				{
					sol.leftChild.parent = root;
					sol = root.leftChild;
					out.println(sol.element);
					depth = 1;
				}
			}
			client.close();

		} catch (IOException ex)
		{
			Logger.getLogger(BTree.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void addNode(String dom, String si_no)
	{
		Node x = root;
		if (si_no.equalsIgnoreCase("no"))
		{
			x.rightChild.parent = x;
			x = x.rightChild;
			x.element = dom;
		}
		if (si_no.equalsIgnoreCase("si"))
		{
			x.leftChild.parent = x;
			x = x.leftChild;
			x.element = dom;
		}
	}

}
