

public class GameLL {
	private class ListNode
	{
		Game data;
		ListNode link;
		public ListNode(Game aData, ListNode aLink) 
		{
			data = aData;
			link = aLink;
		}
	}
	private ListNode head;//First Element
	private ListNode current;//Current node of interest
	private ListNode previous;//One node behind current
	
	public GameLL() 
	{
		head = current = previous = null;
	}
	public void add(Game aData) 
	{
		ListNode newNode = new ListNode(aData,null);
		if(head == null) //Empty list
		{
			head = current = newNode;
			return;
		}
		ListNode temp = head;
		while(temp.link != null) 
			temp = temp.link;
		temp.link = newNode;
	}
	public void addAfterCurrent(Game aData) 
	{
		if(current == null)
			return;
		ListNode newNode = new ListNode(aData, current.link);
		current.link = newNode;
	}
	public void print() 
	{
		ListNode temp = head;
		while(temp != null) 
		{
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
	public Game getCurrent() 
	{
		if(current != null)
			return null;
		return current.data;
	}
	public void setCurrent(Game aData) 
	{
		if(current == null)
			return;
		current.data = aData;
	}
	public void gotoNext() 
	{
		if(current != null) 
		{
			previous = current;
			current = current.link;
		}
	}
	public boolean hasMore() 
	{
		return current != null;
	}
	public void reset() 
	{
		current = head;
		previous = null;
	}
	public void removeCurrent() 
	{
		if(current != null && previous != null) 
		{
			previous.link = current.link;
			current = current.link;
		}
		else if(current != null && previous == null) 
		{
			head = head.link;
			current = head;
		}
	}
}
