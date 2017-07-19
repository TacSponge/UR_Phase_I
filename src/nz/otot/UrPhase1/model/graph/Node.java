package nz.otot.UrPhase1.model.graph;

import nz.otot.UrPhase1.model.Player;

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
 * (19/07)
 * This node is a directional node and is Mutable and nodes can be added but not removed.
 *
 */
public class Node<T>{

    private ArrayList<Node> childNodes;
    private T content = null;
    private ArrayList<Player> players;


    public Node(){
        this.childNodes = new ArrayList<Node>(0);
        this.players =  new ArrayList<Player>(0);
    }
    public Node(ArrayList<Node> childNodes, ArrayList<Player> players){
        this.childNodes = childNodes;
        this.players = players;

    }
    public Node(ArrayList<Node> childNodes){
        this.childNodes = childNodes;
        this.players = new ArrayList<>(0);
    }

    public Optional<T> getContent() {
        return Optional.of(content);
    }

    public void setContent(T content) {
        this.content = content;
    }

    void addPlayer(Player player){
        if (!this.players.contains(player)) {
            this.players.add(player);
        }
    }
    public void clearContent(){
        content = null;
    }

    void addChild(Node<T> child){
        this.childNodes.add(child);
    }

    public ArrayList<Node> getChildren(){
        return childNodes;
    }
    public ArrayList<Player> getPlayers(){
        return this.players;
    }


}
