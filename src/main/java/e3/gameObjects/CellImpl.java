package e3.gameObjects;

public class CellImpl implements Cell {
    private final boolean hasMine;
    private boolean isShown;
    private boolean isFlagged;
    private int numOfAdjacentMines;

    public CellImpl(final boolean hasMine) {
        this.hasMine = hasMine;
        this.isShown = false;
        this.isFlagged = false;
    }

    @Override
    public boolean doesCellContainsAMine() {
        this.isShown = true;
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
    public void setNumOfAdjacentMines(final int numOfMines) {
        this.numOfAdjacentMines = numOfMines;
    }

    @Override
    public int getNumOfAdjacentMine() {
        return this.numOfAdjacentMines;
    }

    @Override
    public void setCellIsShown(boolean visibility) {
        this.isShown = visibility;
    }
}
