
public class Solution {

	public static void main(String[] args) {
		
		int n = 26;
		System.out.println("Sheet title is " + convertToTitle(n));

	}
	
	
    public static String convertToTitle(int n) {
    	
    	StringBuilder sb = new StringBuilder();
    	int c, mod;
    	while (n > 0){
    		mod = (n%26==0) ? 26: n%26;
    		System.out.println("mod is " + mod);
    		c = 'A' +  mod - 1;
    		sb.append((char)c);
    		n = (n%26==0) ?  n/26 -1 : n/26;
    	}
    	return sb.reverse().toString();
        
    }
    
    
    public String convertToTitle_0(int n) {
        StringBuilder result = new StringBuilder();

        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }

        return result.toString();
    }

}
