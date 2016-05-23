import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.*;

public class GameOfLife extends JPanel{
	
	private static Integer[][] currentBoard;
	
	public GameOfLife(){
		setSize(new Dimension(600,600));

	}
	
	public void paint(Graphics g){
		g.fillRect(100, 100, 400, 400);
		for(int x = 0; x< currentBoard.length; x++){
			for(int y = 0; y<currentBoard[0].length; y++){
				if(currentBoard[x][y] == 0){
					g.clearRect(100+ (x*(400/currentBoard.length)), 100+ (y*(400/currentBoard[0].length)), (400/currentBoard.length), (400/currentBoard[0].length));
				}
			}
		}
	}
	

	public static void main(String[] args) throws InterruptedException{
		GameOfLife game = new GameOfLife();
		
		JFrame frame = new JFrame();
		frame.setTitle("Game of Life");
		frame.add(game);
		frame.pack();
		frame.setSize(new Dimension(600,600));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		GameOfLifeBoard myBoard = new GameOfLifeBoard(10,10);
		for(int x = 0; x < 10; x++){
			myBoard.iterate();
			currentBoard = myBoard.getBoard();
			frame.repaint();
			Thread.sleep(1000);
		}

	}

}
