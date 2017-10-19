package pizzeria;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BTree1<E> {

    public Node root;
    private static String domanda;
    private static String txtLeft;
    private static String txtRight;
    private static String txtFoglia;
    private Socket client;
    PrintWriter output;
    public static int depth = 0;

    public BTree1(Socket client) {
        Node x = new Node("Salve! Vuole ordinare?");
        this.client = client;
        try {
            output = new PrintWriter(this.client.getOutputStream(), true);
        } catch (IOException ex) {
            Logger.getLogger(BTree.class.getName()).log(Level.SEVERE, null, ex);
        }
        root = x;
    }

    public BTree1(Socket client,String[] array) {
        this.client=client;
        try {
            output=new PrintWriter(this.client.getOutputStream(), true);
        } catch (IOException ex) {
            Logger.getLogger(BTree.class.getName()).log(Level.SEVERE, null, ex);
        }
        Node x = new Node("Salve! Vuole ordinare?");
        root=x;
        for (int cont = 0; cont != array.length; cont++) {
            domanda = array[cont];
            preOrderTraversal(root);
            depth++;
        }
    }

    public void solution(String x) {
        Node sol;
        sol = root;
        output.println(sol.element);
        String risposta = x;
        boolean fin = false;
        while (!fin) {
            if (risposta.equalsIgnoreCase("no") && sol.leftChild != null) {
                sol = sol.leftChild;
                output.println(sol.element);
            }
            if (risposta.equalsIgnoreCase("si") && sol.rightChild != null) {
                sol = sol.rightChild;
                output.println(sol.element);
            }
            if (risposta.equalsIgnoreCase("no") && sol.leftChild == null && sol.rightChild == null) {
                output.println(sol.element);
                fin = true;
            }
            if (risposta.equalsIgnoreCase("no") && sol.leftChild == null && sol.rightChild == null) {
                output.println(sol.element);
                fin = true;
            }
        }
        try {
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(BTree.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void add(String dom, String left, String right, String foglia) {
        domanda = dom;
        txtLeft = left;
        txtRight = right;
        txtFoglia = foglia;
        preOrderTraversal2(root);
    }

    public static void levelOrderPrint(Node e) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(e);
        while (!queue.isEmpty()) {
            Node node = queue.remove(0);
            print(node);
            if (node.leftChild != null) {
                queue.add(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.add(node.rightChild);
            }
        }
    }

    private static void preOrderTraversal(Node x) {
        if (x == null) {
            return;
        }
        visit(x, domanda);
        preOrderTraversal(x.leftChild);
        preOrderTraversal(x.rightChild);
    }

    private static void preOrderTraversal2(Node x) {
      /*  if (x.element.equalsIgnoreCase(txtFoglia) && x.leftChild == null && x.rightChild == null) {
            visit2(x, domanda, txtLeft, txtRight);
            return;
        }*/
        preOrderTraversal2(x.leftChild);
        preOrderTraversal2(x.rightChild);
    }

    private static void visit(Node x, String stringa) {
        if (x.element == null) {
            x.element = stringa;
        } else {
            return;
        }
    }

    private static void visit2(Node x, String dom, String left, String right) {
        Node leftChild = x.leftChild;
        Node rightChild = x.rightChild;
        x.element = dom;
        leftChild.element = left;
        rightChild.element = right;
        depth++;
    }

    private static void print(Node x) {
        System.out.println(x.element);
    }
}
