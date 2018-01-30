package nz.otot.UrPhase1.UI;

import nz.otot.UrPhase1.model.Player;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Main on 20-Nov-17.
 *
 * Contains the methods and text for all things that are printed to the console as part of the game.
 *
 * Development and debugging errors do not need to use this class.
 *
 */
public class TextOutput {

    static void welcomeText(){

        System.out.println("THE ROYAL GAME OF UR.\n");
    }

    static boolean askToStart(){
        System.out.println("Would you like to start a new game.");
        return Reciever.boolQuestion();

    }
    static Integer askForPieceNum(Player p, HashSet<Integer> options){
        System.out.println("Choose a piece.");
        return Reciever.numberQuestion(options);
    }
    static void announceRoll(Player player, int roll){
        System.out.println(player.toString() + "you have rolled: " + roll + ". You can move one piece that distance.");
    }
    static void squareShared(){
        System.out.println("ERROR: Square is occupied by two players");
    }
}