
public class Solution {

	public static void main(String[] args) {
		/*
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);
		*/

		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);

		TreeNode p = root.left; 
		TreeNode q = root.left.right;
		TreeNode result = lowestCommonAncestor(root, p, q);
		System.out.println("lowest common ancestor is : " + result.val);

	}
		
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if (p.val > q.val) {
    		TreeNode tmp = p;
    		p=q;
    		q=tmp;
    	}
    	if ((root==null) || (root==p) || root==q ) return root;
    	if ((p.val < root.val) && (root.val < q.val)) return root;
    	if ((p.val < root.val) && (root.val > q.val)) return lowestCommonAncestor(root.left, p, q);
    	if ((p.val > root.val) && (root.val < q.val)) return lowestCommonAncestor(root.right, p, q);
    	return null;
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

}
