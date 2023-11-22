package textinterface;

import model.MazeComponent;

/**
 * Class to create text output in terminal.
 */
public class textInterface {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GRAY = "\u001B[90m";
    public static final String BLOCK = "█";

    /**
     * Generate a StringBuilder to output to terminal.
     *
     * @param grid 2d MazeComponent array representation of maze grid.
     * @param path 2d boolean array of whether a position has been visited or not.
     * @return StringBuilder which shows all relevant icons for each tile.
     *
     * @requires grid != null.
     * @ensures StringBuilder with appropriate grid && visited path.
     */
    public static StringBuilder generateGrid(MazeComponent[][] grid, boolean[][] path) {
        StringBuilder stringGrid = new StringBuilder();

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                char componentSymbol = grid[row][col].getSymbol();

                if (path[row][col] && (componentSymbol == ' ' || componentSymbol == '.')) {
                    stringGrid.append(ANSI_BLUE + BLOCK + ANSI_RESET);
                } else {
                    switch (componentSymbol) {
                        case '#' -> stringGrid.append(ANSI_GRAY + BLOCK + ANSI_RESET);
                        case 'S' -> stringGrid.append(ANSI_GREEN + BLOCK + ANSI_RESET);
                        case 'E' -> stringGrid.append(ANSI_RED + BLOCK + ANSI_RESET);
                        case ' ', '.' -> stringGrid.append(ANSI_BLACK + BLOCK + ANSI_RESET);
                    }
                }
            }
            stringGrid.append("\n");
        }
        return stringGrid;
    }
}
