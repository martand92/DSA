package DSA.Bucket3._04_linkedlist._01_singlyLinkedList.important;

//https://www.geeksforgeeks.org/problems/delete-without-head-pointer/1
public class LL_07_1_DeleteNode_WithoutHeadRef_Nice {
	Node head;
	Node del;

	public static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void push(int d) {
		
		Node newNode = new Node(d);
		
		//Tag Node as "del" with given data to be deleted
		if (d == 2)
			del = newNode;

		newNode.next = head;
		head = newNode;
	}

	public void deleteNode(Node d) {
		// 0 -> 1 -> 2-> 3-> 4 // if 2 should be deleted
		// 0-> 1-> 3-> 3-> 4
		// 0-> 1-> 3-> 4
		del.data = del.next.data;
		del.next = del.next.next;
	}

	public void printList() {
		
		Node n = head;
		
		while (n != null) {
			System.out.println(n.data);
			n = n.next;
		}
	}

	public static void main(String[] args) {
		
		LL_07_1_DeleteNode_WithoutHeadRef_Nice lList = new LL_07_1_DeleteNode_WithoutHeadRef_Nice();

		lList.push(0);
		lList.push(1);
		lList.push(2);
		lList.push(3);
		lList.push(4);

		lList.deleteNode(lList.del);

		lList.printList();

	}
}
