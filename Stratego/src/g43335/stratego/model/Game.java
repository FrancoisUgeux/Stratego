package g43335.stratego.model;

/**
 *
 * @author franc
 */
public class Game implements Model {

    private Board board;
    private Player current;
    private Player opponent;

    public Game(Player current, Player opponent) {
        this.current = current;
        this.opponent = opponent;
    }

    public void initialise() {

    }

    public void start() {

    }

    public boolean isOver() {

    }

    public Square[][] getBoard() {

    }
}
