package g43335.stratego.model;

import java.util.Objects;

/**
 * This class represent the case of the game board.
 *
 * @author G43335
 */
public class Square {

    private Piece piece;

    /**
     * constructor that set a case to null if there is no piece on it.
     */
    public Square() {
        this.piece = null;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.piece);
        return hash;
    }

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
        final Square other = (Square) obj;
        return Objects.equals(this.piece, other.piece);
    }

    /**
     *
     * @return the piece of the current case.
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * Put a piece on a case if this case is empty.
     *
     * @param piece is a piece to add on the current case.
     * @throws NullPointerException if the piece is null.
     * @throws IllegalStateException if there is already a piece on the case.
     */
    public void put(Piece piece) {
        if (piece == null) {
            throw new NullPointerException("piece cannot be null");
        }
        if (this.piece != null) {
            throw new IllegalStateException("the case must be empty");
        }
        this.piece = piece;
    }
}
