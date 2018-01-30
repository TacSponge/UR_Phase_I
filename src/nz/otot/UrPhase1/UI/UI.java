package nz.otot.UrPhase1.UI;

import nz.otot.UrPhase1.model.Interactor;


/**
 * Created by Main on 30-Jan-18.
 */

public class UI {
    public UI(Interactor state){
        TextOutput.welcomeText();
        new turnLoop(state);
    }


}
