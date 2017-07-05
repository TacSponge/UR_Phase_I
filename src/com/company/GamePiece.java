package com.company;

/**
 * Created by Main on 05-Jul-17.
 * A single game peice
 */
public class GamePiece {

    // All pieces are interchangable, movement is currently handled by the track
    // so only current requirement is an ID.
    static private int count = 0;
    private int ID;

    public GamePiece(){

        this.ID = count++;
    }

}
