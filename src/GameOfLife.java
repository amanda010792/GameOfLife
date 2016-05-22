
public class GameOfLife {

	public static void main(String[] args) {
		Integer[][] startingBoard = {{0,1,0,0,0}, {1,0,0,1,1}, {1,1,0,0,1}, {0,1,0,0,0}, {1,0,0,0,1}};
		GameOfLifeBoard myBoard = new GameOfLifeBoard(5, 5, startingBoard);
		myBoard.printBoard();
		myBoard.iterate();
		myBoard.printBoard();

	}

}
