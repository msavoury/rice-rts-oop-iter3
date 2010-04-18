package rice.model.player;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;

public class SelectorNode<T>
{
	private T element;
	private LinkedList<SelectorNode<T>> children = new LinkedList<SelectorNode<T>>();
	private SelectorNode<T> selection;
	
	public SelectorNode()
	{
		
	}
	
	public SelectorNode(T element)
	{
		this.element=element;
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
		return this.children.size()==0;
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
		this.selection=this.children.getFirst();
	}
	
	//select the last node
	public void selectLast()
	{
		this.selection=this.children.getLast();
	}
	
	//returns true if the selected node is the first node in the list
	public boolean isFirstSelected()
	{
		return this.selection.equals(this.children.getFirst());
	}
	
	//returns true if the selected node is the first node in the list
	public boolean isLastSelected()
	{
		return this.selection.equals(this.children.getLast());
	}
	
	//select next node
	public void selectNext()
	{
		int index = this.children.indexOf(this.selection);
		index++;
		if(index>this.children.size())
		{
			index=0;
		}
		this.selection=this.children.get(index);
	}
	
	//select next node
	public void selectPrev()
	{
		int index = this.children.indexOf(this.selection);
		index--;
		if(index<0)
		{
			index=this.children.size()-1;
		}
		this.selection=this.children.get(index);
	}
	
	//select next node at certain level
	public void selectNext(int level)
	{
		if(this.isLeaf() || (level<=0))
		{
			this.selectNext();
		}
		else
		{
			this.selection.selectNext(level-1);
		}		
	}
	
	//select next node at certain level
	public void selectPrev(int level)
	{
		if(this.isLeaf() || (level<=0))
		{
			this.selectPrev();
		}
		else
		{
			this.selection.selectPrev(level-1);
		}	
	}
	
	//selects the next leaf
	public boolean selectNextLeaf()
	{
		if(this.isLeaf())
		{
			this.selectNext();
			return this.isFirstSelected();
		}
		else
		{
			if(this.selection.selectNextLeaf())
			{
				this.selectNext();
				this.selection.selectFirst();
				return this.isFirstSelected();
			}
		}
		return false;
	}
	
	//selects the previous leaf
	public boolean selectPrevLeaf()
	{
		if(this.isLeaf())
		{
			this.selectPrev();
			return this.isLastSelected();
		}
		else
		{
			if(this.selection.selectPrevLeaf())
			{
				this.selectPrev();
				this.selection.selectLast();
				return this.isLastSelected();
			}
		}
		return false;
	}
	
	private int getAllLeafCount()
	{
		return this.getAllLeafs().size();
	}
	
	public List<T> getAllLeafs()
	{
		ArrayList<T> leafs = new ArrayList<T>();
		if(this.isLeaf() && this.getElement() != null)
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
			return this.selection.getSelectedLeaf();
		}
	}
}
