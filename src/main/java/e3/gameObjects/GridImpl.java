package e3.gameObjects;

import e3.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GridImpl implements Grid {
    private final Map<Pair<Integer, Integer>, Cell> grid;
    private final NumOfMinesStrategy numOfMinesStrategy;
    private final int size;
    private final int numOfMines;

    public GridImpl(final int size, final int numOfMines, final NumOfMinesStrategy numOfMinesStrategy) {
        this.size = size;
        this.numOfMines = numOfMines;
        this.grid = new HashMap<>();
        this.numOfMinesStrategy = numOfMinesStrategy;
        this.putMines();
        this.calcNumOfMines();
    }

    public GridImpl(final int size, final List<Pair<Integer, Integer>> minesPositions, final NumOfMinesStrategy numOfMinesStrategy) {
        this.size = size;
        this.numOfMines = minesPositions.size();
        this.grid = new HashMap<>();
        this.numOfMinesStrategy = numOfMinesStrategy;
        this.putMines(minesPositions);
        this.calcNumOfMines();
    }

    @Override
    public boolean doesCellContainsAMine(Pair<Integer, Integer> position) {
        final boolean cellHasMine = this.grid.get(position).doesCellContainsAMine();
        if (!cellHasMine) {
            this.numOfMinesStrategy.revealNumOfMines(position, this.grid, this.size);
        }
        return cellHasMine;
    }

    @Override
    public boolean areAllTheNoMinesCellsVisible() {
        for (final Cell cell: this.grid.values()) {
            if (!cell.isCellShown() && !cell.doesCellContainsAMine())
                return false;
        }
        return true;
    }

    @Override
    public Map<Pair<Integer, Integer>, Cell> getGrid() {
        return new HashMap<>(this.grid);
    }

    @Override
    public void setFlagOnACell(Pair<Integer, Integer> position, boolean flag) {
        this.grid.get(position).setCellFlag(flag);
    }

    @Override
    public boolean isCellFlagged(Pair<Integer, Integer> position) {
        return this.grid.get(position).isCellFlagged();
    }

    @Override
    public int getNumOfMines(Pair<Integer, Integer> position) {
        return this.grid.get(position).getNumOfAdjacentMine();
    }

    @Override
    public boolean isCellAlreadyShown(Pair<Integer, Integer> position) {
        return this.grid.get(position).isCellShown();
    }

    private void putMines() {
        int numMinesPositionated = 0;
        while (numMinesPositionated < this.numOfMines) {
            final Pair<Integer, Integer> randomPosition = new Pair<>(new Random().nextInt(this.size), new Random().nextInt(this.size));
            if(!this.grid.containsKey(randomPosition)) {
                this.grid.put(randomPosition, new CellImpl(true));
                numMinesPositionated++;
            }
        }
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if (!this.grid.containsKey(new Pair<>(i, j)))
                    this.grid.put(new Pair<>(i, j), new CellImpl(false));
            }
        }
    }

    private void putMines(List<Pair<Integer, Integer>> minesPositions) {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if (minesPositions.contains(new Pair<>(i, j)))
                    this.grid.put(new Pair<>(i, j), new CellImpl(true));
                else
                    this.grid.put(new Pair<>(i, j), new CellImpl(false));
            }
        }
    }

    private void calcNumOfMines() {
        for (final Pair<Integer, Integer> pos: this.grid.keySet()) {
            this.numOfMinesStrategy.calcNumOfMines(pos, grid, this.size);
        }
    }
}
