package g43335.stratego.model.pieces;

import g43335.stratego.model.Piece;
import g43335.stratego.model.PlayerColor;

/**
 * This class represent a Scout extending a Piece.
 * 
 * @author G43335
 */
public class Scout extends Piece {

    /**
     * extends Piece to create a Scout with a rank of 2 and number of steps of 2.
     *
     * @param color of the Scout
     */
    public Scout(PlayerColor color) {
        super(2, color, 2);
    }
}
