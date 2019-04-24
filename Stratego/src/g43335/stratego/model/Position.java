package g43335.stratego.model;

/**
 * This class manage the position on the game board.
 *
 * @author G43335
 */
public class Position {

    private final int row;
    private final int column;

    /**
     * Initialize a row and a column.
     *
     * @param row is the row used on the board.
     * @param column is the column used on the board.
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Create a hash code value for the object.
     *
     * @return a hash code value for the object.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.row;
        hash = 53 * hash + this.column;
        return hash;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param obj an object to compare.
     * @return true if the objects are equals.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this.row != other.row) {
            return false;
        }
        return this.column == other.column;
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

    /**
     * Give the next position in a direction
     *
     * @param direction is the direction to check.
     * @return the position in this direction.
     */
    public Position next(Direction direction) {
        Position position = new Position(row + direction.getRow(),
                column + direction.getColumn());
        return position;
    }

}
