package com.company;

/**
 * Created by Main on 05-Jul-17.
 * This keeps track of the Pool of unused tokens that have yet to be place on the board.
 * As all pieces are interchangable this currently stores them just as ints.
 *
 * Primary interactions should be throgh the BoardTrack Class
 */
public class PiecePool {

    private int numPieces;
    private int rightPool;

    // Constructors
    public PiecePool(){
        // By default pools should be empty.
        this.numPieces = 0;

    }

    public  PiecePool(int numPieces){
        // Most game modes will have even pools
        this.rightPool = numPieces;
    }


    public void spawnPiece(){
        //Creates a virtual piece by incrementing one side.
        //In future this could be amended to actually create a GamePiece object

        numPieces++;

    }
    public void killPiece(){
        //coutnerpart to spawn Piece

        numPieces--;

    }

    public int getSize(){
        return this.numPieces;
    }

}
