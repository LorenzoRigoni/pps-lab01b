package e3.gameObjects;

/**
 * This enum contains the directions of the 8 adjacent positions of a cell.
 */
public enum AdjacentPositions {
    UP_LEFT(-1, -1),
    UP(-1, 0),
    UP_RIGHT(-1, 1),
    LEFT(0, -1),
    RIGHT(0, 1),
    DOWN_LEFT(1, -1),
    DOWN(1, 0),
    DOWN_RIGHT(1, 1);

    private final int x;
    private final int y;

    AdjacentPositions(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
