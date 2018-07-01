
public class Solution {

	public static void main(String[] args) {
		
		int c = 999999999;
		c = 2147483646;
		//c = 6;
		//c = 999999999;
		//c = 6;
		c = 25 + 121;
		if (judgeSquareSum(c)){
		//if (judgeSquareSum_1(c)){
			System.out.println("Found sum of squre numbers");
		}
		else {
			System.out.println("NOT found sum of squre numbers");
		}


	}
	
    public static boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        int left = 0, right = sqrt(c);
    	System.out.println("left: " + left + " right: " + right);
        while (left <= right) {
            int cur = left * left + right * right;
            if (cur < c) {
				System.out.println("left++: " + left + " right: " + right);
                left++;
            } else if (cur > c) {
				System.out.println("left: " + left + " right--: " + right);
                right--;
            } else {
                return true;
            }
        }
        return false;
    } 
    public static boolean judgeSquareSum_1(int c) {
    	if (c==0) return true;
    	
    	int a=0;
    	int b=0;
    	int k = (int)Math.sqrt(c);
    	int i=0;
    	//for (i=0;a<k;i++){
    	int tmp;
    	for (i=0;a<c;i++){
    		a += 2*i + 1;
    		tmp = c-a;
    		//System.out.println("a: " + a + " c-a: " + tmp);
    		k = sqrt(tmp);
    		if (k*k == tmp) return true;
    		//if (isPerfectSquare(c-a)) return true;
    		//if (isPerfectsqrt(c-a)) return true;
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
    
    
    public static boolean isPerfectsqrt(int x) {
	    if (x == 0) return true;
	    int left = 1, right = x;
	    while (left<=right) {
	    //while (true) {
	        int mid = left + (right - left)/2;
	        //if (mid > x/mid) {
	        if (mid*mid > x) {
	            right = mid - 1;
	        } else {
	            if (mid + 1 > x/(mid + 1))
	            	if (mid*mid == x ){

						return true;
	            	}
	            left = mid + 1;
	        }
	    }
	    return false;
	}
    
	public static boolean isPerfectSquare(int num) {
        int low = 1, high = num;
        if (num==0) return true;
        while (low <= high) {
            //long mid = (low + high) >>> 1;
            double mid = (low + high) >>> 1;
            if ((mid == num /mid) && (num%mid == 0)) {
            //if (mid * mid== num) {
            //if (mid == num/mid) {
            	System.out.println("num is " + num + " mid is " + mid);
                return true;
            } else if (mid < num/mid) {
            //} else if (mid < num/mid) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }

}
