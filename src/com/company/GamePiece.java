package com.company;

/**
 * Created by Main on 05-Jul-17.
 * A single game peice
 */
public class GamePiece {

    // All pieces are interchangable, movement is currently handled by the piece itself
    // so only current requirement is an ID.
    static private int count = 0;
    private int ID;
    private int position;


    public GamePiece(){

        this.ID = count++;
        setPosition(0);
    }

    public void setPosition(int position, BoardTrack track){
        // checks if the position is available and moves the piece if it is
        if (track.positionIsEmpty(position)){
            this.position = position;
            track.setPiece(this, this.position);
        }
    }

    public void movePiece(int d, BoardTrack track){
        setPosition(d + this.position, track);
    }
}
