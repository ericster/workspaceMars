
public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String num2 = "123";
		//String num1 = "32";
		//String num2 = "9";
		//String num1 = "9";
		//String num1 = "99";
		//String num2 = "9";
		// ** order issue
		//String num2 = "456";
		//String num1 = "123";
		//String num2 = "999";
		//String num1 = "999";
		//String num2 = "5";
		//String num1 = "408";
		String num2 = "1";
		String num1 = "1";
		String result = multiply(num1, num2);
		System.out.println("Result is " + result);

	}
	
    public static String multiply(String num1, String num2) {
        System.out.println("Int max " + Integer.MAX_VALUE);
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        
        int m = num1.length();
        int n = num2.length();
        
        StringBuilder Result = new StringBuilder();
        StringBuilder tmpResult = new StringBuilder(m*n+1);
		int tmpRem = 0;
		int tmpSum = 0;
		int tmpCarry = 0;
		int prevRem = 0;
        for(int i=m-1; i>=0; i--){
        	int n1 = num1.charAt(i) - 48;  //OOB
        	System.out.println("number at i is " + n1);
        	for (int j=n-1; j>=0; j--){
				int n2 = num2.charAt(j) - 48; // OOB
				System.out.println("number at j is " + n2);
				int tmp = n1*n2;
				System.out.println("tmp is " + tmp);
				tmpRem = tmp % 10 ;
				System.out.println("tmpRem is " + tmpRem);
				// previous value
				//if ( j!=0 && i!=m-1){
				if ( i!=m-1){
					prevRem = tmpResult.charAt(n-j + (m-1) -i -1) - 48; // OOB
				}
				else {
					prevRem = 0;
				}
				System.out.println("prevRem is " + prevRem);
				System.out.println("curCarry is " + tmpCarry);
				tmp += tmpCarry + prevRem ;
				tmpRem =  tmp % 10;
				System.out.println("tmpRem2 is " + tmpRem);
				tmpCarry = tmp / 10;
				System.out.println("tmpCarry is " + tmpCarry);
				
				// add
				if (i==m-1 ){
					System.out.println("tmpRem added at i = " + i + " j = " + j );
					tmpResult.append((char) (tmpRem + 48));
					if (j == 0 && tmpCarry !=0){
						System.out.println("tmpCarry is added");
						tmpResult.append((char) (tmpCarry + 48));
						tmpCarry = 0;
					} 
					else if (j == 0 && tmpCarry ==0){
						tmpResult.append((char) ('0'));
					}
				}
				// replace and add carry if any
				else {
					System.out.println("tmpRem replaced ");
					tmpResult.setCharAt(n-j-1 + (m-1) - i, (char) (tmpRem + 48));
					if (j==0 && tmpCarry !=0){
						System.out.println("tmpCarry added at i = " + i + " j = " + j );
						tmpResult.append((char) (tmpCarry + 48));
						tmpCarry = 0;
					}
					else if (i> 0 && j == 0 && tmpCarry ==0){
						tmpResult.append((char) ('0'));
					}
				}
				
				System.out.println("tmpResult is " + tmpResult.toString());
        	}
        	
        }
        // Last carry
		if (tmpCarry !=0){
			System.out.println("tmpCarry is added");
			tmpResult.append((char) (tmpCarry + 48));
			tmpCarry = 0;
		}
        
        Result = tmpResult.reverse();
        
        if (Result.charAt(0)== '0'){
        	return Result.substring(1);
        } 
        else {
        	return Result.toString();
        	
        }
        
    }

}
