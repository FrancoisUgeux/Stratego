package g43335.stratego.model.pieces;

import g43335.stratego.model.Piece;
import g43335.stratego.model.PlayerColor;

/**
 * This class represent a Spy extending a Piece. A spy is stronger than a
 * marshal when attacking it
 *
 * @author G43335
 */
public class Spy extends Piece {

    /**
     * extends Piece to create a Spy with a rank of 1.
     *
     * @param color of the Spy
     */
    public Spy(PlayerColor color) {
        super(1, color);
    }

    @Override
    public boolean isStronger(Piece other) {
        return (super.isStronger(other) || other.getRank() == 10);
    }
}
