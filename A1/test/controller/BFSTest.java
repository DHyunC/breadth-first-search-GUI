package controller;

import io.FileLoader;
import io.GridChanger;
import model.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test all functionality of the BFS class.
 */
public class BFSTest {
    private BFS bfs;
    private FileLoader loader;
    private Position smallStart;
    private Position smallEnd;
    private Position mediumStart;
    private Position mediumEnd;
    private Position largeStart;
    private Position largeEnd;
    private Position stepOne;
    private Position stepFive;
    private Position stepTen;
    private Position stepEleven;
    private Position stepTwelve;


    /**
     * Initialise required classes.
     */
    @Before
    public void setup() {
        this.bfs = new BFS();
        this.loader = new FileLoader();
        smallStart = new Position(1,1);
        smallEnd = new Position(5,5);
        mediumStart = new Position(1,1);
        mediumEnd = new Position(19,39);
        largeStart = new Position(1,1);
        largeEnd = new Position(101,101);
        stepOne = new Position(2, 1);
        stepFive = new Position(5, 2);
        stepTen = new Position(3, 5);
        stepEleven = new Position(4, 5);
        stepTwelve = new Position(2, 5);
    }

    /**
     * Check that it initialises the start and end positions correctly for the small maze.
     */
    @Test
    public void initialiseSmall() {
        try {
            bfs.initialise(GridChanger.convertGrid(loader.load("src/grid/Small.txt")));
            assertEquals(bfs.getStart(), smallStart);
            assertEquals(bfs.getEnd(), smallEnd);

        }
        catch (Exception e) {
            fail("An unexpected exception was thrown.");
        }
    }

    /**
     * Check that it initialises the start and end positions correctly for the medium maze.
     */
    @Test
    public void initialiseMedium() {
        try {
            bfs.initialise(GridChanger.convertGrid(loader.load("src/grid/Medium.txt")));
            assertEquals(bfs.getStart(), mediumStart);
            assertEquals(bfs.getEnd(), mediumEnd);

        }
        catch (Exception e) {
            fail("An unexpected exception was thrown.");
        }
    }

    /**
     * Check that it initialises the start and end positions correctly for the large maze.
     */
    @Test
    public void initialiseLarge() {
        try {
            bfs.initialise(GridChanger.convertGrid(loader.load("src/grid/Large.txt")));
            assertEquals(bfs.getStart(), largeStart);
            assertEquals(bfs.getEnd(), largeEnd);

        }
        catch (Exception e) {
            fail("An unexpected exception was thrown.");
        }
    }

    /**
     * Ensure the reset function makes all variables null and the queue empty.
     */
    @Test
    public void resetTest() {
        try {
            bfs.initialise(GridChanger.convertGrid(loader.load("src/grid/Large.txt")));
            bfs.step();
            bfs.step();
            bfs.step();
            bfs.reset();
            assertNull(bfs.getVisited());
            assertNull(bfs.getStart());
            assertNull(bfs.getEnd());
            assertNull(bfs.getGrid());
            assertNull(bfs.getCurrentPosition());
            assertTrue(bfs.getQueue().isEmpty());

        }
        catch (Exception e) {
            fail("An unexpected exception was thrown.");
        }

    }

    /**
     * Test the functionality of the step function.
     */
    @Test
    public void bfsStepTest() {
        try {
            bfs.initialise(GridChanger.convertGrid(loader.load("src/grid/Small.txt")));
            bfs.step();
            bfs.step();
            assertEquals(bfs.getCurrentPosition(), stepOne);
            for (int i = 0; i < 4; i++) {
                bfs.step();
            }
            assertEquals(bfs.getCurrentPosition(), stepFive);
            for (int i = 0; i < 5; i++) {
                bfs.step();
            }
            assertEquals(bfs.getCurrentPosition(), stepTen);
            bfs.step();
            assertEquals(bfs.getCurrentPosition(), stepTwelve);
            bfs.step();
            assertEquals(bfs.getCurrentPosition(), stepEleven);

        }
        catch (Exception e) {
            fail("An unexpected exception was thrown.");
        }
    }

    /**
     * Check functionality of isSolved method.
     */
    @Test
    public void isSolvedTest() {
        try {
            bfs.initialise(GridChanger.convertGrid(
                    loader.load("test/testgrid/TestMaze.txt")));
            for (int i = 0; i < 3; i++) {
                bfs.step();
            }
            assertFalse(bfs.isSolved());
            for (int i = 0; i < 7; i++) {
                bfs.step();
            }
            assertTrue(bfs.isSolved());

        }
        catch (Exception e) {
            fail("An unexpected exception was thrown.");
        }
    }

}
