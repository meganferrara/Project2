package search;

import java.util.HashMap;

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
	private DocumentReader docReader;
	private HashMap<String, PostingsList> hmap;
	private PostingsList plDocs; //gets all the documents from the postingslist
	private int numDocs;
	
	/**
	 * @param reader a reader that will be used to read the corpus
	 */
	public Index(DocumentReader reader){
		//This sets our hash map to map terms to the postings list and implements our reader
		hmap = new HashMap<String, PostingsList>();
		this.docReader = reader;
		//we will want to add some kind of data structure to save our terms that we will be able to use later to read through
		
		
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
	public PostingsList booleanQuery(String textQuery){ //Highly suggest looking at Improved Tokenizer class tomorrow
		//1 you will need a string to save the parameter to use
		//2 you will have to return a postings list since the method is of type postingslist
		//3 use a data structure to save each term
		//4 use another data structure to save all your postings lists for each term
		//5 maybe use some kind of boolean to check if you have gone through all the docs
		//6 maybe keep track whether you need to do an AND or OR merge using an int var or a boolean
		
		//you will want to split your string made in (1) based on white space
		//7 make a string " " that you will then use for splitting
		//8 make a String[] like in the ImprovedTokenizer class
		//add your terms to a data structure use a for loop to iterate through
		
		//Make a while loop for while your data structure is not empty
		//make a String to save the removed elements from your data structure
		
		
		//you will basically check for "!" and remove it from the postings list and then 
			//check to see if your string of removed elements contains the "!" 
			//if you havent gone through all the Docs yet then get them 
				//(you may need to write a helper method) plDocs make new docs
		//have two postings lists one for the term and one for the NOT term and 
		//you will get the term from the map which will be your termPL
		//and then you will .not from your plDocs and map your termPL to your numDocs var
		
		//Ignore the AND and OR .equalsIgnoreCase
		
		
		return null;
	}
}
