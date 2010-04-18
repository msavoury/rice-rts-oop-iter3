package rice.model.player;

import java.util.HashMap;

public class Selector<T> {
	private SelectorNode<T> mainNode;
	private HashMap<String,SelectorNode<T>> branches = new HashMap<String,SelectorNode<T>>();
	
	public Selector()
	{
		this.mainNode=new SelectorNode<T>();
		this.branches.put("Main", this.mainNode);
	}
	
	//add an empty node to a specific branch
	public SelectorNode<T> addNode(String destBranch, String branch)
	{
		return this.addNode(destBranch, branch, null);
	}
	
	public SelectorNode<T> addNode(String destBranch, T element)
	{
		if(this.branches.containsKey(destBranch))
		{
			//SelectorNode<T> parentNode = this.branches.get(destBranch);
			//SelectorNode<T> newNode=new SelectorNode<T>(element);
		//	parentNode.addChild(newNode);
			//this.branches.put(branch, newNode);
//			return newNode;
		}
		return null;
	}
	
	//add a node to a specific branch
	public SelectorNode<T> addNode(String destBranch, String branch, T element)
	{
		if(this.branches.containsKey(destBranch))
		{
			SelectorNode<T> parentNode = this.branches.get(destBranch);
			SelectorNode<T> newNode=new SelectorNode<T>(element);
			parentNode.addChild(newNode);
			this.branches.put(branch, newNode);
			return newNode;
		}
		return null;
	}
	
	//returns a specific node
	public SelectorNode<T> getNode(String branch)
	{
		if(this.branches.containsKey(branch))
		{
			return this.branches.get(branch);
		}
		return null;
	}
	
	//select next node at certain level
	public void selectNext(int level)
	{
		this.mainNode.selectNext(level);
	}
	
	//select next node at certain level
	public void selectPrev(int level)
	{
		this.mainNode.selectPrev(level);
	}
	
	//gets the current selection
	public T getSelected()
	{
		return this.mainNode.getSelectedLeaf();
	}
}
