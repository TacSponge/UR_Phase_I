package nz.otot.UrPhase1.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


/**
 * Created by Main on 31-Dec-17.
 *
 * This is an set based model of the positions of peices on the board.
 * Here pieces are just integers that state how far they are along the track.
 * The track is 1D but there are positions which overlap. The start space is 1.
 * The pool is the space 0.
 */
class BoardTrack {
    HashMap<Player, HashSet<Integer>> positions;
    int finalSquare;
    int overlapStart;
    int overlapEnd;


    BoardTrack(ArrayList<Player> players){
        //by default the board should start empty.
        positions = new HashMap<>();
        for(Player p : players){
            this.positions.put(p, new HashSet<>());
        }
        //The default values for describing the board state describe the traditional board starting at 0 which is the pool.
        this.finalSquare = 14;
        this.overlapStart = 5;
        this.overlapEnd = 12;
    }
    boolean validateMove(Player p, int piece, int dist){
        HashSet<Integer> playerPos = positions.get(p);
        int endPos = piece + dist;
        boolean exists;
        if(piece == 0){
            exists = p.getPoolSize() >= 1;
        }
        else exists = playerPos.contains(piece);
        return exists && (!playerPos.contains(endPos));
    }
    boolean movePiece(Player p, int piece, int dist){
        boolean valid = validateMove(p, piece, dist);
        if (valid){
            int endPos = piece + dist;
            if(overlapStart <= endPos && endPos <= overlapEnd) resolveOverlap(p, endPos);
            if(endPos > finalSquare) {
                remPos(p, piece);
                p.givePoint();
            }
            else if(piece == 0) {
                p.remFromPool();
                addPos(p, endPos);
            }
            else{
                remPos(p, piece);
                addPos(p,endPos);
            }
        }
        return valid;
    }
    private boolean addPos(Player p, int piece){
        return positions.get(p).add(piece);
    }
    private boolean remPos(Player p, int piece){
        return positions.get(p).remove(piece);
    }
    //This method should only be called after we have validated that there is no allied piece in the end position
    //It tries to remove the specified piece from the other players track and if there is something to remove, it spawns
    //a peice in that players pool.
    private void resolveOverlap(Player activePlayer, int pos){
        boolean cappedEnemy;
        for(Player p : positions.keySet()){
            if(p != activePlayer) {
                cappedEnemy = remPos(p, pos);
                if(cappedEnemy) p.addToPool();
            }
        }
    }
    //returns a shallow copy of the positions for one player.
    HashSet<Integer> getPositions(Player p){
        HashSet<Integer> playerPosCopy = new HashSet<>();
        playerPosCopy.addAll(positions.get(p));
        return playerPosCopy;
    }
}
