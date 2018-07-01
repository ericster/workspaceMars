
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/* The isBadVersion API is defined in the parent class VersionControl.
    boolean isBadVersion(int version); */

	/*
	 * 0 1 2 3(b) 4 5 6 7 8 
	 */
    public static int firstBadVersion(int n) {
    	int mid;
    	int start = 0;
    	int end = n;
    	while (start <= end){
    		mid = (start + end)/2;
    		if (isBadVersion(mid)){
    			end = mid - 1;
				if (!isBadVersion(mid-1)) {
					return mid-1;
				}
    		}
    		else{
    			start = mid +1;
    		}
    	}
    	return 0;
    }

    static boolean isBadVersion(int version) {
    	return false;
    }

}
