package model;

/**
 *
 * @author G43335
 */
public class Board {

    Square[][] squares;

    public Board() {
        this.squares = new Square[5][4];
    }

    public Square[][] getSquares() {
        return squares;
    }
    
    public static boolean isInside(Position position){
        
    }
    public static Square getSquare(Position position){
        
    }
    
   public static void put(Piece piece, Position position){
       
   }
}
