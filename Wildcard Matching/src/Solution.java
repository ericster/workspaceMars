
public class Solution {

	public static void main(String[] args) {

		String s = "aab";
		String p = "c*a*b";
		s ="aa";
		//p = "*";
		//p = "a*";
		p = "?*";
		//p = "c*a*b";
		//p = "aa";
		//s = "";
		//p = "?";
		s = "a";
		p = "a*";

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
    		//if (p_arr[i-1] == '*' || p_arr[i-1] == '?'){
    		if (p_arr[i-1] == '*'){
				dp[0][i] = dp[0][i-1];
    		}
    	}
    	
    	for (int i=1;i<=m;i++){
    		for (int j=1;j<=n;j++){
				// first match
    			if (s_arr[i-1] == p_arr[j-1] || p_arr[j-1] == '?'){
    				dp[i][j] = dp[i-1][j-1];
    			}
    			else if (p_arr[j-1] == '*'){
    				dp[i][j] = dp[i-1][j] || dp[i][j-1];
    			}
    			else {
    				dp[i][j] = false;
    				
    			}
    		}
    	}
    	
    	return dp[m][n];

    }

}
