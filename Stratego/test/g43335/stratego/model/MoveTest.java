package g43335.stratego.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class MoveTest {

    @Test
    public void testGetPiece() {
        System.out.println("getPiece");
        Move instance = new Move(new Piece(5, PlayerColor.BLUE),
                new Position(3, 4), new Position(4, 5));
        Piece expResult = new Piece(5, PlayerColor.BLUE);
        Piece result = instance.getPiece();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetStart() {
        System.out.println("getStart");
        Move instance = new Move(new Piece(5, PlayerColor.BLUE),
                new Position(3, 4), new Position(4, 5));
        Position expResult = new Position(3, 4);
        Position result = instance.getStart();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetEnd() {
        System.out.println("getEnd");
        Move instance = new Move(new Piece(5, PlayerColor.BLUE),
                new Position(3, 4), new Position(4, 5));
        Position expResult = new Position(4, 5);
        Position result = instance.getEnd();
        assertEquals(expResult, result);
    }

    @Test
    public void testEqualsTrueMyself() {
        System.out.println("equalsTrueMyself");
        Piece piece = new Piece(0, PlayerColor.BLUE);
        Position start = new Position(3, 2);
        Position end = new Position(4, 2);
        Move move = new Move(piece, start, end);
        assertTrue(move.equals(move));
        assertTrue(move.hashCode() == move.hashCode());
    }

    @Test
    public void testEqualsTrue() {
        System.out.println("equalsTrue");
        Piece piece = new Piece(0, PlayerColor.BLUE);
        Position start = new Position(3, 2);
        Position end = new Position(4, 2);
        Move move1 = new Move(piece, start, end);
        Move move2 = new Move(piece, start, end);
        assertTrue(move1.equals(move2));
        assertTrue(move1.hashCode() == move2.hashCode());
    }

    @Test
    public void testEqualsFalseDifferentPiece() {
        System.out.println("equalsFalseDifferentPiece");
        Piece piece1 = new Piece(0, PlayerColor.BLUE);
        Piece piece2 = new Piece(9, PlayerColor.RED);
        Position start = new Position(3, 2);
        Position end = new Position(4, 2);
        Move move1 = new Move(piece1, start, end);
        Move move2 = new Move(piece2, start, end);
        assertFalse(move1.equals(move2));
    }

    @Test
    public void testEqualsFalseDifferentStart() {
        System.out.println("equalsFalseDifferentStart");
        Piece piece = new Piece(0, PlayerColor.BLUE);
        Position start1 = new Position(3, 2);
        Position start2 = new Position(4, 1);
        Position end = new Position(4, 2);
        Move move1 = new Move(piece, start1, end);
        Move move2 = new Move(piece, start2, end);
        assertFalse(move1.equals(move2));
    }

    @Test
    public void testEqualsFalseDifferentEnd() {
        System.out.println("equalsFalseDifferentEnd");
        Piece piece = new Piece(0, PlayerColor.BLUE);
        Position start = new Position(3, 2);
        Position end1 = new Position(4, 2);
        Position end2 = new Position(3, 3);
        Move move1 = new Move(piece, start, end1);
        Move move2 = new Move(piece, start, end2);
        assertFalse(move1.equals(move2));
    }

    @Test
    public void testEqualsFalseNull() {
        System.out.println("equalsFalseNull");
        Piece piece = new Piece(0, PlayerColor.BLUE);
        Position start = new Position(3, 2);
        Position end = new Position(4, 2);
        Move move1 = new Move(piece, start, end);
        assertFalse(move1.equals(null));
    }
}
