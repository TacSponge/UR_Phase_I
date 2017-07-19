package nz.otot.UrPhase1.UI;


import nz.otot.UrPhase1.model.Player;
import nz.otot.UrPhase1.model.StateReader;

import java.util.ArrayList;

/**
 * Created by Main on 19-Jul-17.
 */
class ConsoleOutput {

    StateReader state;

    ConsoleOutput(StateReader state){
        this.state = state;
    }

    void update(){
        ArrayList<Player> players = state.getPlayers();


    }

}
