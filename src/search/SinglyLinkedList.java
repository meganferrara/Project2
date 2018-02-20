package search;

/**
 * Implementation of Singly Linked Lists. We make it of type value so that put
 * Integer Values into the Postings list in the PostingsList class
 * 
 * @author Megan Ferrara
 *
 * @param <V>
 *            value
 */

public class SinglyLinkedList<V> {
	protected int count = 0;
	protected Node<V> head;
	protected Node<V> tail;

	/**
	 * GetFirst gets the head of the singly linked list
	 * 
	 * @return the value of the head
	 */
	public V getFirst() {
		return head.getElement();
	}

	/**
	 * GetFirstNode returns the head of the singly linked list
	 * 
	 * @return head
	 */
	public Node<V> getFirstNode() {
		return head;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see LinkedList#getLast()
	 */
	/**
	 * GetLast gets the last nodes value in a singly linked list
	 * 
	 * @return last nodes value
	 */
	public V getLast() {
		return getLastNode().getElement();
	}

	/**
	 * Returns the last node in the list.
	 * 
	 * @return the last node in the list.
	 */
	protected Node<V> getLastNode() {
		Node<V> curNode = head;
		while (curNode.getNext() != null) {
			curNode = curNode.getNext();
		}
		return curNode;

	}

	/**
	 * Returns the node at the specified position in this list.
	 * 
	 * @param index
	 * @return the node at the specified position in this list.
	 */
	protected Node<V> getNode(int index) {

		Node<V> curNode = head;
		while (index > 0) {
			curNode = curNode.getNext();
			index--;
		}
		return curNode;

	}

	/**
	 * AddFirst(Node<V> node) adds a element to the beginning of the list
	 * 
	 * @param value
	 */
	public void addFirst(Node<V> node) {
		if (head == null) {
			head = node;
			// tail = head;
		} else {
			Node<V> oldHead = head;
			head = node;
			head.setNext(oldHead);
		}
		count++;
	}

	/**
	 * AddLast(Node<V> node) adds an element to the end of the list
	 * 
	 * @param node
	 */
	public void addLast(Node<V> node) {
		if (head == null) {
			head = node;
			tail = head;
		} else {
			node.setNext(null);
			tail.setNext(node);
			tail = node;
		}
		count++;
	}

	/**
	 * AddAfterPos(int index, V value) adds a element to a specified position
	 * 
	 * @param index
	 * @param value
	 */
	public void addAfterPos(Node<V> currNode, Node<V> newNode) {
		if (currNode == null) {
			// then dont do anything
		} else if (currNode == tail) {
			currNode.setNext(newNode);
			tail = newNode;
			// this.tail = newNode; //if the previous doesn't work try this

		} else {
			if (currNode.hasNext()) {
				Node<V> oldNextNode = currNode.getNext();
				currNode.setNext(newNode);
				newNode.setNext(oldNextNode);
			}

		}
		count++;
	}

	/**
	 * Remove removes a null from specified index and returns the removed node value
	 * 
	 * @param index
	 * @return the removed nodes value
	 */
	public V remove(int index) {
		Node<V> removedNode = null;
		if (index == 0) {
			removedNode = head;
			head = head.getNext();
		} else {
			Node<V> prevNode = getNode(index - 1);
			removedNode = prevNode.getNext();
			Node<V> nextNode = removedNode.getNext();
			prevNode.setNext(nextNode);
		}
		count--;
		return removedNode.getElement();

	}

	/**
	 * Gets the size of the SinglyLinkedList
	 * 
	 * @return count
	 */
	public int size() {
		return count;
	}

	/**
	 * Clears the SinglyLinkedList
	 */
	public void clear() {
		head = null;
		count = 0;
	}

	/**
	 * Get gets a nodes value from a specified index
	 * 
	 * @param i
	 * @return the specified nodes value
	 */
	public V get(int i) {
		return getNode(i).getElement();
	}

	/**
	 * Checks to see if the SinglyLinkedList is empty
	 * 
	 * @return returns true or false
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

}
