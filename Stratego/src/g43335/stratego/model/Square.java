package g43335.stratego.model;

/**
 * This class represent the case of the game board
 *
 * @author G43335
 */
public class Square {

    private Piece piece;

    /**
     * constructor that set a case to null if there is no piece on it
     */
    public Square() {
        this.piece = null;
    }

    /**
     *
     * @param piece is the piece to place on a case
     */
    public Square(Piece piece) {
        this.piece = piece;
    }

    /**
     *
     * @return
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     *
     * @param piece is a piece to add on the current case
     */
    public void put(Piece piece) {
        if (piece == null) {
            throw new IllegalArgumentException("piece cannot be null");
        }
        this.piece = new Piece(piece.getRank(), piece.getColor());
    }
}
