package rice.model.player;

public class Player {

	//static members
	private static int playerCount = 1;
	
	//instance members
	private int id;
	
	public Player(){
		this.id = playerCount;
		playerCount++;
	}
	
	public void tick() {
		System.out.println("Player "+ id + " ticked");
	}
}
