import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

	public static void main(String[] args) {
		
		int[] nums1 = new int[12];
		int[] nums2 = {2, 3, 5, 10, 13, 20};
		
		nums1[0] = 1;
		nums1[1] = 4;
		nums1[2] = 6;
		nums1[3] = 7;
		nums1[4] = 11;
		
		System.out.println("nums1 size is : " + nums1.length);
		System.out.println("nums2 size is : " + nums2.length);
		int m = 5;
		int n = 6;
		merge(nums1, m, nums2, n);
		

	}
	
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
    	int start_index = 0;
    	for (int i=0;i<n;i++){
			int n2 = nums2[i];
			System.out.println("n2 is : " + n2);
			System.out.println("Result is : " + Arrays.toString(nums1));
			for (int j=start_index;j<m+i;j++){
				if (n2 > nums1[j])  
					start_index++;
			}
			System.out.println("start_index : " + start_index);
			// insert outside nums1 
			int tmp = nums1[start_index];
			nums1[start_index] = n2;
			if (start_index > m+i-1){
				continue;
			}
			// insert inside nums1
			for (int k=start_index+1;k<m+i;k++){
				int tmp2 = nums1[k];
				nums1[k] = tmp;
				tmp = tmp2;
			}
			nums1[m+i] = tmp;
    	}
		System.out.println("Result is : " + Arrays.toString(nums1));
    }

    public static void merge_pq(int[] nums1, int m, int[] nums2, int n) {
    	int start_index = 0;
    	PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

    	for (int i=0;i<n;i++){
    		pq.add(nums2[i]);
    	}

		for (int j=0;j<m;j++){
			pq.add(nums1[j]);
		}
		
		System.out.println("PQ is : " + Arrays.toString(pq.toArray()));
		for (int i=0;i<m+n;i++){
			nums1[i] = pq.poll();
		}
		System.out.println("Result is : " + Arrays.toString(nums1));
    
        
    }

}
