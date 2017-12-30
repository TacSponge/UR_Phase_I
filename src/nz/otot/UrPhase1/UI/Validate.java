package nz.otot.UrPhase1.UI;

import java.util.regex.Pattern;

/**
 * Created by Main on 20-Nov-17.
 *
 * Contains methods for validating input
 */
public class Validate {

    static boolean isInteger(String s){
        String intFormat = "-?[0-9]+"; //using regex an integer can be zero or one minus signs followed by one or more digits
        return Pattern.matches(intFormat,s);
    }
}
