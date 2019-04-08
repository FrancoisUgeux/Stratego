package g43335.stratego.model;

import static g43335.stratego.model.PlayerColor.BLUE;
import static g43335.stratego.model.PlayerColor.RED;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
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
        instance.initialize();
        instance.select(5, 8);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSelectWhenSquareEmpty() {
        System.out.println("testSelectWhenSquareEmpty");
        Game instance = new Game();
        instance.initialize();
        instance.select(0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSelectWhenThereIsOpponent() {
        System.out.println("testSelectWhenThereIsOpponent");
        Game instance = new Game();
        instance.initialize();
        instance.select(4, 2);
    }

    @Test
    public void testSelectOnePiece() {
        System.out.println("testSelectOnePiece");
        Game instance = new Game();
        instance.initialize();
        Position expResult = new Position(3, 2);
    }

    @Test(expected = NullPointerException.class)
    public void testGetSelectedWhenSelectedNull() {
        System.out.println("testGetSelectedWhenSelectedNull");
        Game instance = new Game();
        instance.initialize();
        instance.getSelected();
    }

    @Test
    public void testGetSelected() {
        System.out.println("testGetSelected");
        Game instance = new Game();
        instance.initialize();
        Position position = new Position(0, 1);
        Position expResult = new Position(3, 2);
        instance.select(3, 2);
        Piece result = instance.getSelected();
        assertEquals(expResult, result);
    }

    @Test(expected = NullPointerException.class)
    public void testGetMovesWhenSelectedNull() {
        System.out.println("testGetMovesWhenSelectedNull");
        Game instance = new Game();
        instance.initialize();
        instance.getMoves();
    }

    @Test
    public void testGetMoves() {
        System.out.println("testGetMoves");
        Game instance = new Game();
        instance.initialize();
        instance.select(0, 1);
        List<Move> expResult = new ArrayList();
        Position start = new Position(0, 1);
        Piece piece = new Piece(0, RED);
        expResult.add(new Move(piece, start, new Position(1, 1)));
        expResult.add(new Move(piece, start, new Position(0, 0)));
        expResult.add(new Move(piece, start, new Position(0, 2)));
        List<Move> result = instance.getMoves();
        assertEquals(expResult, result);
    }

    @Test(expected = NullPointerException.class)
    public void testApplyWhenNoMove() {
        System.out.println("testApplyWhenNoMove");
        Game instance = new Game();
        instance.initialize();
        Move move = new Move(null, null, null);
        instance.apply(move);
    }

    @Test
    public void testApplyWhenFree() {
        System.out.println("testApplyWhenFree");
        Game instance = new Game();
        instance.initialize();
        List<Move> moves = new ArrayList();
        Piece piece = new Piece(0, RED);
        Position start = new Position(0, 1);
        Position target = new Position(1, 1);
        moves.add(new Move(piece, start, target));
        instance.apply(moves.get(0));
        instance.select(1, 1);
        Piece expResult = piece;
        Piece result = instance.getSelected();
        assertEquals(expResult, result);
    }

    @Test
    public void testApplyWhenIsStronger() {
        System.out.println("testApplyWhenIsStronger");
        Game instance = new Game();
        instance.initialize();
        List<Move> moves = new ArrayList();
        Piece piece = new Piece(9, RED);
        Position start = new Position(3, 2);
        Position target = new Position(4, 2);
        moves.add(new Move(piece, start, target));
        instance.apply(moves.get(0));
        instance.select(4, 2);
        Piece expResult = piece;
        Piece result = instance.getSelected();
        assertEquals(expResult, result);
    }

    @Test
    public void testApplyWhenHasSameRank() {
        System.out.println("testApplyWhenHasSameRank");
        Game instance = new Game();
        instance.initialize();
        List<Move> moves = new ArrayList();
        Piece piece = new Piece(9, RED);
        Position start = new Position(3, 2);
        Position start2 = new Position(4, 2);
        Position target = new Position(4, 2);
        Position target2 = new Position(4, 1);
        moves.add(new Move(piece, start, target));
        moves.add(new Move(piece, start2, target2));
        instance.apply(moves.get(0));
        instance.apply(moves.get(1));
        defaultBoard[3][2].remove();
        defaultBoard[4][2].remove();
        defaultBoard[4][1].remove();
        Square[][] expResult = defaultBoard;
        Square[][] result = instance.getBoard();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testApplyWhenWeaker() {
        System.out.println("testApplyWhenWeaker");
        Game instance = new Game();
        instance.initialize();
        List<Move> moves = new ArrayList();
        Piece piece = new Piece(0, RED);
        Position start = new Position(0, 1);
        Position start2 = new Position(1, 1);
        Position start3 = new Position(2, 1);
        Position start4 = new Position(3, 1);
        Position target = new Position(1, 1);
        Position target2 = new Position(2, 1);
        Position target3 = new Position(3, 1);
        Position target4 = new Position(4, 1);
        moves.add(new Move(piece, start, target));
        moves.add(new Move(piece, start2, target2));
        moves.add(new Move(piece, start3, target3));
        moves.add(new Move(piece, start4, target4));
        instance.apply(moves.get(0));
        instance.apply(moves.get(1));
        instance.apply(moves.get(2));
        instance.apply(moves.get(3));
        defaultBoard[0][1].remove();
        Square[][] expResult = defaultBoard;
        Square[][] result = instance.getBoard();
        assertArrayEquals(expResult, result);
    }
}
