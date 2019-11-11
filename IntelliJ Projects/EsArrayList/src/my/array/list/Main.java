package my.array.list;

import javax.swing.*;
import java.util.Vector;
public class Main {

    public static void main(String[] args) {
        MyCollection c = new MyCollection();
        c.add(new String("test")).add(new JFrame()).add("pippo").add(3);
        System.out.println(c.getLenght());
        System.out.println(c);
        String a = (String)c.get(1);
       /* Vector v = new Vector();
        v.add(null);*/

    }
}
