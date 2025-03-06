package e3.gameObjects;

import e3.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AdjacentCellsStrategy implements NumOfMinesStrategy {
    private final List<Pair<Integer, Integer>> revealedPositions;

    public AdjacentCellsStrategy() {
        this.revealedPositions = new ArrayList<>();
    }

    @Override
    public void calcNumOfMines(Pair<Integer, Integer> position, Map<Pair<Integer, Integer>, Cell> grid, int size) {
        int numOfAdjecentMines = 0;
        for (AdjacentPositions dir : AdjacentPositions.values()) {
            final int adjX = position.getX() + dir.getX();
            final int adjY = position.getY() + dir.getY();
            if (this.isOnTheGrid(adjX, adjY, size) && grid.get(new Pair<>(adjX, adjY)).doesCellContainsAMine()) {
                numOfAdjecentMines++;
            }
        }
        grid.get(position).setNumOfMines(numOfAdjecentMines);
    }

    @Override
    public void revealNumOfMines(Pair<Integer, Integer> position, Map<Pair<Integer, Integer>, Cell> grid, int size) {
        if (!isOnTheGrid(position.getX(), position.getY(), size) || this.revealedPositions.contains(position))
            return;

        this.revealedPositions.add(position);
        grid.get(position).setCellVisibility(true);

        if (grid.get(position).getNumOfMines() == 0) {
            for (AdjacentPositions dir : AdjacentPositions.values()) {
                final int adjX = position.getX() + dir.getX();
                final int adjY = position.getY() + dir.getY();
                revealNumOfMines(new Pair<>(adjX, adjY), grid, size);
            }
        }
    }

    private boolean isOnTheGrid(final int x, final int y, final int size) {
        return x >= 0 && x < size && y >= 0 && y < size;
    }
}
