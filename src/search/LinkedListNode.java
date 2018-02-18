package search;

/**
 * LinkedListNode class consisting of getters and setters
 * @author Guest
 * @param LinkedListNode<T>
 */
public class LinkedListNode <T>
{
	// data is of type T
	private T data;
	
	// next is of type LinkedListNode because 
	// next will be used to continue to the adjacent node
	public LinkedListNode<T> next;
	
	/**
	 * Get the data stored at this node.
	 */
	public T getData()
	{
		// returns the data stored
		return data;
	}
	
	/**
	 * Set the data stored at this node.
	 */
	public void setData( T data )
	{
		// sets the data at this node
		this.data = data;
	}
	 
	/**
	 * Get (pointer to) next node.
	 */
	public LinkedListNode<T> getNext()
	{
		// returns next because it is pointing to the next node
		return next;
	}
	
	/**
	 * Set the next pointer to passed node.
	 */
	public void setNext( LinkedListNode<T> node )
	{
		// the next pointer is set to the node parameter
		this.next = node;
	}
	 
	/**
	 * Returns a String representation of this node.
	 */
	public String toString()
	{
		// returns the data in string form of node
		return data.toString();
	}
}