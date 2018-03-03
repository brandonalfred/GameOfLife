package gol;

public class Cell implements Runnable
{
	private int alive; // 1 for alive, 0 for dead
	private int neighbors; // used to count the number of alive neighbors for this cell
	
	
	public Cell()
	{
		this.alive = 0;
		this.neighbors = 0;
	}
	
	public void setNeighbor(int value)
	{
		this.neighbors = 0;
	}
	
	public void addNeigbor()
	{
		this.neighbors++;
	}
	
	public void setLife(int value)
	{
		this.alive = value;
	}
	
	public int getLife()
	{
		return alive;
	}
	
	public int getNeighbors()
	{
		return neighbors;
	}
	
	public void run() 
	{
		try
		{
			Thread.sleep(100);
		}catch(Exception e)
		{
			
		}
	}

}
