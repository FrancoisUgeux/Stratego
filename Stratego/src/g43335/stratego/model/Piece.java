package g43335.stratego.model;

/**
 *
 * @author franc
 */
public class Piece {

    private int rank;
    private PlayerColor color;

    public Piece(int rank, PlayerColor color) {
        if(rank < 0){
            throw new IllegalArgumentException("rank cannot be negative");
        }
        this.rank = rank;
        this.color = color;
    }

    public int getRank() {
        return rank;
    }

    public PlayerColor getColor() {
        return color;
    }
}
