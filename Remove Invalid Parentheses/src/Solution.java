import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		/*
		 * 	"()())()" -> ["()()()", "(())()"]
			"(a)())()" -> ["(a)()()", "(a())()"]
			")(" -> [""]
		 */

    	List<String> result = new ArrayList<String>();
		String s = "()())()"; 
		//s = "(a)())()";
		//s = ")(";
		//s = "\"\"";
		//s = "n";
		//s = "))";
		//s = "()";
		//s = ")(f";
		//s = "(";
		//s = "))";
		//s = "p(r)";
		//s = "i))((()(n(())i((((";
		//s = "(())))(((((vp)()((";
		//s = ")))())((p((())a(())(";
		//s = ")()()i)())b(())h))))";
		
		
		result = removeInvalidParentheses(s);
		
		System.out.println("result is : " + result.toString());
		/*
		 * 	result is : [((i(b(()h)))), ((i(b(())h))), ((i()b((h)))), ((i()b(()h))), ((i()b(())h)), ((i())b((h))), ((i())b(()h)), ((i())b(())h), ((i)(b((h)))), ((i)(b(()h))), ((i)(b(())h)), ((i)()b((h))), ((i)()b(()h)), ((i)()b(())h), ((i)())b((h)), ((i)())b(()h), ((i)())b(())h, (()i(b((h)))), (()i(b(()h))), (()i(b(())h)), (()i()b((h))), (()i()b(()h)), (()i()b(())h), (()i())b((h)), (()i())b(()h), (()i())b(())h, (()i)(b((h))), (()i)(b(()h)), (()i)(b(())h), (()i)()b((h)), (()i)()b(()h), (()i)()b(())h, ()(i(b((h)))), ()(i(b(()h))), ()(i(b(())h)), ()(i()b((h))), ()(i()b(()h)), ()(i()b(())h), ()(i())b((h)), ()(i())b(()h), ()(i())b(())h, ()(i)(b((h))), ()(i)(b(()h)), ()(i)(b(())h), ()(i)()b((h)), ()(i)()b(()h), ()(i)()b(())h, ()()i(b((h))), ()()i(b(()h)), ()()i(b(())h), ()()i()b((h)), ()()i()b(()h), ()()i()b(())h]
			result is : [((i(b(()h)))), ((i(b(())h))), ((i()b((h)))), ((i()b(()h))), ((i()b(())h)), ((i())b((h))), ((i())b(()h)), ((i())b(())h), ((i)(b((h)))), ((i)(b(()h))), ((i)(b(())h)), ((i)()b((h))), ((i)()b(()h)), ((i)()b(())h), ((i)())b((h)), ((i)())b(()h), ((i)())b(())h, (()i(b((h)))), (()i(b(()h))), (()i(b(())h)), (()i()b((h))), (()i()b(()h)), (()i()b(())h), (()i())b((h)), (()i())b(()h), (()i())b(())h, (()i)(b((h))), (()i)(b(()h)), (()i)(b(())h), (()i)()b((h)), (()i)()b(()h), (()i)()b(())h, ()(i(b((h)))), ()(i(b(()h))), ()(i(b(())h)), ()(i()b((h))), ()(i()b(()h)), ()(i()b(())h), ()(i())b((h)), ()(i())b(()h), ()(i())b(())h, ()(i)(b((h))), ()(i)(b(()h)), ()(i)(b(())h), ()(i)()b((h)), ()(i)()b(()h), ()(i)()b(())h, ()()i(b((h))), ()()i(b(()h)), ()()i(b(())h), ()()i()b((h)), ()()i()b(()h), ()()i()b(())h]
			result is : [((i(b(()h)))), ((i(b(())h))), ((i()b((h)))), ((i()b(()h))), ((i()b(())h)), ((i())b((h))), ((i())b(()h)), ((i())b(())h), ((i)(b((h)))), ((i)(b(()h))), ((i)(b(())h)), ((i)()b((h))), ((i)()b(()h)), ((i)()b(())h), ((i)())b((h)), ((i)())b(()h), ((i)())b(())h, (()i(b((h)))), (()i(b(()h))), (()i(b(())h)), (()i()b((h))), (()i()b(()h)), (()i()b(())h), (()i())b((h)), (()i())b(()h), (()i())b(())h, (()i)(b((h))), (()i)(b(()h)), (()i)(b(())h), (()i)()b((h)), (()i)()b(()h), (()i)()b(())h, ()(i(b((h)))), ()(i(b(()h))), ()(i(b(())h)), ()(i()b((h))), ()(i()b(()h)), ()(i()b(())h), ()(i())b((h)), ()(i())b(()h), ()(i())b(())h, ()(i)(b((h))), ()(i)(b(()h)), ()(i)(b(())h), ()(i)()b((h)), ()(i)()b(()h), ()(i)()b(())h, ()()i(b((h))), ()()i(b(()h)), ()()i(b(())h), ()()i()b((h)), ()()i()b(()h), ()()i()b(())h]
		 */



	}
	// "()())()"
	public static List<String> removeInvalidParentheses(String s) {
	    int rmL = 0, rmR = 0;
	    for (int i = 0; i < s.length(); i++) {
	        if (s.charAt(i) == '(') {
	            rmL++;
	        } else if (s.charAt(i) == ')') {
	            if (rmL != 0) {
	                rmL--;
	            } else {
	                rmR++;
	            }
	        }
	    }
	    Set<String> res = new HashSet<>();
	    dfs(s, 0, res, new StringBuilder(), rmL, rmR, 0);
	    return new ArrayList<String>(res);
	}

	public static void dfs(String s, int i, Set<String> res, StringBuilder sb, int rmL, int rmR, int open) {
	    if (rmL < 0 || rmR < 0 || open < 0) {
	        return;
	    }
	    if (i == s.length()) {
	        if (rmL == 0 && rmR == 0 && open == 0) {
	            res.add(sb.toString());
	        }        
	        return;
	    }

	    char c = s.charAt(i); 
	    int len = sb.length();

	    if (c == '(') {
	        dfs(s, i + 1, res, sb, rmL - 1, rmR, open);		    // not use (
	    	dfs(s, i + 1, res, sb.append(c), rmL, rmR, open + 1);       // use (

	    } else if (c == ')') {
	        dfs(s, i + 1, res, sb, rmL, rmR - 1, open);	            // not use  )
	    	dfs(s, i + 1, res, sb.append(c), rmL, rmR, open - 1);  	    // use )

	    } else {
	        dfs(s, i + 1, res, sb.append(c), rmL, rmR, open);	
	    }

	    sb.setLength(len);        
	}
	
	public static List<String> removeInvalidParentheses_3(String s) {
	    List<String> ans = new ArrayList<>();
	    remove(s, ans, 0, 0, new char[]{'(', ')'});
	    return ans;
	}
	// "()())()"
	public static void remove(String s, List<String> ans, int last_i, int last_j,  char[] par) {
	    for (int stack = 0, i = last_i; i < s.length(); ++i) {
	        if (s.charAt(i) == par[0]) stack++;
	        if (s.charAt(i) == par[1]) stack--;
	        if (stack >= 0) continue;
	        for (int j = last_j; j <= i; ++j)
	            if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
	                remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
	        return;
	    }
	    String reversed = new StringBuilder(s).reverse().toString();
	    if (par[0] == '(') // finished left to right
	        remove(reversed, ans, 0, 0, new char[]{')', '('});
	    else // finished right to left
	        ans.add(reversed);
	}
	
    public static List<String> removeInvalidParentheses_2(String s) {
        List<String> res = new ArrayList<>();
        
        // sanity check
        if (s == null) return res;
        
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        // initialize
        queue.add(s);
        visited.add(s);
        
        boolean found = false;
        
        while (!queue.isEmpty()) {
          s = queue.poll();
          
          if (isValid(s)) {
            // found an answer, add to the result
            res.add(s);
            found = true;
          }
        
          if (found) continue;
        
          // generate all possible states
          for (int i = 0; i < s.length(); i++) {
            // we only try to remove left or right paren
            if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;
          
            String t = s.substring(0, i) + s.substring(i + 1);
          
            if (!visited.contains(t)) {
              // for each state, if it's not visited, add it to the queue
              queue.add(t);
              visited.add(t);
            }
          }
        }
        
        return res;
      }
      
      // helper function checks if string s contains valid parantheses
      static boolean isValid(String s) {
        int count = 0;
      
        // String t = ")()(";
        for (int i = 0; i < s.length(); i++) {
          char c = s.charAt(i);
          if (c == '(') count++;
          if (c == ')' && count-- == 0) return false;
        }
      
        return count == 0;
      }
      
    public static List<String> removeInvalidParentheses_1(String s) {
    	Queue<String> queue = new LinkedList<String>();
    	List<String> result = new ArrayList<>();
    	/**** to pass TLE **********/
        Set<String> visited = new HashSet<>();
    	if (s.equals("")){
    		result.add(s);
    		System.out.println("empty string size is : " + result.size());
    		return result;
    	}
    	queue.offer(s);
        visited.add(s);
    	int level = 1;
    	String squeue;
    	String tmp;
    	while(!queue.isEmpty()){
    		int queueLen = queue.size();
			System.out.println("level is : " + level);
    		for (int m=0;m<queueLen;m++){
				squeue = queue.poll();
				if (isValid(squeue)){
					result.add(squeue);
					//return result;
				}
				System.out.println("squeue is : " + squeue);
				int len = squeue.length();
				System.out.println("len is: " + len);
				for(int i=0;i<squeue.length();i++){
					// we only try to remove left or right paren
					if (squeue.charAt(i) != '(' && squeue.charAt(i) != ')') continue;
					tmp = squeue.substring(0, i) + squeue.substring(i+1);
					if (isValid(tmp) && !result.contains(tmp) && !tmp.equals("")){
							result.add(tmp);
					}
					//if(!queue.contains(tmp)){
					if (!visited.contains(tmp)) {
						queue.offer(tmp);
						visited.add(tmp);
						System.out.println(tmp);
					}
				}
    		}
			level++;
			if (result.size() > 0){
				return result;
			}
    	}
		if (result.size()==0){
			result.add("\"\"");
			return result;
		}
    	return result;
	}    
    
    
    public static List<String> removeInvalidParentheses_0(String s) {
    	Character[] par = {'(', ')', '[', ']', '{', '}'};
    	List<Character> parList= Arrays.asList(par);
    	Queue<String> queue = new LinkedList<String>();
    	List<String> result = new ArrayList<>();
    	if (s.equals("")){
    		result.add(s);
    		System.out.println("empty string size is : " + result.size());
    		return result;
    	}
    	queue.offer(s);
    	int level = 1;
    	String squeue;
    	String tmp;
    	while(!queue.isEmpty()){
    		int queueLen = queue.size();
			System.out.println("level is : " + level);
    		for (int m=0;m<queueLen;m++){
				squeue = queue.poll();
				if (isValid(squeue)){
					result.add(squeue);
					return result;
				}
				System.out.println("squeue is : " + squeue);
				int len = squeue.length();
				System.out.println("len is: " + len);
				for(int i=0;i<squeue.length();i++){
					// to avoid TLE
					// we only try to remove left or right paren
					if (squeue.charAt(i) != '(' && squeue.charAt(i) != ')') continue;
					/*
					if (i==0){
							tmp = squeue.substring(i+1);
					}
					else if(i==len-1){
							tmp = squeue.substring(0, len-1);
					}
					else{
							tmp = squeue.substring(0, i) + squeue.substring(i+1);
							
					}
					*/
					tmp = squeue.substring(0, i) + squeue.substring(i+1);
					if (isValid(tmp) && !result.contains(tmp) && !tmp.equals("")){
							result.add(tmp);
					}
					if(!queue.contains(tmp)){
						queue.offer(tmp);
						System.out.println(tmp);
					}
				}
    		}
			level++;
			if (result.size() > 0){
				return result;
			}
    	}
		if (result.size()==0){
			result.add("\"\"");
			return result;
		}
    	return result;
	}    
    
    public static boolean isValid_sol(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			//else if (c == '{')
			//	stack.push('}');
			//else if (c == '[')
			//	stack.push(']');
			else if (Character.isAlphabetic(c))
				continue;
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
    }

}
