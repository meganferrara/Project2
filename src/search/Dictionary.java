package search;

import java.util.HashSet;
import java.util.Iterator;

public class Dictionary{
	private HashSet<String> dictionary = new HashSet<String>();
	
	public void addWord(String word){
		dictionary.add(word);
	}
	
	public int size(){
		return dictionary.size();
	}
	
	public double average_length(){
		Iterator<String> it = dictionary.iterator();
		
		double sum = 0.0;
		
		while( it.hasNext() ){
			sum += it.next().length();
		}
		
		return sum/dictionary.size();
	}
}
