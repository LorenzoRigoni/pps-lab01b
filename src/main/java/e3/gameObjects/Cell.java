package e3.gameObjects;

public interface Cell {
    /**
     * Checks if the cell contains a mine.
     *
     * @return true if it contains a mine, false otherwise
     */
    boolean doesCellContainsAMine();

    /**
     * Checks if the cell is flagged.
     *
     * @return true if it is flagged, false otherwise
     */
    boolean isCellFlagged();

    /**
     * Checks if the cell is shown.
     *
     * @return true if it is shown, false otherwise
     */
    boolean isCellShown();

    /**
     * Set the flag of the cell.
     *
     * @param flag The flag to assign
     */
    void setCellFlag(final boolean flag);

    /**
     * Set the number of adjacent mines of the cell.
     *
     * @param numOfMines The number of adjacent mines of the cell.
     */
    void setNumOfMines(final int numOfMines);

    /**
     * Get the number of adjacent mines of the cell.
     * @return The number of adjacent mines of the cell.
     */
    int getNumOfMines();

    /**
     * Set the cell visibility.
     *
     * @param visibility The cell visibility to set
     */
    void setCellVisibility(final boolean visibility);
}
