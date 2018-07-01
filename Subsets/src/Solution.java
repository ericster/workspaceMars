import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		
		int[] nums = {1,2,3};
		subsets(nums);
		//comb(nums);

	}
	
    public static void comb(int[] nums) {
    	int level=0;
    	int[] result = new int[2];
    	int idx = 0;
		combDFS(nums, level, idx, result );
    }
    public static void combDFS(int[] nums, int level, int idx, int[] result) {
    	//System.out.println("level : " + level + " idx : " + idx );
    	if (level == 2){
    		System.out.println(Arrays.toString(result));
    		return;
    	}
    	
    	if (idx >= nums.length)
    		return;
    	
    	result[level] = nums[idx];
    	combDFS(nums, level+1, idx+1, result);

    	combDFS(nums, level, idx+1, result);

    }


    public static List<List<Integer>> subsets(int[] nums) {
    	
    	List<Integer> result = new ArrayList<Integer>();
    	//int[] result = new int[2];
    	List<List<Integer>> results = new ArrayList<List<Integer>>();
    	int level = 0;
    	int index = 0;
    	int idx = 0;
    	for (int r=1;r<=nums.length;r++){
			subsetsDFS(nums, r, 0, 0, result, results);
    	}
		System.out.println("RESULT IS : ");
		for (List<Integer> item : results){
			System.out.println(Arrays.toString(item.toArray()));
			
		}
    	//System.out.println(Arrays.toString(results.toArray()));
    	
    	return null;
        
    }
    public static List<List<Integer>> subsetsDFS(int[] nums, int r, int level, int idx, List<Integer> result, List<List<Integer>> results) {
    	if (level==r) {
			//if (!result.isEmpty() && !result.contains(result)){
			//if (!result.isEmpty() ){
			//if (!results.contains(result)){
					results.add(result);
					System.out.println("result is : " + Arrays.toString(result.toArray()));
			//}
			//}
			return results;
    	}
    	
    	/***********
    	 * Important condition to stop without IOA
    	**********/
    	if(idx>=nums.length){
			return results;
    	}

    	result.add(level, nums[idx]);
    	subsetsDFS(nums, r, level+1, idx+1, result, results);

    	result.remove(level);
    	subsetsDFS(nums, r, level, idx+1, result, results);
    	
    	return null;

    }

}
