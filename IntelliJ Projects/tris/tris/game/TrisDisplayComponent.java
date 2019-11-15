package tris.game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JComponent;
import static tris.game.TrisGame.Symbols.*;

public class TrisDisplayComponent extends JComponent{

    private TrisGame.Symbols[][] grid;
    
    public TrisDisplayComponent()
    {
        grid = new TrisGame.Symbols[3][3];
        clear();
    }
    
    public void addListener(TrisDisplayListener listener)
    {
        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e)
            {
                int x = e.getX();
                int y = e.getY();
                listener.cellClicked(x*3/getWidth(), y*3/getHeight());
            }
        });                        
    }
        
    public void set(int x, int y, TrisGame.Symbols symbol)
    {
        grid[x][y] = symbol;
        repaint();
    }
    
    public void clear()
    {
        for(int x=0; x<3; x++)
            for(int y=0; y<3; y++)
                grid[x][y] = EMPTY;
        repaint();
    }
            
    public void paintComponent(Graphics gr)
    {
        Graphics2D g = (Graphics2D)gr;
        double w = getWidth();
        double h = getHeight();
        double cw = w/3;
        double ch = h/3;
        double m = cw/8;
        g.setColor(Color.black);
        g.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g.draw(new Line2D.Double(cw,0,cw,h));
        g.draw(new Line2D.Double(cw*2,0,cw*2,h));
        g.draw(new Line2D.Double(0,ch,w,ch));
        g.draw(new Line2D.Double(0,ch*2,w,ch*2));
        g.setStroke(new BasicStroke(8, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        for(int x=0; x<3; x++)
            for(int y=0; y<3; y++)
                switch(grid[x][y])
                {
                    case EMPTY: 
                        break;
                    case CROSS: 
                        g.setColor(Color.red);
                        g.draw(new Line2D.Double(x*cw+m,y*ch+m,(x+1)*cw-m,(y+1)*ch-m));
                        g.draw(new Line2D.Double(x*cw+m,(y+1)*ch-m,(x+1)*cw-m,y*ch+m));
                        break;
                    case CIRCLE:
                        g.setColor(Color.blue);
                        g.draw(new Ellipse2D.Double(x*cw+m,y*ch+m,cw-2*m,ch-2*m));
                        break;
                }
        
    }
}
