package prova.swing.callback;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButtonHandler implements ActionListener {

    private int count;

    public MyButtonHandler(){
        count=0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(count++);
    }
}
