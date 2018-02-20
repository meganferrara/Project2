package search;

/**
 * an implementation of postings list your implementation must use a singly
 * linked list for efficiency
 *
 * This class must also provide the functionality to get the complement of a
 * postings list and to merge postings lists (e.g. AND, OR merge). The lists
 * returned should be docIDs in sorted order.
 * 
 * @author dkauchak
 *
 */
public class PostingsList {
	private SinglyLinkedList<Integer> postingslist;

	public PostingsList() {
		postingslist = new SinglyLinkedList<Integer>();
	}

	/**
	 * add a document ID to this posting list
	 *
	 * @param docID
	 *            the docID of the document being added
	 */
	public void addDoc(int docID) {
		//Im 95% sure this is finished
		Integer docIDInt = new Integer(docID);

		Node<Integer> postingsListNode = new Node<Integer>();

		postingsListNode.setElement(docIDInt);

		if (postingslist.getFirstNode() == null) {

			postingslist.addFirst(postingsListNode);// this adds the postingsListNode to head

		} else if (!postingslist.getFirstNode().hasNext()) { // if the head node does not have a next node
			Node<Integer> currHead = postingslist.getFirstNode();
			// compare the current head with the postingsListNode and arrange them in sorted
			// order

			if (docIDInt.compareTo(currHead.getElement()) < 0) { // docIDInt less than currHead doc ID
				// put docIDInt Before currHead
				postingslist.addFirst(postingsListNode);

			} else if (docIDInt.compareTo(currHead.getElement()) == 0) {// If docIDInt equal to currHead docID
				// ignore

			} else if (docIDInt.compareTo(currHead.getElement()) > 0) { // docIDInt greater than currHead doc ID
				// put docIDInt after currHead
				postingslist.addLast(postingsListNode);
			}

		} else { // if there is more than just the head node we add and sort in the else
			// make nodes for head, currentNode, and previousNode all starting at the head
			Node<Integer> head = postingslist.getFirstNode();
			Node<Integer> currNode = head;
			Node<Integer> prevNode = head;
			// have a while loops that runs while the current node has next
			while (currNode.hasNext()) {
				// if the docIDInt is greater than the current node then implement the previous and current node 
				if (docIDInt.compareTo(currNode.getElement()) > 0) {
					prevNode = currNode;
					currNode = currNode.getNext();
				}
				// else if the docIDInt is less than the current node put then docIDInt before the
				// currNode break
				else if (docIDInt.compareTo(currNode.getElement()) < 0) {
					postingslist.addAfterPos(prevNode, postingsListNode);
					prevNode = currNode;
					currNode = currNode.getNext();
					break; //this gets us out of the else if
					
				}else { //the else if here just so we always implement the currNode and to make sure we don't add nodes 
					currNode = currNode.getNext(); 
				}
			}
			//Since the while loop only checks up to the current node when it has a next node 
			//This if statement will compare the docIDInt to the tail node 
			if(docIDInt.compareTo(postingslist.getLastNode().getElement())>0) {
				postingslist.addLast(postingsListNode);
			}
		}

	}

	/**
	 * Given a postings list, return the NOT of the postings list, i.e. a postings
	 * list that contains all document ids not in "list"
	 * 
	 * document IDs should range from 0 to maxDocID
	 * 
	 * @param list
	 *            the postings list to NOT
	 * @param maxDocID
	 *            the maximum allowable document ID
	 * @return not of the posting list
	 */
	public static PostingsList not(PostingsList list, int maxDocID) {
		//I have an idea for this method but I dont know what kinda of data structure to use for mapping
		PostingsList notPL = new PostingsList();
		int[] notDocIDs = list.getIDs();
		int notDocIDsMax = notDocIDs.length;
		
		//So that you can walk through both classes at the same time
		int currPLPoint = 1;
		int currNotPoint = 0;
		
		//you will add your not indexes to the notDocIDs you will save a int to keep track of the length
		//you will have a pointers currPLPoint(the pointer for the list we are removing NOT from)
		//currNotPoint(the pointer for the list we are saving NOT to)
		
		//while the currPLPoint is <= maxDocID && currNotPoint is < notDocIDsMax
			
			//if the notDocIDs at currNotPoint is equal to currPLPoint
		
				//increment both points
			
			//else if notDocIds at currNotPoint is greater than currPLPoint
		
				//
		
		
		
		return null;
	}

	/**
	 * Given two postings lists, return a new postings list that contains the AND of
	 * the postings, i.e. all the docIDs that occur in both posting1 and posting2
	 * 
	 * @param posting1
	 * @param posting2
	 * @return the AND of the postings lists
	 */
	public static PostingsList andMerge(PostingsList posting1, PostingsList posting2) {
		return null;
	}

	/**
	 * Given two postings lists, return a new postings list that contains the OR of
	 * the postings, i.e. all those docIDs that occur in either posting1 and
	 * posting2
	 * 
	 * @param posting1
	 * @param posting2
	 * @return the OR of the postings lists
	 */
	public static PostingsList orMerge(PostingsList posting1, PostingsList posting2) {
		return null;
	}

	/**
	 * @return the number of docIDs for this posting list
	 */
	public int size() {
		//this is finished
		return postingslist.size();
	}

	/**
	 * From the linked list structure, generate an integer array containing all of
	 * the document ids. This will make our life easy when we want to print out the
	 * ids. (another option would have been to write an iterator, but this is
	 * easier).
	 * 
	 * @return
	 */
	public int[] getIDs() {
		return null;
	}
}
