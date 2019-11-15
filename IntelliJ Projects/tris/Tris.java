package tris;

import javax.swing.JFrame;
import static tris.TrisGame.Symbols.*;

public class Tris{
        
    public static void main(String[] args) {
        JFrame window = new JFrame("Balance Display");
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TrisDisplayComponent display = new TrisDisplayComponent();
        TrisGame game = new TrisGame(display);
        window.add(display);
        window.setVisible(true);
    }
    
}
