import java.util.Arrays;

public class Solution {


	/*
	 * Given [1, 2, 3, 4, 5],
		return true.

		Given [5, 4, 3, 2, 1],
		return false.
	 */
	public static void main(String[] args) {
		
		//int[] input = {1, 2, 3, 4, 5};
		//int[] input = {5,4,3,2,1};
		int[] input = {5,1,5,5,2,5,4};
		if (increasingTriplet(input))
			System.out.println("true");
		else
			System.out.println("false");


	}
	
    public static boolean increasingTriplet(int[] nums) {
    	int tmp = Integer.MAX_VALUE;
    	int[] lis = new int[nums.length];
    	for (int i=0;i<nums.length;i++){
    		lis[i]=1;
    		
    	}
    	for (int i=1;i<nums.length;i++){
    		for (int j=0;j<i;j++){
    			if (nums[j]<nums[i] && lis[i] < lis[j]+1 ){
    				lis[i] = lis[j] + 1;
    			}
    		}
    	}
    	
    	System.out.println("lis is : " + Arrays.toString(lis));
    	for (int i=0;i<nums.length;i++){
    		if (lis[i]>=3){
    			return true;
    		}
    	}
    	
    	return false;
        
    }

}
