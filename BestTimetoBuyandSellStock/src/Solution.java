
public class Solution {

	public static void main(String[] args) {
		int[] prices = {7, 1, 5, 3, 6, 4};
		prices = new int[] {1, 2, 3, 4, 5};
		prices = new int[] {7,6,4,3,1};
		prices = new int[] {3,2,6,5,0,3}; // k=2, 7
		int k = 2;
		int profit = maxProfit(prices, k);
		System.out.println("Max profit is " + profit);


	}

	/*
	 *                    0     1          2         3            4            5     6
	 *                          ^         ^          ^            ^                     
	 *                    
		 prices =         7,    1,        5,         3,           6,            4
		                  0     0         0          0            0             0
		                     a[1]-a[0] a[2]-a[0]   a[3]-a[0]  a[4]-a[0]  a[5]-a[0]         
		                               a[2]-a[1]   a[3]-a[1]  a[4]-a[1]  a[5]-a[1]         
		                     	                   a[3]-a[2]  a[4]-a[2]  a[5]-a[2]         
		                     	                              a[4]-a[3]  a[5]-a[3]         
		                     	                                         a[5]-a[4]         
		                     	             a[3]-a[0], a[3]-a[1], a[3]-a[2]+ dp[1]: a[1]-a[0]   
		                     	             a[4]-a[0], a[4]-a[1], a[4]-a[2]+a[1]-a[0], 
		                     	                                   a[4]-a[3]+a[2]-a[1]
		                     	                                   a[4]-a[3]+a[2]-a[0]                        
		                     	                                   a[4]-a[3]+a[1]-a[0]                        
		                     	                                         
		                     -6  -2   -4  -1  -3
		                          4   2   5   3
		                             -2   1   -1
		                                  3    1            
		 dp[i][j]
		 buy                                
		 sell                                        
		 max_curr    0                       
		 max         0                            

	 *	 
	 */
    public static int maxProfit(int[] prices, int k) {
    	int n = prices.length;
        if (k >= n/2) {
            // fast case because there are [0, n/2] continuous increases
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                int diff = prices[i] - prices[i-1];
                if (diff > 0) {
                    maxProfit += diff;
                }
            }
            return maxProfit;
        }
        int[][] dp = new int[k + 1][n + 1];
        // For day 0, you can't 
        // earn money irrespective
        // of how many times you trade
        for (int i = 0; i <= k; i++)
            dp[i][0] = 0;
 
        // profit is 0 if we don't do any transaction
        // (i.e. k =0)
        for (int j = 0; j <= n; j++)
            dp[0][j] = 0;
 
        // fill the table in 
        // bottom-up fashion
        for (int i = 1; i <= k; i++) 
        {
            for (int j = 1; j < n; j++)
            {
                int max_so_far = 0;
 
                for (int m = 1; m < j; m++)
					max_so_far = Math.max(max_so_far, prices[j] - prices[m] + dp[i - 1][m-1]);
 
                dp[i][j] = Math.max(dp[i] [j - 1], max_so_far);
            }
        }
 
        return dp[k][n - 1]; 

    }
    public static int maxProfit_all(int[] prices, int k) {
    	int n = prices.length;
        if (n == 1)
            return 0;
         
        int count = 0;
        // solution array
        String tmp = "test";
        int hash = tmp.hashCode();
 
        // Traverse through given price array
        int i = 0;
        int buy, sell;
        int sum=0;
        while (i < n - 1) 
        {
            // Find Local Minima. Note that the limit is (n-2) as we are
            // comparing present element to the next element. 
            while ((i < n - 1) && (prices[i + 1] <= prices[i]))
                i++;
 
            // If we reached the end, break as no further solution possible
            if (i == n - 1)
                break;
 
            buy = prices[i++];
            // Store the index of minima
             
 
            // Find Local Maxima.  Note that the limit is (n-1) as we are
            // comparing to previous element
            while ((i < n) && (prices[i] >= prices[i - 1]))
                i++;
 
            // Store the index of maxima
            sell = prices[i-1];
            sum += sell - buy;
             
            // Increment number of buy/sell
            count++;
        }
        return (count == 0) ? 0: sum;
    }

    public static int maxProfit_1(int[] prices, int k) {
    	int N = prices.length;
    	if (N < 2) return 0;
    	int[] dp = new int[N];
    	int tmp_min = Integer.MAX_VALUE;
    	for (int i=1;i<N;i++) {
    		tmp_min = (tmp_min < prices[i-1] ) ?   tmp_min : prices[i-1];
    		dp[i] = (dp[i-1] > prices[i]-tmp_min) ? dp[i-1]: prices[i]-tmp_min;
    		System.out.println("i " + i + " dp " + dp[i]);
    	}
    	return dp[N-1];

    	/*
    	for (int i=0;i<N;i++) {
    		for (int j=1;j<N;j++) {
    			// dp[0][j]
    			if (i==0) {
    				dp[i][j] = Math.max(dp[i][j-1], prices[j]-prices[i]);
    				//System.out.println("i " + i + " j " + j + " dp " + dp[i][j]);
    			}
    			else if (i<j) {
    				// sell on j
    				int temp_min = Math.max(dp[i-1][j], prices[j] - prices[i]);
    				// 
    				dp[i][j] = Math.max(dp[i][j-1], temp_min);
    				//System.out.println("i " + i + " j " + j + " dp " + dp[i][j]);
    			}
    		}
    	}
    	return dp[k+1][N-1];
    	*/
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static int maxProfit_0(int[] prices, int k) {
    	int[][] profit = new int[k+1][prices.length];
    	
    	int n = prices.length;
        // For day 0, you can't earn money
        // irrespective of how many times you trade
        for (int i = 0; i <= k; i++)
            profit[i][0] = 0;
     
        // profit is 0 if we don't do any transation
        // (i.e. k =0)
        for (int j= 0; j < n; j++)
            profit[0][j] = 0;
        
    	
    	int maxCur ;
    	int maxSoFar = 0;
    	for (int i=1;i<k+1;i++){
    		maxCur =  -prices[0];
    		for (int j=1;j<n;j++){
    			profit[i][j] = Math.max(profit[i][j - 1], prices[j] + maxCur);
                maxCur =  Math.max(maxCur, profit[i - 1][j - 1] - prices[j]);
                
    			//maxCur = Math.max(0, maxCur+prices[j]-prices[j-1]);
    			//profit[i][j]= Math.max(profit[i][j-1], maxCur);
    			
    		}
    	}
    	
    	return profit[k][n-1];
        
    }
    
    public int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }

}
