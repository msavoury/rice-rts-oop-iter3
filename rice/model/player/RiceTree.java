package rice.model.player;

import java.util.ArrayList;
import java.util.Collection;

public class RiceTree extends TechnologyTree
{
	private ArrayList<String> branches=new ArrayList<String>();
	private int selectedBranch=0;
	private int selectedTech=0;
	
	public RiceTree()
	{
		this.branches.add("Worker");
		this.addTechNode("Worker", new TechNode("Work Radius", 0, 10, 1));
		this.addTechNode("Worker", new TechNode("Worker Density", 0, 10, 5));
		this.addTechNode("Worker", new TechNode("Ore production rate", 0, 10, 5));
		this.addTechNode("Worker", new TechNode("Food production rate", 0, 10, 5));
		this.addTechNode("Worker", new TechNode("Energy production rate", 0, 10, 5));
		this.addTechNode("Worker", new TechNode("Research rate", 0, 10, 5));
		this.addTechNode("Worker", new TechNode("Breeding rate", 0, 10, 5));
		
		this.branches.add("Explorer");
		this.addTechNode("Explorer", new TechNode("Visibility Radius", 0, 10, 1));
		this.addTechNode("Explorer", new TechNode("Attack", 0, 10, 5));
		this.addTechNode("Explorer", new TechNode("Defense", 0, 10, 5));
		this.addTechNode("Explorer", new TechNode("Armor", 0, 10, 5));
		this.addTechNode("Explorer", new TechNode("Movement Speed", 0, 10, 5));
		this.addTechNode("Explorer", new TechNode("Health", 0, 10, 5));
		this.addTechNode("Explorer",new TechNode( "Efficiency", 0, 10, 5));
		
		this.branches.add("Colonist");
		this.addTechNode("Colonist", new TechNode("Visibility Radius", 0, 10, 1));
		this.addTechNode("Colonist", new TechNode("Attack", 0, 10, 5));
		this.addTechNode("Colonist", new TechNode("Defense", 0, 10, 5));
		this.addTechNode("Colonist", new TechNode("Armor", 0, 10, 5));
		this.addTechNode("Colonist", new TechNode("Movement Speed", 0, 10, 5));
		this.addTechNode("Colonist", new TechNode("Health", 0, 10, 5));
		this.addTechNode("Colonist",new TechNode( "Efficiency", 0, 10, 5));
		
		this.branches.add("Melee");
		this.addTechNode("Melee", new TechNode("Visibility Radius", 0, 10, 1));
		this.addTechNode("Melee", new TechNode("Attack", 0, 10, 5));
		this.addTechNode("Melee", new TechNode("Defense", 0, 10, 5));
		this.addTechNode("Melee", new TechNode("Armor", 0, 10, 5));
		this.addTechNode("Melee", new TechNode("Movement Speed", 0, 10, 5));
		this.addTechNode("Melee", new TechNode("Health", 0, 10, 5));
		this.addTechNode("Melee",new TechNode( "Efficiency", 0, 10, 5));
		
		this.branches.add("Ranged");
		this.addTechNode("Ranged", new TechNode("Visibility Radius", 0, 10, 1));
		this.addTechNode("Ranged", new TechNode("Attack", 0, 10, 5));
		this.addTechNode("Ranged", new TechNode("Defense", 0, 10, 5));
		this.addTechNode("Ranged", new TechNode("Armor", 0, 10, 5));
		this.addTechNode("Ranged", new TechNode("Movement Speed", 0, 10, 5));
		this.addTechNode("Ranged", new TechNode("Health", 0, 10, 5));
		this.addTechNode("Ranged",new TechNode( "Efficiency", 0, 10, 5));
		
		this.branches.add("Bulldozer");
		this.addTechNode("Bulldozer", new TechNode("Visibility Radius", 0, 10, 1));
		this.addTechNode("Bulldozer", new TechNode("Attack", 0, 10, 5));
		this.addTechNode("Bulldozer", new TechNode("Defense", 0, 10, 5));
		this.addTechNode("Bulldozer", new TechNode("Armor", 0, 10, 5));
		this.addTechNode("Bulldozer", new TechNode("Movement Speed", 0, 10, 5));
		this.addTechNode("Bulldozer", new TechNode("Health", 0, 10, 5));
		this.addTechNode("Bulldozer",new TechNode( "Efficiency", 0, 10, 5));
		
		this.branches.add("Transporter");
		this.addTechNode("Transporter", new TechNode("Visibility Radius", 0, 10, 1));
		this.addTechNode("Transporter", new TechNode("Attack", 0, 10, 5));
		this.addTechNode("Transporter", new TechNode("Defense", 0, 10, 5));
		this.addTechNode("Transporter", new TechNode("Armor", 0, 10, 5));
		this.addTechNode("Transporter", new TechNode("Movement Speed", 0, 10, 5));
		this.addTechNode("Transporter", new TechNode("Health", 0, 10, 5));
		this.addTechNode("Transporter",new TechNode( "Efficiency", 0, 10, 5));
		
		this.branches.add("Capital");
		this.addTechNode("Capital", new TechNode("Visibility Radius", 0, 10, 1));
		this.addTechNode("Capital", new TechNode("Defense", 0, 10, 5));
		this.addTechNode("Capital", new TechNode("Armor", 0, 10, 5));
		this.addTechNode("Capital", new TechNode("Health", 0, 10, 5));
		this.addTechNode("Capital",new TechNode( "Efficiency", 0, 10, 5));
		
		this.branches.add("Mine");
		this.addTechNode("Mine", new TechNode("Visibility Radius", 0, 10, 1));
		this.addTechNode("Mine", new TechNode("Defense", 0, 10, 5));
		this.addTechNode("Mine", new TechNode("Armor", 0, 10, 5));
		this.addTechNode("Mine", new TechNode("Health", 0, 10, 5));
		this.addTechNode("Mine",new TechNode( "Efficiency", 0, 10, 5));
		
		this.branches.add("Farm");
		this.addTechNode("Farm", new TechNode("Visibility Radius", 0, 10, 1));
		this.addTechNode("Farm", new TechNode("Defense", 0, 10, 5));
		this.addTechNode("Farm", new TechNode("Armor", 0, 10, 5));
		this.addTechNode("Farm", new TechNode("Health", 0, 10, 5));
		this.addTechNode("Farm",new TechNode( "Efficiency", 0, 10, 5));
		
		this.branches.add("PowerPlant");
		this.addTechNode("PowerPlant", new TechNode("Visibility Radius", 0, 10, 1));
		this.addTechNode("PowerPlant", new TechNode("Defense", 0, 10, 5));
		this.addTechNode("PowerPlant", new TechNode("Armor", 0, 10, 5));
		this.addTechNode("PowerPlant", new TechNode("Health", 0, 10, 5));
		this.addTechNode("PowerPlant",new TechNode( "Efficiency", 0, 10, 5));
		
		this.branches.add("PowerPlant");
		this.addTechNode("PowerPlant", new TechNode("Visibility Radius", 0, 10, 1));
		this.addTechNode("PowerPlant", new TechNode("Defense", 0, 10, 5));
		this.addTechNode("PowerPlant", new TechNode("Armor", 0, 10, 5));
		this.addTechNode("PowerPlant", new TechNode("Health", 0, 10, 5));
		this.addTechNode("PowerPlant",new TechNode( "Efficiency", 0, 10, 5));
		
		this.branches.add("ObservatoryTower");
		this.addTechNode("ObservatoryTower", new TechNode("Visibility Radius", 0, 10, 1));
		this.addTechNode("ObservatoryTower", new TechNode("Defense", 0, 10, 5));
		this.addTechNode("ObservatoryTower", new TechNode("Armor", 0, 10, 5));
		this.addTechNode("ObservatoryTower", new TechNode("Health", 0, 10, 5));
		this.addTechNode("ObservatoryTower",new TechNode( "Efficiency", 0, 10, 5));
		
		this.branches.add("University");
		this.addTechNode("University", new TechNode("Visibility Radius", 0, 10, 1));
		this.addTechNode("University", new TechNode("Defense", 0, 10, 5));
		this.addTechNode("University", new TechNode("Armor", 0, 10, 5));
		this.addTechNode("University", new TechNode("Health", 0, 10, 5));
		this.addTechNode("University",new TechNode( "Efficiency", 0, 10, 5));
		
		this.branches.add("Fort");
		this.addTechNode("Fort", new TechNode("Visibility Radius", 0, 10, 1));
		this.addTechNode("Fort", new TechNode("Attack", 0, 10, 5));
		this.addTechNode("Fort", new TechNode("Defense", 0, 10, 5));
		this.addTechNode("Fort", new TechNode("Armor", 0, 10, 5));
		this.addTechNode("Fort", new TechNode("Health", 0, 10, 5));
		this.addTechNode("Fort",new TechNode( "Efficiency", 0, 10, 5));		
	}
	
	public void selectNextBranch()
	{
		this.selectedTech=0;
		this.selectedBranch++;
		if(this.selectedBranch>=this.branches.size())
		{
			this.selectedBranch=0;
		}
	}
	
	public void selectPrevBranch()
	{
		this.selectedTech=0;
		this.selectedBranch--;
		if(this.selectedBranch<=0)
		{
			this.selectedBranch=this.branches.size()-1;
		}
	}
	
	public void selectNextTech()
	{
		this.selectedTech++;
		if(this.selectedTech>=this.getSelectedBranch().size())
		{
			this.selectedTech=0;
		}
	}
	
	public void selectPrevTech()
	{
		this.selectedTech--;
		if(this.selectedTech<=0)
		{
			this.selectedTech=this.getSelectedBranch().size()-1;
		}
	}
	
	public Collection<TechNode> getSelectedBranch()
	{
		return this.getBranch(this.branches.get(this.selectedBranch));
	}
}
