package g43335.stratego.model;

import java.util.Objects;

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
     * Create a hash code value for the object.
     *
     * @return a hash code value for the object.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.piece);
        hash = 89 * hash + Objects.hashCode(this.start);
        hash = 89 * hash + Objects.hashCode(this.end);
        return hash;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param obj an object to compare.
     * @return true if the objects are equals.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Move other = (Move) obj;
        if (!Objects.equals(this.piece, other.piece)) {
            return false;
        }
        if (!Objects.equals(this.start, other.start)) {
            return false;
        }
        if (!Objects.equals(this.end, other.end)) {
            return false;
        }
        return true;
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
