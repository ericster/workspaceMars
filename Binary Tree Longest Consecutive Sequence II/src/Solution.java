
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
    	//return (root==null)?0:Math.max(h(root.left, root.val), h(root.right, root.val));
    	if (root==null) return 0;
    	h(root,Integer.MIN_VALUE);
    	return max;

    }
	static int max = 0;
    private static int h(TreeNode root, int pre) {
        if (root == null) {
            return 0;
        }
        int left = h(root.left, root.val);
        int right = h(root.right, root.val);
        
        if (left * right < 0) {
            max = Math.max(max, 1 + Math.abs(left) + Math.abs(right));
        } else {
            max = Math.max(max, 1 + Math.max(Math.abs(left), Math.abs(right)));
        }
        
        if (root.val - pre == 1) {
            return 1 + Math.max(0, Math.max(left, right));
        }
        if (root.val - pre == -1) {
            return -1 + Math.min(0, Math.min(left, right));
        }
        return 0;
    }
    
    public int[] helper(TreeNode root){
        if(root == null) return new int[]{0,0};
        int[] left = helper(root.left);
        int[] right= helper(root.right);
        int inc = 1, des = 1;
        if(root.left != null){
            if(root.val - root.left.val == 1){
                des = left[1]+1;
            }else if(root.val - root.left.val == -1){
                inc = left[0]+1;
            }
        }
        if(root.right != null){
            if(root.val - root.right.val == 1){
                des = Math.max(des,right[1]+1);
            }else if(root.val - root.right.val == -1){
                inc = Math.max(inc,right[0]+1);
            }
        }
        max = Math.max(max,inc+des-1);
        return new int[]{inc,des};
    }
    
	public static int dfs(TreeNode root, int count, int val, int sign){
		// sign +1:increasing -1:decreasing 0:n
		if(root==null) return count;
		int signn = 0;
		if (root.val-val == 1 ) signn = 1;
		else if (root.val-val == -1) signn = -1;
		else signn = 0;
		count = ((sign==1 && signn==1)||(sign==-1&&signn==-1) )?count+1:1;

		int left = dfs(root.left, count, root.val, signn);
		int right = dfs(root.right, count, root.val, signn);
		return Math.max(Math.max(left, right), count);
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
