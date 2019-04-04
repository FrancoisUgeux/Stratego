package g43335.stratego.model;

/**
 *
 * @author G43335
 */
public class Move {

    private Piece piece;
    private Position start;
    private Position end;

    public Move(Piece piece, Position start, Position end) {
        if (piece == null || start == null || end == null) {
            throw new NullPointerException("Attributes cannot be null");
        }
        this.piece = piece;
        this.start = start;
        this.end = end;
    }

    public Piece getPiece() {
        return piece;
    }

    public Position getStart() {
        return start;
    }

    public Position getEnd() {
        return end;
    }

}
