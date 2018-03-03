package gol;

public class Main 
{
	public static void main(String[] args) throws InterruptedException 
	{
		char[][] startingBoard = {   {'o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o'},
									{'o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o'},
									{'o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o'},
									{'o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o'},
									{'o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o'},
									{'o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o'},
									{'o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o'},
									{'o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o'},
									{'o','o','o','o','o','o','o','o','o','o','x','o','o','o','o','o','o','o','o','o'},
									{'o','o','o','o','o','o','o','o','o','x','x','o','o','o','o','o','o','o','o','o'},
									{'o','o','o','o','o','o','o','o','o','x','x','o','o','o','o','o','o','o','o','o'},
									{'o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o'},
									{'o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o'},
									{'o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o'},
									{'o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o'},
									{'o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o'},
									{'o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o'},
									{'o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o'},
									{'o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o'},
									{'o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o'}};
		
		
		
		
		// GameOfLife(startingBoard, generations)
		GameOfLife g = new GameOfLife(startingBoard, 5);
		g.start();
	}
}
