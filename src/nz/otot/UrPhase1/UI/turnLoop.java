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
    Player activePlayer;
    AsciiDisplay display;
    Interactor state;

    turnLoop(Interactor state){
        this.activePlayer = state.getPlayers().get(0);
        this.display = new AsciiDisplay(state);
        this.state = state;
        TextOutput.welcomeText();
        loop();
    }
    private void loop(){
        while (true) {
            display.update();
            makeMove();
            passTurn();
        }
    }
    private void makeMove(){
        int dist = Dice.roll();
        boolean validMoveMade = false;
        while (!validMoveMade) {
            TextOutput.announceRoll(this.activePlayer, dist);
            HashSet<Integer> positions = getPositions();
            int piece = TextOutput.askForPieceNum(activePlayer, positions);
            validMoveMade = state.movePiece(activePlayer, piece, dist);
        }
    }
    private void passTurn(){
        ArrayList<Player> players = state.getPlayers();
        int i = players.indexOf(activePlayer);
        if(i == -1){
            System.out.println("Error cannot find player");
            System.exit(1);
        }
        activePlayer = players.get((i + 1) % players.size());
    }
    private HashSet<Integer> getPositions(){
        HashSet<Integer> p = state.getPositions(activePlayer);
        if(state.getPoolSize(activePlayer) >= 1){
            p.add(0);
        }
        return p;
    }
}
