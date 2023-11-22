package model;

import java.awt.*;

/**
 * MazeComponent for the start point of the maze.
 */
public class Start extends MazeComponent{

    /**
     * Initialise Start object with position given, set colour to green and symbol to 'S'.
     *
     * @param position Location of End for given maze.
     *
     * @requires position != null.
     * @ensures  A start object is initialised at the given position with color green and symbol
     *           'S'.
     */
    public Start(Position position) {
        super(position, Color.green, 'S');
    }

}
