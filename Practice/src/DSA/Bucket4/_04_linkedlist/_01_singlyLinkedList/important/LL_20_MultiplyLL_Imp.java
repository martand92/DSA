package DSA.Bucket4._04_linkedlist._01_singlyLinkedList.important;

public class LL_20_MultiplyLL_Imp {

	Node head1;
	Node head2;

	public static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void push1(int d) {
		Node newNode = new Node(d);
		newNode.next = head1;
		head1 = newNode;
	}

	public void push2(int d) {
		Node newNode = new Node(d);
		newNode.next = head2;
		head2 = newNode;
	}

	public static void printList(Node head) {
		Node n = head;

		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

	public void multiplyTwoLists(Node l1, Node l2) {

		long N = 1000000007;
		long num1 = 0, num2 = 0;

		while (l1 != null || l2 != null) {
			if (l1 != null) {
				num1 = (((num1) * 10) + l1.data) % N;
				l1 = l1.next;
			}

			if (l2 != null) {
				num2 = (((num2) * 10) + l2.data) % N;
				l2 = l2.next;
			}
		}

		System.out.println((num1 * num2) % N);

	}

	public static void main(String[] args) {

		LL_20_MultiplyLL_Imp lList = new LL_20_MultiplyLL_Imp();

		lList.push1(0);
		lList.push1(9);
		lList.push1(1);

		lList.push2(0);
		lList.push2(9);
		lList.push2(1);

		lList.multiplyTwoLists(lList.head1, lList.head2);

	}

}
