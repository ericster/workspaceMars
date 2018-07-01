import java.util.ArrayList;
import java.util.List;
public class Solution
{        
	public static void main(String[] args) {
		String s = ""; //len=5
		//s = "";
		int num = 4;
		num=0;
		List<String> result = new ArrayList();
		
		String literatureText = "Jack and Jill went to the market to buy bread and cheese. Cheese is Jack's and Jill's favorite food.";
		List<String> wordsToExclude = new ArrayList();
		result = retrieveMostFrequentlyUsedWords(literatureText, wordsToExclude);
		System.out.println(result);


	}
	
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    static List<String> retrieveMostFrequentlyUsedWords(String literatureText, List<String> wordsToExclude)
    {
    	String[] tokens = literatureText.split("\\'|\\.");
    	
    	int len = tokens.length;
    	for (int i=0;i<len;i++) {
    		System.out.println(tokens[i]);
    	}


    }
    // METHOD SIGNATURE ENDS
}