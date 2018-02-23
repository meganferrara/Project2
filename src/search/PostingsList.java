package search;

/**
 * an implementation of postings list your implementation must use a singly
 * linked list for efficiency
 *
 * This class must also provide the functionality to get the complement of a
 * postings list and to merge postings lists (e.g. AND, OR merge). The lists
 * returned should be docIDs in sorted order.
 * 
 * @author Megan Ferrara
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
		// Make an integer variable to save the param to
		Integer docIDInt = new Integer(docID);
		// Make a new node of type integer to then set this integer object to
		Node<Integer> postingsListNode = new Node<Integer>();
		postingsListNode.setElement(docIDInt);

		if (postingslist.getFirstNode() == null) {

			postingslist.addFirst(postingsListNode);// this adds the postingsListNode to head

		} else if (!postingslist.isEmpty()) { // if the list is not empty add docs in sorted order
			// make nodes for head, currentNode, and previousNode all starting at the head
			Node<Integer> head = postingslist.getFirstNode();
			Node<Integer> currNode = head;
			Node<Integer> prevNode = head;
			// have a while loops that runs while the current node has next
			while (currNode.hasNext()) {
				// if the docIDInt is greater than the current node then implement the previous
				// and current node
				if (docIDInt.compareTo(currNode.getElement()) > 0) {
					prevNode = currNode;
					currNode = currNode.getNext();
				}
				// else if the docIDInt is less than the current node put then docIDInt before
				// the
				// currNode break
				else if (docIDInt.compareTo(currNode.getElement()) < 0) {
					postingslist.addAfterPos(prevNode, postingsListNode);
					prevNode = currNode;
					currNode = currNode.getNext();
					break; // this gets us out of the else if

				} else { // the else if here just so we always implement the currNode and to make sure we
							// don't add nodes
					currNode = currNode.getNext();
				}
			}
			// This if statement will compare the docIDInt to the tail node
			if (docIDInt.compareTo(postingslist.getLastNode().getElement()) > 0) {
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
		int currPLPoint = 1;
		int notPoints = 0; // how many not points that you have to start
		PostingsList notPL = new PostingsList();
		int[] notDocIDs = list.getIDs();
		int notDocIDsMax = notDocIDs.length;

		while ((currPLPoint <= maxDocID) && (notPoints < notDocIDsMax)) {
			if (notDocIDs[notPoints] == currPLPoint) {
				// increment both points
				currPLPoint++;
				notPoints++;
			} else if (notDocIDs[notPoints] > currPLPoint) {
				// else if notDocIds at currNotPoint is greater than currPLPoint
				Integer notIDPoint = new Integer(currPLPoint);
				notPL.addDoc(notIDPoint);// save this position where not is detected
				currPLPoint++;
			} else {
				notPoints++;
			}
		}
		// This if statement is used to catch anything that our while loop may have not
		// been able to get to.
		if (currPLPoint <= maxDocID) {
			for (int i = currPLPoint; i < maxDocID; i++) {
				Integer newDocID = new Integer(i);
				notPL.addDoc(newDocID);
			}
		}
		// return the not postings list after its been processed
		return notPL;
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
		PostingsList andMergePL = new PostingsList();
		PostingsList post1 = posting1;
		PostingsList post2 = posting2;

		int[] post1IDs = post1.getIDs();
		int[] post2IDs = post2.getIDs();
		int post1Max = post1.size();
		int post2Max = post2.size();
		int post1Point = 0;
		int post2Point = 0;

		// walk through the list until you reach the max of one of the lists
		// in the while loop add the IDs to the andMergePL if they match
		// and if they dont match increment the values until they do match or reach the
		// end
		while ((post1Point < post1Max) && (post2Point < post2Max)) {
			// if your posts are at the same id and match then add that index to the list
			if (post1IDs[post1Point] == post2IDs[post2Point]) {
				Integer newDocID = new Integer(post1IDs[post1Point]);
				andMergePL.addDoc(newDocID);
				post1Point++;
				post2Point++;
			} else if (post1IDs[post1Point] < post2IDs[post2Point]) {// if the post1ID is less than post2IDs point then
																		// increment post 1 point
				post1Point++;
			} else {
				post2Point++;
			}
		}

		return andMergePL;
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
		PostingsList orMergePL = new PostingsList();
		PostingsList post1 = posting1;
		PostingsList post2 = posting2;

		int[] post1IDs = post1.getIDs();
		int[] post2IDs = post2.getIDs();
		int post1Max = post1.size();
		int post2Max = post2.size();
		int post1Point = 0;
		int post2Point = 0;

		// walk through the list until you reach the max of one of the lists
		// in the while loop add the IDs to the orMergePL if they match
		// or if the post1 ID at the current position is less than the post2 IDs
		// position
		// add the post1 ID to the orMergePL and then add
		// and if they dont match increment the values until they do match or reach the
		// end
		while ((post1Point < post1Max) && (post2Point < post2Max)) {
			// if your posts are at the same id and match then add that index to the list
			if (post1IDs[post1Point] == post2IDs[post2Point]) {
				Integer newDocID = new Integer(post1IDs[post1Point]);
				orMergePL.addDoc(newDocID);
				post1Point++;
				post2Point++;
			} else if (post1IDs[post1Point] < post2IDs[post2Point]) { // if the pos at post1 is less then you will add
				Integer newDocID = new Integer(post1IDs[post1Point]);
				orMergePL.addDoc(newDocID);
				post1Point++;
			} else {// you will add the first part of the OR above and in this else statement get
					// the second part
				Integer newDocID = new Integer(post2IDs[post2Point]);
				orMergePL.addDoc(newDocID);
				post2Point++;
			}
		}

		// Make sure you got through both lists completely
		// (they could be different lengths)
		if ((post1Point < post1IDs.length) || (post2Point < post2IDs.length)) {
			if (post1Point < post1IDs.length) {// if the post1 wasnt run through completely
				for (int i = post1Point; i < post1Max; i++) {
					Integer newDocID = new Integer(post1IDs[post1Point]);
					orMergePL.addDoc(newDocID);
				}
			} else if (post2Point < post2IDs.length) {
				for (int i = post2Point; i < post2Max; i++) {
					Integer newDocID = new Integer(post2IDs[post2Point]);
					orMergePL.addDoc(newDocID);
				}
			}

		}

		return orMergePL;
	}

	/**
	 * @return the number of docIDs for this posting list
	 */
	public int size() {
		// this is finished
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
		int plSize = size();
		int[] postIDs = new int[plSize];
		int postIDsPoint = 0; // use this pointer to go through the list

		// Made a new node that gets the first node in the postings list
		Node<Integer> currNode = postingslist.getFirstNode();
		if (currNode == null) {
			System.out.println("GetIds Method currNode is null!");
			return null;
		} else {
			postIDs[postIDsPoint] = currNode.getElement();
			while (currNode.hasNext()) {
				Integer newNode = currNode.getNext().getElement();
				postIDs[postIDsPoint] = newNode;
				// increment the postIDsPoint and the currNode position
				postIDsPoint++;
				currNode = currNode.getNext();
			}
		}
		return postIDs;
	}
}
