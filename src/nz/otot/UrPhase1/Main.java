package nz.otot.UrPhase1;

import nz.otot.UrPhase1.UI.*;
import nz.otot.UrPhase1.model.*;

public class Main {

    public static void main(String[] args) {
       Interactor state = new GameState();
       new GameStarter(state);
    }
}
