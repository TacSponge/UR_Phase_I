package nz.otot.UrPhase1.UI;

import nz.otot.UrPhase1.model.Interactor;

import javax.swing.*;
import java.awt.*;
import java.io.PrintStream;
import java.util.concurrent.ArrayBlockingQueue;


/**
 * Created by Main on 30-Jan-18.
 */

public class UI {
    public UI(Interactor state){

        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(1);
        JFrame frame = new JFrame("UR");
        Display d = new Display(queue);
        PrintStream stream = new PrintStream(System.out){
            @Override
            public void println(String text){
                d.addTextln(text);
            }
        };
        System.setOut(stream);
        frame.setContentPane(d.mainPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        new turnLoop(state, queue);

    }


}
