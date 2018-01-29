package nz.otot.UrPhase1;

import nz.otot.UrPhase1.UI.*;
import nz.otot.UrPhase1.model.*;

public class Main {

    public static Boolean testing = true;

    public static void main(String[] args) {
       Interactor state = new GameState();
       UI.startUI(state);

    }
}
