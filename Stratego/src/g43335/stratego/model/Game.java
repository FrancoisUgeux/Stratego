package g43335.stratego.model;

import g43335.stratego.model.pieces.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class assemble all the other class in model and initialize the different
 * data.
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
        board.put(new Flag(PlayerColor.RED), new Position(0, 1));
        board.put(new General(PlayerColor.RED), new Position(3, 2));
        board.put(new Bomb(PlayerColor.RED), new Position(1, 0));
        board.put(new Miner(PlayerColor.RED), new Position(5, 0));
        board.put(new Marshal(PlayerColor.RED), new Position(0, 3));
        board.put(new Spy(PlayerColor.RED), new Position(5, 4));
        board.put(new Scout(PlayerColor.RED), new Position(1, 4));
        board.put(new Flag(PlayerColor.BLUE), new Position(4, 2));
        board.put(new General(PlayerColor.BLUE), new Position(4, 1));
        board.put(new Bomb(PlayerColor.BLUE), new Position(5, 1));
        board.put(new Miner(PlayerColor.BLUE), new Position(2, 0));
        board.put(new Marshal(PlayerColor.BLUE), new Position(5, 3));
        board.put(new Spy(PlayerColor.BLUE), new Position(0, 4));
        board.put(new Scout(PlayerColor.BLUE), new Position(4, 4));
        current.addPiece(new Flag(PlayerColor.RED));
        current.addPiece(new General(PlayerColor.RED));
        current.addPiece(new Bomb(PlayerColor.RED));
        current.addPiece(new Miner(PlayerColor.RED));
        current.addPiece(new Marshal(PlayerColor.RED));
        current.addPiece(new Spy(PlayerColor.RED));
        current.addPiece(new Scout(PlayerColor.RED));
        opponent.addPiece(new Flag(PlayerColor.BLUE));
        opponent.addPiece(new General(PlayerColor.BLUE));
        opponent.addPiece(new Bomb(PlayerColor.BLUE));
        opponent.addPiece(new Miner(PlayerColor.BLUE));
        opponent.addPiece(new Marshal(PlayerColor.BLUE));
        opponent.addPiece(new Spy(PlayerColor.BLUE));
        opponent.addPiece(new Scout(PlayerColor.BLUE));
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
        if (board == null) {
            return false;
        }
        return (!hasMoves(current) && !hasMoves(opponent)) || (!current.hasFlag()
                || !opponent.hasFlag());
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

    /**
     * select a piece and assign it to the attribute "selected".
     *
     * @param row is the row of the piece to select.
     * @param column is the column of the piece to select.
     * @throws IllegalArgumentException if the position is out of board.
     * @throws IllegalArgumentException if the position is empty.
     * @throws IllegalArgumentException if the position belong to the opponent.
     */
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

    /**
     * Get the selected piece.
     *
     * @return the piece selected piece.
     * @throws NullPointerException if there is no piece selected.
     */
    @Override
    public Piece getSelected() {
        if (selected == null) {
            throw new NullPointerException("selected cannot be null");
        }
        return board.getPiece(selected);
    }

    /**
     * Create a list of moves availables for the selected piece.
     *
     * @return the list of moves availables fot the selected piece.
     * @throws NullPointerException if there is no piece selected.
     */
    @Override
    public List<Move> getMoves() {
        if (selected == null) {
            throw new NullPointerException("selected piece cannot be null");
        }
        Piece piece = getSelected();
        Position start = selected;
        List<Move> moves = new ArrayList<>();
        for (Direction direction : Direction.values()) {
            Position firstEnd;
            Position secondEnd = null;
            if (piece.getNbSteps() != 0) {
                if (piece.getNbSteps() == 1) {
                    firstEnd = selected.next(direction);
                } else {
                    firstEnd = selected.next(direction);
                    secondEnd = firstEnd.next(direction);
                }
                if (board.isInside(firstEnd)
                        && piece.canCross(board.getSquare(firstEnd))
                        && !board.isMyOwn(firstEnd, current.getColor())) {
                    moves.add(new Move(piece, start, firstEnd));
                    if (piece.getNbSteps() == 2 && board.isInside(secondEnd)
                            && piece.canCross(board.getSquare(secondEnd))
                            && board.isFree(firstEnd)
                            && board.isFree(secondEnd)) {
                        moves.add(new Move(piece, start, secondEnd));
                    }
                }
            }
        }
        return moves;
    }

    /**
     * Apply the chosed move from the list of moves.
     *
     * @param move is the list of moves available for the selected piece.
     * @throws NullPointerException if there is no move.
     */
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
            current.remove(assailant);
            opponent.remove(attacked);
        } else {
            current.remove(assailant);
        }
        board.remove(move.getStart());
        swapPlayers();
    }

    /**
     * Exchange the status of each player.
     */
    public void swapPlayers() {
        if (hasMoves(opponent)) {
            Player temp = current;
            current = opponent;
            opponent = temp;
        }
    }

    /**
     * Get the current player.
     *
     * @return the current player.
     */
    @Override
    public Player getCurrent() {
        return current;
    }

    /**
     * Check if a player has some moves available.
     *
     * @param player is the player to check for some moves.
     * @return true if the player has at least one move available.
     */
    public boolean hasMoves(Player player) {
        List positions = board.getTakenSquare(player);
        Iterator<Position> iterator = positions.iterator();
        Boolean hasMove = false;
        while (iterator.hasNext() && !hasMove) {
            Position position = iterator.next();
            for (Direction direction : Direction.values()) {
                int nbSteps = board.getSquare(position).getPiece().getNbSteps();
                Position nextPos = position.next(direction);
                if (board.isInside(nextPos)
                        && board.getSquare(nextPos).isLand()
                        && nbSteps != 0) {
                    hasMove = true;
                }
            }
        }
        return hasMove;
    }

    /**
     * Determines the winner(s).
     *
     * @return the list of winner(s).
     * @throws IllegalArgumentException if the game is not over.
     */
    @Override
    public List<Player> getWinners() {
        if (!isOver()) {
            throw new IllegalArgumentException("Game must be over");
        }
        List<Player> winner = new ArrayList();
        if ((!current.hasFlag() && !opponent.hasFlag())
                || (!hasMoves(current) && !hasMoves(opponent))
                || (!current.hasFlag() && !hasMoves(opponent))
                || (!opponent.hasFlag() && !hasMoves(current))) {
            winner.add(current);
            winner.add(opponent);
        } else if (!current.hasFlag() || !hasMoves(current)) {
            winner.add(opponent);
        } else {
            winner.add(current);
        }
        return winner;
    }
}
