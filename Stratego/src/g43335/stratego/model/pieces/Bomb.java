package g43335.stratego.model.pieces;

import g43335.stratego.model.Piece;
import g43335.stratego.model.PlayerColor;

/**
 * This class represent a Bomb extending a Piece.
 *
 * @author G43335
 */
public class Bomb extends Piece {

    /**
     * Extends Piece to create a Bomb with a rank of 11 and number of step of 0.
     *
     * @param color of the Bomb
     */
    public Bomb(PlayerColor color) {
        super(11, color, 0);
    }

}
