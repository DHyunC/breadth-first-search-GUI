package io;

import exceptions.MazeMalformedException;
import exceptions.MazeSizeMissmatchException;


import java.io.*;

/**
 * Implements the load method from FileInterface to convert a text file into a 2d array of
 * characters.
 */
public class FileLoader implements FileInterface{

    /**
     * Converts a given text file to a 2d character array of the character at the given index of row,
     * column per text file.
     *
     * @param filename The path to the maze file to be loaded.
     * @return 2d array of characters representing the tile from given text file.
     * @throws java.io.FileNotFoundException         If file is not located.
     * @throws exceptions.MazeSizeMissmatchException If provided dimensions do not match observed
     *                                               dimensions.
     * @throws exceptions.MazeMalformedException     If maze contains non-valid characters,
     *                                               dimensions not declared properly & does not fit
     *                                               required text file format.
     * @throws IllegalArgumentException              If provided name of file is not a string.
     *
     * @ensures That maze has odd rows & cols, does not contain invalid characters, declared
     *          dimensions match actual dimensions & text file follows format of dimension
     *          declaration then lines of characters.
     */
    @Override
    public char[][] load(String filename) throws MazeMalformedException, MazeSizeMissmatchException,
            IllegalArgumentException, FileNotFoundException {

        try {

            BufferedReader br = new BufferedReader(new FileReader(filename));


            int observedRows = 0;
            int observedCols = -1;
            int startCount = 0;
            int endCount = 0;
            String line;

            String dimensions = br.readLine();
            if (dimensions == null) {
                throw new MazeMalformedException();
            }
            String[] dimensionSpec = dimensions.split(" ");
            if (dimensionSpec.length != 2) {
                throw new MazeMalformedException();
            }


            int expectedRows = Integer.parseInt(dimensionSpec[0]);
            int expectedCols = Integer.parseInt(dimensionSpec[1]);

            if (expectedRows % 2 == 0 || expectedCols % 2 == 0) {
                throw new MazeMalformedException();
            }

            char[][] maze = new char[expectedRows][expectedCols];

            while ((line = br.readLine()) != null) {
                observedRows++;

                if (observedCols == -1) {
                    observedCols = line.length();
                    if (observedCols != expectedCols) {
                        throw new MazeSizeMissmatchException();
                    }
                }
                char[] tiles = line.toCharArray();
                for (int col = 0; col < observedCols; col++) {
                    char tile = tiles[col];
                    if (tile != '#' & tile != 'S' & tile != 'E' & tile != ' ') {
                        throw new MazeMalformedException();
                    }
                    if (tile == 'S') {
                        startCount++;
                    }
                    if (tile == 'E') {
                        endCount++;
                    }
                    if (startCount > 1|| endCount > 1) {
                        throw new MazeMalformedException();
                    }
                    maze[observedRows - 1][col] = tile;
                    if ((col == 0 || col == line.length() - 1) && tile != '#') {
                        throw new MazeMalformedException();
                    }
                }
            }
            if (observedRows != expectedRows) {
                throw new MazeSizeMissmatchException();
            }

            return maze;
        }
        catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
            throw new MazeMalformedException();
        }
        catch (IOException IOe) {
            throw new FileNotFoundException();
        }
    }
}
