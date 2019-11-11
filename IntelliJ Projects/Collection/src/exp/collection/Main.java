package exp.collection;

import javax.swing.*;
import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
        Collection<String> c = new Collection<>();
        Collection<JFrame> frames = new Collection<>();
        c.daringAdd("test");
        c.daringAdd("Pippo");
        frames.add(new JFrame("Pippo"));
        System.out.println(c.elementAt(1));
        int pos=c.elementAt(0).indexOf("st");
        System.out.println(pos);
    }
}
