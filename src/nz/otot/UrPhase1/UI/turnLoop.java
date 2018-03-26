package nz.otot.UrPhase1.UI;

import nz.otot.UrPhase1.model.Dice;
import nz.otot.UrPhase1.model.Interactor;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Main on 30-Jan-18.
 *
 */
public class turnLoop {
    int activePlayer;
    AsciiDisplay board;
    PrintStream stream;
    Interactor state;
    ArrayBlockingQueue<String> queue;

    turnLoop(Interactor state, ArrayBlockingQueue<String> queue, PrintStream stream, AsciiDisplay board){
        this.activePlayer = state.getPIDs().get(0);
        this.board = board;
        this.stream = stream;
        this.state = state;
        this.queue = queue;

        TextOutput.welcomeText(this.stream);
        loop();
    }
    //Keeps the game running until one player wins.
    private void loop(){
        while (true) {
            board.update(activePlayer);
            makeMove(); //here it has to wait for input from the player
            if (state.checkVictory(activePlayer)) break;
            passTurn();
        }
        TextOutput.gameOver(state.getPlayerName(activePlayer), this.stream);
    }
    private void makeMove(){
        int dist = Dice.roll();
        String name = state.getPlayerName(activePlayer);
        //If a move is not valid the player should get another chance until they make a valid move.
        boolean validMoveMade;
        if(dist == 0){
            //A roll of Zero is always valid. It does not require a piece to be moved.
            validMoveMade = true;
            TextOutput.zeroRoll(this.stream);
        }
        else validMoveMade = false; //No valid move has been made yet.
        while (!validMoveMade) {
            TextOutput.announceRoll(name, dist, this.stream);

            HashSet<Integer> positions = getPositions();
            int piece = TextOutput.askForPieceNum(positions, queue, this.stream);
            validMoveMade = state.movePiece(activePlayer, piece, dist); //move piece reports true if the move was valid
        }
    }
    private void passTurn(){
        ArrayList<Integer> players = state.getPIDs();
        int i = players.indexOf(activePlayer);
        int errorIndex = -1; //indexOf returns -1 if it cannot find the index.
        if(i == errorIndex){
            System.out.println("Error cannot find player");
            System.exit(1);
        }
        //Set active player to the next player in the players array.
        activePlayer = players.get((++i) % players.size());
    }
    private HashSet<Integer> getPositions(){
        HashSet<Integer> p = state.getPositions(activePlayer);
        //If there is a piece in the pool, add the pool (position 0) to the valid positions.
        if(state.getPoolSize(activePlayer) >= 1){
            p.add(0);
        }
        return p;
    }
}
