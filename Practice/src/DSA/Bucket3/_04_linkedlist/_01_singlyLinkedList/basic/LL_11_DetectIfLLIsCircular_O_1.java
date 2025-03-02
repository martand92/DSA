package DSA.Bucket3._04_linkedlist._01_singlyLinkedList.basic;

public class LL_11_DetectIfLLIsCircular_O_1 {

	Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void push(int n) {
		Node newNode = new Node(n);
		newNode.next = head;
		head = newNode;
	}

	public static void main(String[] args) {

		LL_11_DetectIfLLIsCircular_O_1 lList = new LL_11_DetectIfLLIsCircular_O_1();
		lList.push(1);
		lList.push(2);
		lList.push(3);
		lList.push(4);
		lList.push(5);

		// HashSet<Node> set = new HashSet<Node>(); // O(n) for both time and space,
		// below approach reduce space to O(1)
		Node n = lList.head;
		boolean isLoop = false;

		while (n != null) {
			n = n.next;
			if (n == lList.head) {
				isLoop = true;
				break;
			}
		}
		System.out.println(isLoop);
	}
}
