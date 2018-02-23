package search;

/**
 * This class is very similar to a SingltLinkedListNode class slightly different 
 * in terms of syntax
 * 
 * 
 * @author Megan Ferrara
 *
 * @param <V> value
 */
public class Node<V> {
	private V element;
	private Node<V> next;
	
	public Node() {
		this(null, null);
	}
	
	public Node(V element, Node<V> next) {
		this.element = element;
		this.next = next;
	}
	public V getElement() {
		return element;
	}
	public void setElement(V element) {
		this.element = element;
	}
	public Node<V> getNext(){
		return next;
	}
	public void setNext(Node<V> next) {
		this.next = next;
	}
	public boolean hasNext() {
		if(next == null) {
			return false;
		}else {
			return true;
		}
	}
	
}
