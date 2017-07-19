package nz.otot.UrPhase1.model;

/**
 * Created by Main on 05-Jul-17.
 * An interactor interface takes instructions from the controller and passes them to the relevant model pieces
 */
public interface Interactor extends StateReader {

    // Creates a new peice for that player in the pool
    void spawnPiece(Player player);

   // Moves a piece by a set distance
    void movePiece(Piece piece, int dist);


}
