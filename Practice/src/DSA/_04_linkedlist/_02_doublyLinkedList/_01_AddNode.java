package DSA._04_linkedlist._02_doublyLinkedList;

public class _01_AddNode {
	Node head;

	static class Node {
		int data;
		Node prev;
		Node next;

		Node(int d) {
			data = d;
			prev = null;
			next = null;
		}
	}

	public void printlist() {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}

	public void push(int data) {
		Node newNode = new Node(data);

		if (head != null)
			head.prev = newNode;

		newNode.next = head;
		head = newNode;
	}

	public void addNodeAtFront(int data) {
		System.out.println("Adding node at front");

		Node newNode = new Node(data);

		newNode.next = head;
		head.prev = newNode;
		head = newNode;

	}

	public void addNodeAfterGivenNode(int crrNodeData, int newNodeData) {

		System.out.println("Adding node After Node with data : " + crrNodeData);

		Node newNode = new Node(newNodeData);

		Node n = head;

		while (n != null) {

			if (n.data == crrNodeData) {
				newNode.next = n.next;
				n.next.prev = newNode;
				n.next = newNode;
				newNode.prev = n;
				break;
			}

			n = n.next;
		}
	}

	public void addNodeBeforeGivenNode(int crrNodeData, int newNodeData) {
		System.out.println("Adding node Before Node with data : " + crrNodeData);

		Node newNode = new Node(newNodeData);
		if (head.data == crrNodeData) {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		} else {
			Node n = head;
			while (n != null) {
				if (n.data == crrNodeData) {
					newNode.next = n;
					newNode.prev = n.prev;
					n.prev.next = newNode;
					n.prev = newNode;
					break;
				}
				n = n.next;
			}
		}

	}

	public void addNodeAtEnd(int d) {
		System.out.println("Adding node at end");

		Node n = head;
		Node newNode = new Node(d);

		while (n.next != null)
			n = n.next;

		n.next = newNode;
		newNode.prev = n;

	}

	public static void main(String[] args) {
		_01_AddNode lList = new _01_AddNode();

		lList.push(5);
		lList.push(4);
		lList.push(3);
		lList.push(2);
		lList.push(1);

		lList.printlist();

		lList.addNodeAtFront(0);
		lList.printlist();
		lList.addNodeAfterGivenNode(3, 6);
		lList.printlist();
		lList.addNodeBeforeGivenNode(6, 8);
		lList.addNodeAtEnd(7);
		lList.printlist();

	}

}
