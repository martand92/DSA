package DSA.Bucket4._04_linkedlist._01_singlyLinkedList.easy;

//Its not quick sort but bubble sort
public class LL_18_BubbleSort2 {

	Node head;
	int listLength;

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

	public void printList(Node n) {
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}

		System.out.println();

	}

	public void sort() {

		Node initHead = cloneLL(head);
		head = reverseLL(head);
		Node n = head;

		while (n != null) {

			Node node = initHead;
			Node prev = null;
			boolean swapped = false;

			while (node != null) { // Shouldn't take this till end, for every itr should stop at n - 1

				if (prev != null) {

					if (prev.data > node.data) {
						swapped = true;
						int temp = prev.data;
						prev.data = node.data;
						node.data = temp;
					}
				}

				prev = node;
				node = node.next;
			}

			head = initHead;

			if (!swapped)
				break;

			n = n.next;
		}

	}

	public Node cloneLL(Node head) {

		Node n = head;
		Node initHead = null;

		while (n != null) {

			Node newNode = new Node(n.data);
			newNode.next = initHead;
			initHead = newNode;
			n = n.next;
		}

		return reverseLL(initHead);
	}

	public Node reverseLL(Node head) {
		Node n = head;
		Node next = null;
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

	public static void main(String[] args) {

		LL_18_BubbleSort2 lList = new LL_18_BubbleSort2();
		lList.push(5);
		lList.push(3);
		lList.push(6);
		lList.push(2);
		lList.push(4);
		lList.push(1);

		lList.printList(lList.head);

		lList.sort();
		System.out.println("After Sorting : ");
		lList.printList(lList.head);

	}

}
