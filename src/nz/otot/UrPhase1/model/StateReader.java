package nz.otot.UrPhase1.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Main on 06-Jul-17.
 */
public interface StateReader {

    List getPostions();

    int getPoolSize(Player player);

    ArrayList<Player> getPlayers();
}

