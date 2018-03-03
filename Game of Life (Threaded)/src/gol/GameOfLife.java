package gol;

import java.util.ArrayList;

public class GameOfLife 
{
	private int COLUMNS;
	private int ROWS;
	private int generations;
	private Cell[][] cellsThreaded;
	
	public GameOfLife(char[][] startingBoard, int generations)
	{
		COLUMNS = startingBoard[0].length;
		ROWS = startingBoard.length;
		this.generations = generations;
		
		cellsThreaded = new Cell[COLUMNS][ROWS];
		setBoard(startingBoard);
	}
	
	public void start() throws InterruptedException
	{
		System.out.println("You're asking for a game with " + ROWS + " rows and " + COLUMNS + " columns "
				   + "over " + generations + " generations");
		
		System.out.println("Your starting board\n");
		showBoard();
		
		for(int i = 0; i < generations; i++)
			generate();
		
		System.out.println("\nAfter " + generations + " generation(s)....\n");
		showBoard();
	}
	
	public void generate() throws InterruptedException
	{		
		// creating a list to store the threads
		ArrayList<Thread> threads = new ArrayList<>();
		
		Cell[][] next = new Cell[ROWS][COLUMNS];
		
		// instantiating an object for each next generation
		for(int x = 0; x < ROWS; x++)
		{
			for(int y = 0; y < COLUMNS; y++)
			{
				next[x][y] = new Cell();
			}
		}
		
		
		for(int x = 1; x < ROWS - 1; x++)
		{
			for(int y = 1; y < COLUMNS - 1; y++)
			{
				Integer threadRow = x;
				Integer threadColumns = y;
				
				Thread t = new Thread(() -> {
					cellsThreaded[threadRow][threadColumns].setNeighbor(0);
					
					// Counting neighbors for each cell
					for(int i = -1; i <= 1; i++)
					{
						for(int j = -1; j <= 1; j++)
						{
							if(i == 0 && j == 0)
								continue;
							if(threadRow + i < 0 || threadRow + i >= ROWS)
								continue;
							if(threadColumns + j < 0 || threadColumns + j >= COLUMNS)
								continue;
							
							// if neighboring cell is alive, increase the amount of live neighbors
							if(cellsThreaded[threadRow + i][threadColumns + j].getLife() == 1)
								cellsThreaded[threadRow][threadColumns].addNeigbor();
						}	
					}
					// The Rules of life
					
					if((cellsThreaded[threadRow][threadColumns].getLife() == 1) && 
							(cellsThreaded[threadRow][threadColumns].getNeighbors() < 2))
						next[threadRow][threadColumns].setLife(0);						// live cell with less than 2 neighbors dies
					
					else if((cellsThreaded[threadRow][threadColumns].getLife() == 1) && 
							(cellsThreaded[threadRow][threadColumns].getNeighbors() > 3))
						next[threadRow][threadColumns].setLife(0);						// live cell with more than 2 neighbors dies
					
					else if((cellsThreaded[threadRow][threadColumns].getLife() == 0) && 
							(cellsThreaded[threadRow][threadColumns].getNeighbors() == 3))
						next[threadRow][threadColumns].setLife(1);						// dead cell with 3 neighbors is born
					
					else
						next[threadRow][threadColumns].setLife(cellsThreaded[threadRow][threadColumns].getLife());	// cell remains same
				});
				
				t.start();
				threads.add(t);
			}
		}
		
		for(Thread t : threads)
			t.join();
		
		cellsThreaded = next;
	}
	
	public void setBoard(char[][] startingBoard)
	{	
		for(int i = 0; i < ROWS; i++)
		{
			for(int j = 0; j < COLUMNS; j++)
			{		
				cellsThreaded[i][j] = new Cell();
				
				if(startingBoard[i][j] == 'x')
					cellsThreaded[i][j].setLife(1);
				else if(startingBoard[i][j] == 'o')
					cellsThreaded[i][j].setLife(0);
			}
		}
	}
	
	public void showBoard()
	{
		for(int i = 0; i < ROWS; i++)
		{
			for(int j = 0; j < COLUMNS; j++)
			{
				if(cellsThreaded[i][j].getLife() == 1)
					System.out.print("x");
				else if(cellsThreaded[i][j].getLife() == 0)
					System.out.print("o");
			}
			System.out.println();
		}
	}
	
}
