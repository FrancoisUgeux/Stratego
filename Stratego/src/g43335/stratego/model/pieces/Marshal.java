package g43335.stratego.model.pieces;

import g43335.stratego.model.Piece;
import g43335.stratego.model.PlayerColor;

/**
 * This class represent a Marshal extending a Piece.
 *
 * @author G43335
 */
public class Marshal extends Piece {

    /**
     * extends Piece to create a Marshal with a rank of 10.
     *
     * @param color of the Marshal
     */
    public Marshal(PlayerColor color) {
        super(10, color);
    }
}
