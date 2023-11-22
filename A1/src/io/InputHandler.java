package io;

import controller.BFS;
import model.MazeComponent;
import textinterface.textInterface;

import java.util.Scanner;

/**
 * Class for handling user input when using terminal text output.
 */
public class InputHandler {
    private final BFS bfs;

    /**
     * Initialise the Breadth First Search Algorithm and set variable.
     *
     * @param bfs Breadth First Search object used to solve the maze.
     */
    public InputHandler(BFS bfs) {
        this.bfs = bfs;
    }

    /**
     * Constantly take in the input of the user and step in BFS if input is 's' or quit if input is
     * 'q'.
     *
     * @param grid The 2d MazeComponent array to use for generating text output.
     * @requires grid != null.
     */
    public void readInput(MazeComponent[][] grid) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            StringBuilder terminalGrid =  textInterface.generateGrid(grid, bfs.getVisited());
            System.out.println(terminalGrid);

            System.out.print("Enter 's' to step or 'q' to quit: ");
            String userInput = scanner.nextLine().toLowerCase();

            if (userInput.equals("s")) {
                if (bfs.isSolved()) {
                    System.out.println("Maze Solved, terminating BFS");
                } else {
                    System.out.println("Taking a step.");
                    bfs.step();
                }
            } else if (userInput.equals("q")) {
                System.out.println("Quitting application.");
                break;
            } else {
                System.out.println("Invalid input.");
            }
        }
        scanner.close();
    }
}
