
public class GameOfLifeBoard {
	public static Integer[][] board;
	public static Integer length;
	public static Integer width;
	
	public GameOfLifeBoard(int x, int y){
		// If user inputs board size, creates board of given length and width
		length = x;
		width = y;
		board = new Integer[x][y];
		for(int a = 0; a < x; a++){
			for(int b = 0; b < y; b++){
				if(Math.random() < 0.5){
					board[a][b] = 0;
				} 
				else{
					board[a][b] = 1;
				}
			}
		}
	}
	
	public GameOfLifeBoard(int x, int y, Integer[][] board){
		length = x;
		width = y;
		GameOfLifeBoard.board = board;
	}

	public Integer[][] getBoard() {
		return board;
	}

	public void iterate(){
		Integer[][] newBoard = new Integer[length][width];
		int liveNeighborsCount;
		for(int x = 0; x < length; x++){
			for(int y = 0; y < width; y++){
				liveNeighborsCount = 0;
				//Look at far left edge cases
				if(x == 0){
					//Upper left corner
					if(y == 0){
						liveNeighborsCount = board[1][0] + board[1][1] + board[0][1];
					}
					//Lower left corner
					else if(y == width-1){
						liveNeighborsCount = board[0][width-2] + board[1][width-2] + board[1][width-1];
					}
					//All other left side cases
					else{
						liveNeighborsCount = board[0][y-1] + board[1][y-1] + board[1][y] + board[1][y+1] + board[0][y+1];
					}
				}
				//Look at far right edge cases
				else if(x == length-1){
					//Upper right corner
					if(y == 0){
						liveNeighborsCount = board[length-2][0] + board[length-2][1] + board[length-1][1];
					}
					//Lower right corner
					else if(y == width-1){
						liveNeighborsCount = board[length-2][width-1] + board[length-2][width-2] + board[length-1][width-2];
					}
					//All other right side cases
					else{
						liveNeighborsCount = board[length-1][y-1] + board[length-2][y-1] + board[length-2][y] + board[length-2][y+1] + board[length-1][y+1];
					}
				}
				//All top edge cases besides corners
				else if(y == 0){
					liveNeighborsCount = board[x-1][0] + board[x-1][1] + board[x][1] + board[x+1][1] + board[x+1][0];
				}
				//All bottom edge cases besides corners
				else if(y == width-1){
					liveNeighborsCount = board[x-1][width-1] + board[x-1][width-2] + board[x][width-2] + board[x+1][width-2] + board[x+1][width-1];
				}
				//All other cases (pieces surrounded by other pieces on all sides)
				else{
					liveNeighborsCount = board[x-1][y-1] + board[x][y-1] + board[x+1][y-1] + board[x+1][y] + board[x+1][y+1] + board[x][y+1] + board[x-1][y+1] + board[x-1][y];
				}
				if (board[x][y] == 0) {
					//Any dead cell with exactly 3 live neighbors becomes a live cell
					if (liveNeighborsCount == 3) {
						newBoard[x][y] = 1;
					}
					else{
						newBoard[x][y] = 0;
					}
				}
				else {
					//Any live cell with fewer than 2 live neighbors dies
					if (liveNeighborsCount < 2){
						newBoard[x][y] = 0;
					}
					//Any life cell with more than 3 live neighbors dies
					else if (liveNeighborsCount > 3){
						newBoard[x][y] = 0;
					}
					else{
						newBoard[x][y] = 1;
					}
				}
			}
		}
		board= newBoard;
	}

}
