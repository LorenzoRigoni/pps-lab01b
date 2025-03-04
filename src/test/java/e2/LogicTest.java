package e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {
  private static final int FIELD_SIZE = 5;
  private static final Pair<Integer, Integer> INITIAL_KNIGHT_POS = new Pair<>(4, 3);
  private static final Pair<Integer, Integer> INITIAL_PAWN_POS = new Pair<>(3, 1);
  private static final Pair<Integer, Integer> KNIGHT_CAPTURE_PAWN = new Pair<>(3, 1);
  private static final Pair<Integer, Integer> KNIGHT_MOVE_UP_BY_TWO = new Pair<>(2, 2);
  private static final Pair<Integer, Integer> KNIGHT_MOVE_UP_BY_ONE = new Pair<>(2, 4);
  private static final Pair<Integer, Integer> KNIGHT_WRONG_MOVE = new Pair<>(0, 0);
  private Logics logic;

  @BeforeEach
  public void beforeEach() {
    this.logic = new LogicsImpl(FIELD_SIZE, INITIAL_PAWN_POS, INITIAL_KNIGHT_POS);
  }

  @Test
  public void testKnightCapturePawn() {
    assertTrue(this.logic.hit(KNIGHT_CAPTURE_PAWN.getX(), KNIGHT_CAPTURE_PAWN.getY()));
  }

  @Test
  public void testKnightCanMoveByOne() {
    assertAll(
            () -> assertFalse(this.logic.hit(KNIGHT_MOVE_UP_BY_ONE.getX(), KNIGHT_MOVE_UP_BY_ONE.getY())),
            () -> assertTrue(this.logic.hasKnight(KNIGHT_MOVE_UP_BY_ONE.getX(), KNIGHT_MOVE_UP_BY_ONE.getY()))
    );
  }

  @Test
  public void testKnightCanMoveByTwo() {
    assertAll(
            () -> assertFalse(this.logic.hit(KNIGHT_MOVE_UP_BY_TWO.getX(), KNIGHT_MOVE_UP_BY_TWO.getY())),
            () -> assertTrue(this.logic.hasKnight(KNIGHT_MOVE_UP_BY_TWO.getX(), KNIGHT_MOVE_UP_BY_TWO.getY()))
    );
  }

  @Test
  public void testKnightCannotMove() {
    assertAll(
            () -> assertFalse(this.logic.hit(KNIGHT_WRONG_MOVE.getX(), KNIGHT_WRONG_MOVE.getY())),
            () -> assertFalse(this.logic.hasKnight(KNIGHT_WRONG_MOVE.getX(), KNIGHT_WRONG_MOVE.getY()))
    );
  }
}
