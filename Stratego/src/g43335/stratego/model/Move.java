package g43335.stratego.model;

/**
 * This class represent a movement for a piece.
 *
 * @author G43335
 */
public class Move {

    private Piece piece;
    private Position start;
    private Position end;

    /**
     * Initialize the differents attributes.
     *
     * @param piece is the piece to move.
     * @param start is the starting point of the piece.
     * @param end is the point of arrival of the piece.
     */
    public Move(Piece piece, Position start, Position end) {
        if (piece == null || start == null || end == null) {
            throw new NullPointerException("Attributes cannot be null");
        }
        this.piece = piece;
        this.start = start;
        this.end = end;
    }

    /**
     * Get the piece.
     *
     * @return the piece.
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * Get the starting point.
     *
     * @return the starting point.
     */
    public Position getStart() {
        return start;
    }

    /**
     * Get the point of arrival.
     *
     * @return the point of arrival.
     */
    public Position getEnd() {
        return end;
    }

}
