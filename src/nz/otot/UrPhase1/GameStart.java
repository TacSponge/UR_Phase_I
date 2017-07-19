package nz.otot.UrPhase1;

import java.util.ArrayList;

/**
 * Created by Main on 13-Jul-17.
 *
 * Starts up the game
 */
public class GameStart {

    ArrayList<Node> startNodes;
    ArrayList<Player> players;
    int startingPieces = 7;

    public GameStart(){
        // Build the graph and assign players their nodes.
        GraphBuilder builder = new GraphBuilder();

        this.startNodes = builder.getStartNodes();
        this.players = makePlayers(startNodes);
        for (Player p : players) builder.assignNodesToPlayer(p, p.getStartingNode());


        GameState state = new GameState(players);
    }

    private ArrayList<Player> makePlayers(ArrayList<Node> startNodes){
        ArrayList<Player> players = new ArrayList<Player>(startNodes.size());

        for(Node n : startNodes){
            players.add(new Player(7,n));
        }

        return players;
    }


}
