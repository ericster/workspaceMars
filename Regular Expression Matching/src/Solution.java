
public class Solution {

	public static void main(String[] args) {
		String s = "aab";
		String p = "c*a*b";
		s = "aaa";
		p = "aaaa";
		s= "aaaa";
		p= "ab*a*c*a";
		s ="aa";
		p = ".*";

		if (isMatch(s, p)){
			System.out.println("Matched");
		}
		else {
			System.out.println("Not matched");
		}

	}
	
	
    public static boolean isMatch(String s, String p) {
    
    	int m = s.length();
    	int n = p.length();
    	char[] s_arr = s.toCharArray();
    	char[] p_arr = p.toCharArray();
    	boolean[][] dp = new boolean[m+1][n+1];
    	
    	// Init
    	dp[0][0] = true;
    	for (int i=1;i<=m;i++){
    		dp[i][0] = false;
    	}
    	// deal with pattern a* a*b*, a*b*c*
    	for (int i=1;i<=n;i++){
    		if (p_arr[i-1] == '*'){
				dp[0][i] = dp[0][i-2];
    		}
    	}
    	
    	for (int i=1;i<=m;i++){
    		for (int j=1;j<=n;j++){
				// first match
    			if (s_arr[i-1] == p_arr[j-1] || p_arr[j-1] == '.'){
    				dp[i][j] = dp[i-1][j-1];
    			}
    			else if (p_arr[j-1] == '*'){
				// * without match
    				dp[i][j]=  dp[i][j-2]; 
				// * with match
    				boolean w;
    				if (s_arr[i-1] == p_arr[j-2] || p_arr[j-2] == '.'){
    					dp[i][j] = dp[i][j] ||  dp[i-1][j];
    				}
    			}
    			else {
    				dp[i][j] = false;
    				
    			}
    		}
    	}
    	
    	return dp[m][n];

    }
    public static boolean isMatch_0(String s, String p) {
    	
    	char [] s_arr = s.toCharArray();
    	char [] p_arr = p.toCharArray();
    	char [] dp = new char[p_arr.length];
    	
    	int index=0;
    	for (int i=0;i<p_arr.length;i++){
    		// s=aaa, p=aaaa
    		// s=aaa, p=ab*a*c*a
    		if (index < s_arr.length && p_arr[i]== s_arr[index]){
    			dp[i] = p_arr[i];
    			index++;
    		}
    		else if (p_arr[i] == '.'){
    			if (s_arr[index] >= 'a' && s_arr[index] <= 'z'){
					dp[i] = '.';
					index++;
    			}
    			
    		}
    		else if (p_arr[i] == '*' ){
    			if (dp[i-1] == '.'){
    				return true;
    			}
    			else if (index < s_arr.length && dp[i-1] == s_arr[index] ){
    				dp[i]= s_arr[index];
    				while (index < s_arr.length && dp[i-1] == s_arr[index]){
						index++;
    				}
    			}
    		} else {
    			dp[i] = p_arr[i];
    		}
    	}
    	
    	System.out.println("index is : " + index);
    	if (index != s_arr.length) return false;
    	if (dp[p_arr.length-1] == 0) return false;
    	return true;
        
    }

}
