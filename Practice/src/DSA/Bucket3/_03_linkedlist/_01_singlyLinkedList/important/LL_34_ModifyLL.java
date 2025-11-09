package DSA.Bucket3._03_linkedlist._01_singlyLinkedList.important;

//https://practice.geeksforgeeks.org/problems/modify-linked-list-1/1
public class LL_34_ModifyLL {

	static Node head;
	int len;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public void printList(Node head) {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}

	// creating new reversed linkedlist & counting total nodes
	public Node reverseLL(Node head) {

		Node n = head, prev = null, next = n.next, newNode = null;

		while (n != null) {
			next = n.next;
			newNode = new Node(n.data);
			newNode.next = prev;
			prev = newNode;
			n = next;
			len++;
		}

		return newNode;
	}

	public void modify() {

		Node newHead = reverseLL(head);// expectation was to do it with O(1) space but here O(N).

		Node n = head;
		Node n1 = newHead;
		len /= 2;
		while (len > 0) {
			n.data = n1.data - n.data;
			n = n.next;
			n1 = n1.next;
			len--;
		}

	}

	public static void main(String[] args) {

		LL_34_ModifyLL lList = new LL_34_ModifyLL();

		lList.push(6);
		lList.push(3);
		lList.push(5);
		lList.push(4);
		lList.push(10);

		lList.printList(head);

		lList.modify();

		lList.printList(head);
	}

}
