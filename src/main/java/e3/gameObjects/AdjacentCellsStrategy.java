package e3.gameObjects;

import e3.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AdjacentCellsStrategy implements NumOfMinesStrategy {

    @Override
    public int calcNumOfMines(Pair<Integer, Integer> position, Map<Pair<Integer, Integer>, Cell> grid, int size) {
        final List<Pair<Integer, Integer>> visitedPositions = new ArrayList<>();
        int numOfAdjecentMines = 0;
        for (AdjacentPositions dir : AdjacentPositions.values()) {
            final int adjX = position.getX() + dir.getDx();
            final int adjY = position.getY() + dir.getDy();
            if (this.isOnTheGrid(adjX, adjY, size)) {
                final Pair<Integer, Integer> positionToCheck = new Pair<>(adjX, adjY);
                visitedPositions.add(positionToCheck);
                if (grid.get(positionToCheck).doesCellContainsAMine())
                    numOfAdjecentMines++;
            }
        }
        grid.get(position).setNumOfAdjacentMines(numOfAdjecentMines);
        grid.get(position).setCellIsShown(true);
        if (numOfAdjecentMines == 0) {
            for (final Pair<Integer, Integer> pos : visitedPositions) {
                return this.calcNumOfMines(pos, grid, size);
            }
        }
        return numOfAdjecentMines;
    }

    private boolean isOnTheGrid(final int x, final int y, final int size) {
        return x >= 0 && x < size && y >= 0 && y < size;
    }
}
