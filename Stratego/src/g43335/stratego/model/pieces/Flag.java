package g43335.stratego.model.pieces;

import g43335.stratego.model.Piece;
import g43335.stratego.model.PlayerColor;

/**
 * This class represent a Flag extending a Piece.
 *
 * @author G43335
 */
public class Flag extends Piece{
    
    /**
     * extends Piece to create a Flag with a rank of 0.
     * @param rank of the Flag.
     * @param color of the Flag.
     */
    public Flag(int rank, PlayerColor color) {
        super(0, color);
    }
    
}
