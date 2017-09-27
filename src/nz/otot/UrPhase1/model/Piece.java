package nz.otot.UrPhase1.model;

import nz.otot.UrPhase1.model.graph.Node;

import java.awt.*;
import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by Main on 05-Jul-17.
 * A single game piece.
 * Implements methods for moving peices along the board and removing them.
 */
class Piece implements UIGamePeice{

    // All pieces are interchangable, movement is currently handled by the piece itself
    private Node<Piece> currentNode;
    private Player player;


    Piece(Player player) {

        this.player = player;
        this.currentNode = player.getStartingNode();
    }

    public Player getPlayer() {
        return player;
    }

    void movePiece(int distance) {

        // Keeps track of where the node is virtually until it locks in its new poistiomnn.
        // The attempted move may turn out to be invalid.
        Node<Piece> virtualPosition = this.currentNode;

        // Movie piece forward
        for (int i = 0; i < distance; i++) {

            ArrayList<Node> options = virtualPosition.getChildren();

            // If the node is a dead-end the piece can be removed and scored.
            if (options.isEmpty()) {
                removeAndScore();
            }
            // otherwise move our virtual position to the next node
            else {
                Node nextPos = advanceVirtual(options, virtualPosition);

                // if advance doesn't have anywhere to go we have reached a dead end so remove the peice
                if (nextPos == virtualPosition) removeAndScore();
            }
        }
        // once location is determined check if valid and resolve displacements
        Optional<Piece> peiceInNode = virtualPosition.getContent();

        if (peiceInNode.isPresent()) {
            if (peiceInNode.get().getPlayer() == this.player) {
                // TODO: 13-Jul-17  implement (in)validation
            }
            else {
                // Like ludo hitting another piece moves that piece away to start
                peiceInNode.get().displace();
                this.currentNode = virtualPosition; // then set the current piece into that spot
                this.currentNode.setContent(this);

            }

        }
        else{
            this.currentNode = virtualPosition; // set the peice to the virtual position.
            this.currentNode.setContent(this);
        }
    }

    private Node<Piece> advanceVirtual(ArrayList<Node> options, Node<Piece> currentNode) {

        for (Node child : options){
            if (child.getPlayers().contains(this.player)) return child; //If the child node belongs to the current player
        }

        return currentNode; // if there is no next square stay in current square.
    }

    private void removeAndScore() {
        this.currentNode.clearContent();
        // TODO: Implement scoring
    }

    // Kicks a piece back to the pool Ludo style/
    void displace() {

        Optional<Piece> nodePeice = this.currentNode.getContent();

        // Checks to make sure displacement will be implemented correctly.
        if (nodePeice.isPresent()) {
            if (nodePeice.get() == this) {
                this.currentNode.clearContent();
            }
        }

        this.player.spawnPiece();
    }

    
}