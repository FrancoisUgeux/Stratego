package g43335.stratego.model;

import static g43335.stratego.model.PlayerColor.BLUE;
import static g43335.stratego.model.PlayerColor.RED;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PieceTest {

    @Test
    public void testConstructPieceWhenRankIsZero() {
        System.out.println("testConstructPieceWhenRankIsZero");
        Piece instance = new Piece(0, BLUE);
        assertEquals(BLUE, instance.getColor());
        assertEquals(0, instance.getRank());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructPieceWhenRankIsNegative() {
        System.out.println("testConstructPieceWhenRankIsNegative");
        Piece instance = new Piece(-1, BLUE);
    }

    @Test
    public void testConstructPieceWhenRankIsOne() {
        System.out.println("testConstructPieceWhenRankIsOne");
        Piece instance = new Piece(1, BLUE);
        assertEquals(BLUE, instance.getColor());
        assertEquals(1, instance.getRank());
    }

    @Test
    public void testGetColorBlue() {
        System.out.println("testGetColorBlue");
        Piece instance = new Piece(0, BLUE);
        PlayerColor expResult = BLUE;
        PlayerColor result = instance.getColor();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetColorRed() {
        System.out.println("testGetColorRed");
        Piece instance = new Piece(12, RED);
        PlayerColor expResult = RED;
        PlayerColor result = instance.getColor();
        assertEquals(expResult, result);
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Piece instance = new Piece(0, PlayerColor.BLUE);
        String result = instance.toString();
        assertFalse(result.isEmpty());

    }

    @Test
    public void equalsTrueMySelf() {
        Piece piece1 = new Piece(10, BLUE);
        assertTrue(piece1.equals(piece1));
        assertTrue(piece1.hashCode() == piece1.hashCode());
    }

    @Test
    public void equalsTrue() {
        Piece piece1 = new Piece(10, BLUE);
        Piece piece2 = new Piece(10, BLUE);
        assertTrue(piece1.equals(piece2));
        assertTrue(piece1.hashCode() == piece2.hashCode());
    }

    @Test
    public void equalsFalseDifferentColor() {
        Piece piece1 = new Piece(10, BLUE);
        Piece piece2 = new Piece(10, RED);
        assertFalse(piece1.equals(piece2));
    }

    @Test
    public void equalsFalseDifferentRank() {
        Piece piece1 = new Piece(10, BLUE);
        Piece piece2 = new Piece(9, BLUE);
        assertFalse(piece1.equals(piece2));
    }

    @Test
    public void equalsFalseOtherObject() {
        Piece piece1 = new Piece(10, BLUE);
        String piece2 = "abcd";
        assertFalse(piece1.equals(piece2));
    }

    @Test
    public void equalsFalseNull() {
        Piece piece1 = new Piece(10, BLUE);
        assertFalse(piece1.equals(null));
    }
    
    @Test
    public void testIsStronger(){
        System.out.println("isStronger");
        Piece instance = new Piece(5, RED);
        Piece other = new Piece(4, BLUE);
        assertTrue(instance.isStronger(other));
    }
    
    @Test
    public void testIsStrongerWhenSameRank(){
        System.out.println("isStrongerWhenSameRank");
        Piece instance = new Piece(5, RED);
        Piece other = new Piece (5, BLUE);
        assertFalse(instance.isStronger(other));
    }
    
    @Test
    public void testHasSameRank(){
        System.out.println("hasSameRank");
        Piece instance = new Piece(10,RED);
        Piece other = new Piece(10, BLUE);
        assertTrue(instance.hasSameRank(other));
    }
    
        @Test
    public void testHasSameRankWhenDifferent(){
            System.out.println("hasSameRankWhenDifferent");
        Piece instance = new Piece(3,RED);
        Piece other = new Piece(5, BLUE);
        assertFalse(instance.hasSameRank(other));
    }
}
