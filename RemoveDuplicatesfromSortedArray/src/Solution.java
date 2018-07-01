import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		//int[] nums = {1,1,1,2,2,2,2,3};
		int[] nums = {1,1};
		removeDuplicates(nums);

	}
	
    public static int removeDuplicates(int[] nums) {
    	
    	int idx = 1;
    	for (int i=0;i<nums.length-1;i++){
    		if(!(nums[i]==nums[i+1])){
    			nums[idx]=nums[i+1];
    			idx++;
    		}
    	}
    	System.out.println(Arrays.toString(nums));
    	System.out.println("Dupliated no is : " + idx);
    	return idx;
        
    }

}
