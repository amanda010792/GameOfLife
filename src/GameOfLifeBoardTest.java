import static org.junit.Assert.*;

import org.junit.Test;

public class GameOfLifeBoardTest {

	@Test
	public void testIterate() {
		//Test a standard 5x5 board
		Integer[][] beforeBoard = {{0,1,0,0,0}, {1,0,0,1,1}, {1,1,0,0,1}, {0,1,0,0,0}, {1,0,0,0,1}};
		GameOfLifeBoard gol = new GameOfLifeBoard(5, 5, beforeBoard);
		gol.iterate();
		Integer[][] afterBoard = gol.getBoard();
		Integer[][] expectedBoard = {{0,0,0,0,0}, {1,0,1,1,1}, {1,1,1,1,1}, {0,1,0,0,0}, {0,0,0,0,0}};
		assertArrayEquals(afterBoard, expectedBoard);
	}

}
