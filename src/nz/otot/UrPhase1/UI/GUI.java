package nz.otot.UrPhase1.UI;

import javax.swing.*;

/**
 * Created by Main on 19-Jul-17.
 * Testing basic Swing GUI
 *
 * There is one frame and different panels can be swapped in and out.
 */
public class GUI {

    public static void startUI() {
        JFrame frame = new JFrame("UR");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new IntroMenu());


        frame.setVisible(true);
    }

}
