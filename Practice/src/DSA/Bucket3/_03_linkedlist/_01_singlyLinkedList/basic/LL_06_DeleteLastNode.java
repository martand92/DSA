package DSA.Bucket3._03_linkedlist._01_singlyLinkedList.basic;

public class LL_06_DeleteLastNode {

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		Node second = new Node(2);
		head.next = second;
		Node third = new Node(3);
		second.next = third;
		Node fourth = new Node(4);
		third.next = fourth;
		Node fifth = new Node(5);
		fourth.next = fifth;

		Node n = head;
		Node prev = head;
//		while (n != null) {
//			if (n.next == null) {
//				prev.next = null;
//				n = null;
//				break;
//			}
//			prev = n;// point existing node as previous and then hop onto next node
//			n = n.next;
//		}

		// Simpler solution
		while (n.next != null) {
			prev = n;
			n = n.next;
		}
		prev.next = null; // make n-1 node's pointer as null
		
		
		// iterating just to print
		Node k = head;
		while (k != null) {
			System.out.println(k.data);
			k = k.next;
		}
	}

}
