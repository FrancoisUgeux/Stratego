package g43335.stratego.model;

import java.util.Objects;

/**
 * This class represent the case of the game board
 *
 * @author G43335
 */
public class Square {

    private Piece pieces;


    /**
     * constructor that set a case to null if there is no piece on it
     */
    public Square() {
        this.pieces = null;
    }

    /**
     *
     * @param piece is the piece to place on a case
     */
    public Square(Piece piece) {
        this.pieces = piece;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.pieces);
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
        if (!Objects.equals(this.pieces, other.pieces)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    public Piece getPiece() {
        return pieces;
    }

    /**
     *
     * @param piece is a piece to add on the current case
     */
    public void put(Piece pieces) {
        if (pieces == null) {
            throw new NullPointerException("piece cannot be null");
        }
        this.pieces = pieces;   //new Piece(piece.getRank(), piece.getColor());
    }
}
