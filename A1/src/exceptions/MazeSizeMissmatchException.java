package exceptions;

/**
 * Thrown if the declared dimensions do not match the actual dimension provided by the followed
 * characters.
 */
public class MazeSizeMissmatchException extends Exception{

    /**
     * Default constructor with error message.
     */
    public MazeSizeMissmatchException() {
        super("Maze data doesn't match the specified dimensions.");
    }
}
