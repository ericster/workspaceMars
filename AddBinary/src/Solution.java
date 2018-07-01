import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		String a = "11";
		String b = "1";
		a = "0";
		b = "0";
		addBinary(a, b);

	}
	
	/*
	 *  a = "11"
		b = "1"
		Return "100".
	 */
    public static String addBinary(String a, String b) {
    	int m = a.length();
    	int n = b.length();
    	int l = (m-n) > 0 ? m:n;
    	int[] sum = new int[l+1];
    	for (int i=0;i<l;i++){
    		int a_value = (i < m) ? a.charAt(m -1 - i) - '0': 0;
    		int b_value = (i < n) ? b.charAt(n -1 - i) - '0': 0;
    		int tmp = a_value + b_value;
    		sum[l - i - 1] = (sum[l - i] + tmp)/2;
    		sum[l - i] = (sum[l - i] + tmp )% 2;
    	}
    	
    	String result = Arrays.toString(sum);
    	StringBuilder sb = new StringBuilder();
    	for (int i=0;i<sum.length;i++){
    		if (i==0 && sum[i] == 0) continue;
    		sb.append(sum[i]);
    	}

    	System.out.println("result is " + result);
    	System.out.println("result is in String " + sb);

    	
    	return sb.toString();
        
    }

}
