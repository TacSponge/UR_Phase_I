package nz.otot.UrPhase1.UI;

import nz.otot.UrPhase1.model.Interactor;

import javax.swing.*;
import java.awt.*;
import java.io.PrintStream;
import java.util.concurrent.ArrayBlockingQueue;


/**
 * Created by Main on 30-Jan-18.
 */

public class GameStarter {
    public GameStarter(Interactor state){
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(1);
        Display d = startGUI(queue);

        PrintStream stream = makeStream(d);
        AsciiDisplay board = new AsciiDisplay(state, stream);
        new turnLoop(state, queue, stream, board);
    }
    private Display startGUI(ArrayBlockingQueue<String> queue){
        JFrame frame = new JFrame("UR");
        Display d = new Display(queue);
        frame.setContentPane(d.mainPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return d;
    }
    private PrintStream makeStream(Display d){
        PrintStream stream = new PrintStream(System.out){
            @Override
            public void println(String text){
                d.addTextln(text);
                d.scrollDown();
            }
        };
        return stream;
    }


}
