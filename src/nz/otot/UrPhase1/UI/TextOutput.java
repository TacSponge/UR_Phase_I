package nz.otot.UrPhase1.UI;

import nz.otot.UrPhase1.model.Player;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by Main on 20-Nov-17.
 *
 * Contains the methods and text for all things that are printed to the console as part of the game.
 * If neccasary it will prompt the receiver for input.
 *
 * Development and debugging errors do not need to use this class.
 *
 */
class TextOutput {

    static void welcomeText(PrintStream stream){stream.println("THE ROYAL GAME OF UR.\n");}
    static boolean askToStart(ArrayBlockingQueue<String> queue, PrintStream stream){
        stream.println("Would you like to start a new game.");
        return Reciever.boolQuestion(queue);
    }
    static Integer askForPieceNum(HashSet<Integer> options, ArrayBlockingQueue<String> queue, PrintStream stream){
        stream.println("Choose a piece.");
        return Reciever.numberQuestion(options, queue, stream);
    }
    static void selectInt(HashSet<Integer> options, PrintStream stream){
        stream.println("Please select one of: " + options.toString());
    }
    static void announceRoll(String name, int roll, PrintStream stream){
        stream.println(name + ", you have rolled: " + roll + ". You can move one piece that distance.");
    }
    static void squareShared(PrintStream stream){
        stream.println("ERROR: Square is occupied by two players");
    }
    static void lineBreak(PrintStream stream){
        stream.println("________________________________________\n");
    }
    static void announceTurn(String name, PrintStream stream){
        stream.println(name + ", it is your turn.");
    }
    static void zeroRoll(PrintStream stream){stream.println("You have rolled 0, skipping your turn.");}
    static void score2P(int p0, int p1, PrintStream stream){
        stream.println("The score is: " + p0 + " - " + p1 + ".");
    }
    static void gameOver(String name, PrintStream stream){
        stream.println("Game Over, " + name + " wins!");
    }
    static void invalidMSG(PrintStream stream){
        stream.println("Apologies. That is invalid.");
    }
}