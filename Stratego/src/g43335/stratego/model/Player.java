package g43335.stratego.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franc
 */
public class Player {

    private PlayerColor color;
    private Piece pieces;

    public Player(PlayerColor color) {
        this.color = color;
        this.pieces = null;
        List<Piece> list = new ArrayList<>();
    }

    public PlayerColor getColor() {
        return color;
    }

    public Piece getPieces() {
        return pieces;
    }

    public void addPiece(Piece piece) {
        this.pieces.getRank();
        this.pieces.getColor();
    }

}
