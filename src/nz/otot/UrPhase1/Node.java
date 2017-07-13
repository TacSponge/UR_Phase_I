package nz.otot.UrPhase1;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by Main on 11-Jul-17.
 * A node.
 * The primary use for this will be on the graph that represents the board.
 * As the board cares about which player the objects belong to the nodes need to aswell.
 *
 * Pieces move themselves along the graph and off it using the nodes as guidelines.
 *
 */
public class Node<T>{

    private ArrayList<Node> childNodes;
    private T content = null;
    private ArrayList<Player> players;


    public Node(){
        this.childNodes = new ArrayList<Node>(0);
        this.players =  new ArrayList<Node>(0);
    }
    public Node(ArrayList<Node> childNodes, ArrayList<Player> players){
        this.childNodes = childNodes;
        this.players = players;

    }

    public Optional<T> getContent() {
        return Optional.of(content);
    }

    public void setContent(T content) {
        this.content = content;
    }
    public void clearContent(){
        content = null;
    }

    public ArrayList<Node> getChildren(){
        return childNodes;
    }
    public ArrayList<Player> getPlayers(){
        return this.players;
    }


}
