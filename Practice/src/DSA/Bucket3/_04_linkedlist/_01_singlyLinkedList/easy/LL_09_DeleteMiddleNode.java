package DSA.Bucket3._04_linkedlist._01_singlyLinkedList.easy;

public class LL_09_DeleteMiddleNode {

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

	public static void main(String[] args) {

		LL_09_DeleteMiddleNode lList = new LL_09_DeleteMiddleNode();

		lList.push(1);
		lList.push(2);
		lList.push(3);
		lList.push(4);

		Node n = lList.head;

		lList.printList();

		int count = 0, midPos = 0;

		while (n != null) {
			count++;
			n = n.next;
		}

		midPos = ((count + 1) / 2);

		n = lList.head;
		Node prev = null;

		while (midPos != 0) {
			prev = n;
			n = n.next;
			midPos--;
		}

		prev.next = n.next;
		lList.printList();

		// lList.deleteMidPos(midPos);
	}

//	void deleteMidPos(int midPos) {
//		System.out.println("Deleting node");
//
//		Node n = head;
//		Node prev = head;
//		int i = 0;
//		while (i < midPos - 1) {
//			prev = n;
//			i++;
//			n = n.next;
//		}
//
//		prev.next = n.next;
//
//		Node k = head;
//		while (k != null) {
//			System.out.println(k.data);
//			k = k.next;
//		}
//
//		// If you want to delete whole linkedList then point head to null in java and
//		// all other nodes will be released and cleared by GC
//
//	}

}
