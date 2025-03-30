package DSA.Bucket4._04_linkedlist._01_singlyLinkedList.easy;

public class LL_18_BubbleSort_Data {

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
			listLength++;
			System.out.print(n.data + " ");
			n = n.next;
		}

		System.out.println();

	}

	public static void main(String[] args) {

		LL_18_BubbleSort_Data lList = new LL_18_BubbleSort_Data();
		lList.push(5);
		lList.push(3);
		lList.push(6);
		lList.push(2);
		lList.push(4);
		lList.push(1);

//		3,5,6,2,4,1
//		3,5,6,2,4,1
//		3,5,2,6,4,1
//		3,5,2,4,6,1
//		3,5,2,4,1,6

		lList.printList(lList.head);

		Node n;

		int temp = 0;

		for (int i = 0; i < lList.listLength; i++) {

			n = lList.head;

			for (int j = 0; j < lList.listLength - 1 - i; j++) {

				if (n.data > n.next.data) {
					temp = n.data;
					n.data = n.next.data;
					n.next.data = temp;
				}

				n = n.next;

			}
		}

		System.out.println("After Sorting : ");
		lList.printList(lList.head);
	}

}
