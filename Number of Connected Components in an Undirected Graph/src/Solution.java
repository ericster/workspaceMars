import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		
		int[][] edges = new int[][]{{0,1}, {1,2}, {2,3}, {3,4}};  
		edges = new int[][]{{0,1}, {1,2}, {3,4}};  
		edges = new int[][]{{1,0}};  
		int n = 2;
		countComponents(n, edges);

	}
	
    public static int countComponents(int n, int[][] edges) {
    	
    	System.out.println("row size is " + edges.length); 
    	System.out.println("column size is " + edges[0].length); 

		List<Integer>[] adj = new LinkedList[n];
		for (int i=0;i<n;i++){
			adj[i] = new LinkedList();
		}
		boolean[] visited = new boolean[n];
		
		int k = edges.length;
		int m = edges[0].length;
		
		for (int i=0;i<k;i++){
			System.out.println("v is " + edges[i][0] + " connected to " + edges[i][1]);
			adj[edges[i][0]].add(edges[i][1]);
			adj[edges[i][1]].add(edges[i][0]);
		}

		for (int i=0;i<n;i++){
			int size = adj[i].size();
			System.out.println(" v is " + i + " has node " + size);
		}
		
		int cnt = 0;
		for (int i=0;i<n;i++){
			if (!visited[i]){
				System.out.println("current i is " + i );
				System.out.println("visisted " + Arrays.toString(visited));
				dfs(i, adj, visited);
				cnt++;
			}

		}
		
		System.out.println("No of islands is " + cnt);
    	return -1;
        
    }
    
    public static void dfs (int v, List<Integer>[] adj, boolean[] visited){
    	visited[v] = true;
		System.out.println("   current v is " + v );
		System.out.println("   visisted " + Arrays.toString(visited));
    	int len = adj[v].size();
    	for (int i=0;i<len;i++){
			System.out.println("   adj v " + adj[v].get(i));
    		if (!visited[adj[v].get(i)]){
    			dfs(adj[v].get(i), adj, visited);
    		}
    		
    	}
    	
    }

}
