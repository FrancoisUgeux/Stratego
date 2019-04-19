package g43335.stratego.model;

import static g43335.stratego.model.PlayerColor.BLUE;
import static g43335.stratego.model.PlayerColor.RED;
import g43335.stratego.model.pieces.Flag;
import g43335.stratego.model.pieces.General;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
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
        defaultBoard[0][1].put(new Flag(0, RED));
        defaultBoard[3][2].put(new General(9, RED));
        defaultBoard[4][2].put(new Flag(0, BLUE));
        defaultBoard[4][1].put(new General(9, BLUE));
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
        Piece expResult = new Piece(0, RED);
        Game instance = new Game();
        instance.initialize();
        instance.select(0, 1);
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
        instance.select(3, 2);
        List<Move> expResult = new ArrayList();
        Position start = new Position(3, 2);
        Piece piece = new General(9, RED);
        expResult.add(new Move(piece, start, new Position(2, 2)));
        expResult.add(new Move(piece, start, new Position(4, 2)));
        expResult.add(new Move(piece, start, new Position(3, 1)));
        expResult.add(new Move(piece, start, new Position(3, 3)));
        List<Move> result = instance.getMoves();
        /*assertThat(result, hasItems(
                    new Move(piece, start, new Position(2,2)),
                    new Move(piece, start, new Position(4,2)),
                    new Move(piece, start, new Position(3,1)),
                    new Move(piece, start, new Position(3,3))));*/
        //assertTrue(result.containsAll(expResult));
        //assertTrue(expResult.equals(result));
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
        defaultBoard[0][1].remove();
        defaultBoard[1][1].put(piece);
        Square[][] expResult = defaultBoard;
        Square[][] result = instance.getBoard();
        assertArrayEquals(expResult, result);
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
        defaultBoard[3][2].remove();
        defaultBoard[4][2].remove();
        defaultBoard[4][2].put(piece);
        Square[][] expResult = defaultBoard;
        Square[][] result = instance.getBoard();
        assertArrayEquals(expResult, result);
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

    @Test
    public void testSwapPlayers() {
        System.out.println("testSwapPlayers");
        Game instance = new Game();
        instance.initialize();
        PlayerColor expResult = new Player(PlayerColor.BLUE).getColor();
        instance.swapPlayers();
        PlayerColor result = instance.getCurrent().getColor();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetCurrent() {
        Game instance = new Game();
        instance.initialize();
        Player expResult = new Player(PlayerColor.RED);
        Player result = instance.getCurrent();
    }

    @Test
    public void testHasMovesWhenOk() {
        Game instance = new Game();
        instance.initialize();

    }
}
