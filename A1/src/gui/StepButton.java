package gui;

import controller.BFS;
import javax.swing.*;

/**
 * Button to take one step of Breadth First Search and to change the panel to represent path taken.
 */
public class StepButton extends JButton{
    private boolean mazeSolved;

    /**
     * Default constructor for button to take a single iteration of Breadth First Search.
     *
     * @param bfs       The BFS object being used in the maze.
     * @param mazePanel The panel being used to display the maze.
     */
    public StepButton(BFS bfs, MazePanel mazePanel) {
        super("BFS Next Step");
        this.mazeSolved = false;


        addActionListener(e -> {
            if (!mazeSolved) {
                bfs.step();
                mazePanel.highlightPath(bfs.getVisited());

                mazeSolved = bfs.isSolved();
            }
            else {
                System.out.println("Maze Solved terminating BFS");
            }
        });
    }

    /**
     * Reset the button by setting mazeSolved to false.
     */
    public void reset() {
        this.mazeSolved = false;
    }
}
