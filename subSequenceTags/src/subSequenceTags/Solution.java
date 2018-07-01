package subSequenceTags;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> targetList = new ArrayList();
		List<String> availableTagList = new ArrayList();
		targetList.add("made");
		targetList.add("in");
		targetList.add("spain");
		availableTagList.add("made"); // 0
		availableTagList.add("weather"); // 1
		availableTagList.add("forecast"); // 2
		availableTagList.add("says"); // 3
		availableTagList.add("that"); // 4
		availableTagList.add("made"); // 5
		availableTagList.add("rain"); // 6
		availableTagList.add("in");   // 7
		availableTagList.add("spain");// 8
		availableTagList.add("stays");// 9
		subSequenceTags(targetList, availableTagList);
		// [5 8]
		String [] tarr = {"2abc", "bcd", "cab"};
		List<String> tlist = Arrays.asList(tarr);
		// [1 3]
		String [] aarr = {"dbc", "2abc", "cab", "bcd", "bcb"};
		// 2abc(1) bcb(4) bcd(3) cab(2) dbc(0)
		// 2abc bcd cab
		List<String> alist = Arrays.asList(aarr);
		subSequenceTags(tlist, alist);

		tarr = new String[]{"in", "the", "spain"};
		aarr = new String[]{"the", "spain", "that", "the", "rain", "in", "spain", "stays", "forecast", "in", "the"};
		/*
		 *    true min, max
		 *    false
		 */
		// [3 6] 
		tlist = Arrays.asList(tarr);
		alist = Arrays.asList(aarr);
		subSequenceTags(tlist, alist);

	}
	
    public static List<Integer> subSequenceTags(List<String> targetList, List<String> availableTagList) {
    	int len = availableTagList.size();
    	int target_len = targetList.size();
    	for (int l=target_len;l<len+1;l++){
    		for (int i=0;i<len-l+1;i++){
				HashSet<String> targetSet = new HashSet(targetList);
				int target_cnt = 0;
    			for (int j=i;j<i+l;j++){
    				if (targetSet.contains(availableTagList.get(j))){
    					targetSet.remove(availableTagList.get(j));
    					target_cnt++;
    				}
    			}
				System.out.println("target_cnt is : " + target_cnt);
				if (target_cnt == target_len){
					int min = i;
					int max = i+l-1;
					Integer[] result = {min,max};
					System.out.println("min is: " + min + " max is: " + max);
					return Arrays.asList(result);
				}
    				
    			
    		}
    	}
    	
    	
    	return null;

    }
    public static List<Integer> subSequenceTags_0(List<String> targetList, List<String> availableTagList) {
	// WRITE YOUR CODE HERE
    	int startIdx=0;
    	int endIdx=Integer.MAX_VALUE;
    	
    	int tsize = targetList.size();
    	int [] idx = new int[tsize];
    	List<List<Integer>> index = new ArrayList<List<Integer>>();
    	int asize = availableTagList.size();
    	
    	for (int j=0;j<tsize;j++){
			for (int i=0;i<asize;i++){
				List<Integer> indices = new ArrayList<Integer>();
				if (availableTagList.get(i).equalsIgnoreCase(targetList.get(j))){
					indices.add(i);
				}
				index.add(indices);
    		}
    	}
    	
    	int indexS = index.size();
    	for (int i=0;i<indexS;i++){
    		int elmSize = index.get(i).size();
    		if (elmSize==0) return null;
    		for (int j=0;j<elmSize;j++){
    			if (i==0){
    				if (index.get(i).get(j) > startIdx){
    					startIdx = index.get(i).get(j);
    				}
    			if (i==indexS){
    				if (index.get(i).get(j) < endIdx){
    					endIdx = index.get(i).get(j);
    				}
    			}

    			}
    		}

    	}
    	
    	
    
    	/*
    	 [ [0 5]
    	   [7]
    	   [8]
    	 */
    	
    	Integer [] result = {startIdx, endIdx}; 
		System.out.println("min is: " + startIdx + " max is: " + endIdx);
    	return Arrays.asList(result) ;
	}

}
