package model;

import java.awt.*;

/**
 * MazeComponent for the path of the maze.
 */
public class Path extends MazeComponent{

    /**
     * Initialise path object with position given, set colour to black and symbol to ' '.
     *
     * @param position Location of a path for given maze.
     *
     * @requires position != null.
     * @ensures  A path object is initialised at the given position with color black and symbol ' '.
     */
    public Path (Position position) {
        super(position, Color.black, ' ');
    }

}
