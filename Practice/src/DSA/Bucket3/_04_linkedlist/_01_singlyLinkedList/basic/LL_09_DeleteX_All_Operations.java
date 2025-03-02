package DSA.Bucket3._04_linkedlist._01_singlyLinkedList.basic;

public class LL_09_DeleteX_All_Operations {

	Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void addNode(int data) {
		Node newNode = new Node(data);

		if (head != null)
			newNode.next = head;

		head = newNode;

	}

	public void deleteHeadNode() {
		Node n = head;
		head = n.next;
	}

	public void deleteTailNode() {
		Node n = head;
		Node prev = n;

		if (head.next == null)
			head = null;

		else {
			while (n.next != null) {
				prev = n;
				n = n.next;
			}
			prev.next = null;
		}
	}

	public void deleteNodeWithGivenData(int data) {
		Node n = head;
		Node prev = n;

		while (n.data != data) {
			prev = n;
			n = n.next;
		}

		if (n == head)
			head = n.next;
		else if (n.next == null)
			prev.next = null;
		else
			prev.next = n.next;
	}

	public void deleteNodeAtGivenPos(int pos) {
		int count = 0;
		Node n = head;
		Node prev = null;

		while (n != null) {
			count++;
			n = n.next;
		}

		if (pos == 1)
			head = head.next;

		else if (pos > count + 1)
			System.out.println("Provided position is incorrect");

		else {

			while (n != null && pos != 1) {
				pos--;
				prev = n;
				n = n.next;
			}

			prev.next = n.next;
		}
	}

	public void deleteEveryKthNode(int k) {
		Node n = head;
		int initk = k;
		Node prev = n;

		while (n != null) {

			k--;

			if (k == 0) {
				prev.next = n.next;
				k = initk;
			}
			prev = n;
			n = n.next;
		}
	}

	public void deleteNNodesAfterMNodes(int n, int m) {
		Node node = head;
		Node prev = null;
		int initm = m;
		int initn = n;
		Node deletableNode = null;

		while (node != null) {

			while (m != 0) {
				m--;
				prev = node;
				node = node.next;
				deletableNode = node;
			}

			while (n != 1) {
				n--;
				deletableNode = deletableNode.next;
			}

			prev.next = deletableNode.next;
			node = prev.next;
			m = initm;
			n = initn;
		}

	}

	public void deleteMidNode() {
		Node n = head;
		Node prev = null;
		int count = 0;

		while (n != null) {
			count++;
			n = n.next;

		}

		n = head;

		if (count % 2 == 0)
			count = count / 2; // if no of nodes = 4, then 4/2 = 2 = 2nd node to be deleted
		else
			count = count / 2 + 1; // if no of nodes = 5, then 5/2 = 2 + 1 = 3rd node to be deleted

		if (count == 1)
			head = head.next;

		else {
			while (count != 1) {
				count--;
				prev = n;
				n = n.next;
			}

			prev.next = n.next;
		}
	}

	public static void main(String[] args) {
		LL_09_DeleteX_All_Operations ll = new LL_09_DeleteX_All_Operations();
		ll.addNode(1);
		ll.addNode(2);
		ll.addNode(3);
		ll.addNode(4);
		ll.addNode(5);
	}
}