package g43335.stratego.model;

import static g43335.stratego.model.PlayerColor.BLUE;
import static g43335.stratego.model.PlayerColor.RED;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

    private final Square[][] defaultBoard = {
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()}};

    @Before
    public void setUp() throws Exception {
        defaultBoard[0][1].put(new Piece(0, RED));
        defaultBoard[3][2].put(new Piece(9, RED));
        defaultBoard[4][2].put(new Piece(0, BLUE));
        defaultBoard[4][1].put(new Piece(9, BLUE));
    }

    @Test
    public void testInitialize() {
        System.out.println("initialize");
        Game instance = new Game();
        instance.initialize();
        Square[][] result = instance.getBoard();
        assertArrayEquals(defaultBoard, result);
    }

    @Test(expected = IllegalStateException.class)
    public void testStartWhenNoBoard() {
        System.out.println("testStartWhenNoBoard");
        Game instance = new Game();
        instance.start();
    }

    @Test
    public void testStartWhenInitializeDone() {
        System.out.println("testStartWhenInitializeDone");
        Game instance = new Game();
        instance.initialize();
        instance.start();
        assertFalse(instance.isOver());
    }

    @Test
    public void testIsOverWhenGameBegin() {
        System.out.println("testIsOverWhenGameBegin");
        Game instance = new Game();
        assertFalse(instance.isOver());
    }

    @Test
    public void testGetBoardWhenGameBegin() {
        System.out.println("testGetBoardWhenGameBegin");
        Game instance = new Game();
        instance.initialize();
        Square[][] expResult = defaultBoard;
        Square[][] result = instance.getBoard();
        assertArrayEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSelectWhenOutOfBoard() {
        System.out.println("testSelectWhenOutOfBoard");
        Game instance = new Game();
        Board board = new Board();
        instance.getBoard();
        instance.select(5, 8);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSelectWhenSquareEmpty() {
        System.out.println("testSelectWhenSquareEmpty");
        Game instance = new Game();
        Board board = new Board();
        instance.select(3, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSelectWhenThereIsOpponent() {
        System.out.println("testSelectWhenThereIsOpponent");
        Game instance = new Game();
        Board board = new Board();
        Player current = new Player(PlayerColor.RED);
        board.put(new Piece(4,PlayerColor.BLUE), new Position(3,2));
        instance.select(3, 2);
    }
}
