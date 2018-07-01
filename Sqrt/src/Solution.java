
public class Solution {

	public static void main(String[] args) {
		
		// 4 -> 2
		// 9 -> 3, 4/0-> 2 -> 3
		int x = 9;
		x = 5;
		x = 999444974;
		int st = sqrt(x);
		
		System.out.println("sqrt of " + x + " is "  + sqrt(x));
		//if (st*st == x){
		if (isPerfectSquare(x)){ 
		//if (isPerfectsqrt(x)){ 
			System.out.println("Perfect sqrt");
		}
		else{
			System.out.println("NOT perfect sqrt");
		}

	}
	
	public static boolean isPerfectsqrt(int x) {
	    if (x == 0) return true;
	    int left = 1, right = x;
	    while (left<=right) {
	    //while (true) {
	        int mid = left + (right - left)/2;
	        if (mid > x/mid) {
	            right = mid - 1;
	        } else {
	            if (mid + 1 > x/(mid + 1))
	            	if (mid == (float)x/mid){
						return true;
	            	}
	            left = mid + 1;
	        }
	    }
	    return false;
	}
	public static int sqrt(int x) {
	    if (x == 0)
	        return 0;
	    int left = 1, right = x;
	    //while (left<right) {
	    while (true) {
	        int mid = left + (right - left)/2;
	        if (mid > x/mid) {
	            right = mid - 1;
	        } else {
	            if (mid + 1 > x/(mid + 1))
	                return mid;
	            left = mid + 1;
	        }
	    }
	}
	
	/*
	 * 0, 9 -> 4
	 * 0, 3 -> 1
	 * 2, 3 -> 2
	 * 3, 3 -> 3
	 */
	public static boolean isPerfectSquare(int num) {
        int low = 1, high = num;
        while (low <= high) {
            long mid = (low + high) >>> 1;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }

}
