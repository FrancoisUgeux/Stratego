package g43335.stratego.model.pieces;

import g43335.stratego.model.Piece;
import g43335.stratego.model.PlayerColor;

/**
 * This class represent a Miner extending a Piece. A miner is stronger than a
 * Bomb.
 *
 * @author G43335
 */
public class Miner extends Piece {

    /**
     * extends Piece to create a Miner with a rank of 3
     *
     * @param color of the Miner
     */
    public Miner(PlayerColor color) {
        super(3, color);
    }

    @Override
    public boolean isStronger(Piece other) {
        return (super.isStronger(other) || other.getRank() == 11);
    }
}
