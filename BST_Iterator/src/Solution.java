import java.util.PriorityQueue;


public class Solution {

	static TreeNode root = null;


	public static void main(String[] args) {
		Solution tree = new Solution();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
		 // print inorder traversal of the BST
        tree.inorder();
        
        System.out.println("root is " + root.val);
        BSTIterator bstIter = new BSTIterator(tree.root);
        bstIter.printPQ();

	}
	
	/**
	 * Definition for binary tree
	 */
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	
    // This method mainly calls insertRec()
    void insert(int val) {
       root = insertRec(root, val);
    }
     
    /* A recursive function to insert a new key in BST */
    TreeNode insertRec(TreeNode root, int val) {
 
        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
 
        /* Otherwise, recur down the tree */
        if (val < root.val)
            root.left = insertRec(root.left, val);
        else if (val > root.val)
            root.right = insertRec(root.right, val);
 
        /* return the (unchanged) node pointer */
        return root;
    }
    
    // This method mainly calls InorderRec()
    void inorder()  {
       inorderRec(root);
    }
 
    // A utility function to do inorder traversal of BST
    void inorderRec(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            inorderRec(root.left);
            inorderRec(root.right);
        }
    }

}
