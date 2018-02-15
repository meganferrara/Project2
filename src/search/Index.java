package search;

/**
 * this builds the actual index using sort-based index construction (e.g. collect term-docID pairs, sort them, 
 * then generate the index (mapping from terms to postings lists) on a final pass.  You might consider implementing a private class
 * to store the term-docID pairs.
 *
 * this class also provides the interface to the search engine for querying the index.
 * It would make sense for example, to have a method that given  a Boolean query, returns 
 * a PostingsList (the list of Doc IDs containing the term or an empty list if no Docs contain the term).
 * Before performing any matching of query and documents, the query will need to be processed to figure
 * out what is being asked (e.g. what are the individual expression types in the query ... x AND y AND !z)
 * 
 * @author dkauchak modified by lballest
 */ 
public class Index {
	/**
	 * @param reader a reader that will be used to read the corpus
	 */
	public Index(DocumentReader reader){
	}

	/**
	 *  Given a boolean query (see the handout for what types of boolean
	 *  queries are valid), return a PostingsList containing the document
	 *  IDs that match the query.  If no documents match, you should still return a
	 *  PostingsList, but it will not have any document ids.
	 * 
	 * @param textQuery
	 * @return
	 */
	public PostingsList booleanQuery(String textQuery){
		return null;
	}
}
