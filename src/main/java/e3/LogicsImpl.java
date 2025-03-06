package e3;

import e3.gameObjects.Grid;
import e3.gameObjects.GridImpl;
import e3.gameObjects.NumOfMinesStrategy;

import java.util.List;

public class LogicsImpl implements Logics {
    private final Grid grid;

    public LogicsImpl(final int size, final int numOfMines, final NumOfMinesStrategy numOfMinesStrategy) {
        this.grid = new GridImpl(size, numOfMines, numOfMinesStrategy);
    }

    public LogicsImpl(final int size, final List<Pair<Integer, Integer>> minesPosition, final NumOfMinesStrategy numOfMinesStrategy) {
        this.grid = new GridImpl(size, minesPosition, numOfMinesStrategy);
    }

    @Override
    public boolean isMineFound(final Pair<Integer, Integer> position) {
        return this.grid.doesCellContainsAMine(position);
    }

    @Override
    public boolean isGameOver() {
        return this.grid.areAllTheNoMinesCellsVisible();
    }

    @Override
    public Grid getGrid() {
        return this.grid;
    }
}
