package nz.otot.UrPhase1.UI;

import nz.otot.UrPhase1.model.Player;

import java.util.ArrayList;

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
    static int askForPieceNum(Player p, ArrayList<int> options){
        System.out.println("Choose a piece");
        return Reciever.numberQuestion(options);
    }
}