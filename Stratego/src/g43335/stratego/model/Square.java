package g43335.stratego.model;

/**
 *
 * @author franc
 */
public class Square {

    private Piece piece;

    public Square() {
        this.piece = null;
    }

    public Square(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public void put(Piece piece) {
        this.piece = new Piece(piece.getRank(),piece.getColor());
    }
}
