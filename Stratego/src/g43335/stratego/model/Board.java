package g43335.stratego.model;

/**
 * This class represent the game board
 *
 * @author G43335
 */
public class Board {

    private Square[][] squares;

    /**
     * Initialize the board to 5 row and 4 column
     */
    public Board() {
        this.squares = new Square[5][4];
    }

    /**
     *
     * @return
     */
    public Square[][] getSquares() {
        return squares;
    }

    /**
     *
     * @param position is the position to verify
     * @return true if the position is in the game board
     */
    public boolean isInside(Position position) {
        return (position.getRow() < squares.length
                && position.getRow() >= 0
                && position.getColumn() < squares[0].length
                && position.getColumn() >= 0);
    }

    /**
     *
     * @param position is the position to check
     * @return the value on the position
     */
    public Square getSquare(Position position) {
        if (!isInside(position)) {
            throw new IllegalArgumentException("out of board");
        }
        return this.squares[position.getRow()][position.getColumn()];
    }

    /**
     * Add a piece on a position of the board
     *
     * @param piece is the piece to put on the board
     * @param position is the position where we want to add a piece
     */
    public void put(Piece piece, Position position) {
        if (!isInside(position)) {
            throw new IllegalArgumentException("out of board");
        }
        if(piece == null){
            throw new NullPointerException("piece cannot be null");
        }
        this.squares[position.getRow()][position.getColumn()].put(piece);
    }

}
