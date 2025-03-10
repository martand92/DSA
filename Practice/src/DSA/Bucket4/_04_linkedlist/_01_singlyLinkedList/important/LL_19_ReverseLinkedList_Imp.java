package DSA.Bucket4._04_linkedlist._01_singlyLinkedList.important;

public class LL_19_ReverseLinkedList_Imp {

	Node head;

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

	public void printlist() {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}

	public void reverse() { // 1->2->3->4->5->6->null 6>5>4>3>2>1>null
		Node n = head;
		Node prev = null;
		Node next = null;
		
		while (n != null) {
			next = n.next;
			n.next = prev;
			prev = n;
			n = next;
		}

		head = prev;

	}

	public static void main(String[] args) {

		LL_19_ReverseLinkedList_Imp lList = new LL_19_ReverseLinkedList_Imp();
		lList.push(6);
		lList.push(5);
		lList.push(4);
		lList.push(3);
		lList.push(2);
		lList.push(1);

		lList.printlist();

		lList.reverse();
		lList.printlist();

	}

}
