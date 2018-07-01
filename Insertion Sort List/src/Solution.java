
public class Solution {

	public static void main(String[] args) {
		ListNode head = new ListNode(12);
		head.next = new ListNode(3);
		head.next.next = new ListNode(2);
		head.next.next.next= new ListNode(9);
		head.next.next.next.next = new ListNode(11);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);
		head.next.next.next.next.next.next.next.next = new ListNode(10);
		/*
		*/
		
		
		ListNode min;
		min = insertionSortList(head);
		
		while (min != null){
			System.out.println("result :" + min.val);
			min = min.next;
			
		}

	}
	
	
	// swap outer with min
    public static ListNode insertionSortList(ListNode head) {
		if( head == null ){
			return head;
		}
		
		ListNode helper = new ListNode(0); //new starter of the sorted list
		ListNode cur = head; //the node will be inserted
		ListNode pre = helper; //insert node between pre and pre.next
		ListNode next = null; //the next node will be inserted
		//not the end of input list
		/*
		 * 12, 3, 2, 9, 11, 6, 7, 8, 10
		 */
		while( cur != null ){
			next = cur.next;
			//find the right place to insert
			while( pre.next != null && pre.next.val < cur.val ){
				pre = pre.next;
			}
			//insert between pre and pre.next
			cur.next = pre.next;
			pre.next = cur;
			pre = helper;
			cur = next;
		}
		
		return helper.next;
    }

    public static ListNode insertionSortList_0(ListNode head) {
    	if (head == null) return null;
    	ListNode result = new ListNode(0);
    	result.next = head;
    	ListNode outer = head; 
    	ListNode min = head;
    	ListNode cur; 

    	while (outer != null){
			cur = outer;
			while (cur != null){
				if (cur.val < min.val){
					min = cur;
				}
				cur = cur.next;
			}
			if (min.val < outer.val){
				int tmp = outer.val;
				outer.val = min.val;
				min.val = tmp;
			}
			
			outer = outer.next;
			min = outer;
    	}
    	
    	return result.next;
        
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
