package e3;

import e3.gameObjects.Grid;

import java.util.List;

public class LogicsImpl implements Logics {

    public LogicsImpl(final int size, final int numOfMines) {
    }

    public LogicsImpl(final int size, final List<Pair<Integer, Integer>> minesPosition) {}

    @Override
    public boolean isMineFound(Pair<Integer, Integer> position) {
        return false;
    }

    @Override
    public boolean isGameOver() {
        return false;
    }

    @Override
    public Grid getGrid() {
        return null;
    }
}
