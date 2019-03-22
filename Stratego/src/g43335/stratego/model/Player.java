package g43335.stratego.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represent a player, each player has a color and set of pieces
 *
 * @author G43335
 */
public class Player {

    private PlayerColor color;
    private Piece pieces;

    /**
     *
     * @param color is the color of the player
     */
    public Player(PlayerColor color) {
        if (color == null) {
            throw new IllegalArgumentException("Color cannot be null");
        }
        this.color = color;
        this.pieces = null;
        List<Piece> list = new ArrayList<>();
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
    public Piece getPieces() {
        return pieces;
    }

    /**
     *
     * @param piece is the piece to add in the player's piece set
     */
    public void addPiece(Piece piece) {
        this.pieces.getRank();
        this.pieces.getColor();
    }

}
