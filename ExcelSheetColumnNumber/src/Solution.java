
public class Solution {

	public static void main(String[] args) {

		String[] input = {"A", "B", "C" , "Z", "AA", "AB", "AAA"};
		for (int i=0;i<input.length;i++){
			System.out.println(" number is : " + titleToNumber(input[i]));
		}
	}
	
    public static int titleToNumber(String s) {
    	int result = 0;
    	int m = s.length();
    	for (int i=0; i<m;i++){
    		result +=  Math.pow(26, i)* (s.charAt(m-1-i) - 'A' + 1);
    	}
    	return result;
    }

}
