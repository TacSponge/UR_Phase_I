package nz.otot.UrPhase1.UI;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Main on 20-Nov-17.
 *
 * Takes input from the command line.
 *
 */
public class Reciever {
    static String receiveString(){
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        return s;
    }

    static boolean boolQuestion(){
        System.out.println("Please enter Y/N");


        while(true){
            String response = receiveString();
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
    static int numberQuestion(ArrayList<int> options){

        while (true){
            System.out.println(String.format("Please select one of: " + options.toString()));
            String response = receiveString();

            if (Validate.isInteger(response)){
                int i = Integer.parseInt(response);

                if(options.contains(i)){
                    return i;
                }
            }
            //If we are here we failed somewhere to get the integer.
            System.out.println("Apologies. That is invalid.");
        }
    }


}
