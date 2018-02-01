package nz.otot.UrPhase1.UI;

import nz.otot.UrPhase1.model.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by Main on 20-Nov-17.
 *
 * Contains the methods and text for all things that are printed to the console as part of the game.
 *
 * Development and debugging errors do not need to use this class.
 *
 */
public class TextOutput {

    static void welcomeText(){System.out.println("THE ROYAL GAME OF UR.\n");}
    static boolean askToStart(ArrayBlockingQueue<String> queue){
        System.out.println("Would you like to start a new game.");
        return Reciever.boolQuestion(queue);
    }
    static Integer askForPieceNum(HashSet<Integer> options, ArrayBlockingQueue<String> queue){
        System.out.println("Choose a piece.");
        return Reciever.numberQuestion(options, queue);
    }
    static void announceRoll(String name, int roll){
        System.out.println(name + ", you have rolled: " + roll + ". You can move one piece that distance.");
    }
    static void squareShared(){
        System.out.println("ERROR: Square is occupied by two players");
    }
    static void lineBreak(){
        System.out.println("________________________________________\n");
    }
    static void announceTurn(String name){
        System.out.println(name + ", it is your turn.");
    }
    static void zeroRoll(){System.out.println("You have rolled 0, skipping your turn.");}
    static void score2P(int p0, int p1){
        System.out.println("The score is: " + p0 + " - " + p1 + ".");
    }
    static void gameOver(String name){
        System.out.println("Game Over, " + name + " wins!");
    }
}