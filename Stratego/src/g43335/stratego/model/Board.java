package g43335.stratego.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represent the game board.
 *
 * @author G43335
 */
public class Board {

    private final Square[][] squares;
    private static final int ROWS = 6;
    private static final int COLUMNS = 5;

    /**
     * Initialize the board to 6 row and 5 column. With a lake in
     * (2,1)(2,2)(2,3) and the others square in land.
     */
    public Board() {
        squares = new Square[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if ((i == 2) && (j == 1 || j == 2 || j == 3)) {
                    squares[i][j] = new Square(SquareType.WATER);
                } else {
                    squares[i][j] = new Square(SquareType.LAND);
                }
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

    /**
     * Check if a position is empty/available.
     *
     * @param position is the position to verify.
     * @return true if the position is available.
     * @throws IllegalArgumentException if the position is out of board.
     */
    public boolean isFree(Position position) {
        if (!isInside(position)) {
            throw new IllegalArgumentException("out of board");
        }
        return squares[position.getRow()][position.getColumn()].isFree();
    }

    /**
     * Check if a position belong to the player
     *
     * @param position is the position to verify.
     * @param color is the color of the player.
     * @return true if there is a piece from this player on this position.
     * @throws IllegalArgumentException if the position is out of board.
     */
    public boolean isMyOwn(Position position, PlayerColor color) {
        if (!isInside(position)) {
            throw new IllegalArgumentException("out of board");
        }
        return !(squares[position.getRow()][position.getColumn()].isFree()
                || !squares[position.getRow()][position.getColumn()].isMyOwn(color));
    }

    /**
     * get the piece on a position.
     *
     * @param position is the position to verify.
     * @return the piece on this position.
     * @throws IllegalArgumentException if the position is out of board.
     */
    public Piece getPiece(Position position) {
        if (!isInside(position)) {
            throw new IllegalArgumentException("out of board");
        }
        return (squares[position.getRow()][position.getColumn()].getPiece());
    }

    /**
     * Remove a piece on a position of the board.
     *
     * @param position is the position from the piece we need to remove.
     * @throws IllegalArgumentException if the position is out of board.
     */
    public void remove(Position position) {
        if (!isInside(position)) {
            throw new IllegalArgumentException("out of board");
        }
        if (!isFree(position)) {
            getSquare(position).remove();
        }
    }

    /**
     * Make a list of all the position where a player as a piece.
     *
     * @param player is the player to verify.
     * @return a list containing all the square taked by this player.
     */
    public List<Position> getTakenSquare(Player player) {
        List<Position> positions = new ArrayList();
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                if (isMyOwn(new Position(i, j), player.getColor())) {
                    positions.add(new Position(i, j));
                }
            }
        }
        return positions;
    }
}
