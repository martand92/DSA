package DSA.Bucket4._04_linkedlist._01_singlyLinkedList.important;

//https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1
public class LL_20_Add2LL_Imp {
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

	public Node reverseLL(Node head) {

		Node next = null;
		Node n = head;
		Node prev = null;

		while (n != null) {
			next = n.next;
			n.next = prev;
			prev = n;
			n = next;
		}

		head = prev;
		return head;
	}

	public void addTwoLists(Node head1, Node head2) {

		head1 = reverseLL(head1);
		head2 = reverseLL(head2);

		int carry = 0;
		Node head = null;
		int sum = 0;

		while (head1 != null && head2 != null) {
			sum = head1.data + head2.data + carry;
			Node newNode = new Node(sum % 10);
			carry = sum / 10;
			newNode.next = head;
			head = newNode;

			head1 = head1.next;
			head2 = head2.next;
		}

		while (head1 != null) {
			sum = head1.data + carry;
			Node newNode = new Node(sum % 10);
			carry = sum / 10;
			newNode.next = head;
			head = newNode;
			head1 = head1.next;
		}

		while (head2 != null) {
			sum = head2.data + carry;
			Node newNode = new Node(sum % 10);
			carry = sum / 10;
			newNode.next = head;
			head = newNode;
			head2 = head2.next;
		}

		printList(head);

	}

	public static void main(String[] args) {

		LL_20_Add2LL_Imp lList = new LL_20_Add2LL_Imp(); // represents number 190 as 1->9->0->null
		lList.push1(0);
		lList.push1(9);
		lList.push1(1);

		lList.push2(5); // represent 2-> 5-> null
		lList.push2(2);

		lList.addTwoLists(lList.head1, lList.head2);

	}
}
