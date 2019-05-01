package g43335.stratego.model;

import static g43335.stratego.model.PlayerColor.BLUE;
import static g43335.stratego.model.PlayerColor.RED;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BoardTest {

    private final Square[][] defaultBoard = {
        {new Square(SquareType.LAND), new Square(SquareType.LAND), new Square(SquareType.LAND), new Square(SquareType.LAND)},
        {new Square(SquareType.LAND), new Square(SquareType.LAND), new Square(SquareType.LAND), new Square(SquareType.LAND)},
        {new Square(SquareType.LAND), new Square(SquareType.LAND), new Square(SquareType.LAND), new Square(SquareType.LAND)},
        {new Square(SquareType.LAND), new Square(SquareType.LAND), new Square(SquareType.LAND), new Square(SquareType.LAND)},
        {new Square(SquareType.LAND), new Square(SquareType.LAND), new Square(SquareType.LAND), new Square(SquareType.LAND)}};

    @Test
    public void testGetSquareWhenSquareIsFill() {
        System.out.println("testGetSquareWhenSquareIsFill");
        Position position = new Position(3, 2);
        Board instance = new Board();
        instance.put(new Piece(4, PlayerColor.BLUE), position);
        Square expResult = new Square(SquareType.LAND);
        expResult.put(new Piece(4, PlayerColor.BLUE));
        Square result = instance.getSquare(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetSquareWhenSquareIsEmpty() {
        System.out.println("testGetSquareWhenSquareIsEmpty");
        Position position = new Position(0, 1);
        Board instance = new Board();
        Square expResult = new Square(SquareType.LAND);
        Square result = instance.getSquare(position);
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetSquareWhenPositionOutside() {
        System.out.println("testGetSquareWhenPositionOutside");
        Position position = new Position(-1, 2);
        Board instance = new Board();
        instance.getSquare(position);
    }

    @Test
    public void testGetSquaresWhenDefaultBoard() {
        System.out.println("testGetSquaresWhenDefaultBoard");
        Board instance = new Board();
        Square[][] expResult = defaultBoard;
        Square[][] result = instance.getSquares();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testGetSquaresWhen2PiecesAdded() {
        System.out.println("testGetSquaresWhen2PiecesAdded");
        Board instance = new Board();
        instance.put(new Piece(4, PlayerColor.RED), new Position(1, 2));
        instance.put(new Piece(1, PlayerColor.BLUE), new Position(4, 3));
        Square[][] expResult = defaultBoard;
        defaultBoard[1][2].put(new Piece(4, PlayerColor.RED));
        defaultBoard[4][3].put(new Piece(1, PlayerColor.BLUE));
        Square[][] result = instance.getSquares();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testPutOnePiece() {
        System.out.println("testPutOnePiece");
        Piece piece = new Piece(2, PlayerColor.BLUE);
        Position position = new Position(0, 0);
        Board instance = new Board();
        instance.put(piece, position);
        Square expResult = new Square(SquareType.LAND);
        expResult.put(piece);
        Square result = instance.getSquare(position);
        assertEquals(expResult, result);
    }

    @Test(expected = NullPointerException.class)
    public void testPutWhenPieceIsNull() {
        System.out.println("testPutWhenPieceIsNull");
        Piece piece = null;
        Position position = new Position(2, 2);
        Board instance = new Board();
        instance.put(piece, position);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPuWhenPositionIsOutside() {
        System.out.println("testPuWhenPositionIsOutside");
        Piece piece = new Piece(1, PlayerColor.BLUE);
        Position position = new Position(6, 2);
        Board instance = new Board();
        instance.put(piece, position);
    }

    @Test
    public void testIsInsideWhenCornerUpLeft() {
        System.out.println("testIsInsideWhenCornerUpLeft");
        Position position = new Position(0, 0);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenCornerUpRight() {
        System.out.println("testIsInsideWhenCornerUpRight");
        Position position = new Position(0, 3);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenCornerDownleft() {
        System.out.println("testIsInsideWhenCornerDownleft");
        Position position = new Position(4, 0);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenCornerDownRight() {
        System.out.println("testIsInsideWhenCornerDownRight");
        Position position = new Position(4, 3);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenBoundaryUp() {
        System.out.println("testIsInsideWhenBoundaryUp");
        Position position = new Position(0, 1);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenBoundaryDown() {
        System.out.println("testIsInsideWhenBoundaryDown");
        Position position = new Position(4, 2);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenBoundaryLeft() {
        System.out.println("testIsInsideWhenBoundaryLeft");
        Position position = new Position(1, 0);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenBoundaryRight() {
        System.out.println("testIsInsideWhenBoundaryRight");
        Position position = new Position(3, 3);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenOutsideBoundaryUp() {
        System.out.println("testIsInsideWhenOutsideBoundaryUp");
        Position position = new Position(-1, 1);
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenOutsideBoundaryDown() {
        System.out.println("testIsInsideWhenOutsideBoundaryDown");
        Position position = new Position(5, 2);
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenOutsideBoundaryLeft() {
        System.out.println("testIsInsideWhenOutsideBoundaryLeft");
        Position position = new Position(1, -1);
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenOutsideBoundaryRight() {
        System.out.println("testIsInsideWhenOutsideBoundaryRight");
        Position position = new Position(3, 4);
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenInside() {
        System.out.println("testIsInsideWhenInside");
        Position position = new Position(2, 1);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test(expected = NullPointerException.class)
    public void testIsInsideWhenPositionIsNull() {
        System.out.println("testIsInsideWhenPositionIsNull");
        Board instance = new Board();
        instance.isInside(null);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsFreeWhenPositionIsOutside() {
        System.out.println("testIsFreeWhenPositionIsOutside");
        Position position = new Position(6, 2);
        Board instance = new Board();
        instance.isFree(position);
    }

    @Test
    public void testIsFreeTrue() {
        System.out.println("testIsFreeTrue");
        Board instance = new Board();
        Position position = new Position(4, 3);
        boolean expResult = true;
        boolean result = instance.isFree(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsFreeFalse() {
        System.out.println("testIsFreeFalse");
        Board instance = new Board();
        Position position = new Position(1, 3);
        instance.put(new Piece(4, PlayerColor.BLUE), new Position(1, 3));
        boolean expResult = false;
        boolean result = instance.isFree(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsMyOwnWhenMyOwn() {
        System.out.println("testIsMyOwnWhenMyOwn");
        Board instance = new Board();
        instance.put(new Piece(4, PlayerColor.BLUE), new Position(2, 3));
        Position position = new Position(2, 3);
        boolean expResult = true;
        boolean result = instance.isMyOwn(position, BLUE);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsMyOwnWhenNotMyOwn() {
        System.out.println("testIsMyOwnWhenNotMyOwn");
        Board instance = new Board();
        instance.put(new Piece(4, PlayerColor.RED), new Position(2, 3));
        Position position = new Position(2, 3);
        boolean expResult = false;
        boolean result = instance.isMyOwn(position, BLUE);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsMyOwnWhenNull() {
        System.out.println("testIsMyOwnWhenNull");
        Board instance = new Board();
        Position position = new Position(2, 3);
        boolean expResult = false;
        boolean result = instance.isMyOwn(position, BLUE);
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsMyOwnWhenPositionIsOutside() {
        System.out.println("testIsMyOwnWhenPositionIsOutside");
        Piece piece = new Piece(1, PlayerColor.BLUE);
        Position position = new Position(6, 2);
        Board instance = new Board();
        instance.isMyOwn(position, BLUE);
    }

    @Test
    public void testGetPiece() {
        System.out.println("testGetPiece");
        Board instance = new Board();
        Position position = new Position(1, 2);
        instance.put(new Piece(4, PlayerColor.BLUE), position);
        Square expResult = new Square(SquareType.LAND);
        expResult.put(new Piece(4, PlayerColor.BLUE));
        Square result = instance.getSquare(position);
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetPieceWhenPositionIsOutside() {
        System.out.println("testGetPieceWhenPositionIsOutside");
        Position position = new Position(6, 2);
        Board instance = new Board();
        instance.getPiece(position);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveWhenPositionIsOutside() {
        System.out.println("testRemoveWhenPositionIsOutside");
        Position position = new Position(6, 7);
        Board instance = new Board();
        instance.remove(position);
    }

    @Test
    public void testRemove() {
        System.out.println("testRemove");
        Position position = new Position(3, 2);
        Board instance = new Board();
        Square expResult = instance.getSquare(position);
        instance.put(new Piece(4, PlayerColor.BLUE), position);
        instance.remove(position);
        Square result = instance.getSquare(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTakenSquare() {
        System.out.println("testGetTakenSquare");
        Board instance = new Board();
        Player player = new Player(BLUE);
        Piece piece = new Piece(0, BLUE);
        Piece piece2 = new Piece(5, RED);
        Piece piece3 = new Piece(6, BLUE);
        Position position = new Position(0, 3);
        Position position2 = new Position(2, 3);
        Position position3 = new Position(1, 2);
        instance.put(piece, position);
        instance.put(piece2, position2);
        instance.put(piece3, position3);
        List<Position> expResult = new ArrayList();
        expResult.add(position);
        expResult.add(position3);
        List<Position> result = instance.getTakenSquare(player);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetTakenSquareWhenNoSquareTaken(){
        System.out.println("testGetTakenSquareWhenNoSquareTaken");
        Board instance = new Board();
        Player player = new Player(BLUE);
        List<Position> expResult = new ArrayList();
        List<Position> result = instance.getTakenSquare(player);
        assertEquals(expResult, result);
    }
}
