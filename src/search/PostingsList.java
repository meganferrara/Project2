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
	// private LinkedList<Integer> postingslist;
	private SinglyLinkedList<Integer> postingslist;

	public PostingsList() {
		// postingslist = new LinkedList<Integer>();
		postingslist = new SinglyLinkedList<Integer>();
	}

	/**
	 * add a document ID to this posting list
	 *
	 * @param docID
	 *            the docID of the document being added
	 */
	public void addDoc(int docID) {
		Integer docIDInt = new Integer(docID);
		Node<Integer> postingsListNode = new Node<Integer>();
		postingsListNode.setElement(docIDInt);

		if (postingslist.getFirstNode() == null) {
			postingslist.insertFirst(postingsListNode);// this needs to add the postingsListNode
		} else if (!postingslist.getFirstNode().hasNext()) {
			Node<Integer> currHead = postingslist.getFirstNode();
			if (docIDInt.intValue() > currHead.getElement()) {
				postingslist.insertLast(postingsListNode);// this needs to add the postingsListNode
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
		PostingsList notPL = new PostingsList();
		int[] notIDsList = list.getIDs();
		int notIDsMax = notIDsList.length;
		// int notListPointer = 0;//curr
		// int listPointer = 1;//next
		// while(notListPointer<=maxDocID && listPointer<=maxDocID) {
		// if()
		// }

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
