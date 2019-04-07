package g43335.stratego.model;

/**
 * This class represent the game board.
 *
 * @author G43335
 */
public class Board {

    private final Square[][] squares;

    /**
     * Initialize the board to 5 row and 4 column.
     */
    public Board() {
        int rows = 5;
        int columns = 4;
        squares = new Square[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                squares[i][j] = new Square();
            }
        }
    }

    /**
     *
     * @return the squares.
     */
    public Square[][] getSquares() {
        return squares;
    }

    /**
     * Check if a position is inside the board.
     *
     * @param position is the position to verify.
     * @return true if the position is in the game board.
     * @throws NullPointerException if the position is null.
     */
    public boolean isInside(Position position) {
        if (position == null) {
            throw new NullPointerException("position cannot be null");
        }
        return (position.getRow() < squares.length
                && position.getRow() >= 0
                && position.getColumn() < squares[0].length
                && position.getColumn() >= 0);
    }

    /**
     *
     * @param position is the position to check on the board.
     * @return the value on this position of the board.
     * @throws NullPointerException if the position is null.
     * @throws IllegalArgumentException if the position is not inside the board.
     */
    public Square getSquare(Position position) {
        if (position == null) {
            throw new NullPointerException("position cannot be null");
        }
        if (!isInside(position)) {
            throw new IllegalArgumentException("out of board");
        }
        return squares[position.getRow()][position.getColumn()];
    }

    /**
     * Add a piece on a position of the board
     *
     * @param piece is the piece to put on the board
     * @param position is the position where we want to add a piece
     * @throws IllegalArgumentException if the position is not inside the board.
     * @throws NullPointerException if the piece is null.
     */
    public void put(Piece piece, Position position) {
        if (!isInside(position)) {
            throw new IllegalArgumentException("out of board");
        }
        if (piece == null) {
            throw new NullPointerException("piece cannot be null");
        }
        squares[position.getRow()][position.getColumn()].put(piece);
    }

    public boolean isFree(Position position) {
        if (!isInside(position)) {
            throw new IllegalArgumentException("out of board");
        }
        return (squares[position.getRow()][position.getColumn()].getPiece()
                == null);
    }

    public boolean isMyOwn(Position position, PlayerColor color) {
        if (!isInside(position)) {
            throw new IllegalArgumentException("out of board");
        }
        return !(squares[position.getRow()][position.getColumn()]
                .getPiece() == null
                || squares[position.getRow()][position.getColumn()]
                        .getPiece().getColor() != color);
    }

    public Piece getPiece(Position position) {
        if (!isInside(position)) {
            throw new IllegalArgumentException("out of board");
        }
        return (squares[position.getRow()][position.getColumn()].getPiece());
    }
    
    public void remove(Position position){
        if(!isInside(position)){
            throw new IllegalArgumentException("out of board");
        }
        if(!isFree(position)){
            squares[position.getRow()][position.getColumn()].remove();
        }
    }
}
