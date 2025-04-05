package DSA.Bucket4._04_linkedlist._01_singlyLinkedList.important;

//https://practice.geeksforgeeks.org/problems/rearrange-linked-list-in-place/1
public class LL_35_RearrangeLLInPlace {

	static Node head;
	int count = 0;

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
	}

	// creating new reversed linkedlist
	public Node reverse(Node head) {
		Node n = head;
		Node next = null;
		Node prev = null;
		Node newNode = null;

		while (n != null) {
			next = n.next;
			newNode = new Node(n.data);
			newNode.next = prev;
			prev = newNode;
			n = next;
			count++;
		}

		head = newNode;
		return head;
	}

	public void rearrange() {

		Node head1 = head, head2 = reverse(head1);
		Node head1Next = null, head2Next = null;
		boolean even = (count & 1) == 0 ? true : false;
		count /= 2;

		while (count > 0) {

			head1Next = head1.next;
			head2Next = head2.next;
			head1.next = head2;

			if (count == 1 & even)
				head2.next = null;

			else if (count == 1 & !even) {
				head2.next = head1Next;
				head1Next.next = null;

			} else {
				head2.next = head1Next;
				head1 = head1Next;
				head2 = head2Next;
			}

			count--;
		}

	}

	public static void main(String[] args) {

		LL_35_RearrangeLLInPlace lList = new LL_35_RearrangeLLInPlace();
		lList.push(6);
		lList.push(5);
		lList.push(4);
		lList.push(3);
		lList.push(2);
		lList.push(1);

		lList.rearrange();

		lList.printList(head);
	}

}
