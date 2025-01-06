package DSA._04_linkedlist._01_singlyLinkedList.basic;

public class LL_04_1_AddNodeAtEnd {

	Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

//	public static void main(String[] args) {
//		LL_4_AddNodeAtEnd linkedList = new LL_4_AddNodeAtEnd();
//		linkedList.head = new Node(1);
//		Node second = new Node(2);
//		linkedList.head.next = second;
//		Node third = new Node(3);
//		second.next = third;
//
//		//traversing whole initial list and printing 
//		Node n = linkedList.head;
//		while (n != null) {
//			System.out.println(n.data);
//			n = n.next;
//		}
//
//		System.out.println("Adding node at last");
//		Node newNode = new Node(4);
//		
//		//traversing whole list till end and adding new node
//		Node k = linkedList.head;
//		while (k != null) {
//			System.out.println(k.data);
//			if (k.next == null) {
//				k.next = newNode;
//				break;
//			}
//			k = k.next;
//		}
//		
//		System.out.println("Final List");
//		Node k1 = linkedList.head;
//		while (k1 != null) {
//			System.out.println(k1.data);
//			k1 = k1.next;
//		}
//
//	}

	public static void main(String[] args) {
		LL_04_1_AddNodeAtEnd linkedList = new LL_04_1_AddNodeAtEnd();
		linkedList.addNode(new Node(0));
		linkedList.addNode(new Node(1));
		linkedList.addNode(new Node(2));
		linkedList.addNode(new Node(3));
		linkedList.addNode(new Node(4));

		// traversing through final linkedList
		Node n = linkedList.head;
		while (n != null) {
			System.out.println(n.data);
			n = n.next;
		}

	}

	public void addNode(Node node) {
		if (head == null)
			head = node;

		else {

			Node n = head;

			while (n.next != null)
				n = n.next;

			n.next = node;

		}
	}

}
