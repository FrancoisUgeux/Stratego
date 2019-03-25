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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.row;
        hash = 53 * hash + this.column;
        return hash;
    }

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
        if (this.column != other.column) {
            return false;
        }
        return true;
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
