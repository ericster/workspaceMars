
public class Solution {

	public static void main(String[] args) {

	/*
	TreeNode root = new TreeNode(3);
	root.left = new TreeNode(5);
	root.right = new TreeNode(1);
	root.right.left = new TreeNode(0);
	root.right.right = new TreeNode(8);
	root.right = new TreeNode(1);
	root.left.left = new TreeNode(6);
	root.left.right = new TreeNode(2);
	root.left.right = new TreeNode(2);
	root.left.right.left = new TreeNode(7);
	root.left.right.right = new TreeNode(4);
	*/

	TreeNode root = new TreeNode(-1);
	root.left = new TreeNode(0);
	root.right = null;
	root.left.left = new TreeNode(1);
	root.left.right = null;
	root.left.left.left = new TreeNode(2);
	root.left.left.right = null;
	root.left.left.left.left = new TreeNode(3);
	root.left.left.left.right = null;

	TreeNode p = root.left.left.left; 
	TreeNode q = root.left.left.left.left; 
	
	lowestCommonAncestor(root, p, q);

	}
	
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if (root==null) return null;
    	if ((p.left == q ) || (p.right == q)){
    		return p;
    	}
    	if ((q.left == p) || (q.right == p)){
    		return q;
    	}
    	
    	TreeNode CA = root;
    	TreeNode ancestor = root;
    	while(ancestor !=null){
    		System.out.println("current root node is : " + ancestor.val);
    		if (findCommonAncestor(ancestor.left, p) && findCommonAncestor(ancestor.left, q)){
    			System.out.println("current left node is : " + ancestor.left.val);
				ancestor = ancestor.left;
    		}
    		else if (findCommonAncestor(ancestor.right, p) && findCommonAncestor(ancestor.right, q)){
    			System.out.println("current right node is : " + ancestor.right.val);
				ancestor = ancestor.right;
    		} 
    		else break;
    	}
    	
    	System.out.println("LCA is : " + ancestor.val);
    	return ancestor;
        
    }

    public static boolean findCommonAncestor(TreeNode root, TreeNode p) {
    
    	if (root!=null ) System.out.println("current node is : " + root.val);
    	if (root == null) return false;
    	if (root==p) return true;
    	return findCommonAncestor(root.left, p) || findCommonAncestor(root.right, p);

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
