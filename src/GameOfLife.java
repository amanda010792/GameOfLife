
public class GameOfLife {

	public static void main(String[] args) {
		GameOfLifeBoard myBoard = new GameOfLifeBoard(10,10);
		myBoard.printBoard();
		myBoard.iterate();
		myBoard.printBoard();

	}

}
