package nz.otot.UrPhase1.UI;


import nz.otot.UrPhase1.model.Player;
import nz.otot.UrPhase1.model.StateReader;
import sun.awt.Symbol;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Main on 20-Nov-17.
 *
 * This is an ASCII representation of the board state.
 * At this part display logic becomes tied to a 2 player game.
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
 *  Below is a mapping of the squares to their numbers and a pictoral display using arrows to show the board flow.
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
public class AsciiDisplay {
    private StateReader state;
    private HashMap<Player, Character> symbols;
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

    public void show2PGrid(StateReader state){
        this.state = state;
        HashMap<Player, Character> playerSymbols = new HashMap<>();
        playerSymbols.put(findPlayer(0), 'X');
        playerSymbols.put(findPlayer(1), 'O');
        this.symbols = playerSymbols;
        ArrayList<Player> players = this.state.getPlayers();
        if (players.size() != 2){
            System.out.println("Error: incorrect number of players");
        }
        else{
            for(int[] gridLine : this.grid){
                String printLine = "";
                for(int i = 0; i < gridLine.length; i++) printLine = printLine + genSquare(gridLine[i]);
                System.out.println(printLine);
            }
        }

    }
    //Creates the content of a square which is [x], where x is a player symbol if a player has a piece there or ' ' if
    //square is empty. The square knows which players it can hold from the numbering system.
    private String genSquare(int squareNum){
        String squareDisplay = "[ ]";
        int pos = squareNum % 100; // the hundreds column of the squarenum shows the section, so the position is the last two digits
        if (squareNum == 0) squareDisplay = "[~]";
        else if(squareNum < 5){
            System.out.println("Error: Square number is too small.");
        }
        //5 <= Squarenum < 100
        else if(squareNum < 100){
            squareDisplay = getSquareSymbol(state.getPlayers(), pos);
        }
        //100 <= squareNum < 200 so it is in section 100;
        else {
            int playerIndex;
            Player p;
            if(squareNum < 200) {
                playerIndex = 0;
                p = findPlayer(playerIndex); // The section 100 squares belong to the first player.
            }
            else {
                playerIndex = 1;
                p = findPlayer(playerIndex);
            }
            squareDisplay = getSquareSymbol(p, pos);
        }
        return squareDisplay;
    }

    private String getSquareSymbol(Player p, int pos){
        char squareSymbol = ' ';
        if (state.getPositions(p).contains(pos)) {
            //switch the default empty symbol to the symbol for that player.
            squareSymbol = symbols.get(p);
        }
        return "[" + squareSymbol + "]";
    }

    private String getSquareSymbol(ArrayList<Player> players, int pos){
        final String blank = "[ ]";
        String square = blank;
        for(Player p : players) {
            String candidate = getSquareSymbol(p, pos);
            if((!candidate.equalsIgnoreCase(blank)) && (!square.equalsIgnoreCase(blank))){
                TextOutput.squareShared();
            }
            square = candidate;
        }
        return square;
    }
    private Player findPlayer(int playerIndex){
        return this.state.getPlayers().get(playerIndex);
    }

}


