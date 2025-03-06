package e3;

import e3.gameObjects.Grid;

public interface Logics {
    /**
     * Checks if, in a given position, there is a mine.
     *
     * @param position The position to check
     * @return true if there is a mine (game lost), false otherwise
     */
    boolean isMineFound(final Pair<Integer, Integer> position);

    /**
     * Checks if the player has won the game by selecting all the no-mine positions.
     *
     * @return true if the game is over, false otherwise
     */
    boolean isGameOver();

    /**
     * Get the grid of the game.
     *
     * @return The grid as a map with positions as keys and cells as values
     */
    Grid getGrid();
}
