package nz.otot.UrPhase1.model;

import nz.otot.UrPhase1.Main;

/**
 * Created by Main on 05-Jul-17.
 * This class represents the players.
 * It exists to keep track of them, their scores and how many pieces they have waiting to be put on the board.
 */
public class Player {

    private int poolSize;
    private String name;
    private int score = 0;
    private static int autoNameNum = 0;

    Player(String name, int startingPieces) {

        this.name = name;
        this.poolSize = startingPieces;
    }
    // Auto generate player name with no name given
    Player(int startingPieces) {
        
        this.name = "Player" + Integer.toString(autoNameNum++);
        this.poolSize = startingPieces;
    }
    int getPoolSize(){
        return this.poolSize;
    }
    void addToPool(){
        poolSize++;
    }
    void remFromPool(){
        poolSize--;
    }
    
    void givePoint(){
        score++;
    }
    int getScore(){
        return score;
    }
    public String toString(){
        return this.name;
    }
}

