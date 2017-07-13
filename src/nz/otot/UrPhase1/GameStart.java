package nz.otot.UrPhase1;

import java.util.ArrayList;

/**
 * Created by Main on 13-Jul-17.
 */
public class GameStart {

    ArrayList<Node> startNodes;
    ArrayList<Player> players;
    int startingPieces = 7;

    public GameStart(){
        this.startNodes = buildGraph();
        this.players = makePlayers(startNodes);

        GameState state = new GameState(players);
    }
    private ArrayList<Node> buildGraph(){
        GraphBuilder builder = new GraphBuilder();

        return builder.getStartNodes();
    }
    private ArrayList<Player> makePlayers(ArrayList<Node> startNodes){
        ArrayList<Player> players = new ArrayList<Player>(startNodes.size());

        for(Node n : startNodes){
            players.add(new Player(7,n));
        }

        return players;
    }

}
