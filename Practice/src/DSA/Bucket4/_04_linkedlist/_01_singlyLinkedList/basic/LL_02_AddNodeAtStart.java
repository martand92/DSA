package DSA.Bucket4._04_linkedlist._01_singlyLinkedList.basic;

public class LL_02_AddNodeAtStart {

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
		Node third = new Node(3);

		head.next = second;
		second.next = third;

		Node newNode = new Node(0);
		
		
		
//		Node temp = head;
//		head = new Node(0);
//		head.next = temp;
		
		newNode.next = head;
		head = newNode;
		
		
		//Follow below code to traverse and print whole LinkedList 
		Node n = head;

		while (n != null) {
			System.out.println(n.data);
			n = n.next;
		}
	}

}
