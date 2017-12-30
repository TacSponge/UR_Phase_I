package nz.otot.UrPhase1.UI;

import com.sun.xml.internal.bind.v2.TODO;
import nz.otot.UrPhase1.model.Player;
import nz.otot.UrPhase1.model.StateReader;
import nz.otot.UrPhase1.model.UIGamePeice;

import java.util.ArrayList;

/**
 * Created by Main on 20-Nov-17.
 */
public class AsciiDisplay {
    private StateReader state;
    private Player activePlayer;

    AsciiDisplay(StateReader state, Player startPlayer){
        this.state = state;
        this.activePlayer = startPlayer;
    }
    update(){
        genGrid();
    }
    String[][] genGrid(){
        ArrayList<UIGamePeice>
    }

}
