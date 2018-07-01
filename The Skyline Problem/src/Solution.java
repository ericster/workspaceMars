import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) {
		int[][] buildings = { {2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8} };
		//[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
		List<int[]> result;
		result = getSkyline(buildings);
		for( int[] item : result){
			System.out.println("Skyline x : " + item[0] + " y: " + item[1]);
		}

	}
	
	public static List<int[]> getSkyline_0(int[][] buildings) {
		// 1. data set of events - sort, with -ve, ve
        List<int[]> heights = new ArrayList<>();
        for (int[] b: buildings) {
            heights.add(new int[]{b[0], - b[2]});
            heights.add(new int[]{b[1], b[2]});
        }
        Collections.sort(heights, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
        // 2. sweepline status data set - Tree map for removal in O(logn)
        TreeMap<Integer, Integer> heightMap = new TreeMap<>(Collections.reverseOrder());
        heightMap.put(0,1);
        int prevHeight = 0;
        // 3. output under construction - update if top height changes
        List<int[]> skyLine = new LinkedList<>();
        for (int[] h: heights) {
            if (h[1] < 0) {
                Integer cnt = heightMap.get(-h[1]);
                cnt = ( cnt == null ) ? 1 : cnt + 1;
                heightMap.put(-h[1], cnt);
            } else {
                Integer cnt = heightMap.get(h[1]);
                if (cnt == 1) {
                    heightMap.remove(h[1]);
                } else {
                    heightMap.put(h[1], cnt - 1);
                }
            }
            int currHeight = heightMap.firstKey();
            if (prevHeight != currHeight) {
                skyLine.add(new int[]{h[0], currHeight});
                prevHeight = currHeight;
            }
        }
        return skyLine;
    }
    public static List<int[]> getSkyline(int[][] buildings) {
		// 1. data set of events - sort, with -ve, ve
        List<int[]> points = new ArrayList<>();
        for(int [] b : buildings){
            points.add(new int[]{b[0], -b[2]});
            points.add(new int[]{b[1], b[2]});
        }
        Collections.sort(points, (p1, p2) -> (p1[0] == p2[0]) ? p1[1] - p2[1] : p1[0] - p2[0]);
        /*
        Collections.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int [] p1, int [] p2){
                if(p1[0] == p2[0]) return p1[1] -p2[1];
                else return p1[0] - p2[0];
            }
        });
        */
        // 2. sweepline status data set - Tree map for removal in O(logn)
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();// using TreeMap to archive TreeMultiSet
        // 3. output under construction - update if top height changes
        List<int[]> result = new ArrayList<>();
        treeMap.put(0, 1);//add a sentinel to avoid processing with empty TreeMap
        int prev = 0;
        for(int [] point: points){
            if(point[1]<0) treeMap.put(-point[1], treeMap.getOrDefault(-point[1], 0) + 1);//reach a new rectangle, height count+1
            else {
                treeMap.put(point[1], treeMap.getOrDefault(point[1], 0) - 1);//leave a new rectangle, height count-1
                if(treeMap.get(point[1]) == 0) treeMap.remove(point[1]);
            }
            int cur = treeMap.lastKey();
            if(prev != cur){//find a new skyline strip
                result.add(new int[]{point[0], cur});
                prev = cur;
            }
        }
        return result;
    }
}
