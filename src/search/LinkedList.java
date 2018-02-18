package search;

/**
 * LinkedList class to add, 
 * delete, and insert nodes in the list.
 * It is also in charge of always starting with the head,
 * so that we know whether the list can be utilized or not.
 * @author Guest
 *Linked List class that creates the list
 * @param <T> is the type
 */
public class LinkedList <T>
{
	// head is the LinkedListNode because we are starting with head
	private LinkedListNode<T> head;
	
	/**
	 * Get data stored in head node of list.
	 */
	public T getFirst()
	{
		// returns head with the beginning data
		return head.getData();
	}
	 
	/**
	 * Get the head node of the list.
	 */
	public LinkedListNode<T> getFirstNode()
	{
		// returns head because it is the first node all the time
		return head;
	}
	 
	/**
	 * Get data stored in last node of list.
	 */
	public T getLast()
	{
		// returns the last node with the data
		return getLastNode().getData();
	}
	 
	/**
	 * Get the tail node of the list.
	 */
	public LinkedListNode<T> getLastNode()
	{		
		// setting the currentNode to head because we are starting with head
		 LinkedListNode<T> currentNode = new LinkedListNode<T>();
		 
		 // while loop to keep going through the list
		 // it keeps going through the list until it gets to the last node
		 // I will know when it is the last node because the last node is not pointing to anything
		while(currentNode.getNext() != null)
		{
			// the current node is set to get the next node each time
			currentNode = currentNode.getNext();
		}
		// the current node is returned once you get to the last node
		return currentNode;
	}
	 
	/**
	 * Insert a new node with data at the head of the list.
	 */
	public void insertFirst( T data )
	{
		// creates new node of type linked list
		LinkedListNode<T> myNewNode = new LinkedListNode<T>();
		
		// the new node stores the data
		myNewNode.setData(data);
		
		// the new node is the head since the head is the first to begin with
		myNewNode.setNext(head);
		
		// the new node is the head initially
		head = myNewNode;
	}
	 
	/**
	 * Insert a new node with data after currentNode
	 */
	public void insertAfter( LinkedListNode<T> currentNode, T data )
	{
		// setting the currentNode to head because we are starting with head
		LinkedListNode<T> newNode = new LinkedListNode<T>();
		
		// inserting new current node with data
		newNode.setData(data);
		
		// if the currentNode is null make a new node
		if (head == null)
		{
			// head becomes new node
			// always make the new node a head to begin with
			head = newNode;
			
			// return nothing
			return; 
		}
		
		// setting the pointer of the current and new node to the next node
		newNode.setNext(currentNode.getNext());
		
		// changing pointer of current node to new node,
		// so that the new node can be inserted 
		// and have the point be set to the next node
		currentNode.setNext(newNode);		
				
	}
	 
	/**
	 * Insert a new node with data at the end of the list.
	 */
	public void insertLast( T data )
	{
		// setting the currentNode to head because we are starting with head
		LinkedListNode<T> newNode = new LinkedListNode<T>();
		
		// inserting new current node with data
		newNode.setData(data);
		
		// current node is head at first then transfers through whole list
		LinkedListNode<T> currentNode = head; 
		
		// if the currentNode is null make a new node
		if (head == null)
		{
			// head becomes new node
			head = newNode;
			return; 
		}
		
		// transfers through list
		while(currentNode.getNext() != null)
		{
			// the current node is set to get the next node each time, increments node
			currentNode = currentNode.getNext();
		}
		
		// inserting last node
		currentNode.setNext(newNode);
	}
	 
	/**
	 * Remove the first node
	 */
	public void deleteFirst()
	{
		//  forgetting first node and moving to next node
		head = head.getNext();
	}
	 
	/**
	 * Remove the last node
	 */
	public void deleteLast()
	{		
		// current node is head at first then transfers through whole list
		LinkedListNode<T> currentNode = head; 
		
		// transvering from first node to second to last node
		currentNode.getNext().getNext();
	}
	 
	/**
	 * Remove node following currentNode
	 * If no node exists (i.e., currentNode is the tail), do nothing
	 */
	public void deleteNext( LinkedListNode<T> currentNode )
	{
		// start from current node and delete the node next to it 
		currentNode.setNext(currentNode.getNext().getNext());
	}
	 
	/**
	 * Return the number of nodes in this list.
	 */
	public int size()
	{
		// current node is head at first then transfers through whole list
		LinkedListNode<T> currentNode = head; 
		
		// variable L equals int zero
		int L = 0;
		
		while(currentNode != null)
		{
			// the current node is set to get the next node each time, increments node
			currentNode = currentNode.getNext();
			
			// incrementing number in the list
			L++;
		}
		return L; 
	}
	 
	/**
	 * Check if list is empty.
	 * @return true if list contains no items.
	 */
	public boolean isEmpty()
	{
		// if there is a head 
		return ( head == null);
		
	}
	 
	/**
	 * Return a String representation of the list.
	 */
	public String toString()
	{
		// current node is head at first then transfers through whole list
		LinkedListNode<T> currentNode = head; 
		
		// creates temporary string variable
		String s = "";
		
		// transverses through list
		while( currentNode.getNext() != null)
		{	
//			// concatinates string each time
//			s+= currentNode.getData().toString();
			
			// I did this because I don't want an arrow after the last 
//			if(currentNode. != null)
//			{
				// concatinates string each time
				s+= currentNode.getData().toString();
				// creates arrow
				s+= " -> ";
				// get the next node
				currentNode = currentNode.getNext();
//			}
		}
			// otherwise
			// when I reach the end then I update without putting arrow
//			else
//			{
				// the current node is set to get the next node each time, increments node
				// concatinates string each time
				s+= currentNode.getData().toString();
//			}
			
		
		
		return s;// just returning an empty string so I don't get any errors
	}
}