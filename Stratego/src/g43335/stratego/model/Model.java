package g43335.stratego.model;

import java.util.List;

/**
 * Model of Stratego
 *
 * @author G43335
 */
public interface Model {

    /**
     * Initialize the stratego game with a default board.
     */
    void initialize();

    /**
     * Check if a match can start.
     */
    void start();

    /**
     * Declares if it's the end of the game.
     *
     * @return true if it's the end of the game.
     */
    boolean isOver();

    /**
     * Return the board.
     *
     * @return the board.
     */
    Square[][] getBoard();

    /**
     * Select a piece from a new position of row and column.
     *
     * @param row is the row from the position to select.
     * @param column is the column from the position to select.
     */
    void select(int row, int column);

    /**
     * Get the selected piece.
     *
     * @return the selected piece.
     */
    Piece getSelected();

    /**
     * Create a list of moves availables for the selected piece.
     *
     * @return the list of moves availables fot the selected piece.
     */
    List<Move> getMoves();

    /**
     * Apply the chosed move from the list of moves.
     *
     * @param move is the list of moves available for the selected piece.
     */
    void apply(Move move);

    /**
     * Get the current player.
     *
     * @return the current player.
     */
    Player getCurrent();

    /**
     * Determines the winner(s).
     *
     * @return the list of winner(s).
     */
    List<Player> getWinners();
}
