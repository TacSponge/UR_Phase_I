package nz.otot.UrPhase1.UI;

import nz.otot.UrPhase1.model.Dice;
import nz.otot.UrPhase1.model.Interactor;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Main on 30-Jan-18.
 */
public class turnLoop {
    int active;
    AsciiDisplay board;
    PrintStream stream;
    Interactor state;
    ArrayBlockingQueue<String> queue;

    turnLoop(Interactor state, ArrayBlockingQueue<String> queue, PrintStream stream, AsciiDisplay board){
        this.active = state.getPIDs().get(0);
        this.board = board;
        this.stream = stream;
        this.state = state;
        this.queue = queue;

        TextOutput.welcomeText(this.stream);
        loop();
    }
    private void loop(){
        while (true) {
            board.update(active);
            makeMove();
            if (state.checkVictory(active)) break;
            passTurn();
        }
        TextOutput.gameOver(state.getPlayerName(active), this.stream);
    }
    private void makeMove(){
        int dist = Dice.roll();
        boolean validMoveMade = false;
        //if the move was not valid the player should get another chance until they make a valid move.
        String name = state.getPlayerName(active);
        if(dist == 0){
            validMoveMade = true;
            TextOutput.zeroRoll(this.stream);
        }
        while (!validMoveMade) {
            TextOutput.announceRoll(name, dist, this.stream);
            HashSet<Integer> positions = getPositions();
            int piece = TextOutput.askForPieceNum(positions, queue, this.stream);
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
