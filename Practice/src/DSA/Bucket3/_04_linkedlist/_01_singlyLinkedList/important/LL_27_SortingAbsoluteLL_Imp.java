package DSA.Bucket3._04_linkedlist._01_singlyLinkedList.important;

//https://practice.geeksforgeeks.org/problems/absolute-list-sorting/1
public class LL_27_SortingAbsoluteLL_Imp {

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
	}

	public void sortingAbsoluteLL() {

		Node n = head;
		Node prev = null;

		while (n != null) {

			if (n.data < 0) {
				prev.next = n.next;
				n.next = head;
				head = n;

			} else
				prev = n;

			n = prev.next;

		}
	}

	public static void main(String[] args) {

		LL_27_SortingAbsoluteLL_Imp lList = new LL_27_SortingAbsoluteLL_Imp();

		lList.push(-5);
		lList.push(4);
		lList.push(-3);
		lList.push(-2);
		lList.push(1);
		lList.push(0);

		lList.sortingAbsoluteLL();

		lList.printList();
	}

}
