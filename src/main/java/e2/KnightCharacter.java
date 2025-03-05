package e2;

public class KnightCharacter extends ChessCharacterImpl {
    private static final int NUM_KNIGHT_MOVES = 3;

    public KnightCharacter(Pair<Integer, Integer> position) {
        super(position);
    }

    public boolean hasKnightHitPawn(final Pair<Integer, Integer> pawnPosition, final Pair<Integer, Integer> positionToMove) {
        final Pair<Integer, Integer> knightAllowedMoves = this.calcKnightAllowedMoves(positionToMove);
        if (knightAllowedMoves.getX() != 0 && knightAllowedMoves.getY() != 0 &&
                (Math.abs(knightAllowedMoves.getX()) + Math.abs(knightAllowedMoves.getY())) == NUM_KNIGHT_MOVES) {
            this.setPosition(positionToMove);
            return this.position.equals(pawnPosition);
        }
        return false;
    }

    private Pair<Integer, Integer> calcKnightAllowedMoves(final Pair<Integer, Integer> positionToMove) {
        return new Pair<>(
                positionToMove.getX() - this.position.getX(), positionToMove.getY() - this.position.getY()
        );
    }
}
