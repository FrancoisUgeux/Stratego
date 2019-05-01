package g43335.stratego.model.pieces;

import g43335.stratego.model.Piece;
import g43335.stratego.model.PlayerColor;

/**
 *
 * @author G43335
 */
public class Spy extends Piece {

    public Spy(PlayerColor color) {
        super(1, color);
    }

    @Override
    public boolean isStronger(Piece other) {
        return (super.isStronger(other) || other.getRank() == 10);
    }
}
