package prova.rectangle;

import javax.swing.*;
import java.awt.*;

public class RectangleDisplay extends JComponent {

    private Rectangle r;

    public RectangleDisplay(Rectangle r){
        this.r=r;
    }

    public void paintComponent(Graphics g){
        g.drawRect((int)r.getX(),(int)r.getY(),(int)r.getW(),(int)r.getH());
    }
}
