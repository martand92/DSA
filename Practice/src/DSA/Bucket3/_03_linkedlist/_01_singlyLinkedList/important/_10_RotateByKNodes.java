package DSA.Bucket3._03_linkedlist._01_singlyLinkedList.important;

public class _10_RotateByKNodes {

	Node head;
	Node tailNode;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public void addNode(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public int countNodes() {

		int count = 0;
		Node n = head;

		while (n != null) {

			count++;

			if (n.next == null)
				tailNode = n;

			n = n.next;
		}

		return count;
	}

	public void printList() {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}

		System.out.println();
	}

	public void rotateKTimes(int k) {

		// Step 1 : if k > n, then do k = k % n;
		int n = countNodes();
		System.out.println(n);
		k = k % n;

		// Step 2 : point last node to head and make it circular LL
		tailNode.next = head;

		// Step 3 : instead of adding k nodes to front, goto (n - k)th node and point it
		// to null and point head to (n - k + 1)th node
		Node n1 = head;
		for (int i = 0; i < (n - k - 1); i++)// as head is already at first node, you should only jump k - 1 times
			n1 = n1.next;

		head = n1.next;
		n1.next = null;

	}

	public static void main(String[] args) {

		_10_RotateByKNodes ll = new _10_RotateByKNodes();
		ll.addNode(5);
		ll.addNode(4);
		ll.addNode(3);
		ll.addNode(2);
		ll.addNode(1);

		ll.printList();
		ll.rotateKTimes(2);
		ll.printList();

	}
}
