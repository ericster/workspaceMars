
public class Solution {

	public static void main(String[] args) {

		char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'}, 
				{'1','1','1','1','1'}, {'1','0','1','1','1'}};
		/*
		//char[][] matrix = {{'1'}} ; 
		//char[][] matrix = {{'0','1'}} ; 
		char[][] matrix = {{'0','0','0','1'},{'1','1','0','1'}, 
				{'1','1','1','1'}, {'0','1','1','1'},
				{'0','1','1','1'}};
		*/
	
		int result = maximalSquare(matrix);
		System.out.println("result is : " + result);

	}
	
    public static int maximalSquare(char[][] a) {
		if(a.length == 0) return 0;
		int m = a.length, n = a[0].length, result = 0;
		int[][] b = new int[m+1][n+1];
		for (int i = 1 ; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if(a[i-1][j-1] == '1') {
					// max[i][j] denotes the max length of a square of 1's whose bottom-right is at i-1,j-1
					b[i][j] = Math.min(Math.min(b[i][j-1] , b[i-1][j-1]), b[i-1][j]) + 1;
					result = Math.max(b[i][j], result); // update result
				}
			}
		}
		return result*result;
    }
    public static int maximalSquare_0(char[][] matrix) {
    	int m = matrix.length;
        if (m==0) return 0;
        if (m==1 && matrix[0][0]=='1') return 1;
    	int n = matrix[0].length;
    	
    	if (m==0) return 0;
    	
    	int[][] res = new int[m][n];
    	
    	for (int i=0;i<n;i++){
    		res[0][i] = matrix[0][i] - '0';
    		//res[0][i] = matrix[0][i] ;
    	}
    	for (int i=0;i<m;i++){
    		res[i][0] = matrix[i][0] - '0';
    		//res[i][0] = matrix[i][0] ;
    	}

    	for (int i=1;i<m;i++){
    		for (int j=1;j<n;j++){
    			if (matrix[i][j]=='1' && res[i-1][j] >= 1 && res[i-1][j-1] >=1
    					&& res[i][j-1]>=1){
    				res[i][j] = 1 + Math.min(res[i-1][j-1], Math.min(res[i-1][j], res[i][j-1]));
    			}
    			else{
    				res[i][j] = matrix[i][j] -'0';
    			}
    		}
    		
    	}
    	int max = 0;
    	for (int i=0;i<m;i++){
    		for (int j=0;j<n;j++){
    			if (res[i][j] > max){
    				max = res[i][j];
    			}
    		}
    	}
    	
    	System.out.println("max is: " + max);
    	int square = 0;
    	for (int i=0;i<max;i++){
    		square += 2*i+1;
    	}

    	return square;
    }

}
