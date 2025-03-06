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
}
