package rice.model.player;

public class RiceTree extends TechnologyTree
{
	public RiceTree()
	{
		this.addTechNode("Worker", new TechNode("Work Radius", 0, 10, 1));
		this.addTechNode("Worker", new TechNode("Worker Density", 0, 10, 5));
		this.addTechNode("Worker", new TechNode("Ore production rate", 0, 10, 5));
		this.addTechNode("Worker", new TechNode("Food production rate", 0, 10, 5));
		this.addTechNode("Worker", new TechNode("Energy production rate", 0, 10, 5));
		this.addTechNode("Worker", new TechNode("Research rate", 0, 10, 5));
		this.addTechNode("Worker", new TechNode("Breeding rate", 0, 10, 5));
		
		this.addTechNode("Explorer", new TechNode("Visibility Radius", 0, 10, 1));
		this.addTechNode("Explorer", new TechNode("Attack", 0, 10, 5));
		this.addTechNode("Explorer", new TechNode("Defense", 0, 10, 5));
		this.addTechNode("Explorer", new TechNode("Armor", 0, 10, 5));
		this.addTechNode("Explorer", new TechNode("Movement Speed", 0, 10, 5));
		this.addTechNode("Explorer", new TechNode("Health", 0, 10, 5));
		this.addTechNode("Explorer",new TechNode( "Efficiency", 0, 10, 5));
		
		this.addTechNode("Colonist", new TechNode("Visibility Radius", 0, 10, 1));
		this.addTechNode("Colonist", new TechNode("Attack", 0, 10, 5));
		this.addTechNode("Colonist", new TechNode("Defense", 0, 10, 5));
		this.addTechNode("Colonist", new TechNode("Armor", 0, 10, 5));
		this.addTechNode("Colonist", new TechNode("Movement Speed", 0, 10, 5));
		this.addTechNode("Colonist", new TechNode("Health", 0, 10, 5));
		this.addTechNode("Colonist",new TechNode( "Efficiency", 0, 10, 5));
		
		this.addTechNode("Melee", new TechNode("Visibility Radius", 0, 10, 1));
		this.addTechNode("Melee", new TechNode("Attack", 0, 10, 5));
		this.addTechNode("Melee", new TechNode("Defense", 0, 10, 5));
		this.addTechNode("Melee", new TechNode("Armor", 0, 10, 5));
		this.addTechNode("Melee", new TechNode("Movement Speed", 0, 10, 5));
		this.addTechNode("Melee", new TechNode("Health", 0, 10, 5));
		this.addTechNode("Melee",new TechNode( "Efficiency", 0, 10, 5));
		
		this.addTechNode("Range", new TechNode("Visibility Radius", 0, 10, 1));
		this.addTechNode("Range", new TechNode("Attack", 0, 10, 5));
		this.addTechNode("Range", new TechNode("Defense", 0, 10, 5));
		this.addTechNode("Range", new TechNode("Armor", 0, 10, 5));
		this.addTechNode("Range", new TechNode("Movement Speed", 0, 10, 5));
		this.addTechNode("Range", new TechNode("Health", 0, 10, 5));
		this.addTechNode("Range",new TechNode( "Efficiency", 0, 10, 5));
		
		this.addTechNode("Buldozer", new TechNode("Visibility Radius", 0, 10, 1));
		this.addTechNode("Buldozer", new TechNode("Attack", 0, 10, 5));
		this.addTechNode("Buldozer", new TechNode("Defense", 0, 10, 5));
		this.addTechNode("Buldozer", new TechNode("Armor", 0, 10, 5));
		this.addTechNode("Buldozer", new TechNode("Movement Speed", 0, 10, 5));
		this.addTechNode("Buldozer", new TechNode("Health", 0, 10, 5));
		this.addTechNode("Buldozer",new TechNode( "Efficiency", 0, 10, 5));
		
		this.addTechNode("Transporter", new TechNode("Visibility Radius", 0, 10, 1));
		this.addTechNode("Transporter", new TechNode("Attack", 0, 10, 5));
		this.addTechNode("Transporter", new TechNode("Defense", 0, 10, 5));
		this.addTechNode("Transporter", new TechNode("Armor", 0, 10, 5));
		this.addTechNode("Transporter", new TechNode("Movement Speed", 0, 10, 5));
		this.addTechNode("Transporter", new TechNode("Health", 0, 10, 5));
		this.addTechNode("Transporter",new TechNode( "Efficiency", 0, 10, 5));
		
		
		this.addTechNode("Capital", new TechNode("Visibility Radius", 0, 10, 1));
		this.addTechNode("Capital", new TechNode("Defense", 0, 10, 5));
		this.addTechNode("Capital", new TechNode("Armor", 0, 10, 5));
		this.addTechNode("Capital", new TechNode("Health", 0, 10, 5));
		this.addTechNode("Capital",new TechNode( "Efficiency", 0, 10, 5));
		
		this.addTechNode("Mine", new TechNode("Visibility Radius", 0, 10, 1));
		this.addTechNode("Mine", new TechNode("Defense", 0, 10, 5));
		this.addTechNode("Mine", new TechNode("Armor", 0, 10, 5));
		this.addTechNode("Mine", new TechNode("Health", 0, 10, 5));
		this.addTechNode("Mine",new TechNode( "Efficiency", 0, 10, 5));
		
		this.addTechNode("Farm", new TechNode("Visibility Radius", 0, 10, 1));
		this.addTechNode("Farm", new TechNode("Defense", 0, 10, 5));
		this.addTechNode("Farm", new TechNode("Armor", 0, 10, 5));
		this.addTechNode("Farm", new TechNode("Health", 0, 10, 5));
		this.addTechNode("Farm",new TechNode( "Efficiency", 0, 10, 5));
		
		this.addTechNode("PowerPlant", new TechNode("Visibility Radius", 0, 10, 1));
		this.addTechNode("PowerPlant", new TechNode("Defense", 0, 10, 5));
		this.addTechNode("PowerPlant", new TechNode("Armor", 0, 10, 5));
		this.addTechNode("PowerPlant", new TechNode("Health", 0, 10, 5));
		this.addTechNode("PowerPlant",new TechNode( "Efficiency", 0, 10, 5));
		
		this.addTechNode("PowerPlant", new TechNode("Visibility Radius", 0, 10, 1));
		this.addTechNode("PowerPlant", new TechNode("Defense", 0, 10, 5));
		this.addTechNode("PowerPlant", new TechNode("Armor", 0, 10, 5));
		this.addTechNode("PowerPlant", new TechNode("Health", 0, 10, 5));
		this.addTechNode("PowerPlant",new TechNode( "Efficiency", 0, 10, 5));
		
		this.addTechNode("ObservatoryTower", new TechNode("Visibility Radius", 0, 10, 1));
		this.addTechNode("ObservatoryTower", new TechNode("Defense", 0, 10, 5));
		this.addTechNode("ObservatoryTower", new TechNode("Armor", 0, 10, 5));
		this.addTechNode("ObservatoryTower", new TechNode("Health", 0, 10, 5));
		this.addTechNode("ObservatoryTower",new TechNode( "Efficiency", 0, 10, 5));
		
		this.addTechNode("University", new TechNode("Visibility Radius", 0, 10, 1));
		this.addTechNode("University", new TechNode("Defense", 0, 10, 5));
		this.addTechNode("University", new TechNode("Armor", 0, 10, 5));
		this.addTechNode("University", new TechNode("Health", 0, 10, 5));
		this.addTechNode("University",new TechNode( "Efficiency", 0, 10, 5));
		
		this.addTechNode("Fort", new TechNode("Visibility Radius", 0, 10, 1));
		this.addTechNode("Fort", new TechNode("Attack", 0, 10, 5));
		this.addTechNode("Fort", new TechNode("Defense", 0, 10, 5));
		this.addTechNode("Fort", new TechNode("Armor", 0, 10, 5));
		this.addTechNode("Fort", new TechNode("Health", 0, 10, 5));
		this.addTechNode("Fort",new TechNode( "Efficiency", 0, 10, 5));		
	}
}
