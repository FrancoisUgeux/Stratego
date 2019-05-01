package g43335.stratego.model;

import static g43335.stratego.model.PlayerColor.BLUE;
import static g43335.stratego.model.PlayerColor.RED;
import g43335.stratego.model.pieces.Bomb;
import g43335.stratego.model.pieces.Flag;
import g43335.stratego.model.pieces.General;
import g43335.stratego.model.pieces.Marshal;
import g43335.stratego.model.pieces.Miner;
import g43335.stratego.model.pieces.Scout;
import g43335.stratego.model.pieces.Spy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

    private final Square[][] defaultBoard = {
        {new Square(SquareType.LAND), new Square(SquareType.LAND), new Square(SquareType.LAND), new Square(SquareType.LAND), new Square(SquareType.LAND)},
        {new Square(SquareType.LAND), new Square(SquareType.LAND), new Square(SquareType.LAND), new Square(SquareType.LAND), new Square(SquareType.LAND)},
        {new Square(SquareType.LAND), new Square(SquareType.LAND), new Square(SquareType.LAND), new Square(SquareType.LAND), new Square(SquareType.LAND)},
        {new Square(SquareType.LAND), new Square(SquareType.LAND), new Square(SquareType.LAND), new Square(SquareType.LAND), new Square(SquareType.LAND)},
        {new Square(SquareType.LAND), new Square(SquareType.LAND), new Square(SquareType.LAND), new Square(SquareType.LAND), new Square(SquareType.LAND)},
        {new Square(SquareType.LAND), new Square(SquareType.LAND), new Square(SquareType.LAND), new Square(SquareType.LAND), new Square(SquareType.LAND)}};

    @Before
    public void setUp() throws Exception {
        defaultBoard[0][1].put(new Flag(RED));
        defaultBoard[3][2].put(new General(RED));
        defaultBoard[1][0].put(new Bomb(RED));
        defaultBoard[5][0].put(new Miner(RED));
        defaultBoard[0][3].put(new Marshal(RED));
        defaultBoard[5][4].put(new Spy(RED));
        defaultBoard[1][4].put(new Scout(RED));
        defaultBoard[4][2].put(new Flag(BLUE));
        defaultBoard[4][1].put(new General(BLUE));
        defaultBoard[5][1].put(new Bomb(BLUE));
        defaultBoard[2][0].put(new Miner(BLUE));
        defaultBoard[5][3].put(new Marshal(BLUE));
        defaultBoard[0][4].put(new Spy(BLUE));
        defaultBoard[4][4].put(new Scout(BLUE));
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
    public void testIsOverWhenGameEnd() {
        System.out.println("testIsOverWhenGameEnd");
        Game instance = new Game();
        instance.initialize();
        instance.getCurrent().remove(new Piece(0, RED));
        assertTrue(instance.isOver());
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
    public void testSelect() {
        System.out.println("testSelect");
        Game instance = new Game();
        instance.initialize();
        Piece expResult = new General(RED);
        instance.select(3, 2);
        Piece result = instance.getSelected();
        assertEquals(expResult, result);
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
        Position start = new Position(3, 2);
        Piece piece = new General(RED);
        List<Move> result = instance.getMoves();
        List<Move> expResult = Arrays.asList(new Move(piece, start, new Position(4, 2)),
                new Move(piece, start, new Position(3, 1)),
                new Move(piece, start, new Position(3, 3)));
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
    public void testSwapPlayersRedToBlue() {
        System.out.println("testSwapPlayersRedToBlue");
        Game instance = new Game();
        instance.initialize();
        PlayerColor expResult = new Player(PlayerColor.BLUE).getColor();
        instance.swapPlayers();
        PlayerColor result = instance.getCurrent().getColor();
        assertEquals(expResult, result);
    }

    @Test
    public void testSwapPlayersBlueToRed() {
        System.out.println("testSwapPlayersRedToBlue");
        Game instance = new Game();
        instance.initialize();
        PlayerColor expResult = new Player(PlayerColor.RED).getColor();
        instance.swapPlayers();
        instance.swapPlayers();
        PlayerColor result = instance.getCurrent().getColor();
        assertEquals(expResult, result);
    }

    @Test
    public void testHasMoves() {
        System.out.println("testHasMoves");
        Game instance = new Game();
        instance.initialize();
        Player player = new Player(BLUE);
        boolean expResult = true;
        boolean result = instance.hasMoves(player);
        assertEquals(expResult, result);
    }

    @Test
    public void testHasMovesWhenNoMoves() {
        System.out.println("testHasMovesWhenNoMoves");
        Game instance = new Game();
        instance.initialize();
        Player player = instance.getCurrent();
        boolean expResult = false;
        Square[][] square = instance.getBoard();
        square[3][2].remove();
        square[0][3].remove();
        square[1][4].remove();
        square[5][4].remove();
        square[5][0].remove();
        boolean result = instance.hasMoves(player);
        assertEquals(expResult, result);

    }
}
