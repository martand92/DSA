package DSA.Bucket3._04_linkedlist._02_doublyLinkedList;

public class _11_RotateByNNodes {

	Node head;
	Node tailNode;

	static class Node {
		int data;
		Node next;
		Node prev;

		Node(int d) {
			data = d;
		}
	}

	public void printlist() {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			if (n.next == null) {
				tailNode = n;
			}
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

	public void rotateByNNode(int num) {

		Node n = head;

		while (n.next != null)
			n = n.next;

		while (num > 0) {

			n.next = head;
			head.prev = n;
			n = n.next;
			head = head.next;
			head.prev = null;
			n.next = null;

			num--;
		}

	}

	public static void main(String[] args) {
		_11_RotateByNNodes lList = new _11_RotateByNNodes();
		lList.push(-2);
		lList.push(-1);
		lList.push(5);
		lList.push(4);
		lList.push(3);
		lList.push(2);
		lList.push(1);
		lList.push(5);
		lList.push(4);
		lList.push(3);
		lList.push(2);
		lList.push(1);
		lList.printlist();
		lList.rotateByNNode(2);
		lList.printlist();
	}

}
