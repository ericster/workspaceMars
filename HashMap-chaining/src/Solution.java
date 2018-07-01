import java.util.ArrayList;

class HashNode<K, V> {
	K key;
	V value;
	// next node
	HashNode<K, V> next;

	public HashNode(K key, V value) {
		 this.key = key;
		 this.value = value;
	}
}

//Class to represent entire hash table
class HashMap<K, V> {
	 // bucketArray 
	 private ArrayList<HashNode<K, V>> bucketArray;

	 // capacity 
	 private int capacity;

	 // Current size 
	 private int size;

	 public HashMap() {
		 bucketArray = new ArrayList<>();
		 capacity = 10;
		 size = 0;
		 // Create empty chains
		 for (int i = 0; i < capacity; i++)
			 bucketArray.add(null);
	 }

	 public int size() { return size; }
	 public boolean isEmpty() { return size() == 0; }

	 private int getIndex(K key) {
		 int hashCode = key.hashCode();
		 int index = hashCode % capacity;
		 return index;
	 }

	public V get(K key) {
		 // Find head of chain for given key
		 int bucketIndex = getIndex(key);
		 HashNode<K, V> head = bucketArray.get(bucketIndex);

		 // Search key in chain
		 while (head != null)
		 {
			 if (head.key.equals(key))
				 return head.value;
			 head = head.next;
		 }

		 // If key not found
		 return null;
	}

	 public void add(K key, V value) {
		 // Find head of chain for given key
		 int bucketIndex = getIndex(key);
		 HashNode<K, V> head = bucketArray.get(bucketIndex);

		 // Check if key is already present
		 while (head != null)
		 {
			 if (head.key.equals(key))
			 {
				 // choice: update
				 head.value = value;
				 return;
			 }
			 head = head.next;
		 }

		 // *** Insert key in front of chain
		 size++;
		 head = bucketArray.get(bucketIndex);
		 HashNode<K, V> newNode = new HashNode<K, V>(key, value);
		 newNode.next = head;
		 bucketArray.set(bucketIndex, newNode);

	 }
}

public class Solution {
	 public static void main(String[] args) {
		 HashMap<String, Integer>map = new HashMap<>();
		 map.add("this",1 );
		 map.add("coder",2 );
		 map.add("this",4 );
		 map.add("hi",5 );
		 System.out.println(map.size());
		 System.out.println(map.size());
		 System.out.println(map.isEmpty());
	 }
	
}