package nz.otot.UrPhase1.model;

import nz.otot.UrPhase1.Main;
import nz.otot.UrPhase1.model.graph.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Main on 05-Jul-17.
 * This keeps track of the game state and passes information to the View/ Controller
 */
public class GameState implements Interactor {

    private ArrayList<Node> startNodes;
    private ArrayList<Player> players;
    private int startingPieces = 7;



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
    public ArrayList<Piece> getPostions() {
        return null;
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
