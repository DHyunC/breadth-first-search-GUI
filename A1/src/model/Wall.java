package model;

import java.awt.*;

/**
 * MazeComponent for a wall of the maze.
 */
public class Wall extends MazeComponent{

    /**
     * Initialise wall object with position given, set colour to gray and symbol to '#'.
     *
     * @param position Location of End for given maze.
     *
     * @requires position != null.
     * @ensures  A wall object is initialised at the given position with color gray and symbol '#'.
     */
    public Wall(Position position) {
        super(position, Color.gray, '#');
    }

}
