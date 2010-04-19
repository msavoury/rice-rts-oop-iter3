package rice.model.map;

import java.util.ArrayList;
import java.util.List;

import rice.util.Position;


public class HexTranslator extends MapPositionTranslator
{	
	public static final int UP_RIGHT = 0;
	public static final int UP = 1;
	public static final int UP_LEFT = 2;
	public static final int DOWN_LEFT = 3;
	public static final int DOWN = 4;
	public static final int DOWN_RIGHT = 5;
	public static final int DIR_COUNT = 6;
	
	public HexTranslator()
	{
		
	}

	public int getDirectionCount()
	{
		return DIR_COUNT;
	}
	
	public int getOptimalDirection(Position origin, Position destination)
	{
		return this.getDirection(this.getOptimalAngle(origin, destination));
	}
	
	private double getOptimalAngle(Position origin, Position destination)
	{
		Position diff = new Position(origin.getX()-destination.getX(),destination.getX()-origin.getX());
		double angle = Math.atan2((double)diff.getX(), (double)diff.getY())*(180/Math.PI);
		if(angle<0)
		{
			angle+=360;
		}
		return angle;
	}
	
	//return direction depending angle
	public int getDirection(double angle)
	{
		return ((int)angle % 360)/60;
	}
	
	//return adjacent position depending on current position and direction
	public Position getAdjecentPosition(Position position, int direction)
	{
		//System.out.println("Old position is " + position.getX() + "," + position.getY()+ ". Direction is " + direction);
		Position newPosition = new Position();
		switch (direction)
		{
		case UP_RIGHT:
			newPosition.setX(position.getX()+1);
			newPosition.setY(((position.getX() % 2)==0 ? position.getY()-1 : position.getY()));
			break;
		case UP:
			//System.out.println("case up");
			newPosition.setX(position.getX());
			newPosition.setY(position.getY()-1);
			break;
		case UP_LEFT:
			newPosition.setX(position.getX()-1);
			newPosition.setY(((position.getX() % 2)==0 ? position.getY()-1 : position.getY()));
			break;
		case DOWN_LEFT:
			newPosition.setX(position.getX()-1);
			newPosition.setY(((position.getX() % 2)==1 ? position.getY()+1 : position.getY()));
			break;
		case DOWN:
			newPosition.setX(position.getX());
			newPosition.setY(position.getY()+1);
			break;
		case DOWN_RIGHT:
			newPosition.setX(position.getX()+1);
			newPosition.setY(((position.getX() % 2)==1 ? position.getY()+1 : position.getY()));
			break;
		default:
			newPosition.set(position);
		}
		//System.out.println("New position is " + newPosition.getX() + "," + newPosition.getY());

		return newPosition;
	}
	
	public Position getAdjacentPosition(Position position, int direction)
	{
		//System.out.println("Old position is " + position.getX() + "," + position.getY()+ ". Direction is " + direction);
		Position newPosition = new Position();
		String help = "none";
		switch (direction){
		
		}
		switch (direction)
		{
		
		}
		//System.out.println("New position is " + newPosition.getX() + "," + newPosition.getY());

		return newPosition;
	}
	
	//return a list of valid positions in an area surrounding the origin with a certain radius
	public List<Position> getPositionArea(Position origin, int radius)
	{
		List<Position> posiotions = new ArrayList<Position>();
		for (int i=0; i<=radius; i++)
		{
			posiotions.addAll(this.getPositionRing(origin,i));
		}
		return posiotions;
	}
	
	//return a list of valid positions surrounding the origin with a certain radius
	public List<Position> getPositionRing(Position origin, int radius)
	{
		List<Position> posiotions = new ArrayList<Position>();
		Position newPosition = new Position(origin);
			if(radius>0)
			{
			newPosition.setX(origin.getX());
			newPosition.setY(origin.getY()+radius);
			
			for(int i=0;i<DIR_COUNT;i++)
			{
				for(int j=0;j<radius;j++)
				{
					newPosition = this.getAdjecentPosition(newPosition, i);
					if(this.verifyLocation(newPosition))
					{
						posiotions.add(newPosition);
					}
				}
			}			
		}
		else
		{
			posiotions.add(newPosition);
		}
		return posiotions;
	}

	/**
	 * Convert string like NORTH to the necessary constant
	 * @param s
	 * @return
	 */
	public int convertToDirection(String direction) {
        int result = UP;
		
		if (direction.equals("NORTH"))
		  result = UP;
		else if (direction.equals("NORTHWEST"))
		  result = UP_LEFT;
		else if (direction.equals("NORTHEAST"))
		  result = UP_RIGHT;
		else if (direction.equals("SOUTHWEST"))
		  result = DOWN_LEFT;
		else if (direction.equals("SOUTHEAST"))
		  result = DOWN_RIGHT;
		else if (direction.equals("SOUTH"))
		  result = DOWN;
		System.out.println("translated " + direction + "to " + result);
		
		return result;
	}

}
