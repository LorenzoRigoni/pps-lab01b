package e3;
import e3.gameObjects.AdjacentCellsStrategy;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {
    private static final int SIZE = 7;
    private static final List<Pair<Integer, Integer>> MINES_POSITIONS = List.of(
            new Pair<>(0, 2),
            new Pair<>(1, 1),
            new Pair<>(2, 0),
            new Pair<>(2, 4),
            new Pair<>(2, 5),
            new Pair<>(3, 3),
            new Pair<>(3, 6),
            new Pair<>(5, 3),
            new Pair<>(6, 2)
    );
    private static final Pair<Integer, Integer> NO_MINE_POSITION = new Pair<>(0, 0);
    private static final int NUM_OF_ADJACENT_MINES = 1;
    private Logics logic;

    @BeforeEach
    public void beforeEach() {
        this.logic = new LogicsImpl(SIZE, MINES_POSITIONS, new AdjacentCellsStrategy());
    }

    @Test
    public void testIsNotGameOver() {
        assertFalse(this.logic.isGameOver());
    }

    @Test
    public void testCellDoesntContainsAMine() {
        assertFalse(this.logic.doesCellContainsAMine(NO_MINE_POSITION));
    }

    @Test
    public void testGameIsLost() {
        assertTrue(this.logic.doesCellContainsAMine(MINES_POSITIONS.get(0)));
    }

    @Test
    public void testCorrectNumberOfAdjacentMines() {
        assertEquals(NUM_OF_ADJACENT_MINES, this.logic.getNumOfMinesOfACell(NO_MINE_POSITION));
    }

    @Test
    public void testGameIsWon() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                final Pair<Integer, Integer> positionToClick = new Pair<>(i, j);
                if (!MINES_POSITIONS.contains(positionToClick) && !this.logic.isCellAlreadyShown(positionToClick))
                    this.logic.doesCellContainsAMine(positionToClick);
            }
        }

        assertTrue(this.logic.isGameOver());
    }
}
