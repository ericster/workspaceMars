import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		
		String word = "122";
		//String word = "2";
		//String word = "10";
		//String word = "12";
		//String word = "100"; 174/259
		//String word = "12120"; 223/259
		String[] input = {"122", "2", "12", "10", "100", "12120"};
		for (int i=0;i<input.length;i++){
			//decodeWays(input[i]);
			numDecodings(input[i]);
		}

	}
	
    public static int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;
        
        int[] memo = new int[n+1];
        memo[n]  = 1;
        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;
        
        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];
        
        System.out.println(Arrays.toString(memo));
        
        return memo[0];
    }
	public static int decodeWays(String s){
		if (s.equals("")) return 0; 
		char[] wordArray = s.toCharArray();
		int[] nums = new int[27]; 
		int result;
		for (int i=1;i<27;i++){
			nums[i] = i;
		}
		
		int N = wordArray.length;
				
		int[][] map = new int[27][N+1];
		/*
		map[0][0]=0;
		for (int i=1;i<27;i++){
			map[i][0] = 0;
		}
		*/
		
		for (int j=1;j<=N;j++){
			for (int i=1;i<27;i++){
				// matching 1 char
				if(i  == (wordArray[j-1] - '0')) {
					map[i][j] = (j-1==0)? map[i][j-1]+1:map[26][j-1];
					System.out.println("matching 1    char at map[" + i + "][" + j + "] is : " + map[i][j] );
				}
				else if(j-2 >= 0 && i == ((wordArray[j-2] - '0')*10  + (wordArray[j-1] - '0')) ){
					// *** debug
					//map[i][j] = (j-2==0)? 1 + map[i-1][j] : map[i][j-2] + map[i-1][j]; 
					map[i][j] = (j-2==0)? 1 + map[i-1][j] : map[26][j-2] + map[i-1][j]; 
					System.out.println("matching 2    char at map[" + i + "][" + j + "] is : " + map[i][j] );
				}
				// No matching 
				else{
					// ***** debug ***** //
					map[i][j] =  map[i-1][j] ;
					System.out.println("matching no   char at map[" + i + "][" + j + "] is : " + map[i][j] );
				}
			}
		}

		result = map[26][N];
		System.out.println("***********result is : " + result);
		return result;
	}


}
