import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) {
		WordDictionary wd = new WordDictionary();
	/*
	 * 
	 	addWord("bad")
		addWord("dad")
		addWord("mad")
		search("pad") -> false
		search("bad") -> true
		search(".ad") -> true
		search("b..") -> true
		b d m
		a a a 
		d d d
	 */
		wd.addWord("");
		wd.addWord("bad");
		wd.addWord("dad");
		wd.addWord("dadd");
		String sword = ".ad";
		sword = "b..";
		//sword = "b.k";
		if (wd.search(sword)){
			System.out.println("In dictionary");
		}
		else {
			System.out.println("Not in dictionary");
		}
				

	}
	

	public static class WordDictionary {

	    /** Initialize your data structure here. */
		int N = 26;
		public Trie top;
	    public WordDictionary() {
	    	top = new Trie();
	        
	    }
	    
	    public void printWordDictionary() {
	    	Queue<Trie> queue = new LinkedList<Trie>();
	    	StringBuilder sb = new StringBuilder();
	    	Trie tmp ;
	    	queue.offer(top);
	    	tmp = queue.poll();
	    	while (tmp!=null){
	    		for(int i=0;i<N;i++){
	    			if(tmp.childen[i]!=null){
	    				queue.offer(tmp.childen[i]);
	    				sb.append((char)(i + 'a'));
	    			}
	    			if(tmp.childen[i].isWord){
	    				System.out.println(sb.toString());
	    			}
	    		}

				tmp = queue.poll();
	    	}
	    	
	    }
	    
	    /** Adds a word into the data structure. */
	    public void addWord(String word) {
	    	Trie tmp = top;
	    	int n = word.length();
	    	for (int i=0;i<n;i++){
	    		int idx = word.charAt(i) - 'a';
	    		if (tmp.childen[idx] == null){
	    			tmp.childen[idx] = new Trie();
	    		}
	    		tmp = tmp.childen[idx];
	    	}
	    	tmp.isWord=true;
	    }
	    
	/*
	 * 
	 	addWord("bad")
		addWord("dad")
		addWord("mad")
		search("pad") -> false
		search("bad") -> true
		search(".ad") -> true
		search("b..") -> true
		b d m
		a a a 
		d d d
	 */
	    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	    public boolean search(String word) {
	    	Queue<Trie> queue = new LinkedList<>();
	    	queue.offer(top);
	    	int n = word.length();
	    	Trie tmp = new Trie();
	    	for (int i=0;i<n;i++){
				int q_size = queue.size();
				for (int j=0;j<q_size;j++){
					tmp = queue.poll();
					if (word.charAt(i) == '.'){
						for (int k=0;k<26;k++){
							if (tmp.childen[k] != null){
								queue.offer(tmp.childen[k]);
							}
						}

					} else{
						int idx = word.charAt(i) - 'a';
						if (tmp.childen[idx] != null){
							queue.offer(tmp.childen[idx]);
						}
					}
				}
	    	}
	    	while(!queue.isEmpty()){
	    		tmp = queue.poll();
				if (tmp.isWord){
					return true;
				}
	    	}
	    	return false;
	    }

	    public boolean search_0(String word) {
	    	Queue<Trie> queue = new LinkedList<>();
	    	queue.offer(top);
	    	int n = word.length();
	    	Trie tmp = new Trie();
	    	for (int i=0;i<n;i++){
				if (word.charAt(i) == '.'){
					int q_size = queue.size();
					for (int j=0;j<q_size;j++){
						tmp = queue.poll();
						for (int k=0;k<26;k++){
							if (tmp.childen[k] != null){
								queue.offer(tmp.childen[k]);
							}
						}
					}
				}
				else {
					int q_size = queue.size();
					int idx = word.charAt(i) - 'a';
					for (int j=0;j<q_size;j++){
						tmp = queue.poll();
						if (tmp.childen[idx] != null){
							queue.offer(tmp.childen[idx]);
						}
					}
				}
	    	}
	    	while(!queue.isEmpty()){
	    		tmp = queue.poll();
				if (tmp.isWord){
					return true;
				}
	    	}
	    	return false;
	    }

		public class Trie {
			boolean isWord;
			Trie[] childen = new Trie[N];
		}
	}
	

	/**
	 * Your WordDictionary object will be instantiated and called as such:
	 * WordDictionary obj = new WordDictionary();
	 * obj.addWord(word);
	 * boolean param_2 = obj.search(word);
	 */

}
