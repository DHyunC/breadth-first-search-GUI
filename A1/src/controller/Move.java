package controller;

import model.Position;

/**
 * Interface for lambda move functions to change location of player in a 2d grid.
 */
public interface Move {
    Position move(Position position);
}
