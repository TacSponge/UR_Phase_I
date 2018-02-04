package nz.otot.UrPhase1.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ArrayBlockingQueue;


/**
 * Created by Main on 01-Feb-18.
 */
public class Display {
    JPanel mainPanel;
    private JTextArea textDisplay;
    private JTextField inputField;
    private JScrollPane scroll;
    private ArrayBlockingQueue<String> queue;


    public Display(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                queue.clear();
                queue.offer(inputField.getText());
                inputField.setText("");
            }
        });
    }

    void addTextln(String text){
        this.textDisplay.append(text + "\n");
    }
    void scrollDown(){
        this.textDisplay.setCaretPosition(textDisplay.getDocument().getLength());
    }



}
