package com.company;

/**
 * Created by Main on 05-Jul-17.
 * A single game peice
 */
public class GamePiece {
    static private int count = 0;
    private int ID;

    public GamePiece(){
        this.ID = count++;
    }

}
