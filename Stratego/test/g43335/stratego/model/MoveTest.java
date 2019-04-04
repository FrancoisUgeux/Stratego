/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

}
