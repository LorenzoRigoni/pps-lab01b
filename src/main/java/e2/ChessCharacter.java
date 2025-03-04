package e2;

public interface ChessCharacter {
    /**
     * Get the position of the character.
     *
     * @return
     */
    Pair<Integer, Integer> getPosition();

    /**
     * Set the position of the character.
     *
     * @param position The new position
     */
    void setPosition(Pair<Integer, Integer> position);
}
