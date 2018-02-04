package nz.otot.UrPhase1.UI;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Main on 20-Nov-17.
 *
 * Takes input from the queue.
 *
 * This is primarily called by the Text Output methods
 *
 */
public class Reciever {


    static String receiveString(ArrayBlockingQueue<String> queue){
        try {
            return queue.take();
        }
        catch (InterruptedException e){
            System.exit(1);
            return "";
        }

    }

    static boolean boolQuestion(ArrayBlockingQueue queue){
        System.out.println("Please enter Y/N");


        while(true){
            String response = receiveString(queue);
            if(response.equalsIgnoreCase("N")){
                return false;
            }
            if(response.equalsIgnoreCase("Y")){
                return true;
            }
            else{
                System.out.println("That is an invalid response. Please answer 'Y' or 'N'");
            }
        }
    }
    static int numberQuestion(HashSet<Integer> options, ArrayBlockingQueue queue, PrintStream stream){

        while (true){
            TextOutput.selectInt(options, stream);
            String response = receiveString(queue);

            if (Validate.isInteger(response)){
                int i = Integer.parseInt(response);

                if(options.contains(i)){
                    return i;
                }
            }
            //If we are here we failed somewhere to get the integer.
            System.out.println();
        }
    }
}
