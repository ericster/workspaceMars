import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		//LRUCacheLHM cache = new LRUCacheLHM(2);

		int res;
		cache.put(1, 1);
		cache.put(2, 2);
		res = cache.get(1);       // returns 1
		System.out.println("res " + res);
		cache.put(3, 3);    // evicts key 2
		res = cache.get(2);       // returns -1 (not found)
		System.out.println("res " + res);
		cache.put(4, 4);    // evicts key 1
		res = cache.get(1);       // returns -1 (not found)
		System.out.println("res " + res);
		res = cache.get(3);       // returns 3
		System.out.println("res " + res);
		res = cache.get(4);       // returns 4
		System.out.println("res " + res);
	}
	static class Node {
	    int key;
	    int data;
	    Node prev;
	    Node next;
	}
	static class SNode {
	    int key;
	    int data;
	    SNode next;
	}
	
	static class LRUCacheLHM extends LinkedHashMap<Integer, Integer>{
	    private int maxSize;
	    public LRUCacheLHM(int capacity) {
	        super(capacity, 0.75f, true);
	        this.maxSize = capacity;
	    }

	    //return -1 if miss
	    public int get(int key) {
	        Integer v = super.get(key);
	        return v == null ? -1 : v;
	    }

	    public void put(int key, int value) {
	        super.put(key, value);
	    }

	    @Override
	    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
	        return this.size() > maxSize; //must override it if used in a fixed cache
	    }
	}

	static class LRUCache{
		 
	    private int capacity;
	    private Map<Integer, Node> cmap;
	    private Node head;
	    private Node tail;
	 
	    public LRUCache(int capacity) {
	        this.capacity = capacity;
	        this.cmap = new HashMap<>();
	        this.head = new Node();
	        this.tail = new Node();
	        this.head.next = this.tail;
	        this.tail.prev = this.head;
	    }
	    
	    public int get(int key) {
	    	//System.out.println("get key head " + head.next.key);
	    	//System.out.println("get key tail " +  tail.prev.key);
	    	int res = -1;
	    	if (cmap.containsKey(key)) {
	    		Node curr = cmap.get(key);
	    		res = curr.data;

	    		// Debug:remove 
	    		curr.prev.next = curr.next;
	    		curr.next.prev = curr.prev;


	    		// and move to head
	    		// h -> n1
	    		// h -> newN ->n1
	    		curr.prev = this.head;
	    		curr.next = this.head.next;
	    		this.head.next.prev = curr;
	    		this.head.next = curr;

	    	}
	    	//System.out.println("after key head " + head.next.key);
	    	//System.out.println("after key tail " +  tail.prev.key);
	    	
	    	return res;
	    }
	    	
	    public void put(int key, int value) {
	    	if (cmap.containsKey(key)) {
	    		// remove node at current position
	    		// h<->n1<->n->tail
	    		// h<->n1->tail
	    		// h<->n<->n1->tail

	    		Node curr = cmap.get(key);
	    		//update curr in cmap
	    		curr.data = value;
	    		cmap.put(key, curr);
	    		
	    		//remove
	    		curr.prev.next = curr.next;
	    		curr.next.prev = curr.prev;
	    		
	    		// and move to head
	    		curr.prev = this.head;
	    		curr.next = this.head.next;
	    		this.head.next.prev = curr;
	    		this.head.next = curr;
	    		
	    	}
	    	else {
	    		//insert a new node after head
				Node nNode = new Node();
				nNode.key = key;
				nNode.data = value;
	    		
	    		// haed->n1
	    		// head->newN->n1
	    		nNode.prev = this.head;
	    		nNode.next = this.head.next;
	    		// ??
	    		this.head.next.prev = nNode;
	    		this.head.next = nNode;
	    		cmap.put(key, nNode);
				//System.out.println("key head " + head.next.key);
				//System.out.println("key tail " +  tail.prev.key);
	    		if (cmap.size() > this.capacity) {
	    			// remove from cmap
	    			Node temp = this.tail.prev;
	    			cmap.remove(temp.key);
	    			System.out.println("key removed " + temp.key);
	    			// remove tail
	    			// head-n1-n2-n3-tail
	    			// head-n1-n2-tail
	    			// ???
	    			this.tail.prev = temp.prev;
	    			temp.prev.next = this.tail;
	    			
	    		}
	    	}
	    }
	    
	}
	static class LRUCache_0{
		 
	    private int capacity;
	    private Map<Integer, Node> cmap;
	    private Node head;
	    private Node tail;
	 
	    public LRUCache_0(int capacity) {
	        this.capacity = capacity;
	        this.cmap = new HashMap<>();
	        this.head = new Node();
	        this.tail = new Node();
	        this.head.next = this.tail;
	        this.tail.prev = this.head;
	    }
	    
	    public int get(int key) {
	    	//System.out.println("get key head " + head.next.key);
	    	//System.out.println("get key tail " +  tail.prev.key);
	    	int res = -1;
	    	if (cmap.containsKey(key)) {
	    		Node curr = cmap.get(key);
	    		res = curr.data;

	    		// Debug:remove 
	    		curr.prev.next = curr.next;
	    		curr.next.prev = curr.prev;


	    		// and move to head
	    		// h -> n1
	    		// h -> newN ->n1
	    		curr.prev = this.head;
	    		curr.next = this.head.next;
	    		this.head.next.prev = curr;
	    		this.head.next = curr;

	    	}
	    	//System.out.println("after key head " + head.next.key);
	    	//System.out.println("after key tail " +  tail.prev.key);
	    	
	    	return res;
	    }
	    	
	    public void put(int key, int value) {
	    	if (cmap.containsKey(key)) {
	    		// remove node at current position
	    		// h<->n1<->n->tail
	    		// h<->n1->tail
	    		// h<->n<->n1->tail

	    		Node curr = cmap.get(key);
	    		//update curr in cmap
	    		curr.data = value;
	    		cmap.put(key, curr);
	    		
	    		//remove
	    		curr.prev.next = curr.next;
	    		curr.next.prev = curr.prev;
	    		
	    		// and move to head
	    		curr.prev = this.head;
	    		curr.next = this.head.next;

	    		// ??
	    		this.head.next.prev = curr;
	    		this.head.next = curr;
	    		
	    	}
	    	else {
	    		//insert a new node after head
				Node nNode = new Node();
				nNode.key = key;
				nNode.data = value;
	    		
	    		// haed->n1
	    		// head->newN->n1
	    		nNode.prev = this.head;
	    		nNode.next = this.head.next;
	    		// ??
	    		this.head.next.prev = nNode;
	    		this.head.next = nNode;
	    		cmap.put(key, nNode);
				//System.out.println("key head " + head.next.key);
				//System.out.println("key tail " +  tail.prev.key);
	    		if (cmap.size() > this.capacity) {
	    			// remove from cmap
	    			Node temp = this.tail.prev;
	    			cmap.remove(temp.key);
	    			System.out.println("key removed " + temp.key);
	    			// remove tail
	    			// head-n1-n2-n3-tail
	    			// head-n1-n2-tail
	    			// ???
	    			this.tail.prev = temp.prev;
	    			temp.prev.next = this.tail;
	    			
	    		}
	    	}
	    }
	    
	}

	static class LRUCache_2 {
		 
	    private int capacity;
	    private Map<Integer, SNode> cache;
	    private SNode head;
	    private SNode tail;
	 
	    public LRUCache_2(int capacity) {
	        this.capacity = capacity;
	        this.cache = new HashMap<>();
	    }
	    
	    private void add(SNode node) {
	    	 
	        // Reset position
	        node.next = null;
	     
	        // First element
	        if (null == this.head) {
	            this.head = node;
	            this.tail = node;
	            return;
	        }
	     
	        /*  head
	         *  node <-> n1  <->  n2  <-> tail
	         *  node <-> head 
	         */
	        // Existing element
	        node.next = this.head;
	        this.head = node;
	    }
	    
	    private void remove(SNode node) {
	    	 
	        // Nothing to do
	        if (this.head == null || null == node) {
	            return;
	        }
	     
	        // The only one item
	        if (this.head == this.tail && this.head == node) {
	            this.head = null;
	            this.tail = null;
	            return;
	        }
	     
	        // Remove from head
	        if (node == this.head) {
	            this.head = this.head.next;
	            return;
	        }
	     
	        /*
	         * ... n2 -> tail
	         */
	        // Remove from tail
	        if (node == this.tail) {
	        	/*
	            this.tail.previous.next = null;
	            this.tail = this.end.previous;
	            */
	            return;
	        }
	     
	        /*
	         * n1 <-> node <-> n2
	         * n1 <-> n2
	         */
	        // Remove in the middle
	        node.key = node.next.key;
	        node.data = node.next.data;
	        node.next = node.next.next;
	     
	    }
	    
	    private void moveFirst(SNode node) {
	        this.remove(node);
	        this.add(node);
	    }
	     
	    private void removeLast() {
	        this.remove(this.tail);
	    }
	    
	    public int get(int key) {
	    	 
	        // Existing key
	        if (this.cache.containsKey(key)) {
	 
	            // Move to first place
	            SNode node = this.cache.get(key);
	            this.moveFirst(node);
	 
	            // Return the value
	            return node.data;
	        }
	 
	        // Not found
	        return -1;
	    }
	    
	    public void put(int key, int value) {
	    	 
	        // Existing slot
	        if (this.cache.containsKey(key)) {
	            SNode node = this.cache.get(key);
	            this.moveFirst(node);
	            node.data = value;
	            return;
	        }
	     
	        // Out of capacity, cleaning the oldest slot
	        if (this.cache.size() >= this.capacity) {
	            int id = this.tail.key;
	            this.removeLast();
	            this.cache.remove(id);
	        }
	     
	        // New slot
	        SNode node = new SNode();
	        node.key = key;
	        node.data = value;
	        this.add(node);
	        this.cache.put(key, node);
	    }
 
	    
	    
	}

	static class LRUCache_1 {
		 
	    private int capacity;
	    private Map<Integer, Node> data;
	    private Node head;
	    private Node end;
	 
	    public LRUCache_1(int capacity) {
	        this.capacity = capacity;
	        this.data = new HashMap<>();
	    }
	    
	    private void add(Node node) {
	    	 
	        // Reset position
	        node.next = null;
	        node.prev = null;
	     
	        // First element
	        if (null == this.head) {
	            this.head = node;
	            this.end = node;
	            return;
	        }
	     
	        /*  head
	         *  node <-> n1  <->  n2  <-> tail
	         *  node <-> head 
	         */
	        // Existing element
	        this.head.prev = node;
	        node.next = this.head;
	        this.head = node;
	    }
	    
	    private void remove(Node node) {
	    	 
	        // Nothing to do
	        if (this.head == null || null == node) {
	            return;
	        }
	     
	        // The only one item
	        if (this.head == this.end && this.head == node) {
	            this.head = null;
	            this.end = null;
	            return;
	        }
	     
	        // Remove from head
	        if (node == this.head) {
	            this.head.next.prev = null;
	            this.head = this.head.next;
	            return;
	        }
	     
	        // Remove from end
	        if (node == this.end) {
	            this.end.prev.next = null;
	            this.end = this.end.prev;
	            return;
	        }
	     
	        /*
	         * n1 <-> node <-> n2
	         * n1 <-> n2
	         */
	        // Remove in the middle
	        node.prev.next = node.next;
	        node.next.prev = node.prev;
	     
	    }
	    
	    private void moveFirst(Node node) {
	        this.remove(node);
	        this.add(node);
	    }
	     
	    private void removeLast() {
	        this.remove(this.end);
	    }
	    
	    public int get(int key) {
	    	 
	        // Existing key
	        if (this.data.containsKey(key)) {
	 
	            // Move to first place
	            Node node = this.data.get(key);
	            this.moveFirst(node);
	 
	            // Return the value
	            return node.data;
	        }
	 
	        // Not found
	        return -1;
	    }
	    
	    public void put(int key, int value) {
	    	 
	        // Existing slot
	        if (this.data.containsKey(key)) {
	            Node node = this.data.get(key);
	            this.moveFirst(node);
	            node.data = value;
	            return;
	        }
	     
	        // Out of capacity, cleaning the oldest slot
	        if (this.data.size() >= this.capacity) {
	            int id = this.end.key;
	            this.removeLast();
	            this.data.remove(id);
	        }
	     
	        // New slot
	        Node node = new Node();
	        node.key = key;
	        node.data = value;
	        this.add(node);
	        this.data.put(key, node);
	    }
 
	    
	    
	}


}
