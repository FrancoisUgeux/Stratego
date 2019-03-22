package g43335.stratego.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franc
 */
public class Game implements Model {

    private List<Piece> pieces;
    //private Position position;
    //private Piece piece;
    // private Board board;
    private Player current;
    private Player opponent;
    private Game game;

    public Game(Player current, Player opponent) {
        this.pieces = new ArrayList<>();
        this.current = new Player(PlayerColor.RED);
        this.opponent = new Player(PlayerColor.BLUE);
        // this.current.addPiece(new Player(PlayerColor.RED));
        //this.opponent.addPiece(new Player(PlayerColor.BLUE));
    }

    @Override
    public void initialize() {
        Board board = new Board();
        this board.put(new Piece(0, PlayerColor.RED), new Position(0, 1));
    }

    @Override
    public void start() {
        if ( && isOver) {
            throw new IllegalArgumentException
            ("board not initialized or game is over");
        }
    }

    @Override
    public boolean isOver() {
        return false;
    }

    @Override
    public Square[][] getBoard() {
        return this.getBoard();
    }
}
