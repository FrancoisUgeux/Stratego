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
        return (position.getRow() <= squares.length
                && position.getRow() >= 0
                && position.getColumn() <= squares.length
                && position.getColumn() >= 0);
    }

    public Square getSquare(Position position) {
        if (!isInside(position)) {
            throw new IllegalArgumentException("out of board");
        }
        return this.squares[position.getRow()][position.getColumn()];
    }

    public void put(Piece piece, Position position) {
        if (!isInside(position)) {
            throw new IllegalArgumentException("out of board");
        }
        this.squares[position.getRow()][position.getColumn()] = piece;
    }

}
