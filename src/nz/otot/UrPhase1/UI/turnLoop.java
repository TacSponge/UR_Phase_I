package nz.otot.UrPhase1.UI;

import nz.otot.UrPhase1.model.Dice;
import nz.otot.UrPhase1.model.Interactor;
import nz.otot.UrPhase1.model.Player;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Main on 30-Jan-18.
 */
public class turnLoop {
    int active;
    AsciiDisplay display;
    Interactor state;

    turnLoop(Interactor state){
        this.active = state.getPIDs().get(0);
        this.display = new AsciiDisplay(state);
        this.state = state;
        TextOutput.welcomeText();
        loop();
    }
    private void loop(){
        while (true) {
            display.update(active);
            makeMove();
            passTurn();
        }
    }
    private void makeMove(){
        int dist = Dice.roll();
        boolean validMoveMade = false;
        //if the move was not valid the player should get another chance until they make a valid move.
        String name = state.getPlayerName(active);
        if(dist == 0){
            validMoveMade = true;
            TextOutput.zeroRoll();
        }
        while (!validMoveMade) {
            TextOutput.announceRoll(name, dist);
            HashSet<Integer> positions = getPositions();
            int piece = TextOutput.askForPieceNum(positions);
            validMoveMade = state.movePiece(active, piece, dist); //move piece reports true if the move was valid
        }
    }
    private void passTurn(){
        ArrayList<Integer> players = state.getPIDs();
        int i = players.indexOf(active);
        if(i == -1){
            System.out.println("Error cannot find player");
            System.exit(1);
        }
        active = players.get((i + 1) % players.size());
    }
    private HashSet<Integer> getPositions(){
        HashSet<Integer> p = state.getPositions(active);
        if(state.getPoolSize(active) >= 1){
            p.add(0);
        }
        return p;
    }
}
