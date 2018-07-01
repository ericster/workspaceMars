import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		
		int[] nums = {100, 4, 200, 1, 3, 2};
		
		int res = longestConsecutive(nums);
		
		System.out.println("result is : " + res);

	}
	
    public static int longestConsecutive(int[] nums) {
    	  int max = 0;
    	  
    	  Set<Integer> set = new HashSet<Integer>();
    	  for (int i = 0; i < nums.length; i++) {
    	    set.add(nums[i]);
    	  }
    	  
    	  for (int i = 0; i < nums.length; i++) {
    	    int count = 1;
    	    
    	    // look left
    	    int num = nums[i];
    	    while (set.contains(--num)) {
    	      count++;
    	      set.remove(num);
    	    }
    	    
    	    // look right
    	    num = nums[i];
    	    while (set.contains(++num)) {
    	      count++;
    	      set.remove(num);
    	    }
    	    
    	    max = Math.max(max, count);
    	  }
    	  
    	  return max;

    }

    public static int longestConsecutive_0(int[] nums) {
    	HashSet<Integer> hs = new HashSet<Integer>();
    	int lcs = 0;
    	
    	for (int i=0;i<nums.length;i++){
    		hs.add(nums[i]);
    	}

    	for (int i=0;i<nums.length;i++){
    		int value = nums[i];
    		if(!hs.contains(value-1)){
    			int tmp = value;
    			while (hs.contains(tmp))
    				tmp++;
    			if(lcs < tmp-value){
    				lcs = tmp - value;
    			}

    		}
    	}
    	return lcs;
        
    }

}
