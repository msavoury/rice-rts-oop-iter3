package rice.model.player;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;

public class SelectorNode<T>
{
	private String branchName;
	private T element;
	private LinkedList<SelectorNode<T>> children = new LinkedList<SelectorNode<T>>();
	private SelectorNode<T> selection;
	
	public SelectorNode(String branchName)
	{
		this.branchName=branchName;
	}
	
	public SelectorNode(T element)
	{
		this.element=element;
	}
	
	public String getBranchName()
	{
		return this.branchName;
	}
	
	public List<String> getBranchPath()
	{
		List<String> branchPath = new ArrayList<String>();
			if(this.getBranchName()!=null && !this.getBranchName().isEmpty())
			{
				branchPath.add(this.getBranchName());
			}
			if(!this.isLeaf())
			{
				branchPath.addAll(this.selection.getBranchPath());
			}
	
		return branchPath;
	}
	
	//adds a new child node, if node already exists, does nothing
	public void addChild(SelectorNode<T> child)
	{
		if(!this.children.contains(child))
		{
			if(this.selection==null)
			{
				this.selection=child;
			}
			this.children.add(child);
		}
	}
	
	//removes a child node
	public void removeChild(SelectorNode<T> child)
	{
		if(this.selection.equals(child))
		{
			this.selectPrev();
		}
		this.children.remove(child);
	}
	
	//removes all children at once
	public void removeAllChildren()
	{
		this.children.clear();
		this.selection=null;
	}
	
	//removes a child node, returns true if a node was removed
	public boolean removeChild(T element)
	{
		Iterator<SelectorNode<T>> iter = this.children.iterator(); 
		while(iter.hasNext())
		{
			if(iter.next().getElement().equals(element))
			{
				this.selectPrev();
				iter.remove();
				return true;
			}
		}	
		return false;
	}
	
	//return true if this node is a leaf
	public boolean isLeaf()
	{		
		return (this.children.size()==0);
	}
	
	//returns the element
	public T getElement()
	{
		return this.element;
	}
	
	//sets the element
	public void setElement(T element)
	{
		this.element=element;
	}
	
	//select the first node
	public void selectFirst()
	{
		if(this.children.size()>0)
		{
			this.selection=this.children.getFirst();
		}
		else
		{
			this.selection=null;
		}
	}
	
	//select the last node
	public void selectLast()
	{
		if(this.children.size()>0)
		{
			this.selection=this.children.getLast();
		}
		else
		{
			this.selection=null;
		}
	}
	
	//returns true if the selected node is the first node in the list
	public boolean isFirstSelected()
	{
		if(this.children.size()==0)
		{
			return true;
		}
		else
		{
			return this.selection.equals(this.children.getFirst());
		}
	}
	
	//returns true if the selected node is the first node in the list
	public boolean isLastSelected()
	{
		if(this.children.size()==0)
		{
			return true;
		}
		else
		{
			return this.selection.equals(this.children.getLast());
		}
	}
	
	//select next node
	public void selectNext()
	{
		if(this.children.size()>0)
		{
			int index = this.children.indexOf(this.selection);
			index++;
			if(index>=this.children.size())
			{
				index=0;
			}
			this.selection=this.children.get(index);
		}
		else
		{
			this.selection=null;
		}
	}
	
	//select next node
	public void selectPrev()
	{
		if(this.children.size()>0)
		{
			int index = this.children.indexOf(this.selection);
			index--;
			if(index<0)
			{
				index=this.children.size()-1;
			}
			this.selection=this.children.get(index);
		}
		else
		{
			this.selection=null;
		}
	}
	
	//select next node at certain level
	public void selectNext(int level)
	{
		if(this.selection.isLeaf() || (level<=0))
		{
			
			this.selectNext();
			
				for(int i=0;i<this.children.size();i++)
				{
					if(this.selection.getAllLeafCount()==0)
					{					
						this.selectNext();
					}
					else
					{
						break;
					}
				}
			if(this.selection.getSelectedLeaf()==null)
			{
				this.selection.selectNextLeaf();
			}
		}
		else
		{
			for(int i=0;i<this.getAllLeafCount();i++)
			{
				this.selection.selectNext(level-1);
				if(this.selection.getAllLeafCount()>0)
				{
					return;
				}
			}
			this.selectNextLeaf();
		}		
	}
	
	//select prev node at certain level
	public void selectPrev(int level)
	{
		if(this.selection.isLeaf() || (level<=0))
		{
			
			this.selectPrev();			
				for(int i=0;i<this.children.size();i++)
				{
					if(this.selection.getAllLeafCount()==0)
					{					
						this.selectPrev();
					}
					else
					{
						break;
					}
				}
			if(this.selection.getSelectedLeaf()==null)
			{
				this.selection.selectPrevLeaf();
			}
		}
		else
		{
			for(int i=0;i<this.getAllLeafCount();i++)
			{
				this.selection.selectPrev(level-1);
				if(this.selection.getAllLeafCount()>0)
				{
					return;
				}
			}
			this.selectPrevLeaf();
		}		
	}
	
	//selects the next leaf
	public boolean selectNextLeaf()
	{
		if(this.isLeaf())
		{
			return true;
		}
		
		if(this.getAllLeafCount()==0)
		{
			return true;
		}
		
		if(this.selection.getAllLeafCount()!=0)
		{
			if(this.selection.selectNextLeaf())
			{
				this.selectNext();
				this.selection.selectFirst();
				if(this.selection.getAllLeafCount()>0)
				{
					return this.isFirstSelected();
				}	
			}	
			else
			{
				return false;
			}
		}

		if(this.selection.getAllLeafCount()==0)
		{
			for(int i=0; i<this.children.size();i++)
			{
				if(this.selection.getAllLeafCount()==0)
				{
					this.selectNext();
					this.selection.selectFirst();					
				}
				else
				{
					return false;				
				}					
			}	
		}
		return true;
	}
	
	//selects the next leaf
	public boolean selectPrevLeaf()
	{
		if(this.isLeaf())
		{
			return true;
		}
		
		if(this.getAllLeafCount()==0)
		{
			return true;
		}
		
		if(this.selection.getAllLeafCount()!=0)
		{
			if(this.selection.selectPrevLeaf())
			{
				this.selectPrev();
				this.selection.selectLast();
				if(this.selection.getAllLeafCount()>0)
				{
					return this.isLastSelected();
				}	
			}	
			else
			{
				return false;
			}
		}

		if(this.selection.getAllLeafCount()==0)
		{
			for(int i=0; i<this.children.size();i++)
			{
				if(this.selection.getAllLeafCount()==0)
				{
					this.selectPrev();
					this.selection.selectLast();					
				}
				else
				{
					return false;				
				}					
			}	
		}
		return true;
	}
	
	public int getAllLeafCount()
	{
		return this.getAllLeafs().size();
	}
	
	public List<T> getAllLeafs()
	{
		ArrayList<T> leafs = new ArrayList<T>();
		if(this.isLeaf() && (this.getElement() !=null))
		{
			leafs.add(this.getElement());
		}
		else
		{
			Iterator<SelectorNode<T>> iter = this.children.iterator();
			while(iter.hasNext())
			{
				leafs.addAll(iter.next().getAllLeafs());
			}			
		}
		return leafs;
	}
	
	//gets the current selection
	public T getSelectedLeaf()
	{
		if(this.isLeaf())
		{
			return this.getElement();
		}
		else
		{
			if(this.selection.getSelectedLeaf()==null)
			{
				//this.selectNextLeaf();
			}			
			return this.selection.getSelectedLeaf();
		}
	}
}
