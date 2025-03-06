package e3.gameObjects;

import e3.Pair;

import java.util.Map;

public class GridImpl implements Grid {
    @Override
    public boolean doesCellContainsAMine(Pair<Integer, Integer> position) {
        return false;
    }

    @Override
    public boolean areAllTheNoMinesCellsShowed() {
        return false;
    }

    @Override
    public Map<Pair<Integer, Integer>, Cell> getGrid() {
        return Map.of();
    }

    @Override
    public void setFlagOnACell(Pair<Integer, Integer> position, boolean flag) {

    }

    @Override
    public boolean isCellFlagged(Pair<Integer, Integer> position) {
        return false;
    }

    @Override
    public int getNumOfMines(Pair<Integer, Integer> position) {
        return 0;
    }
}
