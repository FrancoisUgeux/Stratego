package g43335.stratego.model.pieces;

import g43335.stratego.model.Piece;
import g43335.stratego.model.PlayerColor;

/**
 *
 * @author G43335
 */
public class Miner extends Piece {

    public Miner(PlayerColor color) {
        super(3, color);
    }

    @Override
    public boolean isStronger(Piece other) {
        return (super.isStronger(other) || other.getRank() == 11);
    }
}
