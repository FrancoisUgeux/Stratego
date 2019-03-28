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
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Piece other = (Piece) obj;
        if (this.rank != other.rank) {
            return false;
        }
        return this.color == other.color;
    }

    /**
     *
     * @return the rank of the piece.
     */
    public int getRank() {
        return rank;
    }

    /**
     *
     * @return the color of the piece.
     */
    public PlayerColor getColor() {
        return color;
    }
}
