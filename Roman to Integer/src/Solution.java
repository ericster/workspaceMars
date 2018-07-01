import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		
		String s = "MCMLIV"; //1954
		//s = "MMCM"; //2900
				
		int res = romanToInt(s);
		
		System.out.println("res is : " + res);
	}
	
	
    public static int romanToInt(String s) {
    	
    	HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
    	hm.put('I', 1);
    	hm.put('V', 5);
    	hm.put('X', 10);
    	hm.put('L', 50);
    	hm.put('C', 100);
    	hm.put('D', 500);
    	hm.put('M', 1000);
    
    	// Three rules
    	// 1. repetition, 2. Addition followed by small no 3. Subtraction followed by large no.
    	char [] sInt = s.toCharArray();
    	int sum = 0;
    	int first = hm.get(sInt[0]);
    	int second;
    	sum = first;
    	for (int i=1;i<sInt.length;i++){
    		second = hm.get(sInt[i]);
    		if (first >= second) { sum += second; }
    		else { sum += second - 2* first; }
    		first = second;
    	}
    	
    	return sum;
        
    }

}
