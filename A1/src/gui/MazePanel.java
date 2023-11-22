package gui;

import model.MazeComponent;

import java.awt.*;
import java.awt.Graphics;
import javax.swing.*;

/**
 * Panel to display the maze in either text or GUI format.
 *
 * @requires grid != null.
 */
public class MazePanel extends JPanel{
    private MazeComponent[][] grid;

    /**
     * Constructs a panel with specified maze and boolean flag for whether to use text or GUI.
     *
     * @param grid   2d MazeComponent array representation of the maze.
     *
     * @requires grid != null && useGUI = true || false.
     */
    public MazePanel(MazeComponent[][] grid) {
        this.grid = grid;
    }

    /**
     * Setter method for variable grid.
     *
     * @param grid The new 2d MazeComponent array for grid variable.
     */
    public void setGrid(MazeComponent[][] grid) {
        this.grid = grid;
        repaint();
    }


    /**
     * Paints maze panel with colours or symbols specific to each maze component.
     *
     * @param g The Graphics object.
     *
     * @ensures All maze components are painted according to their colour or symbol.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int componentWidth = getWidth() / this.grid[0].length;
        int componentHeight = getHeight() / this.grid.length;


        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                MazeComponent component = grid[row][col];
                Color componentColor = component.getColor();

                g.setColor(componentColor);
                g.fillRect(col * componentWidth, row * componentHeight, componentWidth, componentHeight);
            }
        }
    }

    /**
     * Returns the symbol at the given row and column.
     *
     * @param row Row value to be checked.
     * @param col Column value to be checked.
     * @return Symbol at the row and column position.
     *
     * @ensures Symbol returned is the symbolic representation of the MazeComponent.
     */
    public char getGridData(int row, int col) {
        return grid[row][col].getSymbol();
    }

    /**
     * Highlights the traversed path by an algorithm.
     *
     * @param path 2d boolean array where if a position has been traversed upon, it will be true.
     *
     * @requires Path to be the same size as grid.
     */
    public void highlightPath(boolean[][] path){
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {

                if (path[row][col] && getGridData(row, col) == ' ') {
                    grid[row][col].color = Color.blue;
                    repaint();
                }
            }
        }
        repaint();
    }
}
