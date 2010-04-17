package rice.model.map;

import java.util.ArrayList;
import java.util.List;

import util.Position;

public class HexTranslator extends MapPositionTranslator
{	
	public static final int UP_RIGHT = 0;
	public static final int UP = 1;
	public static final int UP_LEFT = 2;
	public static final int DOWN_LEFT = 3;
	public static final int DOWN = 4;
	public static final int DOWN_RIGHT = 5;
	public static final int DIR_COUNT = 6;
	
	public HexTranslator(Map map)
	{
		super(map);
	}


	
	//return direction depending angle
	public int getDirection(double angle)
	{
		return ((int)angle % 360)/60;
	}
	
	//return adjacent position depending on current position and angle
	public Position getAdjecentPosition(Position position, double angle)
	{
		return	this.getAdjecentPosition(position,this.getDirection(angle));	
	}

	//return adjacent position depending on current position and direction
	public Position getAdjecentPosition(Position position, int direction)
	{
		Position newPosition = new Position();
		switch (direction)
		{
		case UP_RIGHT:
			newPosition.setX(position.getX()+1);
			newPosition.setY(((position.getX() % 2)==0 ? position.getY()-1 : position.getY()));
		case UP:
			newPosition.setX(position.getX());
			newPosition.setY(position.getY()-1);
		case UP_LEFT:
			newPosition.setX(position.getX()-1);
			newPosition.setY(((position.getX() % 2)==0 ? position.getY()-1 : position.getY()));
		case DOWN_LEFT:
			newPosition.setX(position.getX()-1);
			newPosition.setY(((position.getX() % 2)==1 ? position.getY()+1 : position.getY()));
		case DOWN:
			newPosition.setX(position.getX());
			newPosition.setY(position.getY()+1);
		case DOWN_RIGHT:
			newPosition.setX(position.getX()+1);
			newPosition.setY(((position.getX() % 2)==1 ? position.getY()+1 : position.getY()));
		default:
			newPosition.set(position);
		}
		return newPosition;
	}
	
	//return a list of valid positions surrounding the origin with a certain radius
	public List<Position> getPositionRing(Position origin, int radius)
	{
		List<Position> posiotions = new ArrayList<Position>();
		Position newPosition = new Position();
		newPosition.setX(origin.getX());
		newPosition.setY(origin.getY()+radius);
		
		for(int i=0;i<DIR_COUNT;i++)
		{
			for(int j=0;j<=radius;j++)
			{
				newPosition = this.getAdjecentPosition(newPosition, i);
				if(this.verifyLocation(newPosition))
				{
					posiotions.add(newPosition);
				}
			}
		}		
		
		return posiotions;
	}

}
