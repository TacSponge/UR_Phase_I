package nz.otot.UrPhase1.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Main on 06-Jul-17.
 *
 * Provides an interface so that the View can get the information that it needs without being otherwise able to interact
 * with the gamestate
 *
 */
public interface StateReader {

    HashMap<Player, Integer> getPositions(Player p);

    int getPoolSize(Player player);

    ArrayList<Player> getPlayers();

}

