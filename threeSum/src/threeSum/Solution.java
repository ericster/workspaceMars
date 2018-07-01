package threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
        int idx = 0;
        int sum;
        int[] data = new int[3];
        //int[] nums = {3,0,-2,-1,1,2};
        int[] nums = {0,0,0};
        //Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> resultSet = null;
        //threeSumUtil(nums, len, 0, data, 0);
        List<int[]> resultList = new ArrayList<>();
        combinations(nums, 3);
	}
	
	public static void combinations(int[] input, int k) {
		//int k = 3;                             // sequence length   

		List<int[]> subsets = new ArrayList<>();

		int[] s = new int[k];                  // here we'll keep indices 
		                                       // pointing to elements in input array

		if (k <= input.length) {
		    // first index sequence: 0, 1, 2, ...
		    for (int i = 0; (s[i] = i) < k - 1; i++);  
		    subsets.add(getSubset(input, s));
		    for(;;) {
		        int i;
		        // find position of item that can be incremented
		        for (i = k - 1; i >= 0 && s[i] == input.length - k + i; i--); 
		        if (i < 0) {
		            break;
		        }
		        s[i]++;                    // increment this item
		        for (++i; i < k; i++) {    // fill up remaining items
		            s[i] = s[i - 1] + 1; 
		        }
		        subsets.add(getSubset(input, s));
		    }
		}
		System.out.println("subsets are :" + Arrays.toString(subsets.toArray()));
		int arrayListSize = subsets.size();
		for(int i = 0; i < arrayListSize; i++)
		{
		  System.out.println(Arrays.toString(subsets.get(i)));
		}
	}
	// generate actual subset by index sequence
	static int[] getSubset(int[] input, int[] subset) {
	    int[] result = new int[subset.length]; 
	    for (int i = 0; i < subset.length; i++) 
	        result[i] = input[subset[i]];
	    return result;
	}
	
	/*
    public static List<List<Integer>> threeSum(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        List<List<Integer>> resultSet = new ArrayList<List<Integer>>();
        
        int len = nums.length;
        int idx = 0;
        int sum;
        int[] data = new int[3];
        threeSumUtil(nums, len, 0, data, 0, resultSet);
        return resultSet;
    }
    */
    
    public static void threeSumUtil(int[] nums, int len, int i, int[] data, int idx){
        if (idx==3){
            int sum = 0;
            
            System.out.println("data all : " + Arrays.toString(data));
            for(int j=0;j<3;j++){
                sum += data[j];
            }
            
            if (sum==0){
                System.out.println("Found");
                System.out.println("data is" + Arrays.toString(data));
                Arrays.sort(data);
                
                System.out.println("Sorted data is" + Arrays.toString(data));
                //System.out.println("resultSet is" + Arrays.toString(resultSet.toArray()));
            }
            return;
        }
        
        if (i>=len)
            return;
        
        // i elm included
        data[idx] = nums[i];
        threeSumUtil(nums, len, i+1, data, idx+1);
        
        // i elm excluded
        threeSumUtil(nums, len, i+1, data, idx);
        
    }

}
