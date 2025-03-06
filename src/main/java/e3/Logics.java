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

    /**
     * Set the flag of a cell.
     *
     * @param position The position of the cell
     * @param flag The flag to assign to the cell
     */
    void setCellFlag(final Pair<Integer, Integer> position, final boolean flag);

    /**
     * Get the flag of the cell in the given position.
     *
     * @param position The position of the cell
     * @return true if the cell has a flag, false otherwise
     */
    boolean getCellFlag(final Pair<Integer, Integer> position);

    /**
     * Get the number of mines of a cell.
     *
     * @param position The position of the cell
     * @return The number of the mines
     */
    int getNumOfMinesOfACell(final Pair<Integer, Integer> position);

    /**
     * Check if a cell is already been clicked.
     *
     * @param position The position of the cell
     * @return true if it is already been clicked, false otherwise
     */
    boolean isCellAlreadyShown(final Pair<Integer, Integer> position);
}
