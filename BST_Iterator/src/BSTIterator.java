import java.util.PriorityQueue;

public class BSTIterator {

	PriorityQueue<TreeNode> pq; 
	
	/**
	 * Definition for binary tree
	 */
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }


   public BSTIterator(Solution.TreeNode root) {

		pq = new PriorityQueue<TreeNode>();
	
		BSTIteratorUtil(root, pq); 
       
   }

   public void BSTIteratorUtil(Solution.TreeNode root, PriorityQueue pq) {
	   if (root == null)
		   return;
		BSTIteratorUtil(root.left, pq); 
		pq.add(root.val);
		BSTIteratorUtil(root.right, pq); 
   }
   
   public void printPQ(){
   	int size = pq.size();
   	for (int i=0;i<size;i++){
   		System.out.println("pq in order" + pq.remove());
   	}
   	
   }

   /** @return whether we have a next smallest number */
   public boolean hasNext() {
   	return false;
       
   }

   /** @return the next smallest number */
   public int next() {
   	return 0;
       
   }
/**
* Your BSTIterator will be called like this:
* BSTIterator i = new BSTIterator(root);
* while (i.hasNext()) v[f()] = i.next();
*/
}

