package rice.model.player;

import rice.model.structures.University;

public class TechNode {
	private String name;
	private int currentLevel;
	private int maxLevel;
	private int modifier;
	private double levelOfCompletion;
	private University university;
	
	public TechNode(String name, int startLevel, int maxLevel, int modifier)
	{
		this.name=name;
		this.currentLevel=startLevel;
		this.maxLevel=maxLevel;
		this.modifier=modifier;
		this.levelOfCompletion=0;
		this.university=null;
	}
	
	//returns the name of the technology
	public String getName()
	{
		return this.name;
	}
	
	//returns the bonus of this technology
	public int getBonus()
	{
		return this.currentLevel*this.modifier;
	}
	
	//increases the completion level and current level, returns true if max level is reached
	public boolean increaseCompletionLevel(double value)
	{		
		this.levelOfCompletion+=value;
		if(this.levelOfCompletion>=100)
		{
			this.levelOfCompletion=0;
			this.currentLevel++;
			if(this.currentLevel>this.maxLevel)
			{
				this.currentLevel=this.maxLevel;
				return true;
			}
		}
		return false;		
	}
	
	//return assigned university
	public University getUniversity()
	{
		return this.university;
	}
	
	//try to assign university, if successful return true
	public boolean assignUniversity(University university)
	{
		if(this.university==null)
		{
			this.university=university;
			return true;
		}
		return false;
	}
	
	//unassigns university
	public void unassignUniversity()
	{
		this.university=null;
	}	
	
	//returns whether the technology is available to be researched
	public boolean isAvailible()
	{
		return ((this.currentLevel<this.maxLevel) && (this.university==null));
	}
}
