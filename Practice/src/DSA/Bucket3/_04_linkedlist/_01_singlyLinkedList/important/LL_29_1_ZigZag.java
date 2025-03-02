package DSA.Bucket3._04_linkedlist._01_singlyLinkedList.important;

//https://practice.geeksforgeeks.org/problems/linked-list-in-zig-zag-fashion/1
// here zig zag pattern to be followed is a < b > c < d > e ... 
public class LL_29_1_ZigZag {

	Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void push(int d) {
		Node newNode = new Node(d);
		newNode.next = head;
		head = newNode;
	}

	public void printList() {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}

	// IP : 2->95->30->11->48
	// Expected OP : 2->95->11->48->30
	public void zigzagPattern() {

		Node n = head.next, prev = head;
		int temp = 0;
		int i = 0;

		while (n != null) {

			if (i % 2 == 0) {
				// invalid condition
				if (prev.data > n.data) {
					temp = n.data;
					n.data = prev.data;
					prev.data = temp;

				}

			} else {
				// invalid condition
				if (prev.data < n.data) {
					temp = n.data;
					n.data = prev.data;
					prev.data = temp;
				}
			}
			i++;
			prev = n;
			n = n.next;
		}

	}

	public static void main(String[] args) {

		LL_29_1_ZigZag lList = new LL_29_1_ZigZag();

		lList.push(48);
		lList.push(11);
		lList.push(30);
		lList.push(95);
		lList.push(2);

		lList.printList();

		lList.zigzagPattern(); // 2-> 95-> 11-> 48-> 30

		lList.printList();
	}

}
