
public class Solution {

	public static void main(String[] args) {
		String haystack = "This is not a joke in the needle to find needle again.";
		String needle = "needle";
		haystack = "";
		needle = "";
		//haystack = "aaa";
		//needle = "aaaa";
		//haystack = "mississippi";
		//needle = "issipi";
		//needle = "a";
		//haystack = "the needle";
		//needle = "needle";
		
		int index = strStr(haystack, needle);
		System.out.println("Found the needle at index : " + index);

	}
	
    public static int strStr(String haystack, String needle) {
    	int m = haystack.length();
    	int n = needle.length();
    	if (n==0) return 0;
    	//if (n>m) return -1;
    	for (int i=0;i<=m-n;i++){
    		System.out.println("haystack at " + i+ " is :" + haystack.charAt(i) );
    		int j;
			for (j=0;j<needle.length();j++){
				if (haystack.charAt(i+j)!=needle.charAt(j)){
					System.out.println("break at " + j);
					break;
				}
				System.out.println("needle at " + j+ " is :" + needle.charAt(j) );
			}
			if (j==n) return i;
    	}
    	return -1;
    }

    public static int strStr_1(String haystack, String needle) {
    	int cnt = -1;
    	if (needle.length()==0) return 0;
    	if (needle.length()>haystack.length()) return -1;
    	for (int i=0;i<haystack.length();i++){
    		System.out.println("haystack at " + i+ " is :" + haystack.charAt(i) );
    		if (haystack.charAt(i) == needle.charAt(0) && haystack.length()-i >= needle.length()){
    			int j;
    			cnt =0;
    			for (j=1;j<needle.length();j++){
					System.out.println("needle at " + j+ " is :" + needle.charAt(j) );
    				if (haystack.charAt(i+j)!=needle.charAt(j)){
    					cnt=0;
    					break;
    				}
    				else {
    					cnt++;
    				}
    			}
    		}
    		if (cnt==needle.length()-1){
    			return i;
    		}
    	}
    	return -1;
    }

}
