package rice.util;

public class Position {
	private int posX;
	private int posY;
	
	public Position()
	{
		this(0,0);
	}
	
	public Position(int x, int y)
	{
		this.setX(x);
		this.setY(y);
	}
	
	public Position(Position position)
	{
		this.setX(position.getX());
		this.setY(position.getY());
	}
	
	public int getX()
	{
		return this.posX;
	}
	
	public int getY()
	{
		return this.posY;
	}
	
	public void setX(int x)
	{
		this.posX=x;
	}
	
	public void setY(int y)
	{
		this.posY=y;
	}
	
	public void set(int x, int y)
	{
		this.setX(x);
		this.setY(y);
	}
	
	public void set(Position position)
	{
		this.setX(position.getX());
		this.setY(position.getY());
	}	

}
