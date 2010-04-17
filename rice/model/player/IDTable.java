package rice.model.player;

public class IDTable {
	private boolean[] ids;
	
	public IDTable(int size)
	{
		boolean[] ids=new boolean[size];
		for(boolean id : ids)
		{
			id=false;
		}
	}
	
	//acquire first free id, return -1 if no free id
	public int acquireFirstFreeID()
	{
		for(int i=0;i<this.ids.length;i++)
		{
			if(ids[i]=false)
			{
				ids[i]=true;
				return i;
			}
		}
		return -1;
	}
	
	//relealse id
	public void releaseID(int id)
	{
		if(id<ids.length)
		{
			ids[id]=false;
		}
	}
}
