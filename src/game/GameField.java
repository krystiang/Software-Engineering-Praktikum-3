package game;

public class GameField {
	
	private GameField upperRight;
	private GameField lowerRight;
	private GameField lower;
	private GameField lowerLeft;
	private GameField upperLeft;
	private GameField up;
	
	private int x;
	private int y;
	
	private GamePiece gamePiece;

	public GameField(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}
	
	public void setPiece(GamePiece gp){
		gamePiece = gp;
	}
	
	public GamePiece getPiece(){
		return gamePiece;
	}
}
