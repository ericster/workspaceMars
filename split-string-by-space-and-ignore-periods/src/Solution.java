
public class Solution {

	public static void main(String[] args) {
		String testString = "This. is. a. test. string.";
		//String[] test = testString.split(" ");
		String[] test = testString.split("\\.\\s*");

		for (int i = 0; i < test.length; i++) {
		    System.out.println(test[i]);
		}
	}

}
