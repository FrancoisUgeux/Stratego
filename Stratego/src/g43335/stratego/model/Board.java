package g43335.stratego.model;

/**
 *
 * @author franc
 */
public class Board {

    private Square[][] squares;

    public Board() {
        this.squares = new Square[5][4];
    }

    public Square[][] getSquares() {
        return squares;
    }

    public boolean isInside(Position position) {
        return (position.getRow() <= Square.length && position.getColumn()
                <= Square[0].length);
    }

    public Square getSquare(Position position) {
        return;
    }

    public void put(Piece piece, Position position) {

    }

}
