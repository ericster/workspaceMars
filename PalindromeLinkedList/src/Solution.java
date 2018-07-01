
public class Solution {

	public static void main(String[] args) {
		
    	//ListNode reverse = null; 
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);

		head.next.next = new ListNode(3);
		head.next.next.next= new ListNode(4);
		head.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next.next = new ListNode(1);
		/*
		 * reverse -> 2
		 * reverse.next -> 1
		 * 
		
		reverse = head.next;
		reverse.next = head;
		head = head.next;
		*/

		
		if (isPalindrome(head)){
			System.out.println("Palindrome");
		}
		else {
			System.out.println("Not Palindrome");
		}

	}
	
	public static boolean isPalindrome(ListNode head) {
	    // yavinci solution
	    ListNode fast = head, slow = head;
	    while (fast != null && fast.next != null) {
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	    if (fast != null) { // odd nodes: let right half smaller
	        slow = slow.next;
	    }
	    slow = reverse(slow);
	    fast = head;
	    
	    
	    while (slow != null) {
	        if (fast.val != slow.val) {
				//slow = reverse(slow);
				System.out.println("head is : " + head.val);
				System.out.println("head is : " + head.next.val);
				System.out.println("head is : " + head.next.next.val);
				System.out.println("head is : " + head.next.next.next.val);
				System.out.println("head is : " + head.next.next.next.next.val);
    	System.out.println("head is : " + head.next.next.next.next.next.val);
    	System.out.println("head is : " + head.next.next.next.next.next.next.val);
	            return false;
	        }
	        fast = fast.next;
	        slow = slow.next;
	    }
	    slow = reverse(slow);
    	System.out.println("head is : " + head.val);
    	System.out.println("head is : " + head.next.val);
    	System.out.println("head is : " + head.next.next.val);
    	System.out.println("head is : " + head.next.next.next.val);
    	System.out.println("head is : " + head.next.next.next.next.val);
    	System.out.println("head is : " + head.next.next.next.next.next.val);
    	System.out.println("head is : " + head.next.next.next.next.next.next.val);
	    return true;
	}

	public static ListNode reverse(ListNode head) {
	    ListNode prev = null;
	    while (head != null) {
	        ListNode next = head.next;
	        head.next = prev;
	        prev = head;
	        head = next;
	    }
	    return prev;
	}
    public static boolean isPalindrome_o(ListNode head) {

    	
    	ListNode reverse = null; 
    	ListNode current = head;
    	ListNode current3 = head;
    	int cnt = 0;
    	while (current != null){
    		cnt++;
    		current = current.next;
    	}
    	int iter = (cnt % 2 == 0) ? cnt/2  : cnt/2 +1;
    	ListNode current2 = head;
    	while (current2 != null & iter >0){
    		iter--;
    		System.out.println("current2 is : " + current2.val);
    		current2 = current2.next;
    	}
    	// reverse the 2nd half
    	while (current2 != null){
    		ListNode tmp = current2.next;
    		current2.next = reverse;
    		reverse = current2;
    		current2 = tmp;
    	}
    	System.out.println("reverse is : " + reverse.val);
    	System.out.println("head is : " + head.val);
    	System.out.println("head is : " + head.next.val);
    	System.out.println("head is : " + head.next.next.val);
    	System.out.println("head is : " + head.next.next.next.val);
    	System.out.println("head is : " + head.next.next.next.next.val);

    	while (reverse != null){
    		System.out.println("reverse is : " + reverse.val);
    		System.out.println("current3 is : " + current3.val);
    		if (reverse.val != current3.val) return false;
    		reverse = reverse.next;
    		current3 = current3.next;
    	}

    	System.out.println("head is : " + head.val);
    	System.out.println("head is : " + head.next.val);
    	System.out.println("head is : " + head.next.next.val);
    	System.out.println("head is : " + head.next.next.next.val);
    	System.out.println("head is : " + head.next.next.next.next.val);
    	
    	return true;

    }
    /**
      Definition for singly-linked list.
     */
      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

}
