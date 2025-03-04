package e2;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final ChessCharacter pawn;
	private KnightCharacter knight;
	private final Random random = new Random();
	private final int size;
	 
    public LogicsImpl(int size){
    	this.size = size;
        this.pawn = new ChessCharacterImpl(this.randomEmptyPosition());
        this.knight = new KnightCharacter(this.randomEmptyPosition());
    }

	public LogicsImpl(int size, final Pair<Integer,Integer> pawn, final Pair<Integer,Integer> knight) {
		this.size = size;
		this.pawn = new ChessCharacterImpl(new Pair<>(pawn.getX(), pawn.getY()));
		this.knight = new KnightCharacter(new Pair<>(knight.getX(), knight.getY()));
	}
    
	private final Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn.getPosition()!=null && this.pawn.getPosition().equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		if (row<0 || col<0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		return this.knight.hasKnightHitPawn(this.pawn.getPosition(), new Pair<>(row, col));
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.getPosition().equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.getPosition().equals(new Pair<>(row,col));
	}
}
