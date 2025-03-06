package e3.gameObjects;

public class CellImpl implements Cell {

    @Override
    public boolean doesCellContainsAMine() {
        return false;
    }

    @Override
    public boolean isCellFlagged() {
        return false;
    }

    @Override
    public boolean isCellShown() {
        return false;
    }

    @Override
    public void setCellFlag(boolean flag) {

    }
}
