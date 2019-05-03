package g43335.stratego.model.pieces;

import g43335.stratego.model.Piece;
import g43335.stratego.model.PlayerColor;

/**
 * This class represent a General extending a Piece.
 *
 * @author G43335
 */
public class General extends Piece {

    /**
     * extends Piece to create a Flag with a rank of 9
     *
     * @param color of the General.
     */
    public General(PlayerColor color) {
        super(9, color);
    }

}
