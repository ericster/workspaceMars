public class Solution {
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(2);
		root.right.left.right = new TreeNode(4);
		root.right.left.right.right = new TreeNode(5);
		root.right.left.right.right.right = new TreeNode(6);
		root.right.left.right.right.right.right = new TreeNode(7);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(5);
		
		/*
		root = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(2);
		root.right.left.left = new TreeNode(1);
		*/
		
		int res = longestConsecutive(root);
		
		System.out.println("result is : " + res);

	}
	
    public static int longestConsecutive(TreeNode root) {
    	int res =  longestConsecutiveTree(root) ;
		System.out.println("result  : " + res);
		int result = res + 1;
		System.out.println("result + 1 : " + result);
		// ????  why recursive ?
    	return res   ;

    	//return  longestConsecutiveTree(root) ;
    }
    private static int longestConsecutiveDfs(TreeNode root, int cnt) {
		return (root==null)?0:Math.max(dfs(root.left, 1, root.val), dfs(root.right, 1, root.val));
	}

	public static int dfs(TreeNode root, int count, int val){
		if(root==null) return count;
		count = (root.val - val == 1)?count+1:1;
		int left = dfs(root.left, count, root.val);
		int right = dfs(root.right, count, root.val);
		return Math.max(Math.max(left, right), count);
	}
    private static int longestConsecutiveTree(TreeNode root) {
    	if (root == null) return 0;
    	
    	int result, left, right;

    	if (root.left == null) {
    		left=0;
    	}
    	else {
			left = (root.left.val == root.val+1) ? 1 + longestConsecutive(root.left) : longestConsecutive(root.left);
    	}
    	
    	
    	if (root.right == null) {
    		right=0;
    	}
    	else {
			right = (root.right.val == root.val+1) ? 1 + longestConsecutive(root.right) : longestConsecutive(root.right);
    	}
    	
    	return new Integer(Math.max(left, right)) ;
    }

    
	/**
	 * Definition for binary tree
	 */
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }

}
