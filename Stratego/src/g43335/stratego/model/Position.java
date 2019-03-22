package g43335.stratego.model;

/**
 * This class manage the position on the game board
 *
 * @author G43335
 */
public class Position {

    private int row;
    private int column;

    /**
     *
     * @param row is the row used on the board
     * @param column is the column used on the board
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     *
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     *
     * @return the column
     */
    public int getColumn() {
        return column;
    }

}
