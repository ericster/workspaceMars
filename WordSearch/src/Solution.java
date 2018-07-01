import java.math.BigInteger;

public class Solution {

	public static void main(String[] args) {
		char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'},{'B','C','D'}};
		/*
		{
		  {'A','B','C','E'},
		  {'S','F','C','S'},
		  {'A','D','E','E'}
		};
		*/
		
		BigInteger ss = BigInteger.ONE;
		String word = "AAB";
		if (exist(board, word)) {
			System.out.println("Found");
		}
		else {
			System.out.println("Not found");
		}

	}
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int l = word.length();
        int [][] visited = new int[m][n];
        
        if (m==0){
        	return false;
        }
        
        System.out.println("m = " + m + " n = " + n + " l = " + l);
        
        for (int i=0;i<m;i++){
        	for (int j=0;j<n;j++){
        		System.out.println ("board i " + i + " j " + j + " is " + board[i][j]);
				if (board[i][j]==word.charAt(0)){
					System.out.println ("word.charAt(0) " + word.charAt(0));
					visited[i][j] = 1;
					if (existRec(board, m, n, i, j, visited, word, l, 1)){
						return true;
					}
					visited[i][j] = 0;
				}
        	}
        }
        return false;
        
    }
    
    public static boolean existRec(char[][] board, int m, int n, int i, int j, int[][] visited, String word, int s, int k){
    	boolean result = false;
    	boolean top,bottom,right,left;
    	if (k==s){
    		return true;
    	}
        int[] x = {-1, 1, 0, 0};
        int[] y = { 0, 0, -1, 1};
        
        for (int z=0;z<4;z++){
        	i = i+ x[z];
        	j = j+ y[z];
			System.out.println ("neighbor: board i " + i + " j " + j + " is " );
			if (isSafe(m,n,i,j,visited)){
				if (board[i][j]==word.charAt(k)){
        		System.out.println ("REC: board i " + i + " j " + j + " is " + board[i][j]);
				System.out.println ("REC: word.charAt k " + k + " is " + word.charAt(k));
					visited[i][j] = 1;
					result = existRec(board, m, n, i, j, visited, word, s, k+1);
					if (result) break;
					visited[i][j] = 0;

				}
			}
			i = i- x[z];
			j = j -y[z];
        }
        
        return result;
    }
    
    public static boolean isSafe(int m, int n, int i, int j, int[][] visited){
    	if (i >=0 && i < m && j >=0 && j <n && (visited[i][j] !=1) ){
    		return true;
    	}
    	else {
    		return false;
    	}
    }

}
