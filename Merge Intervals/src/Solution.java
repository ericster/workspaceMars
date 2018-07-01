import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) {
		/*
		 * 	Given [1,3],[2,6],[8,10],[15,18],
		 * 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18
		 *   _______
		 * _____  
		 *       _____        
		 *               	 
		 *   _____           
		 *     _________          
		 *                 _______ 
		 *                					   _____ 
		 *                 				
		 *               
			return [1,6],[8,10],[15,18].
			
			1 2  8 15
			3 6 10 18
			
			1 2 3(e) 6(e) 8 10(e) 15 18(e)
			
			
			skyline(?)
		 */
    	List<Interval> result = new ArrayList<Interval>();
    	List<Interval> intervals = new ArrayList<Interval>();
    	/*
    	intervals.add(new Interval(1,3));
    	intervals.add(new Interval(2,6));
    	intervals.add(new Interval(8,10));
    	intervals.add(new Interval(15,18));
    	*/
    	//intervals.add(new Interval(0,0));
    	//intervals.add(new Interval(1,4));
    	//intervals.add(new Interval(0,4));
    	//intervals.add(new Interval(1,4));
    	// [[1,4],[0,0]] -> [[0,0],[1,4]]
    	// [[1,4],[0,4]] -> [[0,4]]
    	// [[1,4],[0,2],[3,5]] -> [[0,5]], [[0,2],[3,5]]
    	//intervals.add(new Interval(1,4));
    	//intervals.add(new Interval(0,2));
    	//intervals.add(new Interval(3,5));
    	// [[1,4],[4,5]] - > [[1,5]]
    	//intervals.add(new Interval(1,4));
    	//intervals.add(new Interval(4,5));
    	//[[2,3],[5,5],[2,2],[3,4],[3,4]]
    	intervals.add(new Interval(2,3));
    	intervals.add(new Interval(5,5));
    	intervals.add(new Interval(2,2));
    	intervals.add(new Interval(3,4));
    	intervals.add(new Interval(3,4));
    	/*
    	*/
    	
    	result = merge(intervals);
    	
    	for (Interval item : result){
			System.out.println("result : " + item.start + " : " + item.end);
    	}
	}

	/**
	 * Definition for an interval.
	 */
	 public static class Interval {
	     int start;
	     int end;
	     Interval() { start = 0; end = 0; }
	     Interval(int s, int e) { start = s; end = e; }
	 }
	
	 
	 public static List<Interval> merge(List<Interval> intervals) {
			// sort start&end
			int n = intervals.size();
			int[] starts = new int[n];
			int[] ends = new int[n];
			for (int i = 0; i < n; i++) {
				starts[i] = intervals.get(i).start;
				ends[i] = intervals.get(i).end;
			}
			Arrays.sort(starts);
			Arrays.sort(ends);
			// loop through
			List<Interval> res = new ArrayList<Interval>();
			for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
				if (i == n - 1 || starts[i + 1] > ends[i]) {
					res.add(new Interval(starts[j], ends[i]));
					j = i + 1;
				}
			}
			return res;
		}
	 
    public static List<Interval> merge_1(List<Interval> intervals) {
    	if (intervals == null || intervals.size() == 0) return intervals;
    	List<Interval> result = new ArrayList<Interval>();
		 List<int[]> heights = new ArrayList<>();

		 for (Interval b: intervals) {

			 heights.add(new int[]{b.start, b.start} );
			 if (b.end==0){
				 heights.add(new int[]{b.end, -1});
			 }
			 else {
				 heights.add(new int[]{b.end, - b.end});
				 
			 }

		 }

		 /*
		 for (int[] e : heights){
			 System.out.println("height is: " + e[0] + " , " + e[1]);
		 }
		 */
		 Collections.sort(heights, (a, b) -> (a[0] == b[0]) ? b[1] - a[1] : a[0] - b[0]);
		 for (int[] e : heights){
			 System.out.println("Sorted height is: " + e[0] + " , " + e[1]);
		 }
    	
    	// 0, 1, 2(e), 3, 4(e), 5(e)
    	// 1, 2, 3(e), 6(e), 8, 10(e)
    	// 0 (se), 1, 4


	    	/*
	    	 *  Sorted height is: 0 , 0
				Sorted height is: 0 , 0
				Sorted height is: 1 , 1
				Sorted height is: 4 , -4
				cnt is : -2
				result : 0 : 4

				Sorted height is: 0 , 0
				Sorted height is: 1 , 1
				Sorted height is: 4 , -4
				Sorted height is: 4 , -4
				cnt is : -2
				result : 0 : 4
	    	*/
    	int s_val = heights.get(0)[0];
    	int e_val = Integer.MIN_VALUE;
    	int tmp;
    	int cnt=0;
    	for (int[] h : heights){
    		if (h[1] >= 0 ){
    			tmp = h[0];
    			if (tmp > e_val && e_val >= 0 && cnt==0){
    			//if (tmp > e_val && e_val >= 0 ){
					result.add(new Interval(s_val, e_val));
					s_val = tmp;
    			}
    			cnt++;
    		}
    		else{ 
    			tmp = h[0] ;
    			e_val = Math.max(e_val, tmp);
    			cnt--;
    		}

    	}
    	System.out.println("cnt is : " + cnt);
		result.add(new Interval(s_val, e_val));
    	return result;
    }

    public static List<Interval> merge_0(List<Interval> intervals) {
    	if (intervals == null || intervals.size() == 0) return intervals;
    	List<Interval> result = new ArrayList<Interval>();
	    TreeMap<Integer, Boolean> interval = new TreeMap<Integer, Boolean>();
    	for (Interval item : intervals){
    		interval.put(item.end, false );
    		interval.put(item.start, true);
    		System.out.println("item is :" + item.start + " : " + item.end);
    	}
    	for (Integer item : interval.keySet()){
			System.out.println("interval : " +item);
    	}
    	
    	int s_val = interval.firstKey() ;
    	int e_val = 0;
    	int tmp;
    	
    	// 0, 1, 2(e), 3, 4(e), 5(e)
    	// 1, 2, 3(e), 6(e), 8, 10(e)
    	// 0 (se), 1, 4
    	int cnt=0;
    	for (int item : interval.keySet()){
    		if (interval.get(item) ){
    			tmp = item;
    			if (tmp >= e_val && e_val >= 0 && cnt==0){
					result.add(new Interval(s_val, e_val));
					s_val = tmp;
    			}
    			cnt++;
    		}
    		else{ 
    			tmp = item ;
    			e_val = Math.max(e_val, tmp);
    			cnt--;
    		}

    	}
    	System.out.println("cnt is : " + cnt);
		result.add(new Interval(s_val, e_val));
    	return result;
    }
	
	

}
