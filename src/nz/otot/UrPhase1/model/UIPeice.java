package nz.otot.UrPhase1.model;



import java.awt.*;

/**
 * Created by Main on 19-Jul-17.
 *
 * This is an interdface so that only specific elements of the peice can be exposed to the view
 * The view only ever needs to to see the player and the position of the peice
 */
public interface UIPeice {

    Player getPlayer();

    Point getBoardPosition2p();

}
