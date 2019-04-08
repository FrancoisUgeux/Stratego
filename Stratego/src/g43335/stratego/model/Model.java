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
    
    void select(int row, int column);
    
    Piece getSelected();
    
    List<Move> getMoves();
    
    void apply(Move move);
    
    Player getCurrent();
}
