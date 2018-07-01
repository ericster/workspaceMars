
import java.io.*;
import java.util.*;
 
class Graph
{
    private int V;   // No. of vertices
    private List<Integer>[] adj; // Adjacency List
 
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
 
    void addEdge(int v,int w) { adj[v].add(w); }
 
    void dfs(int v, boolean visited[], Stack stack)
    {
        visited[v] = true;
        // Recur for all the vertices adjacent to this vertex
        for (Integer va : adj[v]) {
            if (!visited[va])
                dfs(va, visited, stack);
        }
        stack.push(new Integer(v));
    }
 
    void topologicalSort()
    {
        Stack stack = new Stack();
 
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V]; 
        for (int i = 0; i < V; i++)
        	visited[i] = false;
 
        // Call the recursive helper function to store
        // Topological Sort starting from all vertices
        // one by one
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                dfs(i, visited, stack);
 
        // Print contents of stack
        while (stack.empty()==false)
            System.out.print(stack.pop() + " ");
    }
 
    public static void main(String args[])
    {
    	// 5 4 2 3 1 0
    	/*
    	 *          0<--------4
    	 *          ^         v 
    	 *          5->2->3-> 1
    	 */
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
 
        System.out.println("Following is a Topological " + "sort of the given graph");
        g.topologicalSort();
    }
}
