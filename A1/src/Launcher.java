import controller.BFS;
import gui.MazeFrame;
import io.FileLoader;
import io.GridChanger;
import io.InputHandler;
import model.*;

import java.io.FileNotFoundException;

/**
 * Main entry point for project, connects all other aspects.
 */
public class Launcher{

    /**
     * Launch maze GUI or text output and initialise breadth first search.
     *
     * @param args Command line arguments to determine whether to use GUI or not.
     * @requires   Args != null.
     */
    public static void main(String[] args) {
        FileLoader fileloader = new FileLoader();
        String fileName = null;
        boolean useGUI = false;

        if (args.length == 2 && (args[0].equals("GUI") || args[0].equals("gui"))) {
            useGUI = true;
            fileName = args[1];
        }
        else if (args.length == 1){
            fileName = args[0];
        }

        try {
            char[][] grid = fileloader.load(fileName);
            MazeComponent[][] componentGrid = GridChanger.convertGrid(grid);

//            new Launcher(componentGrid, useGUI);
            Launcher.launch(componentGrid, useGUI);
        }
        catch (FileNotFoundException e) {
            System.out.println("The file could not be found at the specified path");
            System.out.println("Usage of Launcher.java: java Launcher GUI(optional) path to file");
        }
        catch (IllegalArgumentException e) {
            System.out.println("Argument given could not be resolved please follow usage format.");
            System.out.println("Usage of Launcher.java: java Launcher GUI(optional) path to file");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Usage of Launcher.java: java Launcher GUI(optional) path to file");
        }


    }


    /**
     * Launches application with given grid using GUI or terminal output.
     *
     * @param grid   Grid of the maze provided as a 2d array of MazeComponent class.
     * @param useGUI Boolean to indicate whether to use GUI or not.
     */
    public static void launch(MazeComponent[][] grid, boolean useGUI) {

        if (useGUI) {
            new MazeFrame(grid);
        }
        else {
            BFS bfs = new BFS();
            bfs.initialise(grid);
            bfs.step();

            InputHandler inputHandler = new InputHandler(bfs);
            inputHandler.readInput(grid);
        }
    }
}
