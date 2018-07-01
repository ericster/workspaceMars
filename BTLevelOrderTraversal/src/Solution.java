import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	/*
	 * Given binary tree [3,9,20,null,null,15,7],
	 * [
		  [3],
		  [9,20],
		  [15,7]
		]
	 */
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		levelOrder(root);
		levelOrder(root);

	}
	
	/**
	 * Definition for a binary tree node.
	 */
	 public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	 
	 public static List<List<Integer>> levelOrder(TreeNode root) {
		 if (root == null) return null;
		
		 List<Integer> result = new ArrayList<Integer>();
		 List<List<Integer>> results= new ArrayList<List<Integer>>();
		 Queue<TreeNode> queue = new LinkedList<TreeNode>();
		 queue.add(root);
		 int level =0;
		 while(!queue.isEmpty()){
			 int size = queue.size();
			 if (size == 0) return results; 
			 for (int i=0;i<size;i++){
				 TreeNode tmp = queue.remove();
				 if (tmp == null) break;
				 result.add(tmp.val);
				 if (tmp.left != null){
					 queue.add(tmp.left);
				 }
				 if (tmp.right != null){
					 queue.add(tmp.right);
				 }
			 }
			 System.out.println("level " + level + " : result is : " + Arrays.toString(result.toArray()));
			 results.add(new ArrayList<Integer>(result)); 
			 result = new ArrayList<Integer>();
			 level++;
		 }
		 
		 System.out.println("results is : " + Arrays.toString(results.toArray()));
		 return results;
	        
	 }

}
