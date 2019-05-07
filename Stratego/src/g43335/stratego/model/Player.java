package g43335.stratego.model;

import java.util.ArrayList;
import java.util.Objects;

/**
 * This class initialize a player with a color and a set of pieces.
 *
 * @author G43335
 */
public class Player {

    private PlayerColor color;
    private final ArrayList<Piece> pieces;

    /**
     * Initialize a player with a color and a List of pieces.
     *
     * @param color is the color of the player.
     * @throws NullPointerException if the color is null.
     */
    public Player(PlayerColor color) {
        if (color == null) {
            throw new NullPointerException("Color cannot be null");
        }
        this.color = color;
        pieces = new ArrayList<>();
    }

    /**
     * Create a hash code value for the object.
     *
     * @return a hash code value for the object.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.color);
        hash = 67 * hash + Objects.hashCode(this.pieces);
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
        final Player other = (Player) obj;
        if (this.color != other.color) {
            return false;
        }
        return Objects.equals(this.pieces, other.pieces);
    }

    /**
     * Get the color of the player.
     *
     * @return the color of the player.
     */
    public PlayerColor getColor() {
        return color;
    }

    /**
     * Get the pieces of the player.
     *
     * @return the pieces of the player.
     */
    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    /**
     * Add a piece to the player's List of pieces.
     *
     * @param piece is the piece to add in the player's piece set.
     */
    public void addPiece(Piece piece) {
        pieces.add(piece);
    }

    /**
     * Remove a piece from the list of the player.
     *
     * @param piece is the piece to remove.
     */
    public void remove(Piece piece) {
        pieces.remove(piece);
    }

    /**
     * Determines if the player has a flag.
     *
     * @return true if the player has a flag.
     */
    public boolean hasFlag() {
        boolean hasAFlag = false;
        for (Piece piece : pieces) {
            if (piece.getRank() == 0) {
                hasAFlag = true;
            }
        }
        return hasAFlag;
    }
}
