package exceptions;

/**
 * Checks if the maze data doesn't match the given format.
 * The format is as follows, does not contain characters other than (' ','#','S','E'), first line
 * declares dimensions by using 2 integers separated by a single space, only one start & end, rows
 * & cols are odd.
 */
public class MazeMalformedException extends Exception{

    /**
     * Default constructor with error message.
     */
    public MazeMalformedException() {
        super("Maze data doesn't match the given format.");
    }
}
