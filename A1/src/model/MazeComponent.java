package model;

import java.awt.*;

/**
 * Abstract class with getter and setter methods for each MazeComponent to inherit and use.
 */
public abstract class MazeComponent {
    public Position position;
    public Color color;
    public char symbol;

    /**
     * Default constructor to set position, color and symbol.
     *
     * @param position Row and column of the object.
     * @param color    Designated colour of the object.
     * @param symbol   Designated symbol of the object.
     *
     * @requires position != null && color != null && symbol != null.
     * @ensures  MazeComponent object is created at the specified position with given color and
     *           symbol.
     */
    public MazeComponent(Position position, Color color, char symbol) {
        this.position = position;
        this.color = color;
        this.symbol = symbol;
    }

    /**
     * Set the symbol of the MazeComponent object to the given character.
     *
     * @param symbol The new symbol character.
     *
     * @requires symbol != null.
     * @ensures  Character representation of the MazeComponent is changed to new symbol.
     */
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Get the symbol representation for a MazeComponent class.
     *
     * @return A single character to represent the MazeComponent class.
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Get the color of a MazeComponent class.
     *
     * @return The designated color of the MazeComponent class.
     */
    public Color getColor() {
        return color;
    }

}
