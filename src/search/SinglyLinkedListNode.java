package search;
/**
 * Implementation of LinkedListNode for use in SinglyLinkedList 
 * @author eitan
 *
 * @param <T>
 */
public class SinglyLinkedListNode<T> implements LinkedListNode<T> {

	protected T value;
	protected SinglyLinkedListNode<T> next;
	
	/**
	 * Constructs a SinglyLinkedListNode with the specified value.
	 * @param value
	 */
	public SinglyLinkedListNode(T value) {
		this.value = value;
	}
	
	/* (non-Javadoc)
	 * @see LinkedListNode#getValue()
	 */
	@Override
	public T getValue() {
		return value;
	}

	/* (non-Javadoc)
	 * @see LinkedListNode#setValue(java.lang.Object)
	 */
	@Override
	public void setValue(T value) {
		this.value = value;
	}

	/**
	 * Returns the next node.
	 * @return the next node.
	 */
	public SinglyLinkedListNode<T> getNext() {
		return next;
	}


	/**
	 * Sets next to the specified node.
	 * @param node
	 */
	public void setNext(SinglyLinkedListNode<T> node) {
		//This cast will throw a runtime exception if someone tries to 
		//set the next node to something that is not a SinglyLinkedListNode
		this.next =  node;
	}

}
