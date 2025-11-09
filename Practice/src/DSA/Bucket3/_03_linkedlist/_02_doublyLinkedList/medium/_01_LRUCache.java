package DSA.Bucket3._03_linkedlist._02_doublyLinkedList.medium;

import java.util.HashMap;

/* LRU Cache :
 *  
 *  At start LinkedList is initialized with 2 Dummy nodes -> Head & Tail
 *  Addition of new node will be after head
 *  Deletion of a given node results in repointing prev node to next node
 *  
 *  All above operations are internal / private and are not exposed for client to interact
 *  
 *  At LRU cache only 2 methods are exposed : get() , put()
 *  
 *  get() : This first checks if data is available in LL using hm in O(1). 
 *          If available then moves this node to the head as it becomes recently used
 *          If data is not present then return -1
 *          
 *  put() : This first checks if data is already in LL, if yes then remove this node & move it to head
 *          If data is not in LL then check for capacity, if capacity breaches threshold then remove tail node(as its least recently used) and add data to head
 *          else directly add data to head
 *          
 */

public class _01_LRUCache {

	// head and tail nodes are initialized to eliminate checks for null / first /
	// last nodes while inserting or removing edge nodes
	Node head;
	Node tail;
	int capacity;
	HashMap<Integer, Node> hm = new HashMap<Integer, Node>(5);

	static class Node {
		int key;
		int value;
		Node next;
		Node prev;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
			this.next = null;
			this.prev = null;
		}
	}

	public void printlist() {

		Node n = head;

		while (n != null) {

			System.out.print("key:" + n.key);
			System.out.print(" value:" + n.value);

			if (n.prev != null)
				System.out.print(" prev:" + n.prev.key);
			else
				System.out.print(" prev:" + n.prev);

			if (n.next != null)
				System.out.print(" next:" + n.next.key);
			else
				System.out.print(" next:" + n.next);

			System.out.println();

			n = n.next;
		}
	}

	public void lruCacheInitialization(int capacity) {
		head = new Node(0, 0);
		tail = new Node(0, 0);
		this.capacity = capacity;

		head.next = tail;
		tail.prev = head;
	}

	public boolean remove(Node llNode) {
		hm.remove(llNode.key);
		llNode.prev.next = llNode.next;
		llNode.next.prev = llNode.prev;
		return true;
	}

	public boolean insert(Node newNode) {
		hm.put(newNode.key, newNode);
		newNode.next = head.next;
		newNode.prev = head;
		head.next.prev = newNode;
		head.next = newNode;
		return true;
	}

	public int get(int key) {

		if (hm.containsKey(key)) {

			Node llNode = hm.get(key);

			// move this node next to head as it becomes recently used by removing and
			// inserting
			remove(llNode);
			insert(llNode);

			return llNode.value;
		} else
			return -1;

	}

	public boolean put(int key, int value) {

		// if key is already present then remove respective node and add it to front
		if (hm.containsKey(key))
			remove(hm.get(key));

		// if capacity is full then remove tail's prev
		if (hm.size() == capacity)
			remove(tail.prev);// In this step we are saying to remove last node which requires hm entry also
								// to be removed. To know the key for removing hm entry, we store both key and
								// value in node

		// then insert/update new node at the head
		insert(new Node(key, value));

		return true;

	}

	public static void main(String[] args) {

		_01_LRUCache cache = new _01_LRUCache();

		cache.lruCacheInitialization(2);

		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));
		cache.put(3, 3);
		System.out.println(cache.get(2));
		cache.put(4, 4);
		System.out.println(cache.get(1));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));

		cache.printlist();
	}

}
