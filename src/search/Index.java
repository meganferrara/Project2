package search;

import java.util.HashMap;

/**
 * this builds the actual index using sort-based index construction (e.g.
 * collect term-docID pairs, sort them, then generate the index (mapping from
 * terms to postings lists) on a final pass. You might consider implementing a
 * private class to store the term-docID pairs.
 *
 * this class also provides the interface to the search engine for querying the
 * index. It would make sense for example, to have a method that given a Boolean
 * query, returns a PostingsList (the list of Doc IDs containing the term or an
 * empty list if no Docs contain the term). Before performing any matching of
 * query and documents, the query will need to be processed to figure out what
 * is being asked (e.g. what are the individual expression types in the query
 * ... x AND y AND !z)
 * 
 * @author Megan Ferrara
 */
public class Index {
	private DocumentReader docReader;
	private HashMap<String, PostingsList> hmap;
	private PostingsList plDocs; // gets all the documents from the postingslist
	// private int numDocs;

	/**
	 * @param reader
	 *            a reader that will be used to read the corpus
	 */
	public Index(DocumentReader reader) {
		// This sets our hash map to map terms to the postings list and implements our
		// reader
		hmap = new HashMap<String, PostingsList>();
		this.docReader = reader;

		// we will want to add some kind of data structure to save our terms that we
		// will be able to use later to read through each term individually

	}

	// METHODS I THINK WILL BE NEEDED
	// ----------------------------//
	public HashMap<String, PostingsList> getHashMap() {
		return hmap;
	}

	/**
	 * GeneratePL can generate a new postings list and take in the numDocs int at
	 * the top which will be set most likely in the index method
	 */
	public void generatePL() {

		plDocs = new PostingsList();
		// make postings lists
	}

	/**
	 * getDocIDs gets all the docs from the postings list that will be read through
	 * most likely in the index method
	 * 
	 * @return
	 */
	public PostingsList getDocIDs() {

		return plDocs;

	}

	// ---------------------------//
	/**
	 * Given a boolean query (see the handout for what types of boolean queries are
	 * valid), return a PostingsList containing the document IDs that match the
	 * query. If no documents match, you should still return a PostingsList, but it
	 * will not have any document ids.
	 * 
	 * @param textQuery
	 * @return
	 */
	public PostingsList booleanQuery(String textQuery) { // Look at Improved Tokenizer class for ideas

		// WHAT HAS TO BE DONE IN THIS METHOD:

		// save the param to a string to use
		// you will have to return a postings list since method is that return value
		// maybe do something like the passes in the improvedTokenizer
		// save the postings list for each term
		// split saved string based on whitespace like in the improvedTokenizer class
		// read through them.
		// check for ! AND and OR while reading through and do functions based on that
		// return a postings list

		String txtQString = textQuery.toString();
		PostingsList boolQueryPL = new PostingsList();

		return null;
	}
}
