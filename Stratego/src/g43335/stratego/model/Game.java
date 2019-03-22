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
        Piece piece = new Piece();
        this.current = new Player(PlayerColor.RED,pieces);
       // this.current.addPiece(new Player(PlayerColor.RED));
        //this.opponent.addPiece(new Player(PlayerColor.BLUE));
    }

    public void initialise() {
        Position position = new Position(0,1);
        Piece piece = new Piece()
        Board board = new Board(piece, position);
    }

    public void start() {
        if()
    }

    public boolean isOver() {

    }

    public Square[][] getBoard() {

    }
}
