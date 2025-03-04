package e2;

public class ChessCharacterImpl implements ChessCharacter {
    protected Pair<Integer, Integer> position;

    public ChessCharacterImpl(final Pair<Integer, Integer> position) {
        this.position = new Pair<>(position.getX(), position.getY());
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return new Pair<>(this.position.getX(), this.position.getY());
    }

    @Override
    public void setPosition(Pair<Integer, Integer> position) {
        this.position = new Pair<>(position.getX(), position.getY());
    }
}
