package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Main on 05-Jul-17.
 * This Keeps track of pieces on the board and their movements, entries and exits.
 */
public class BoardTrack {
    // The board is in two overlaping tracks along whichj pieces can be moved.
    // There is also a pool of pieces on each side waiting to be put onto the track
    List leftTrack;
    List rightTrack;
    PiecePool leftPool;
    PiecePool rightPool;

    public BoardTrack(int boardSize, int leftPoolPieces, int rightPoolPieces){
        this.leftTrack = new ArrayList(boardSize);
        this.rightTrack = new ArrayList(boardSize);

        this.leftPool = new PiecePool(leftPoolPieces);
        this.leftPool = new PiecePool(rightPoolPieces);

    }

    public  BoardTrack(int boardSize, int numPoolPieces){
        this.leftTrack = new ArrayList(boardSize);
        this.rightTrack = new ArrayList(boardSize);

        this.leftPool = new PiecePool(numPoolPieces);
        this.leftPool = new PiecePool(numPoolPieces);
    }


}
