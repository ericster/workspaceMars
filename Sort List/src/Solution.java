import javax.naming.spi.DirStateFactory.Result;

public class Solution {

	public static void main(String[] args) {
		
		ListNode head = new ListNode(4);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		/*
		head.next.next.next= new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);
		head.next.next.next.next.next.next.next.next = new ListNode(10);
		*/
		
		
		/* 
		 * #1 get the middle node 
		ListNode mid;
		mid = getMiddle(head);
		System.out.println("middle of linked list is : " + mid.val);
		 */
		
		
		/*
		 * #2 merge two sorted lists
		ListNode left = head;
		ListNode right = head.next.next.next.next;
		head.next.next.next.next = null;
		ListNode result = mergeSorted(left, right);
		
		ListNode tmp = result;
		while (tmp !=null){
			System.out.println("result : " + tmp.val);
			tmp = tmp.next;
		}
		*/
		
		
		/*
		 * #3 divide and conquer  
		 */
		/*
		*/
		ListNode result = sortList(head);
		ListNode tmp = result;
		while (tmp !=null){
			System.out.println("result : " + tmp.val);
			tmp = tmp.next;
		}

	}
	
	
    public static ListNode sortList(ListNode head) {
    	// base case handling null/one item
    	if (head==null || head.next ==null) return head;
    	ListNode mid = getMiddle(head);
    	
    	ListNode nextMiddle = mid.next;
    	mid.next = null;

    	// divide and conquer
    	ListNode left = sortList(head);
    	ListNode right = sortList(nextMiddle);
    	
    	// merge two sorted lists
    	ListNode result = mergeSorted(left, right);
    	
    	return result;
    }
    
    public static ListNode mergeSorted(ListNode left, ListNode right){
    	if (left == null) return right;
    	if (right == null) return left;
		ListNode tmp = left;
		while (tmp !=null){
			System.out.println("left : " + tmp.val);
			tmp = tmp.next;
		}
		tmp = right;
		while (tmp !=null){
			System.out.println("right : " + tmp.val);
			tmp = tmp.next;
		}
		ListNode head ;

		if (left.val < right.val) {
			head= left;
			left = left.next;
		}
		else {
			head = right;
			right = right.next;
		}
		ListNode result = head;
    	
    	
    	while ( left != null && right != null){
			System.out.println("left : " + left.val + " right : " + right.val);
    		if (left.val < right.val) {
    			result.next = left;
    			left = left.next;
    		}
    		else {
    			result.next = right;
    			right = right.next;
    		}
			result = result.next;
    	}
    	
    	if (left == null){
    		result.next = right;
    	}
    	if (right == null) {
    		result.next = left;
    	}
    	
    	return head;
    }
    
    public static ListNode getMiddle(ListNode head){
    	ListNode slow, fast;
    	
    	if (head==null) return null;
    	// fast starts early (?)
    	slow = head;
    	fast = head.next;
    	//fast = head;
		// 1, 3, 7, 4, 9, 2, 5, 8, 10
    	while (fast != null && fast.next != null){
			slow = slow.next;
    		fast = fast.next.next;
    		//System.out.println("slow : " + slow.val + " fast : " + fast.val);
    	}
    	return slow;
    }

    public static ListNode getMiddle_0(ListNode head){
    	ListNode slow, fast;
    	
    	if (head==null) return null;
    	slow = head;
    	fast = head.next;
		// 1, 3, 7, 4, 9, 2, 5, 8, 10
    	//while (fast != null && fast.next != null){
    	while (fast != null){
    		fast = fast.next;
			if (fast != null){
				slow = slow.next;
				fast = fast.next;
			}
    		//System.out.println("slow : " + slow.val + " fast : " + fast.val);
    	}
    	return slow;
    }
    
    
    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
