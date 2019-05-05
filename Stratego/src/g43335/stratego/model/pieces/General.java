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
     * @param rank of the General.
     * @param color of the General.
     */
    public General(int rank, PlayerColor color) {
        super(9, color); //constante static pour le rank
    }

}
