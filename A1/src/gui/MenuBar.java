package gui;

import controller.BFS;
import io.GridChanger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Menubar to change the map of the panel
 */
public class MenuBar extends JMenuBar implements ActionListener {
    private final MazePanel mazePanel;
    private final BFS bfs;
    private final StepButton stepButton;


    /**
     * Default constructor to list all mazes within the grid directory and display them.
     */
    public MenuBar(MazePanel mazePanel, BFS bfs, StepButton stepButton) {
        this.mazePanel = mazePanel;
        this.bfs = bfs;
        this.stepButton = stepButton;

//        File directory = new File("src/grid");

        File directory = new File("grid");


        File[] mazeFiles = directory.listFiles();

        JMenu mazes = new JMenu("Choose Maze");

        assert mazeFiles != null;
        for (File file: mazeFiles) {
            String[] splitFile = file.toString().split("[/.]");

            JMenuItem chosenMaze = new JMenuItem(splitFile[1]);

            mazes.add(chosenMaze);

            chosenMaze.addActionListener(this);

        }

        this.add(mazes);

    }

    /**
     * Change the maze to the button clicked
     *
     * @param e the event to be processed (on click)
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        String maze = e.getActionCommand();
        GridChanger.changeGrid(maze, mazePanel, bfs, stepButton);

    }
}
