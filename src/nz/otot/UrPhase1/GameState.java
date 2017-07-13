package nz.otot.UrPhase1;

import java.util.List;

/**
 * Created by Main on 05-Jul-17.
 * This keeps track of the game state and passes information to the View/ Controller
 */
public class GameState implements Interactor {

    @Override
    public void spawnPiece(Player player) {
        player.spawnPiece();

    }


    @Override
    public void movePiece(GamePiece piece, int dist) {
        piece.movePiece(dist);
    }

    @Override
    public List getPostions() {
        return null;
    }

    @Override
    public int getPoolSize(Player player) {
        return player.getSize();
    }
}
