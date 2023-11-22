package controller;


import model.MazeComponent;
import model.Position;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solves given maze using the Breadth First Search algorithm whilst showing single step iterations.
 */
public class BFS {
    private MazeComponent[][] grid;
    private Position start;
    private Position end;
    private boolean[][] visited;
    private Position currentPosition;
    private final Queue<Position> queue = new LinkedList<>();

    /**
     * Initialise the variables and use the initStartEnd function to initialise start and end
     * positions.
     *
     * @param grid 2d MazeComponent array of the maze to be initialised.
     *
     * @requires Grid != null.
     */
    public void initialise(MazeComponent[][] grid) {
        initStartEnd(grid);
        this.grid = grid;
        this.visited = new boolean[grid.length][grid[1].length];
        queue.add(start);

    }

    /**
     * Perform a single iteration of the Breadth First Search Algorithm.
     */
    public void step() {
        if (!queue.isEmpty()) {
            currentPosition = queue.poll();
            visited[currentPosition.getRow()][currentPosition.getCol()] = true;

            Move moveUp = movePosition -> new Position(movePosition.getRow() - 1, movePosition.getCol());
            Move moveDown = movePosition -> new Position(movePosition.getRow() + 1, movePosition.getCol());
            Move moveRight = movePosition -> new Position(movePosition.getRow(), movePosition.getCol() + 1);
            Move moveLeft = movePosition -> new Position(movePosition.getRow(), movePosition.getCol() - 1);

            if (checkMoveValid(currentPosition, moveUp) &&
                    !visited[currentPosition.getRow() - 1][currentPosition.getCol()]) {
                queue.add(moveUp.move(currentPosition));
            }
            if (checkMoveValid(currentPosition, moveDown) &&
                    !visited[currentPosition.getRow() + 1][currentPosition.getCol()]) {
                queue.add(moveDown.move(currentPosition));
            }
            if (checkMoveValid(currentPosition, moveRight) &&
                    !visited[currentPosition.getRow()][currentPosition.getCol() + 1]) {
                queue.add(moveRight.move(currentPosition));
            }
            if (checkMoveValid(currentPosition, moveLeft) &&
                    !visited[currentPosition.getRow()][currentPosition.getCol() - 1]) {
                queue.add(moveLeft.move(currentPosition));
            }

        }
        if (queue.isEmpty() && !isSolved()) {
            System.out.println("Maze is unsolvable");
        }

    }

    /**
     * Getter method for all visited positions.
     *
     * @return 2d boolean array of whether a position has been visited by the algorithm.
     */
    public boolean[][] getVisited() {
        return visited;
    }

    /**
     * Checks if a given move does not result in the player being on top of a wall tile or if a
     * given position is a wall tile.
     *
     * @param position Position to be checked.
     * @param move     Move lambda function to be performed.
     * @return         True if the move does not result in the player being inside a non-path tile,
     *                 else false.
     *
     * @requires Position != null && move != null
     * @ensures Result == true if a move can be performed given position and move command.
     */
    private boolean checkMoveValid(Position position, Move move) {
        Position checkPosition = move.move(position);

        return grid[checkPosition.getRow()][checkPosition.getCol()].getSymbol() != '#' &&
                grid[position.getRow()][position.getCol()].getSymbol() != '#';
    }

    /**
     * Initialise the start and the end of the maze.
     *
     * @param grid The maze represented in 2d MazeComponent grid.
     *
     * @requires grid != null.
     */
    private void initStartEnd(MazeComponent[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col].getSymbol() == 'S') {
                    this.start = new Position(row, col);
                }
                if (grid[row][col].getSymbol() == 'E'){
                    this.end = new Position(row, col);
                }
            }
        }
    }


    /**
     * Checks whether the maze has been solved.
     *
     * @return True if the maze has been solved.
     *
     * @ensures Result == true if the current position is equal to the end position.
     */
    public boolean isSolved() {
        return currentPosition.equals(end);
    }

    /**
     * Reset the Breadth First Search algorithm by setting all variables to null.
     */
    public void reset() {
        queue.clear();
        start = null;
        end = null;
        currentPosition = null;
        grid = null;
        visited = null;
    }

    /**
     * Getter method for start position.
     *
     * @return Position of start.
     */
    public Position getStart() {
        return start;
    }

    /**
     * Getter method for end position.
     *
     * @return Position of end.
     */
    public Position getEnd() {
        return end;
    }

    /**
     * Getter method for grid variable.
     *
     * @return 2d MazeComponent array.
     */
    public MazeComponent[][] getGrid() {
        return grid;
    }

    /**
     * Getter method for current position.
     *
     * @return Position of current.
     */
    public Position getCurrentPosition() {
        return currentPosition;
    }

    /**
     * Getter method for queue.
     *
     * @return Queue object.
     */
    public Queue<Position> getQueue() {
        return queue;
    }
}