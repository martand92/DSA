package DSA._04_linkedlist._01_singlyLinkedList.easy;

//https://practice.geeksforgeeks.org/problems/merge-list-alternatingly/1
public class LL_32_MergeListsAlternatingly {

	static Node head1;
	static Node head2;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void push1(int data) {
		Node newNode = new Node(data);
		newNode.next = head1;
		head1 = newNode;
	}

	public void push2(int data) {
		Node newNode = new Node(data);
		newNode.next = head2;
		head2 = newNode;
	}

	public void printList(Node head) {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}

		System.out.println();
	}

	public void mergeAlt() {

		Node n1 = head1;
		Node n2 = head2;
		Node n2Next = null;
		Node n1Next = null;

		while (n1 != null && n2 != null) {

			n1Next = n1.next;
			n2Next = n2.next;

			n1.next = n2;
			if (n1Next != null)
				n2.next = n1Next;

			n1 = n1Next;
			n2 = n2Next;
		}
	}

	public static void main(String[] args) {

		LL_32_MergeListsAlternatingly lList = new LL_32_MergeListsAlternatingly();

		lList.push1(99);
		lList.push1(88);
		lList.push1(77);
		lList.push1(66);
		lList.push1(55);
		lList.printList(head1);

		lList.push2(55);
		lList.push2(44);
		lList.push2(33);
		lList.push2(22);
		lList.push2(11);
		lList.printList(head2);

		lList.mergeAlt();

		lList.printList(head1);
	}

}
