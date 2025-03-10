package DSA.Bucket4._04_linkedlist._02_doublyLinkedList.medium;

import java.util.HashMap;

public class _02_LFUCache_Hard {

	final int capacity;
	HashMap<Integer, DoublyLL> freqMap; // freq -> DLL. To directly access nodes by freq
	HashMap<Integer, Node> cacheMap; // key -> Node. This is needed to get & put value in freq resp DLL in O(1)
	int leastFreq = 0; // this freq counter is needed to directly access least frequency nodes
	int currCacheSize = 0;

	_02_LFUCache_Hard(int capacity) {
		this.capacity = capacity;
		freqMap = new HashMap<Integer, DoublyLL>();
		cacheMap = new HashMap<Integer, Node>();
	}

	static class Node {
		int key;
		int value;
		int freq;
		Node next;
		Node prev;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
			this.freq = 0;// when initializing set freq as 0
			this.next = null;
			this.prev = null;
		}
	}

	static class DoublyLL {
		int size;
		Node head;
		Node tail;

		DoublyLL() {
			this.size = 0;
			this.head = new Node(0, 0);
			this.tail = new Node(0, 0);
			this.head.next = tail;
			this.tail.prev = head;
		}
	}


	private Node findLFUNode() {
		DoublyLL dll = freqMap.get(leastFreq);
		return dll.tail.prev;
	}

	private void remove(Node node) {

		node.prev.next = node.next;
		node.next.prev = node.prev;

		cacheMap.remove(node.key);
		freqMap.get(node.freq).size--;
		currCacheSize--;
	}

	private void insert(Node node) {

		int currFreq = node.freq;
		cacheMap.put(node.key, node);

		DoublyLL dll;
		dll = freqMap.getOrDefault(currFreq + 1, new DoublyLL());

		// new node
		if (currFreq == 0)
			leastFreq = 1;// new node is always added to freq = 1

		node.next = dll.head.next;
		node.prev = dll.head;
		dll.head.next = node;
		node.next.prev = node;
		node.freq = currFreq + 1;
		dll.size++;
		freqMap.put(currFreq + 1, dll);

		if (currFreq == leastFreq && freqMap.get(currFreq).size == 0)
			leastFreq++;

		currCacheSize++;
	}

	public int get(int key) {

		if (cacheMap.containsKey(key)) {

			Node llNode = cacheMap.get(key);

			// move this node next to head as it becomes recently used by removing and
			// inserting
			remove(llNode);
			insert(llNode);

			return llNode.value;

		} else
			return -1;

	}

	public void put(int key, int value) {

		if (cacheMap.containsKey(key)) {
			Node llNode = cacheMap.get(key);
			remove(llNode);
			insert(llNode);

		} else {

			Node newNode = new Node(key, value);

			// have space to insert
			if (currCacheSize < capacity)
				insert(newNode);

			// no space to insert
			else {
				// first remove lfu node
				Node llNode = findLFUNode();
				remove(llNode);
				insert(newNode);

			}
		}

	}

	public static void main(String[] args) {

		_02_LFUCache_Hard cache = new _02_LFUCache_Hard(2);

		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));
		cache.put(3, 3);
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
		cache.put(4, 4);
		System.out.println(cache.get(1));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));

		// cache.printlist();
	}

}
