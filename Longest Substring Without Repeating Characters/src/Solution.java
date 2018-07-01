import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		
		int[] nums = {100, 4, 200, 1, 3, 2};
		
		String s = "abcabcbb";
		// s = "bbbbb";
		//s = "pwwkew";
		//s = "eceba";
		s = "aaabb";
		s = "ababbc";
		s = "a";
		s = "ababbc";
		//s = "aaabbb";
		//s = "ababbc";
		//int res = lengthOfLongestSubstring(s);
		//int res = lengthOfLongestSubstring_opt(s);
		//int res = lengthOfLongestSubstring_AtMost_Kdistinct(s);
		int res = lengthOfLongestSubstring_AtLeast_Ktimes(s, 2);
		
		System.out.println("result is : " + res);

	}
	
	
	/*
	 *   a b c a a
	 m   1 1 1 2    
	 e   1 2 3 4            
	 c   1 2 3             
	 s   0 0 0 
	 d   1 2 3                          

	 *   e c e b a
	 m   1 1 2 
	 e   1 2 3             
	 c   1 2 3             
	 s   0 0 1 
	 d   1 2 2                          

	 *   a a a b b 
	 m   1 2 3 1 2 
	 e   1 2 3 4 5             
	 c   0 0 1 1            
	 s   0 0 0 1 2 
	 d   1 2 3                          

	 *   a b a b b c 
	 m   1 1 2 2 3 1 
	 e   1 2 3 4 5 6            
	 c   0 0 1 2 3 1           
	 s   0 0 0 0 0 
	 d   0 0 0 4 5                         
	  
	 */

    public static int lengthOfLongestSubstring_AtLeast_Ktimes(String s, int k) {
    	int[] map = new int[128];
    	int end=0, start=0;
    	int counter=0;
    	int d=0;
    	System.out.println("length " + s.length() + " k " + k);
    	if (s.length()==1 && k==1) return k;
    	while (end <s.length()) {
    		if (map[s.charAt(end++)]++ > 0) counter++;
    		System.out.println("end " + end + " counter " + counter + " start " + start + " d " + d);
    		start = end-1;
    		while (counter > 0) {
				System.out.println("###end " + end + " counter " + counter + " start " + start + " d " + d);
				if (map[s.charAt(start--)] > k-1) {
					counter--;
				}
				else {
					break;
				}
    		}
			d = Math.max(d, end-start);
    	}
    	
    	return d;

    }
    
   
    public int longestSubstring_AtLeast_Ktimes(String s, int k) {
        int d = 0;
        
        for (int numUniqueTarget = 1; numUniqueTarget <= 26; numUniqueTarget++)
            d = Math.max(d, longestSubstringWithNUniqueChars(s, k, numUniqueTarget));
        
        return d;
    }
    /*
	 *   a b a b b c 
	 *   a a a b b c
	 m   1 1 2 2 3 1 
	 e   1 2 3 4 5 6            
	 c1  1 1 1 2 0 1           
	 c2  0 1 1               
	 s   0 0 0 0 0 
	 d   0 0 0 4 5                         
     * 
     */
    
    private int longestSubstringWithNUniqueChars(String s, int k, int numUniqueTarget) {
        int[] map = new int[128];
        int numUnique = 0; // counter 1
        int numNoLessThanK = 0; // counter 2
        int begin = 0, end = 0;
        int d = 0;
        List<Integer> arr = new ArrayList<>();
        List<Integer> list = new LinkedList<>();
        
        while (end < s.length()) {
            if (map[s.charAt(end)]++ == 0) numUnique++; // increment map[c] after this statement
            if (map[s.charAt(end++)] == k) numNoLessThanK++; // inc end after this statement
            
            while (numUnique > numUniqueTarget) {
                if (map[s.charAt(begin)]-- == k) numNoLessThanK--; // decrement map[c] after this statement
                if (map[s.charAt(begin++)] == 0) numUnique--; // inc begin after this statement
            }
            
            // if we found a string where the number of unique chars equals our target
            // and all those chars are repeated at least K times then update max
            if (numUnique == numUniqueTarget && numUnique == numNoLessThanK)
                d = Math.max(end - begin, d);
        }
        
        return d;
    }
    
    public static int lengthOfLongestSubstring_AtMost_Kdistinct(String s) {
    	//HashMap<Character, Integer> hm = new HashMap();
    	int[] map = new int[128];
    	int start=0, end=0;	
    	int counter = 0;
    	int d=0;
    	while (end<s.length()) {
    		/*
    		if (hm.getOrDefault(s.charAt(end), 0) == 0) counter++;
    		System.out.println("end " + end + " counter " + counter + " start " + start + " d " + d);
    		hm.put(s.charAt(end), hm.getOrDefault(s.charAt(end), 0)+1);
    		end++;
    		*/
    		if (map[s.charAt(end++)]++ == 0) counter++;
    		while(counter>2) {
    		//System.out.println("###end " + end + " counter " + counter + " start " + start + " d " + d);
    			if (map[s.charAt(start++)]--==1) counter--;
    			/*
    			if (hm.get(s.charAt(start))==1) counter--;
				hm.put(s.charAt(start), hm.get(s.charAt(start))-1 );
				start++;
				*/
    			
    		}
			d = Math.max(d, end-start);
    	}
    	
    	return d;

    }
    
    
    public static int lengthOfLongestSubstring_opt(String s) {
    	HashMap<Character, Integer> hm = new HashMap();
    	int[] map = new int[128];
    	int start=0, end=0;	
    	int counter = 0;
    	int d=0;
    	while (end<s.length()) {
    		/*
    		if (hm.getOrDefault(s.charAt(end), 0) > 0) counter++;
    		hm.put(s.charAt(end), hm.getOrDefault(s.charAt(end), 0)+1);
    		end++;
    		*/
    		if (map[s.charAt(end++)]++>0) counter++;
    		while (counter>0) if(map[s.charAt(start++)]-->1) counter--;

    		/*
    		while(counter>0) {
    			if (hm.get(s.charAt(start))>1) counter--;
				hm.put(s.charAt(start), hm.get(s.charAt(start))-1 );
				start++;
    		}
    		*/
    		d = Math.max(d, end-start);
    	}
    	
    	return d;

    }

    public static int lengthOfLongestSubstring(String s) {
    	HashMap<Character, Integer> hm = new HashMap();
    	int start=0, end=0;	
    	int counter = 0;
    	int d=0;
    	while (end<s.length()) {
    		if (hm.getOrDefault(s.charAt(end), 0) > 0) counter++;
    		hm.put(s.charAt(end), hm.getOrDefault(s.charAt(end), 0)+1);
    		end++;
    		while(counter>0) {
    			if (hm.get(s.charAt(start))>1) counter--;
				hm.put(s.charAt(start), hm.get(s.charAt(start))-1 );
				start++;
    		}
    		d = Math.max(d, end-start);
    	}
    	
    	return d;

    }

    public static int lengthOfLongestSubstring_0(String s) {
    HashMap<Character,Integer> alpha = new HashMap<Character, Integer>();

    int max=0;

    int prevStart=0;

    int len = 0;

    /*
     * 
     *    max 0 3
     *    
     *    
     * 	  0 1 2 3 4 5 6 7 8
     * 	  p p                
	     "a b c a b c b b";
	 len  1 2 3 3 3 3 2 1                               
	     
     */
    for(int i=0; i<s.length(); i++){

          //If in hashmap and prev start < value in map
          if(alpha.containsKey(s.charAt(i)) && prevStart <= alpha.get(s.charAt(i))){

              //compare len and max
              if(max < len){
                  max = len;
              }
              //prev start = value in map + 1
              prevStart = alpha.get(s.charAt(i)) + 1;
              //len = i - value in map
              len = i - alpha.get(s.charAt(i));
          }
          else{

              //length++
              len++;
          }

          //Put in hashmap
          alpha.put(s.charAt(i), i);


    }

     //compare len and max
              if(max < len){
                  max = len;
              }


    return max;
    }

}
