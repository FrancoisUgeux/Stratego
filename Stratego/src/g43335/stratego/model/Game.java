package g43335.stratego.model;

/**
 * This class assemble all the other class in model and initialize the different
 * data
 *
 * @author G43335
 */
public class Game implements Model {

    private final Player current;
    private final Player opponent;
    private Board board;

    /**
     * Initialize the 2 players and their colors.
     */
    public Game() {
        current = new Player(PlayerColor.RED);
        opponent = new Player(PlayerColor.BLUE);
    }

    /**
     * Initialize the stratego game with a default board.
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
     * Check if a game can start.
     *
     * @throws IllegalStateException if the board is not initialized.
     */
    @Override
    public void start() {
        if (board == null) {
            throw new IllegalStateException("board not initialized or game is over");
        }
    }

    /**
     * Check if the game is over.
     *
     * @return true if the game has ended.
     */
    @Override
    public boolean isOver() {
        return false;
    }

    /**
     * Give the game board.
     *
     * @return the board.
     */
    @Override
    public Square[][] getBoard() {
        return this.board.getSquares();
    }
}
