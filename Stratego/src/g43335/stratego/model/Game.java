package g43335.stratego.model;

import g43335.stratego.model.pieces.Flag;
import g43335.stratego.model.pieces.General;
import java.util.ArrayList;
import java.util.List;

/**
 * This class assemble all the other class in model and initialize the different
 * data
 *
 * @author G43335
 */
public class Game implements Model {

    private Player current;
    private Player opponent;
    private Board board;
    private Position selected;

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
        board.put(new Flag(0, PlayerColor.RED), new Position(0, 1));
        board.put(new General(9, PlayerColor.RED), new Position(3, 2));
        board.put(new Flag(0, PlayerColor.BLUE), new Position(4, 2));
        board.put(new General(9, PlayerColor.BLUE), new Position(4, 1));
        current.addPiece(new Flag(0, PlayerColor.RED));
        current.addPiece(new General(9, PlayerColor.RED));
        opponent.addPiece(new Flag(0, PlayerColor.BLUE));
        opponent.addPiece(new General(9, PlayerColor.BLUE));
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
        return board.getSquares();
    }

    @Override
    public void select(int row, int column) {
        if (!board.isInside(new Position(row, column))) {
            throw new IllegalArgumentException("square is out of the board");
        }
        if (board.isFree(new Position(row, column))) {
            throw new IllegalArgumentException("square cannot be empty");
        }
        if (!board.isMyOwn(new Position(row, column), current.getColor())) {
            throw new IllegalArgumentException("square cannot belong to opponent");
        }
        selected = new Position(row, column);
    }

    @Override
    public Piece getSelected() {
        if (selected == null) {
            throw new NullPointerException("selected cannot be null");
        }
        return board.getPiece(selected);
    }

    @Override
    public List<Move> getMoves() {
        if (selected == null) {
            throw new NullPointerException("selected piece cannot be null");
        }

        Piece piece = board.getPiece(new Position(selected.getRow(), selected.getColumn()));
        Position start = new Position(selected.getRow(), selected.getColumn());
        List<Move> moves = new ArrayList<>();
        for (Direction direction : Direction.values()) {
            if (board.isInside(selected.next(direction))) {
                Position end = new Position(selected.next(direction).getRow(),
                        selected.next(direction).getColumn());
                moves.add(new Move(piece, start, end));
            }
        }
        return moves;
    }

    @Override
    public void apply(Move move) {
        if (move == null) {
            throw new NullPointerException("Invalid move");
        }
        Piece assailant = move.getPiece();
        Position target = move.getEnd();
        Piece attacked = board.getSquare(target).getPiece();
        if (board.isFree(target)) {
            board.getSquare(target).put(assailant);
        } else if (assailant.isStronger(attacked)) {
            board.remove(target);
            board.put(assailant, target);
            opponent.remove(attacked);
        } else if (assailant.hasSameRank(attacked)) {
            board.remove(target);
        } else {
            current.remove(assailant);
        }
        board.remove(move.getStart());
        swapPlayers();
    }

    public void swapPlayers() {
        Player temp = current;
        current = opponent;
        opponent = temp;
    }

    @Override
    public Player getCurrent() {
        return current;
    }
}
