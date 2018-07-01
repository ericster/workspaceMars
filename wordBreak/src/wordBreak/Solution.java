package wordBreak;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		//List<String> dict = Arrays.asList("leet", "code");
		//String s = "leetcode";
		List<String> dict = Arrays.asList("cat", "cats", "sand", "and", "dog");
		String s = "catsanddog";
		if (wordBreakBFS(s, dict)){
			System.out.println("true");
		}
		else {
			System.out.println("false");
		};
	}
    public static boolean wordBreakBFS(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            //if (visited[start] == 0) {
            	System.out.println("start is : " + start);
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            //return true;
                        }
                    }
                }
            //    visited[start] = 1;
            //}
        }
        return false;
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
    	Boolean[] memo = new Boolean[s.length()];
        return word_Break(s, new HashSet(wordDict), 0, memo);
    }
    public static boolean word_Break(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
        	System.out.println("memo is " + Arrays.toString(memo));
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
        	//if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end, memo)) {
            if (wordDict.contains(s.substring(start, end))) {
                System.out.println("substring 0, i : " + s.substring(start, end));
				System.out.println("end " +  end);
				memo[start] = Boolean.TRUE;
            	if (word_Break(s, wordDict, end, memo)) {
						return true;
				}
            }
        }
        memo[start] = Boolean.FALSE;
        return false;
    }
    
    public static boolean wordBreak2(String s, List<String> wordDict) {
        int len = s.length();
        boolean result = false;
        if (len==0) return true;
        for (int i=1;i<=len;i++){
            if(wordDict.contains(s.substring(0,i))) {
                System.out.println("substring 0, i : " + s.substring(0,i));
                System.out.println("substring i, len : " + s.substring(i,len));
                if (wordBreak(s.substring(i,len), wordDict)){
                    return true; 
                }
            }
        }
        return false;
    }
	
}
