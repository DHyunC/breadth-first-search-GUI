package io;

import controller.BFS;
import gui.MazePanel;
import gui.StepButton;
import model.*;

/**
 * Modifies the maze grid.
 */
public class GridChanger {

    /**
     * Converts the grid from a 2d character array to a 2d mazeComponent array to use in other
     * classes.
     *
     * @param grid The 2d character array to be converted.
     * @return     The grid represented as a 2d MazeComponent array instead.
     */
    public static MazeComponent[][] convertGrid(char[][] grid) {
        MazeComponent[][] componentGrid = new MazeComponent[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                Position currentPos = new Position(row, col);
                char component = grid[row][col];
                switch (component) {
                    case '#' -> componentGrid[row][col] = new Wall(currentPos);
                    case 'S' -> componentGrid[row][col] = new Start(currentPos);
                    case 'E' -> componentGrid[row][col] = new End(currentPos);
                    case ' ', '.' -> componentGrid[row][col] = new Path(currentPos);
                }
            }
        }
        return componentGrid;
    }


    /**
     * Change the grid to the given grid in the specified file and reset all related classes and
     * functions.
     *
     * @param fileName The file to change the grid to.
     */
    public static void changeGrid(String fileName, MazePanel mazePanel, BFS bfs,
                                  StepButton stepButton) {

        try {
            FileLoader loader = new FileLoader();
            String fullFile = "grid/" + fileName + ".txt";
            char[][] newGrid = loader.load(fullFile);

            MazeComponent[][] newComponentGrid = convertGrid(newGrid);

            mazePanel.setGrid(newComponentGrid);

            bfs.reset();
            bfs.initialise(newComponentGrid);

            stepButton.reset();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
