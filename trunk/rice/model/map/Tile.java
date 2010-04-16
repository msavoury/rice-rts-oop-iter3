package rice.model.map;

public abstract class Tile
{
	private int posX;
	private int posY;
	
	Tile(int x, int y)
	{
		this.posX=x;
		this.posY=y;
	}
}
