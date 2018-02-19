package search;
/**
 * Implementation of Singly Linked Lists.
 * 
 * @author eitan
 *
 * @param <T>
 */

public class SinglyLinkedList<T> implements LinkedList<T> {
	protected int count = 0;
	protected SinglyLinkedListNode<T> head;

	/* (non-Javadoc)
	 * @see LinkedList#getFirst()
	 */
	@Override
	public T getFirst() {
		return head.getValue();
	}
	
	/**
	 * Returns the last node in the list.
	 * 
	 * @return the last node in the list.
	 */
	protected SinglyLinkedListNode<T> getLastNode() {
		SinglyLinkedListNode<T> curNode = head;
		while(curNode.getNext() != null) {
			curNode = curNode.getNext();
		}
		return curNode;
		
	}

	/**
	 * Returns the node at the specified position in this list.
	 * @param index
	 * @return the node at the specified position in this list.
	 */
	protected SinglyLinkedListNode<T> getNode(int index)  {
		
		SinglyLinkedListNode<T> curNode = head;
		while(index > 0) { 
			curNode = curNode.getNext();
			index--;
		}
		return curNode;
		
	}

	
	/* (non-Javadoc)
	 * @see LinkedList#getLast()
	 */
	@Override
	public T getLast() {
		return getLastNode().getValue();
	}
	
	

	/* (non-Javadoc)
	 * @see LinkedList#add(java.lang.Object)
	 */
	@Override
	public void add(T value) {
		SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<T>(value);
		if(head == null) {
			head = newNode;
		} else {
			getLastNode().setNext(newNode);
		}
		count++;
	}

	/* (non-Javadoc)
	 * @see LinkedList#add(int, java.lang.Object)
	 */
	@Override
	public void add(int index, T value)  {
		if(index == 0) {
			SinglyLinkedListNode<T> oldHead = head;
			head = new SinglyLinkedListNode<T>(value);
			head.setNext(oldHead);
		} else {
			SinglyLinkedListNode<T> prevNode = getNode(index -1);
			SinglyLinkedListNode<T> nextNode = prevNode.getNext();
			SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<T>(value);
			prevNode.setNext(newNode);
			newNode.setNext(nextNode);
		}
		count++;

	}

	/* (non-Javadoc)
	 * @see LinkedList#remove(int)
	 */
	@Override
	public T remove(int index) {
		SinglyLinkedListNode<T> removedNode = null;
		if(index == 0) {
				removedNode = head;
				head = head.getNext();
		} else {
			SinglyLinkedListNode<T> prevNode = getNode(index -1);
			removedNode = prevNode.getNext();
			SinglyLinkedListNode<T> nextNode = removedNode.getNext();
			prevNode.setNext(nextNode);
		}		
		count--;
		return removedNode.getValue();

	}

	/* (non-Javadoc)
	 * @see LinkedList#size()
	 */
	@Override
	public int size() {
		return count;
	}

	/* (non-Javadoc)
	 * @see LinkedList#clear()
	 */
	@Override
	public void clear() {
		head = null;
		count = 0;
	}

	/* (non-Javadoc)
	 * @see LinkedList#get(int)
	 */
	@Override
	public T get(int i) {
		return getNode(i).getValue();
	}

	/* (non-Javadoc)
	 * @see LinkedList#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	

}
