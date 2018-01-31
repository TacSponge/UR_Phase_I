package nz.otot.UrPhase1.model;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Main on 06-Jul-17.
 *
 * Provides an interface so that the View can get the information that it needs without being otherwise able to interact
 * with the gamestate
 *
 */
public interface StateReader {

    HashSet<Integer> getPositions(int pID);

    int getPoolSize(int pID);

    int getScore(int pID);

    ArrayList<Integer> getPIDs();

    String getPlayerName(int pID);
}

