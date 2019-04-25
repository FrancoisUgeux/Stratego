package g43335.stratego.model;

/**
 * This enum contains the possible directions.
 *
 * @author G43335
 */
public enum Direction {

    /**
     * Top direction.
     */
    UP(-1, 0),
    /**
     * Low Direction.
     */
    DOWN(1, 0),
    /**
     * Left direction.
     */
    LEFT(0, -1),
    /**
     * Right direction.
     */
    RIGHT(0, 1);

    private final int row;
    private final int column;

    Direction(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Get the row.
     *
     * @return the row.
     */
    public int getRow() {
        return row;
    }

    /**
     * Get the column.
     *
     * @return the column.
     */
    public int getColumn() {
        return column;
    }
}
