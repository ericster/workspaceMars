import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) {
		
		ListNode h1 = new ListNode(1);
		h1.next = new ListNode(5);
		h1.next.next = new ListNode(9);
		ListNode h2 = new ListNode(2);
		h2.next = new ListNode(6);
		h2.next.next = new ListNode(10);
		ListNode h3 = new ListNode(3);
		h3.next = new ListNode(7);
		h3.next.next = new ListNode(11);
		ListNode h4 = new ListNode(4);
		h4.next = new ListNode(8);
		h4.next.next = new ListNode(12);
		
		//ListNode[] lists = {h1,h2,h3};
		ListNode[] lists = {h1,h2,h3,h4};
		//ListNode result = merge2Lists(h1, h2);
		ListNode result = mergeKLists(lists);
		
		while (result!=null){
			System.out.println("result is : " + result.val);
			result = result.next;
		}

	}
	
    public static ListNode mergeKLists(ListNode[] lists) {
    	if (lists.length==0) return null;
    	if (lists.length==1) return lists[0];
    	ListNode result = lists[0];

    	Queue<ListNode> queue = new LinkedList<ListNode>();
    	for(int i=0;i<lists.length;i++){
    		queue.add(lists[i]);
    	}
    	
    	int iter=0;
    	while (!queue.isEmpty()){
    		ListNode first = queue.poll();
    		ListNode second = queue.poll();
    		result = merge2Lists(first, second);
    		iter++;
    		ListNode tmp = result;

    		/*
    		while (tmp!=null){
    			System.out.println("iter : "  + iter + " result is : " + tmp.val);
    			tmp = tmp.next;
    		}
    		*/
    		

    		if (queue.isEmpty()) return result;
    		if (result!=null) queue.add(result);
    	}
    	
    	return result;
        
    }
    
    public ListNode mergeKLists_0(ListNode[] lists) {
        if (lists.length==0) return null;
    	if (lists.length==1) return lists[0];
        ListNode result = lists[0];

    	for(int i=1;i<lists.length;i++){
    		result = merge2Lists(result, lists[i]);
    	}
    	return result;
    }

    public static ListNode merge2Lists(ListNode h1, ListNode h2) {
    	ListNode result = new ListNode(0);
    	ListNode ptr = result;
    	if (h1==null) return h2;
    	if (h2==null) return h1;
    	while (h1!=null || h2!=null){
    		if (h1==null){
    			ptr.next=h2;
    			h2=h2.next;
    		}
    		else if (h2==null){
    			ptr.next=h1;
    			h1=h1.next;
    		}
    		else if(h1.val<h2.val){
    			ptr.next = h1;
    			h1 = h1.next;
    		}
    		else{
    			ptr.next=h2;
    			h2=h2.next;
    		}
    		ptr=ptr.next;
    	}
    	
    	return result.next;

    }

    public static ListNode merge2Lists_0(ListNode h1, ListNode h2) {
    	ListNode result = new ListNode(0);
    	ListNode ptr = result;
    	if (h1==null) return h2;
    	if (h2==null) return h1;
    	while (h1!=null || h2!=null){
    		if (h1==null & h2!=null){
    			ptr.next=h2;
    			h2=h2.next;
				ptr=ptr.next;
    			continue;
    		}
    		if (h2==null && h1!=null){
    			ptr.next=h1;
    			h1=h1.next;
				ptr=ptr.next;
    			continue;
    		}
    		if(h1.val<h2.val){
    			ptr.next = h1;
    			h1 = h1.next;
    		}
    		else{
    			ptr.next=h2;
    			h2=h2.next;
    		}
    		ptr=ptr.next;
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
