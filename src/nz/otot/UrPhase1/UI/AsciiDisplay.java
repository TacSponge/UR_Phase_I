package nz.otot.UrPhase1.UI;


import nz.otot.UrPhase1.model.Interactor;
import nz.otot.UrPhase1.model.StateReader;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Main on 20-Nov-17.
 *
 * This is an ASCII representation of the board state.
 * At this part queue logic becomes tied to a 2 player game.
 *
 *The Board is sort of I shaped with the two starting positions on either side of the central column, before heading up
 * wrapping inside and going down a central column and then wrapping up the side again.
 *
 *
 * The Board is divided into 3 sections :
 *  - 000, the central shaft which both players share,
 *  - 100, spaces unique to player 1
 *  - 200, spaces unique to player 2
 *
 * The positions of each piece are taken from the model and are the distance down the track, where the pool is 0 and
 * the first square for each player is 1.
 *
 * This numbering scheme is common for both players so the section number is added to the distance to make a unique
 * numbering.
 *
 * This gives us the following board where, where each square is given its final identifier and --- is an empty square:
 *  //note that they will be stored as ints so '005' becomes '5' etc.
 *
 *  Below is a mapping of the squares to their numbers and a pictoral queue using arrows to show the board flow.
 *  'o' is the start, x is the end, - is empty and the other characters indicate direction of peice movement.
 *
 *  104 005 204     >   v   <
 *  103 006 203     ^   v   ^
 *  102 007 202     ^   v   ^
 *  101 008 201     o   v   o
 *  --- 009 ---     -   v   -
 *  --- 010 ---     -   v   -
 *  114 011 214     x   v   x
 *  113 012 213     ^  <->  ^
 */
class AsciiDisplay{
    private StateReader state;
    private PrintStream stream;
    private HashMap<Integer, String> symbols;
    // This grid should match the one described above.
    private int[][] grid = {
            {104, 5,   204},
            {103, 6,   203},
            {102, 7,   202},
            {101, 8,   201},
            {0,   9,   0},
            {0,   10,  0},
            {114, 11,  214},
            {113, 12,  213}
    };

    AsciiDisplay(Interactor state, PrintStream stream){
        this.state = state;
        this.stream = stream;

        HashMap<Integer, String> playerSymbols = new HashMap<>();
        playerSymbols.put(findPlayer(0), "X");
        playerSymbols.put(findPlayer(1), "X");
        this.symbols = playerSymbols;

        ArrayList<Integer> players = this.state.getPIDs();
        if (players.size() != 2){
            System.out.println("Error: incorrect number of players");
        }
    }
    // Go through each square in the grid and use genSquare() to get the correct symbol. Then print to console
    void update(Integer active){
        TextOutput.lineBreak(stream);
        TextOutput.score2P(state.getScore(findPlayer(0)), state.getScore(findPlayer(1)),stream);
        TextOutput.announceTurn(state.getPlayerName(active),stream);
        makeGrid(active);
    }

    void makeGrid(Integer active){
        for(int[] gridLine : this.grid){
            String printLine = "";
            for(int i = 0; i < gridLine.length; i++) {
                printLine = printLine + genSquare(active, gridLine[i]);
            }
            this.stream.println(printLine);
        }
    }
    //Creates the content of a square which is [n] where n is the position number if it is the activePlayer playor or [x],
    //where x is a player symbol if a non activePlayer player has a piece there or ' ' if square is empty. The square knows
    //which players it can hold from the numbering system.
    private String genSquare(Integer active, int squareNum){
        String squareDisplay = "[ ]";
        int pos = squareNum % 100; // the hundreds column of the squarenum shows the section, so the position is the last two digits
        if (squareNum == 0) squareDisplay = "[~]";
        else if(squareNum < 5){
            System.out.println("Error: Square number is too small.");
        }
        //5 <= Squarenum < 100
        else if(squareNum < 100){
            squareDisplay = getSquareSymbol(active, state.getPIDs(), pos); //these squares shared by multiple players
        }
        //100 <= squareNum < 200 so it is in section 100;
        else {
            int playerIndex;
            int owner;
            if(squareNum < 200) {
                playerIndex = 0;
                owner = findPlayer(playerIndex); // The section 100 squares belong to the first player.
            }
            else {
                playerIndex = 1;
                owner = findPlayer(playerIndex); // the section 200 squares belong to the second player
            }
            squareDisplay = getSquareSymbol(active, owner, pos);
        }
        return squareDisplay;
    }

    private String getSquareSymbol(int active, int owner, int pos){
        String squareSymbol = " ";
        if (state.getPositions(owner).contains(pos)) {
            //switch the default empty symbol to the symbol for that player.
            if (owner == active) squareSymbol = Integer.toString(pos);
            else squareSymbol = symbols.get(owner);
        }
        return "[" + squareSymbol + "]";
    }
    // The middle squares could have one of many symbols in them so this overloads the above and then runs through
    //using the single player method to check if any of them have players there.
    private String getSquareSymbol(Integer active, ArrayList<Integer> players, int pos){
        final String blank = "[ ]";
        String square = blank;

        for(int p : players) {
            String candidate = getSquareSymbol(active, p, pos);
            //If we try to assign two symbols to a single square there is probably an error with the mapping.
            if((!candidate.equalsIgnoreCase(blank)) && (!square.equalsIgnoreCase(blank))){
                TextOutput.squareShared(this.stream);
            }
            //getSqaureSymbol() will return blank if the player is not there, so this stops the second player from
            //writing blank over the symbol that the first player put there.
            if (!candidate.equalsIgnoreCase(blank)){
                square = candidate;
            }
        }
        return square;
    }
    private int findPlayer(int playerIndex){
        return this.state.getPIDs().get(playerIndex);
    }

}


