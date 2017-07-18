package nz.otot.UrPhase1;

/**
 * Created by Main on 05-Jul-17.
 * This keeps track of the Pool of unused tokens that have yet to be place on the board.
 * As all pieces are interchangable this currently stores them just as ints.
 *
 * Primary interactions should be through the BoardTrack Class
 */
public class Player {

    private static int playerCount = 0;

    private String name;

    private int piecePool; //number of peices available to use in the pool, not on the board.
    private Node<Piece> startingNode;

    public Player(String name, int startingPieces, Node<Piece> startingNode) {

        this.name = name;
        this.piecePool = startingPieces;
        this.startingNode = startingNode; // Takes a start Node from the graph so the graph needs to be made first

    }
    public Player(int startingPieces, Node<Piece> startingNode) {

        this.name = "Player" + Integer.toString(playerCount++);
        this.piecePool = startingPieces;
        this.startingNode = startingNode; // Takes a start Node from the graph so the graph needs to be made first

    }
    public Player(int startingPieces) {

        this.name = "Player" + Integer.toString(playerCount++);
        this.piecePool = startingPieces;
        this.startingNode = new Node<Piece>(); // Takes a start Node from the graph so the graph needs to be made first

    }


    // Pool Management methods

    public void spawnPiece(){
        //Creates a virtual piece by incrementing one side.
        //In future this could be amended to actually create a Piece object

        piecePool++;

    }

    public void killPiece(){
        //counterpart to spawn Pieces

        piecePool--;

    }
    public Piece transferPeice(){
        killPiece();
        return new Piece(this);
    }

    public Node<Piece> getStartingNode(){
        return startingNode;
    }

    public int getSize(){
        return this.piecePool;
    }

}
