package e3.gameObjects;

import e3.Pair;

import java.util.Map;

public interface NumOfMinesStrategy {
    /**
     * Calculate the number of the mines according to the strategy chosen.
     *
     * @param position The position of the cell
     * @param grid The grid of the game
     * @param size The size of the grid
     * @return The number of mines
     */
    int calcNumOfMines(final Pair<Integer, Integer> position, final Map<Pair<Integer, Integer>, Cell> grid, final int size);
}
