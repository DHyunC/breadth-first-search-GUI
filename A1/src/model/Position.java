package model;

/**
 * Class for defining a position of a MazeComponent, where the first value is the row number and the
 * second value is the column number.
 */
public class Position {
    private final int row;
    private final int col;

    /**
     * Default constructor to set position to given row and column values.
     *
     * @param row Number of the row.
     * @param col Number of the column.
     */
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Getter method for row.
     *
     * @return Integer number for row.
     */
    public int getRow() {
        return row;
    }

    /**
     * Getter method for row.
     *
     * @return Integer number for col.
     */
    public int getCol() {
        return col;
    }

    /**
     * Check if two positions are equal by checking their row number and column number or if they
     * are being compared to themselves.
     *
     * @param obj Object to be compared.
     * @return True if row and column is the same or if they are being compared to themselves.
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Position other = (Position) obj;
        return row == other.row && col == other.col;
    }
}
