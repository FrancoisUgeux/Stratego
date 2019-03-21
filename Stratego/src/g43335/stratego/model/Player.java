package g43335.stratego.model;

/**
 *
 * @author franc
 */
public class Player {

    private PlayerColor color;
    private Piece pieces;

    public Player(PlayerColor color) {
        this.color = color;
        this.pieces = null;
    }

    public PlayerColor getColor() {
        return color;
    }

    public Piece getPieces() {
        return pieces;
    }
    
    public static void addPiece(Piece piece){
        this.pieces = new Piece(piece);
    }
}
