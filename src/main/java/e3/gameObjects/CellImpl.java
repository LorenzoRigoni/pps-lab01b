package e3.gameObjects;

public class CellImpl implements Cell {
    private final boolean hasMine;
    private boolean isShown;
    private boolean isFlagged;
    private int numOfMines;

    public CellImpl(final boolean hasMine) {
        this.hasMine = hasMine;
        this.isShown = false;
        this.isFlagged = false;
    }

    @Override
    public boolean doesCellContainsAMine() {
        return this.hasMine;
    }

    @Override
    public boolean isCellFlagged() {
        return this.isFlagged;
    }

    @Override
    public boolean isCellShown() {
        return this.isShown;
    }

    @Override
    public void setCellFlag(boolean flag) {
        this.isFlagged = flag;
    }

    @Override
    public void setNumOfMines(final int numOfMines) {
        this.numOfMines = numOfMines;
    }

    @Override
    public int getNumOfMines() {
        return this.numOfMines;
    }

    @Override
    public void setCellVisibility(boolean visibility) {
        this.isShown = visibility;
    }
}
