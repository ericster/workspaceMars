import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {

		int[] in  = new int[] {1,2,2,2,2,4,4};
		int key = 2;
		boundSearch(in, key);
	}
	
	public static void boundSearch(int[] in, int key){
		
		int N = in.length-1;
		int start = 0, end = N-1;
		int mid, lower=0, upper = N-1;

		System.out.println("in " + Arrays.toString(in));
		while (start <= end){
			mid = (start+end)/2;
			if(in[mid]==key){
				lower = mid;
				end=mid-1;
			}
			else if (in[mid]>key){
				end=mid-1;
			}
			else{
				start=mid+1;
			}
		}

		start = 0; 
		end = N-1;
		while (start <= end){
			mid = (start+end)/2;
			if(in[mid]==key){
				upper = mid;
				start=mid+1;
			}
			else if (in[mid]>key){
				end=mid-1;
			}
			else{
				start=mid+1;
			}
		}

		System.out.println("lower " + lower + " upper " + upper);
	}
}
