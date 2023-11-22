package io;

import exceptions.MazeMalformedException;
import exceptions.MazeSizeMissmatchException;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;


import static org.junit.Assert.*;

/**
 * Class to test the functionality of the FileLoader class
 */
public class FileLoaderTest {
    private FileLoader loader;
    private char[][] smallMaze;
    private char[][] mediumMaze;


    /**
     * Set up variables to compare to and initialise FileLoader.
     */
    @Before
    public void setup() {
        loader = new FileLoader();
        smallMaze = new char[][]{
                "#######".toCharArray(),
                "#S#   #".toCharArray(),
                "# ### #".toCharArray(),
                "# #   #".toCharArray(),
                "# # # #".toCharArray(),
                "#   #E#".toCharArray(),
                "#######".toCharArray()
        };
        mediumMaze = new char[][] {
                "#########################################".toCharArray(),
                "#S#         #   #       #     #   #     #".toCharArray(),
                "# ####### # # # # # ### # ### # ### # # #".toCharArray(),
                "# #     # #   #   #   #   # # #     # # #".toCharArray(),
                "# # ### # ####### ### ##### # ####### # #".toCharArray(),
                "#   # # # #     # #   # #   # #       # #".toCharArray(),
                "##### # ### ### # # ### # # # # ####### #".toCharArray(),
                "#     #     #   # # #     #   # #       #".toCharArray(),
                "# ### ####### ##### # ######### #########".toCharArray(),
                "#   #       #     # # #       #         #".toCharArray(),
                "######### ####### # # ##### # # ####### #".toCharArray(),
                "#   #   #       #   # #   # # #   #     #".toCharArray(),
                "# # # # ####### ##### # # # # ##### #####".toCharArray(),
                "# #   #   #     #   # # #   #     #     #".toCharArray(),
                "# # ##### # # ### # # # ######### ##### #".toCharArray(),
                "# # #   #   # #   #   # #       #       #".toCharArray(),
                "# ### # ##### # ####### # ############# #".toCharArray(),
                "#     # #     #         #           #   #".toCharArray(),
                "# ##### ################# ####### ### ###".toCharArray(),
                "#     #                         #      E#".toCharArray(),
                "#########################################".toCharArray()
        };

    }

    /**
     * Helper method for comparing 2d character arrays against each other
     *
     * @param firstArray  First 2d character array to be compared.
     * @param secondArray Second 2d character array to be compared.
     * @return true if the arrays contain the same characters.
     *
     * @requires two 2d characters arrays.
     * @ensures result == true if 2 arrays contain the same characters && have same length.
     */
    public boolean compareArrays (char[][] firstArray, char[][] secondArray) {
        boolean isSame = firstArray.length == secondArray.length &&
                firstArray[0].length == secondArray[0].length;
        if (isSame) {
            try {
                for (int row = 0; row < firstArray.length; row++) {
                    for (int col = 0; col < firstArray[row].length; col++) {
                        if (firstArray[row][col] != secondArray[row][col]) {
                            isSame = false;
                            break;
                        }
                    }
                }
            }
            catch (Exception e){
                isSame = false;
            }
        }
        return isSame;
    }

    /**
     * Check FileNotFoundException is thrown when file cannot be found.
     */
    @Test
    public void nonexistentFileTest() {
        try {
            String fakeText = "Fake.txt";
            loader.load(fakeText);
        }
        catch (FileNotFoundException e) {
            assertEquals(0,0);
        }
        catch (Exception e){
            assertEquals(0,1);
        }
    }

    /**
     * Check if the loader can load a small maze.
     */
    @Test
    public void smallMazeTest() {
        try {
            char[][] testMaze = loader.load("src/grid/Small.txt");
            if (compareArrays(testMaze, smallMaze)) {
                assertEquals(1,1);
            }
            else {
                fail("The loader did not load the maze properly.");
            }
        }
        catch (Exception e) {
            fail("The loader did not load the maze properly.");
        }
    }

    /**
     * Check if the loader can load a medium maze.
     */
    @Test
    public void mediumMazeTest() {
        try {
            char[][] testMaze = loader.load("src/grid/Medium.txt");
            if (compareArrays(testMaze, mediumMaze)) {
                assertEquals(1,1);
            }
            else {
                fail("The loader did not load the maze properly.");
            }
        }
        catch (Exception e){
            fail("The loader did not load the maze properly.");
        }
    }

    /**
     * Check that the loader checks that declared and actual dimensions match.
     */
    @Test
    public void wrongDimensionTest() {
        try {
            loader.load("test/testGrid/WrongDimensions.txt");
        }
        catch (MazeSizeMissmatchException e) {
            assertEquals(1,1);
        }
        catch (Exception e) {
            fail("Loader did not check if declared dimensions matched actual dimensions");
        }
    }

    /**
     * Check that the loader throws an error if declared dimensions are not odd.
     */
    @Test
    public void evenDimensionTest() {
        try {
            loader.load("test/testgrid/EvenDimensions.txt");
        }
        catch (MazeMalformedException e) {
            assertEquals(1,1);
        }
        catch (Exception e) {
            fail("Loader did not check for odd dimensions");
        }
    }

    /**
     * Check that the loader checks each character is valid.
     */
    @Test
    public void invalidCharacterTest() {
        try {
            loader.load("test/testgrid/InvalidCharacter.txt");
        }
        catch (MazeMalformedException e) {
            assertEquals(1,1);
        }
        catch (Exception e) {
            fail("Loader did not check for valid characters");
        }
    }

    /**
     * Check that there is an enclosing wall around the maze.
     */
    @Test
    public void enclosedWallsTest() {
        try {
            loader.load("test/testgrid/NotEnclosedMaze.txt");
        }
        catch (MazeMalformedException e) {
            assertEquals(1,1);
        }
        catch (Exception e) {
            fail("Loader did not check for enclosed walls");
        }
    }

    /**
     * Check only one start and exit exists.
     */
    @Test
    public void onlyOneStartExit() {
        try {
            loader.load("test/testgrid/StartExit.txt");
        }
        catch (MazeMalformedException e) {
            assertEquals(1,1);
        }
        catch (Exception e) {
            fail("Loader did not check for number of start and exit");
        }
    }

    /**
     * Check that dimensions are declared as 2 integers.
     */
    @Test
    public void invalidDimensionTest() {
        try {
            loader.load("test/testgrid/InvalidDimension.txt");
        }
        catch (MazeMalformedException e) {
            assertEquals(1,1);
        }
        catch (Exception e) {
            fail("Loader did not check for valid dimension declaration");
        }
    }





}
