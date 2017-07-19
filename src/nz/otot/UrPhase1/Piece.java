package nz.otot.UrPhase1;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by Main on 05-Jul-17.
 * A single game piece
 */
public class Piece {

    // All pieces are interchangable, movement is currently handled by the piece itself

    private Node<Piece> position;
    private Player player;


    public Piece(Player player){

        this.player = player;
        this.position = player.getStartingNode();
    }
    public Player getPlayer() {
        return player;
    }

    public void movePiece(int distance){

        // Keeps track of where the node is virtually until it locks in its new poistiomnn
        Node<Piece> virtualPosition = this.position;

        // Movie piece forward
        for (int i = 0; i < distance; i++){

            ArrayList<Node> options = virtualPosition.getChildren();

            // If the node is a dead-end the piece can be removed and scored.
            if (options.isEmpty()){
                removeAndScore();
            }
            // otherwise move our virtual position to the next node
            else{
                Node nextPos = advanceVirtual(options, virtualPosition);

                // if advance doesn't have anywhere to go we have reached a dead end so remove the peice
                if (nextPos == virtualPosition) removeAndScore();
            }
        }


        // once location is determined check if valid and resolve displacements
        Optional<Piece> peiceInNode = virtualPosition.getContent();

        if(peiceInNode.isPresent()){
            if (peiceInNode.get().getPlayer() == this.player){
                // TODO: 13-Jul-17  implement (in)validation
            }
            else{
                // Like ludo hitting another piece moves that piece away to start
                peiceInNode.get().displace();
            }

        }

    }

    private Node<Piece> advanceVirtual(ArrayList<Node> options, Node<Piece> currentNode){

        for(Node child : options)
            if (child.getPlayers().contains(this.player)) return child;
        // if there is no next square stay in currrent square.
        return currentNode;
    }
    private void removeAndScore(){
        this.position.clearContent();
        // TODO: Implement scoring
    }

    void displace(){

        Optional<Piece> nodePeice = this.position.getContent();

        if(nodePeice.isPresent()){
            if(nodePeice.get() == this){
                this.position.clearContent();
            }
        }

        this.player.spawnPiece();
    }



}
