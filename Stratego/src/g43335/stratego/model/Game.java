package g43335.stratego.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class assemble all the other class and initialize the different data
 *
 * @author G43335
 */
public class Game implements Model {

    //private Position position;
    //private Piece piece;
    // private Board board;
    private Player current;
    private Player opponent;
    private Board board;

    public Game() {
        this.current = new Player(PlayerColor.RED);
        this.opponent = new Player(PlayerColor.BLUE);
    }

    /**
     *
     * @param current is the currently playing character
     * @param opponent is the other player
     */
    /**
     * 
     */
    @Override
    public void initialize() {
        board = new Board();
        this.board.put(new Piece(0, PlayerColor.RED), new Position(0, 1));
        this.board.put(new Piece(9, PlayerColor.RED), new Position(3, 2));
        this.board.put(new Piece(0, PlayerColor.BLUE), new Position(4, 2));
        this.board.put(new Piece(9, PlayerColor.BLUE), new Position(4, 1));
        this.current.addPiece(new Piece(0, PlayerColor.RED));
        this.current.addPiece(new Piece(9, PlayerColor.RED));
        this.opponent.addPiece(new Piece(0, PlayerColor.BLUE));
        this.opponent.addPiece(new Piece(9, PlayerColor.BLUE));
    }

    /**
     *
     */
    @Override
    public void start() {
        if (board == null) {
            throw new IllegalStateException("board not initialized or game is over");
        }
    }

    /**
     *
     * @return true if the game has ended
     */
    @Override
    public boolean isOver() {
        return false;
    }

    /**
     *
     * @return the current status of the board
     */
    @Override
    public Square[][] getBoard() {
        return this.board.getSquares();
    }
}
