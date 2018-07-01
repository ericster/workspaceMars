import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
	
	public static void main(String[] args) {
		String s = " the        sky   is blue   ";
		String res;
		res = reverseWords(s);
		System.out.println("result:" + res);

	}

	public static String reverseWords(String s) {
		/*
		String[] words = s.trim().split(" +");
		Collections.reverse(Arrays.asList(words));
		return String.join(" ", words);
		*/
		char[] sa = s.toCharArray();
		reverseWords(sa);
		return String.valueOf(sa);
	}
	
	/*
	   String s = "the        sky   is blue";
	 * reversed whole eulb si   yks        eht
	   result blue is sky   the 
	   reversed whole eulb si   yks        eht
	                         56
	   result blue is   sky        the
	   reversed whole eulb si   yks        eht
	   result blue is sky   the 
	   reversed whole eulb si   yks        eht
	   result blue is   sky        the
	   result:   blue is   sky        the 
	 */
	public static void reverseWords(char[] sa) {
		// Three step to reverse
		// 1, reverse the whole sentence
		reverse(sa, 0, sa.length - 1);
		System.out.println("reversed whole " + String.valueOf(sa));
		// 2, reverse each word
		int start = 0;
		for (int i = 0; i < sa.length; i++) {
			if (sa[i] == ' ') {
				if (i==0 || sa[i-1]== ' ') {
					start = i+1;
					System.out.println("skip " + i);
					continue;
				}
				reverse(sa, start, i - 1);
				start = i + 1;
			}
		}
		// 3, reverse the last word, if there is only one word this will solve the corner case
		reverse(sa, start, sa.length - 1);
	}

	public static void reverse(char[] s, int start, int end) {
		while (start < end) {
			char temp = s[start];
			s[start] = s[end];
			s[end] = temp;
			start++;
			end--;
		}
	}
}