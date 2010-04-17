package rice.model.player;

import java.util.HashMap;

public class IDHashMap
{
	HashMap<String,IDTable> idMap = new HashMap<String,IDTable>();
	
	public IDHashMap()
	{
		
	}
	
	//add a new id table to the map, replace old if tableName already in use
	public void addIDTable(String tableName, int limit)
	{
		this.idMap.put(tableName, new IDTable(limit));
	}
	
	//acquire first free id, return -1 if no free id
	public int acquireFirstFreeID(String tableName)
	{
		IDTable idt = this.idMap.get(tableName);
		if(idt!=null)
		{
			return idt.acquireFirstFreeID();
		}
		return -1;
	}
	
	//relealse id
	public void releaseID(String tableName, int id)
	{
		IDTable idt = this.idMap.get(tableName);
		if(idt!=null)
		{
			idt.releaseID(id);
		}
	}
}
