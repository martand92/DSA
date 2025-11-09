package DSA.Bucket3._03_linkedlist._01_singlyLinkedList.easy;

public class LL_16_1_SwapDataPairWise {

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

	public void swapNodes(Node n) {
		Node prev = n;
		int temp = 0, i = 0;

		while (n != null) {

			if (i % 2 != 0) {
				temp = prev.data;
				prev.data = n.data;
				n.data = temp;
			}

			i++;
			prev = n;
			n = n.next;
		}
	}

	public static void main(String[] args) {
		LL_16_1_SwapDataPairWise lList = new LL_16_1_SwapDataPairWise();

		lList.push(1);
		lList.push(2);
		lList.push(3);
		lList.push(4);
		lList.push(5);
		lList.push(6);
		lList.printList();

		lList.swapNodes(lList.head);
		lList.printList();

	}

}
