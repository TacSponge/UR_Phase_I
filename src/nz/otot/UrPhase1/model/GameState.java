package nz.otot.UrPhase1.model;

import com.sun.xml.internal.bind.v2.TODO;
import nz.otot.UrPhase1.Main;
import nz.otot.UrPhase1.model.graph.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Main on 05-Jul-17.
 * This keeps track of the game state and passes information to the View/ Controller.
 * The GUI then sends commands from the user to Gamestate
 */
public class GameState implements Interactor {

    // Start nodes are start points in the directional graph that makes up the board.
    // There is a 1-1 correspondence between the number of players and number of start nodes. 2 by default.
    private ArrayList<Node> startNodes;
    private ArrayList<Player> players;
    private int startingPieces = 7; // in future this may be configured base on the game mode.



    public GameState(){
        // Build the graph and assign players their nodes.
        GraphBuilder builder = new GraphBuilder();

        this.startNodes = builder.getStartNodes();
        this.players = makePlayers(startNodes);
        for (Player p : players) builder.assignNodesToPlayer(p, p.getStartingNode());

        if(Main.testing)System.out.println("Game Start");
    }


    private ArrayList<Player> makePlayers(ArrayList<Node> startNodes){

        ArrayList<Player> players = new ArrayList<Player>(startNodes.size());

        // While the game only needs two players, this allows more modes to be added later.
        for(Node n : startNodes){
            players.add(new Player(7,n));
        }

        return players;
    }

    @Override
    public void spawnPiece(Player player) {
        player.spawnPiece();

    }


    @Override
    public void movePiece(Piece piece, int dist) {
        piece.movePiece(dist);
    }

    @Override
    public HashMap<Player, Integer> getPositions() {
        return
    }

    @Override
    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    @Override
    public int getPoolSize(Player player) {
        return player.getSize();
    }
}
