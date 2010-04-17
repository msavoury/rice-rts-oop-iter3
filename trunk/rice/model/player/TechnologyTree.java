package rice.model.player;

import java.util.HashMap;

public abstract class TechnologyTree
{
	private HashMap<String,HashMap<String,TechNode>> techBranches = new HashMap<String,HashMap<String,TechNode>>();
	
	public TechnologyTree()
	{
		
	}
	
	//adds a new branch to the three
	public void addBranch(String branch)
	{
		HashMap<String,TechNode> newBranch = new HashMap<String,TechNode>();
		if(!this.techBranches.containsKey(branch))
		{
			this.techBranches.put(branch, newBranch);
		}
	}
	
	//adds a new TechNode to a specific branch of the three
	public void addTechNode(String branch, TechNode techNode)
	{
		if(!this.techBranches.containsKey(branch))
		{
			this.addBranch(branch);
		}
		HashMap<String,TechNode> techBranch = this.techBranches.get(branch);
		techBranch.put(techNode.getName(), techNode);
	}
	
	//returns the specific research
	public TechNode getTechnology(String branch, String tech)
	{
		HashMap<String,TechNode> techBranch = this.techBranches.get(branch);
		if(techBranch!=null)
		{
			return techBranch.get(tech);
		}
		return null;
	}
	
	//returns the specific bonus
	public int getBonus(String branch, String tech)
	{
		HashMap<String,TechNode> techBranch = this.techBranches.get(branch);
		if(techBranch!=null)
		{
			TechNode techNode = techBranch.get(tech);
			if(techNode!=null)
			{
				return techNode.getBonus();
			}
		}
		return 0;
	}

}
