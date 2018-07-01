
public class Solution {

	public static void main(String[] args) {
	
		String s = "A man, a plan, a canal: Panama";
		s = "race a car";
		s = ".,";
		if (isPalindrome(s)){
			System.out.println("This is Palindrome");
		}
		else {
			System.out.println("This is NOT palindrome");
		}

	}
	
    public static boolean isPalindrome(String s) {
    	String str = s.toLowerCase();
    	char a, b;
    	int start = 0;
    	int end = s.length()-1;
    	while (start < end){
    		while (!isAlphaNumeric(str.charAt(start))) {
				System.out.println("start = " + start);
    			if (start >= end) break;
    			start++;
    		}
    		while (!isAlphaNumeric(str.charAt(end))) {
				System.out.println("end = " + end);
    			if (start >= end) break;
    			end--;
    		}
    		System.out.println("a = " + str.charAt(start));
    		System.out.println("b = " + str.charAt(end));
    		System.out.println("start = " + start);
    		System.out.println("end = " + end);
    		if (str.charAt(start) != str.charAt(end)) return false;
    		start++;
    		end--;
    	}
    	
    	return true;
    }
    
    public static boolean isAlphaNumeric(char c){
    	if ( (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z' )) return true;
    	return false;
    	
    }

}
