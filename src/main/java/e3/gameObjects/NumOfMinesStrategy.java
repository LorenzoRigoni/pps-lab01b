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
     */
    void calcNumOfMines(final Pair<Integer, Integer> position, final Map<Pair<Integer, Integer>, Cell> grid, final int size);

    /**
     * Reveal the number of mines. If the number is 0, it reveals recursively his adjacent cells.
     *
     * @param position The position of the cell
     */
    void revealNumOfMines(final Pair<Integer, Integer> position, final Map<Pair<Integer, Integer>, Cell> grid, int size);
}
