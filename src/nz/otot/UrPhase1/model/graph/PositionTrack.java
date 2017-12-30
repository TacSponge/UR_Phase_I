package nz.otot.UrPhase1.model.graph;

import nz.otot.UrPhase1.model.Player;
import nz.otot.UrPhase1.model.UIGamePeice;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Main on 30-Dec-17.
 *
 * Turns the mono-directional graph into a Hashmap that maps from players to the  list which shows which nodes players
 * have pieces in.
 *
 * The positions are then used by the UI to create a grid representation  of the board.
 *
 * It takes the graph in terms of it's Roots, with one root for each player and walks down.
 *
 * Each player has separate numbering starting at it's root.
 *
 */
public class PositionTrack{
    HashMap<Player, ArrayList<Integer>> positions;
    ArrayList<Player> players;

    PositionTrack(ArrayList<Player> players) {
        this.positions = new HashMap<>();
        this.players = players;
        genPositions();
    }

    private void genPositions() {
        for (Player p : players) {
            traceAndAddPositions(p, p.getStartingNode(), 0);
        }
    }

    private void traceAndAddPositions(Player p, Node<UIGamePeice> n, int pos) {
        if (n.hasContent()) addPosition(p,pos);

        // This for loop should only execute zero or one times. Unless it is operating on a branched graph
        for (Node<UIGamePeice> child : n.getChildren(p)) {
            if(child.hasContent()) addPosition(p,pos);
            pos++;
            traceAndAddPositions(p,child,pos);
            }

    }
    //checks that the position is not already in the list and adds it if it is not.
    void addPosition(Player p, int pos){
        ArrayList<Integer> playerPos = positions.get(Player);
        playerPos.add(pos);
        positions.put(p, playerPos);


    }
}