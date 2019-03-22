package g43335.stratego.model;

/**
 * This class create the pieces of the game
 *
 * @author G43335
 */
public class Piece {

    private int rank;
    private PlayerColor color;

    /**
     *
     * @param rank is the rank of a piece
     * @param color is the color of a piece
     */
    public Piece(int rank, PlayerColor color) {
        if (rank < 0) {
            throw new IllegalArgumentException("rank cannot be negative");
        }
        this.rank = rank;
        this.color = color;
    }

    /**
     *
     * @return the rank of the piece
     */
    public int getRank() {
        return rank;
    }

    /**
     *
     * @return the color of the piece
     */
    public PlayerColor getColor() {
        return color;
    }
}
