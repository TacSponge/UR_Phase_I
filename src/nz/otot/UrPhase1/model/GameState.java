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

    // Start nodes are start points in the directional graph that makes up the board.
    // There is a 1-1 correspondence between the number of players and number of start nodes. 2 by default.

    private int startingPieces = 7; // in future this may be configured base on the game mode.
    private BoardTrack board;
    private ArrayList<Player> players;


    public GameState(){
        // Build the graph and assign players their nodes.
        this.players = makePlayers(2);
        this.board = new BoardTrack(players);

        if(Main.testing)System.out.println("Game Start");
    }


    private ArrayList<Player> makePlayers(int n){

        ArrayList<Player> players = new ArrayList<>(n);
        for(int i = 0; i<n; i++) players.add(new Player(7));
        return players;
    }


    public void movePiece(Player p, int piece, int dist) {
        this.board.movePiece(p, piece, dist);
    }

    @Override
    //Eacg position is an Integer describing how far down the track that piece is.
    public HashSet<Integer> getPositions(Player p) {
        return this.board.getPositions(p);
    }

    @Override
    public ArrayList<Player> getPlayers() {
        return (ArrayList<Player>) this.players.clone();
    }

    @Override
    public int getPoolSize(Player player) {
        return player.getPoolSize();
    }
}
