package subStringsLessKDist;

import java.util.ArrayList;
import java.util.List;


public class Solution {

	public static void main(String[] args) {
		String s = "awaglk"; //len=5
		//s = "";
		int num = 4;
		num=0;
		List<String> result = new ArrayList();
		
		result = subStringsLessKDist(s, num);
		System.out.println(result);


	}
	
	
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static List<String> subStringsLessKDist(String inputString, int num)
	{
    	int len = inputString.length();
    	System.out.println(len);

    	List<String> result = new ArrayList();
    	if (len==0) return result; 
    	String subs;
    	
    	for (int i=0;i<len-num+1;i++){
    		subs = inputString.substring(i, i+num);
    		//System.out.println(subs);
    		if (oneRepeat(subs)){
				//System.out.println(subs);
				result.add(subs);
    		}
    	}
    	return result;
    }
    
    public static boolean oneRepeat(String s) {
        int freq [] = new int[26];
        int repeat_cnt = 0;
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++){
            if(freq [s.charAt(i) - 'a'] == 1)
            	continue;
            if(freq [s.charAt(i) - 'a'] == 2)
            	repeat_cnt++;
        }
        if (repeat_cnt == 2) 
        	return true;
        else
			return false;
    }

}
