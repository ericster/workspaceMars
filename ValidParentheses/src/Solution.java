import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		String s ="{(1234abc)}";
		s ="{(1234abc)}";
		s ="([)]";
		s = "[";
		s = "]";
		s = "{{)}";
		s ="()[]{}";
		if (isValid_sol(s)){
			System.out.println("Matching");
		}
		else {
			System.out.println("Not matching");
		}

	}
	
    public static boolean isValid_sol(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
    }
	
    public static boolean isValid(String s) {
    	int len = s.length();
    	List<Character> left_brackets = new ArrayList<Character>(Arrays.asList( '(', '{', '['));
    	List<Character> right_brackets = new ArrayList<Character>(Arrays.asList( ')', '}', ']'));
    	Stack<Character> stack = new Stack<Character>();
    	
    	char left_par, right_par;
    	for (int i=0;i<len;i++){
    		if (left_brackets.contains(s.charAt(i) )){
    			System.out.println("left char at : " + i + " is : "+ s.charAt(i));
				stack.push(s.charAt(i));
    		}
    		if (right_brackets.contains(s.charAt(i) )){
    			if (stack.isEmpty()) return false;
				left_par = stack.pop();
				right_par = s.charAt(i);
    			System.out.println("left char  popped: " + left_par);
    			System.out.println("right char at : " + i + " is : "+ s.charAt(i));
				if (Math.abs(right_par - left_par) > 3) return false;
    		}
    	}
    	if (!stack.isEmpty()) return false;
    	return true;
    }

}
