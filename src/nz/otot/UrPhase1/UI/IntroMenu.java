package nz.otot.UrPhase1.UI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Main on 21-Sep-17.
 * This is the basic UI.
 * For MVP it just needs to be able to start a new game or exit the programme.
 */
public class IntroMenu extends JPanel{

    IntroMenu(){

        JPanel panel = new JPanel();

        JButton startB = new JButton("New Game");
        // TODO: implemt button to start a new game.
        JButton quitB = new JButton("Quit");
        // TODO: implement
        this.add(startB);
        this.add(quitB);
    }
}


