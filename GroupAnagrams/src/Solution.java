import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
		//System.out.println("input" + Arrays.toString(input));
		groupAnagrams(input);

	}
	
    public static List<List<String>> groupAnagrams(String[] strs) {
    	HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
    
    	int len = strs.length;
    	for (int i=0;i<len;i++){
    		String org = strs[i];
    		char[] tmp = strs[i].toCharArray();
    		Arrays.sort(tmp);
    		String sorted = String.valueOf(tmp);
    		//System.out.println("sorted : " + sorted);
    		List<String> initValue = new ArrayList<String>();
    		List<String> tmpValue = new ArrayList<String>();
    		if (!hm.containsKey(sorted)) {
    			initValue.add(org);
    			hm.put(sorted, initValue);
    		}
    		else {
    			tmpValue = hm.get(sorted);
    			tmpValue.add(org);
    		}
    	}
    	
    	List<List<String>> result = new ArrayList<List<String>>();
    	for (Map.Entry<String, List<String>> entry:hm.entrySet()){
    		System.out.println("Key : " + entry.getKey());
    		List<String> tmp = entry.getValue();
    		result.add(tmp);
    		System.out.println("Value : " + Arrays.toString(tmp.toArray()));
    	}
    	
    	
    	return result;
        
    }

}
