package nz.otot.UrPhase1.model;

import nz.otot.UrPhase1.Main;

/**
 * Created by Main on 05-Jul-17.
 * This keeps track of the Pool of unused tokens that have yet to be place on the board.
 * As all pieces are interchangable this currently stores them just as ints.
 *
 * Primary interactions should be through the BoardTrack Class
 */
public class Player {

    private static int playerCount = 0;
    private int poolSize;
    private String name;
    private int score = 0;

    Player(String name, int startingPieces) {

        this.name = name;
        this.poolSize = startingPieces;

    }
    // Auto generate player name with no name given
    Player(int startingPieces) {

        this.name = "Player" + Integer.toString(playerCount++);
        this.poolSize = startingPieces;
        if (Main.testing) System.out.println("Player " + this.name + " created.");
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

