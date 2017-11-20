package nz.otot.UrPhase1.UI;

import java.util.Scanner;

/**
 * Created by Main on 20-Nov-17.
 *
 * Takes input from the command line.
 *
 */
public class Reciever {
    public static String receiveString(){
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        return s;
    }

}
