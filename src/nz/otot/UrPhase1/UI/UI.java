package nz.otot.UrPhase1.UI;

import nz.otot.UrPhase1.model.StateReader;

/**
 * Created by Main on 30-Jan-18.
 */

public class UI {

    public static void startUI(StateReader state){
        TextOutput.welcomeText();
        AsciiDisplay a = new AsciiDisplay();
        a.show2PGrid(state);
    }
}
