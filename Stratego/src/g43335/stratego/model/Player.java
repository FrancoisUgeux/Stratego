package g43335.stratego.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class represent a player, each player has a color and set of pieces
 *
 * @author G43335
 */
public class Player {

    private PlayerColor color;
    private ArrayList<Piece> pieces;

    /**
     *
     * @param color is the color of the player
     */
    public Player(PlayerColor color) {
        if (color == null) {
            throw new NullPointerException("Color cannot be null");
        }
        this.color = color;
        this.pieces = new ArrayList<>();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.color);
        hash = 67 * hash + Objects.hashCode(this.pieces);
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
        final Player other = (Player) obj;
        if (this.color != other.color) {
            return false;
        }
        if (!Objects.equals(this.pieces, other.pieces)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return the color of the player
     */
    public PlayerColor getColor() {
        return color;
    }

    /**
     *
     * @return the pieces of a player
     */
    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    /**
     *
     * @param piece is the piece to add in the player's piece set
     */
    public void addPiece(Piece piece) {
        pieces.add(piece);
    }

}
