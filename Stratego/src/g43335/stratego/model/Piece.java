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
    private int nbSteps;

    /**
     * Initialize a Piece with a rank, a color and a default number of steps.
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
        nbSteps = 1;
    }

    /**
     * Initialize a Piece with a rank, a color and a number of steps.
     *
     * @param rank is the rank of a piece.
     * @param color is the color of a piece.
     * @param nbSteps is the number of steps of a piece.
     * @throws IllegalArgumentException if the number of steps is negative.
     */
    public Piece(int rank, PlayerColor color, int nbSteps) {
        if (nbSteps < 0) {
            throw new IllegalArgumentException("The number of steps cannot be negative");
        }
        this.rank = rank;
        this.color = color;
        this.nbSteps = nbSteps;
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
     * Get the number of steps of the piece.
     *
     * @return the number of steps of this piece.
     */
    public int getNbSteps() {
        return nbSteps;
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

    /**
     * Inform if a square can be crossed.
     *
     * @param square is the square to verify
     * @return true if it can be crossed.
     */
    public boolean canCross(Square square) {
        return square.isLand();
    }
}
