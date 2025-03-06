package e3.gameObjects;

import e3.Pair;

import java.util.Map;

public interface Grid {
    /**
     * Checks if a cell contains a mine.
     *
     * @param position The position of the cell to check
     * @return true if the cell contains a mine, false otherwise
     */
    boolean doesCellContainsAMine(final Pair<Integer, Integer> position);

    /**
     * Checks if all the no-mines cells are shown (in that case, the game is over and is won)
     *
     * @return true if all the no-mines cells are shown, false otherwise
     */
    boolean areAllTheNoMinesCellsVisible();

    /**
     * Get the grid of the game.
     *
     * @return The grid as a map with positions as keys and cells as values
     */
    Map<Pair<Integer, Integer>, Cell> getGrid();

    /**
     * Set the flag on a cell.
     *
     * @param position The position of the cell
     * @param flag The flag to set
     */
    void setFlagOnACell(final Pair<Integer, Integer> position, final boolean flag);

    /**
     * Checks if a cell is flagged.
     *
     * @param position The position of the cell
     * @return true if it is flagged, false otherwise
     */
    boolean isCellFlagged(final Pair<Integer, Integer> position);

    /**
     * Get the number of the adjacent mines of a cell.
     *
     * @param position The position of the cell
     * @return The number of adjacent mines
     */
    int getNumOfMines(final Pair<Integer, Integer> position);
}
