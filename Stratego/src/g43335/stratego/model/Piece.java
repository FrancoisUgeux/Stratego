package g43335.stratego.model;

import java.util.Objects;

/**
 * This class create the pieces of the game.
 *
 * @author G43335
 */
public class Piece {

    private int rank;
    private PlayerColor color;

    /**
     * Initialize a Piece with a rank and a color.
     *
     * @param rank is the rank of a piece.
     * @param color is the color of a piece.
     * @throws IllegalArgumentException if the rank is negative.
     */
    public Piece(int rank, PlayerColor color) {
        if (rank < 0) {
            throw new IllegalArgumentException("rank cannot be negative");
        }
        this.rank = rank;
        this.color = color;
    }

    /**
     * Create a hash code value for the object.
     *
     * @return a hash code value for the object.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.rank;
        hash = 71 * hash + Objects.hashCode(this.color);
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
        final Piece other = (Piece) obj;
        if (this.rank != other.rank) {
            return false;
        }
        return this.color == other.color;
    }

    /**
     * Get the rank of the piece.
     *
     * @return the rank of the piece.
     */
    public int getRank() {
        return rank;
    }

    /**
     * Get the color of the piece.
     *
     * @return the color of the piece.
     */
    public PlayerColor getColor() {
        return color;
    }

    /**
     * Determines if another piece is stronger than the current piece.
     *
     * @param other is the other piece.
     * @return true if the current piece is stronger than the other one.
     */
    public boolean isStronger(Piece other) {
        return (this.rank > other.getRank());
    }

    /**
     * Determines if another piece has the same rank than the current piece.
     *
     * @param other is the other piece.
     * @return true if the other and current piece have the same rank.
     */
    public boolean hasSameRank(Piece other) {
        return (this.rank == other.getRank());
    }
    
    public boolean canCross(Square square){
        return square.isLand();
    }
}
