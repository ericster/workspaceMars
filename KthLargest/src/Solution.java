import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

	public static void main(String[] args) {

	// Given [3,2,1,5,6,4] and k = 2, return 5.
	int[] nums = {3,2,1,5,6,4}; 
	//int[] nums = {-1,-1};
	//int[] nums = {3,2,3,1,2,4,5,5,6};
	int k = 2;
	//int klargest = findKthLargest(nums, k);
	int klargest = findKthLargestPQ(nums, k);
	System.out.println("kth largest is : " + klargest);

	}

    public static int findKthLargestPQ(int[] nums, int k) {
        PriorityQueue<Integer> largeK = new PriorityQueue<Integer>(k + 1);

        int tmp;
        for(int el : nums) {
            largeK.add(el);
            System.out.println("PQ before is " + Arrays.toString(largeK.toArray()));
            if (largeK.size() > k) {
                //tmp = largeK.poll();
                tmp = largeK.remove();
                System.out.println("polled is : " + tmp);
                System.out.println("PQ is " + Arrays.toString(largeK.toArray()));
            }
        }


        tmp = largeK.poll();
        System.out.println("polled is : " + tmp);
        //return largeK.poll();
        return tmp;
    }
	
    public static int findKthLargest(int[] nums, int k) {
    	
    	System.out.println(" Initial array is : " + Arrays.toString(nums));
    	Arrays.sort(nums);
    	
    	for (int i = 0; i < nums.length/2; i++) {
    	    int temp = nums[i];
    	    nums[i] = nums[nums.length-(1+i)];
    	    nums[nums.length-(1+i)] = temp;
    	}
    
    	System.out.println(" Sortedarray is : " + Arrays.toString(nums));
    	/*
    	int idx = k;
    	List<Integer> numsd = new ArrayList<Integer>();
    	for(int i=0;i<nums.length;i++){
    		if((i!=nums.length-1) && nums[i]==nums[i+1]){
    			continue;
    		}
    		numsd.add(nums[i]);
    	}
    	

    	if (k-1 >= numsd.size()){
    		return numsd.get(numsd.size()-1);
    	}
    	else {
			return numsd.get(k-1);
    	}
    	*/
    	return nums[k-1];
    }

}
