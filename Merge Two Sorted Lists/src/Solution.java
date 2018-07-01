
public class Solution {

	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next= new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);
		head.next.next.next.next.next.next.next.next = new ListNode(10);
		
		ListNode mid;
		
		ListNode left = head;
		ListNode right = head.next.next.next.next;
		head.next.next.next.next = null;
		ListNode result = mergeTwoLists(left, right);
		
		ListNode tmp = result;
		while (tmp !=null){
			System.out.println("result : " + tmp.val);
			tmp = tmp.next;
		}

	}
	
	
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	
        if(l1 == null && l2 == null) return null;
        
        ListNode res = new ListNode(0);
        ListNode head = res;
        
        while(l1 != null || l2 != null){
            
            // if l2 reaches the end of list then increment only l1
            if(l2 == null) {
                
                res.next = l1;
                //res = l1;
                l1 = l1.next;
            }
            
            // if l1 reaches the end of list then increment only l2
            else if(l1 == null){
                
                res.next = l2;
                //res = l2;
                l2 = l2.next;
            }
            
            else if(l1.val < l2.val){
                
                res.next = l1;
                //res = l1;
                l1 = l1.next;
                
            }
            
            // if l1.val >= l2.val
            else{
                
                res.next = l2;
                //res = l2;
                l2 = l2.next;
                
            }
            res = res.next;
            
        }
        
        return head.next;
        
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
