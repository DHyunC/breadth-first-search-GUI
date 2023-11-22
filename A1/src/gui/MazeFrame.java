package gui;

import controller.BFS;
import model.MazeComponent;

import javax.swing.*;
import java.awt.*;

/**
 * Frame for holding GUI elements of the maze.
 */
public class MazeFrame extends JFrame {

    /**
     * Constructor which takes 2d MazeComponent array and displays it using JFrame rectangles.
     *
     * @param grid 2d array representation of the maze grid.
     */
    public MazeFrame(MazeComponent[][] grid) {
        setTitle("Maze");
        setSize(450, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        MazePanel mazeGrid = new MazePanel(grid);
        add(mazeGrid);

        BFS bfs = new BFS();
        bfs.initialise(grid);
        bfs.step();

        StepButton stepButton = new StepButton(bfs, mazeGrid);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(stepButton);
        add(buttonPanel, BorderLayout.SOUTH);

        MenuBar menuBar = new MenuBar(mazeGrid, bfs, stepButton);
        setJMenuBar(menuBar);

        setVisible(true);
    }
}
