package nz.otot.UrPhase1.model;
import nz.otot.UrPhase1.Main;
import java.util.ArrayList;
import java.util.HashSet;


/**
 * Created by Main on 05-Jul-17.
 * This keeps track of the game state and passes information to the View/ Controller.
 * The GUI then sends commands from the user to Gamestate
 */
public class GameState implements Interactor {

    private int startingPieces = 7; // in future this may be configured base on the game mode.
    private BoardTracker board;
    private ArrayList<Player> players;

    public GameState(){
        int nPlayers = 2;
        this.players = makePlayers(nPlayers);
        this.board = new BoardTracker(players);
    }


    private ArrayList<Player> makePlayers(int n){

        ArrayList<Player> players = new ArrayList<>(n);
        for(int i = 0; i<n; i++) players.add(new Player(7));
        return players;
    }

    //Returns True and Moves the Piece if it is valid, otherwise it returns False
    public boolean movePiece(int pID, int piece, int dist) {
        return this.board.movePiece(this.players.get(pID), piece, dist);
    }


    //Each position is an Integer describing how far down the track that piece is.
    public HashSet<Integer> getPositions(int pID) {
        return this.board.getPositions(this.players.get(pID));
    }

    public ArrayList<Integer> getPIDs(){
        ArrayList<Integer> pIDs = new ArrayList<>(this.players.size());
        for(int i = 0; i < this.players.size(); i++){pIDs.add(i);}
        return pIDs;
    }

    public int getPoolSize(int pID) {
        return this.players.get(pID).getPoolSize();
    }
    public int getScore(int pID){return this.players.get(pID).getScore();}
    public boolean checkVictory(int pID){
        return (this.players.get(pID).getScore() >= 7);

    }
    public String getPlayerName(int pID){
        return this.players.get(pID).toString();
    }
}
