package model;


import java.awt.*;

/**
 * MazeComponent for the finish point of the maze.
 */
public class End extends MazeComponent {

    /**
     * Initialise End object with position given, set colour to red and symbol to 'E'.
     *
     * @param position Location of End for given maze.
     *
     * @requires position != null.
     * @ensures  An end object is initialised at the given position with color red and symbol 'E'.
     */
    public End (Position position) {
        super(position, Color.red, 'E');
    }


}
