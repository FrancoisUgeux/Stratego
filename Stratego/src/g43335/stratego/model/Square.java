package g43335.stratego.model;

import java.util.Objects;

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
    //public Square(Piece piece) {
    //    this.pieces = piece;
    //}

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
        if (!Objects.equals(this.piece, other.piece)) {
            return false;
        }
        return true;
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
            throw new NullPointerException("piece cannot be null");
        }
        if (this.piece != null) {
            throw new IllegalStateException("the case must be empty");
        }
        this.piece = piece;  
    }
}
