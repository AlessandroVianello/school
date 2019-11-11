package prova.swing.callback;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(640,480));
        Container panel=new Container();
        panel.setLayout(new BorderLayout());
        JTextArea textArea=new JTextArea();
        JButton button = new JButton("Press me!");
        panel.add(button,BorderLayout.SOUTH);
        panel.add(textArea,BorderLayout.CENTER);
        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                textArea.append(" , ");
            }
        });
        frame.add(panel);
        frame.setVisible(true);
        MyButtonHandler buttonHandler=new MyButtonHandler();
        button.addActionListener(buttonHandler);
        button.addActionListener(e -> System.out.print("Stronzate numero: "));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button) {
                    System.out.println("Test 2");
                    JButton source = (JButton) e.getSource();
                    System.out.println(source.getText());
                }
            }
        });
        MyMouseListener motionListener=new MyMouseListener();
        button.addMouseMotionListener(motionListener);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse has been clicked inside button");
            }
        });
    }
}
