import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		
		String s = "barfoothefoobarman";
		String[] words = {"foo", "bar"};
		List<Integer> res = new ArrayList<>();
		res = findSubstring_1(s, words);
		System.out.println("res " + res);

	}

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(words.length == 0 || s.length() < words.length * words[0].length()){
            return res;
        }
        Map<String, Integer> hm = new HashMap<>(), tempMap = new HashMap<>();
        for(String str : words){
        	hm.put(str, hm.getOrDefault(str, 0)+1);
        }
        int wl = words[0].length();
        int begin = 0, end = 0;
        /*
         * 
		String s = "bar foo the foo bar man";
		t           0    0   0   1   1            
		c           1    1   0   1   2              
		w           1    1   1   1                
		String[] words = {"foo", "bar"};
         */
        for(int i = 0; i < wl; i++){
            int counter = 0;
            int wCounter = 0;
            begin = i; end = i;
            while(end + wl <= s.length()){
                String str1 = s.substring(end, end + wl);
                if(hm.containsKey(str1)){
                	tempMap.put(str1, tempMap.getOrDefault(str1, 0)+1);
                    if(tempMap.get(str1) <= hm.get(str1)) counter++;
                }
                end += wl;
                wCounter++;
                if(counter == words.length){
                    res.add(begin);
                }
                if(wCounter == words.length){
                    String temp = s.substring(begin, begin + wl);
                    if(hm.containsKey(temp)){
                        if(tempMap.get(temp) <= hm.get(temp)) counter--;
                        tempMap.put(temp, tempMap.get(temp)-1);
                    }
                    begin += wl;
                    wCounter--;
                }
            }
            tempMap.clear();
        }
        return res;
    }
    
    public static List<Integer> findSubstring_1(String s, String[] words) {
        String S=s;
        String[] L = words;
        List<Integer> res = new ArrayList<Integer>();
        if (S == null || L == null || L.length == 0) return res;
        int num = words.length;
        int len = words[0].length();
        Set<Integer> set = new HashSet<>();
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.containsKey(word) ? count.get(word) + 1 : 1) ;
        }
        for (int i = 0; i < s.length() - num * len + 1; ++i) {
            // Check whether it is the same as a checked one.
            String sub1 = s.substring(i >= len ? i - len : 0, i);
            String sub2 = s.substring(i + num * len - len, i + num * len);
            System.out.println("i " + i + " sub1 "+ sub1 + " sub2 " + sub2);
            if (sub1.equals(sub2)) {
                if (set.contains(i - len)) {
                    res.add(i);
                    set.add(i);
                }
                continue;
            }
        /*
         * 
		String s = "bar foo the foo bar man";
		t           0    0   0   1   1            
		c           1    1   0   1   2              
		w           1    1   1   1                
		String[] words = {"foo", "bar"};
         */

            Map<String, Integer> seen = new HashMap<>();
            int j = i;
            for (; j < i + num * len; j += len) {
                String sub = s.substring(j, j + len);
                System.out.println("i " + i + " sub " + sub);
                if (! count.containsKey(sub)) {
                    break;
                } else {
                    seen.put(sub, seen.containsKey(sub) ? seen.get(sub) + 1 : 1);
                }
                if (seen.get(sub) > count.get(sub)) break;
            }
            if (j == i + num * len) {
                res.add(i);
                set.add(i);
            }
        }
        return res;
    }

}
