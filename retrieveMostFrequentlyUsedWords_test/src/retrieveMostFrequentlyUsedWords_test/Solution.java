package retrieveMostFrequentlyUsedWords_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		String s = ""; //len=5
		//s = "";
		int num = 4;
		num=0;
		List<String> result = new ArrayList();
		
		String literatureText = "Jack and Jill went to the market to buy bread and cheese. Cheese is Jack's and Jill's favorite food.";
		literatureText = "";
		List<String> wordsToExclude = new ArrayList();
		result = retrieveMostFrequentlyUsedWords(literatureText, wordsToExclude);
		System.out.println("RESULT :");
		System.out.println(Arrays.toString(result.toArray()));

	}
	
	
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    static List<String> retrieveMostFrequentlyUsedWords(String literatureText, List<String> wordsToExclude)
    {
    	String[] tokens = literatureText.split("[\\s.,']+");
    	HashMap<String, Integer> hm = new HashMap<String,Integer>();
    	HashSet<String> hs = new HashSet<String>();
    	List<String> result = new ArrayList<String>();
    	
    	int len = tokens.length;
    	int m = wordsToExclude.size();
    	for (String str : wordsToExclude){
    		hs.add(str);
    	}
    	
    	System.out.println("blocked word : ******" );
    	for (String s : hs) {
    	    System.out.println("blocked word : " + s);
    	}
    	
    	
    	System.out.println("Length " + len);
    	String token, tokenLower;

    	for (int i=0;i<len;i++) {
    		System.out.println(tokens[i]);
    		token = tokens[i].toLowerCase();

    		if(hm.containsKey(token)) {
    			hm.put(token, hm.get(token)+1);
    		}
    		else
    		{
    			hm.put(token,1);
    		}
    	
    	}
    	// print
		for (String name : hm.keySet()) 
		{
			Integer cnt = hm.get(name);
			System.out.println("Key = " + name + ", Value = " + cnt);
		}
        Set<Entry<String, Integer>> set = hm.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        } );
        
        
		System.out.println("Ordered **********");

		int mtmp = 0;
		int cnt = 0;
        for(Map.Entry<String, Integer> entry:list){
        	if (hs.contains(entry.getKey())) 
        	{
        		continue;
        	}
        	else
        	{
        		cnt++;
        		if (cnt==1) {
					result.add(entry.getKey());
					mtmp = entry.getValue();
        		}
        		else 
        		{
        			if (entry.getValue() == mtmp) {
						result.add(entry.getKey());
        			}
        			
        		}

        	}
        	
            System.out.println(entry.getKey()+" ==== "+entry.getValue());
        }
        
    	
    	return result;


    }

}
