package nz.otot.UrPhase1;

import nz.otot.UrPhase1.UI.*;
import nz.otot.UrPhase1.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Frame;

public class Main {

    public static Boolean testing = true;

    public static void main(String[] args) {
       Interactor state = new GameState();
       UI ui = new UI(state);
    }
}
