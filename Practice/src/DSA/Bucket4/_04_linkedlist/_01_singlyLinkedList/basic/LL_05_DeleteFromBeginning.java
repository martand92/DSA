package DSA.Bucket4._04_linkedlist._01_singlyLinkedList.basic;

public class LL_05_DeleteFromBeginning {

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

		//Node temp = head; //May be no need to nullify the node as just pointing initial head reference to second node will make initial node without reference and collected by GC
		//temp = null;
		//Simpler solution
		head = second;

		//To traverse ad print
		Node n = head;
		while (n != null) {
			System.out.println(n.data);
			n = n.next;
		}
	

	}
}
