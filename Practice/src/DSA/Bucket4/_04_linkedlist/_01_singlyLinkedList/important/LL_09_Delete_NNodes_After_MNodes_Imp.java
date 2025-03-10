package DSA.Bucket4._04_linkedlist._01_singlyLinkedList.important;

public class LL_09_Delete_NNodes_After_MNodes_Imp {

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


	void linkdelete(int m, int n) {

		// your code here
		Node node = head;
		Node prev = null;
		int mptr = m, nptr = n;

		while (node != null) {

			if (mptr == 0) {
				if (nptr == 1) {
					prev.next = node.next;
					mptr = m;
					nptr = n;
				} else
					nptr--;
			} else {
				mptr--;
				prev = node;
			}

			node = node.next;
		}

	}

	public static void main(String[] args) {

		LL_09_Delete_NNodes_After_MNodes_Imp lList = new LL_09_Delete_NNodes_After_MNodes_Imp();

		int M = 2;
		int N = 2; // After every 2 nodes, delete 2 node

		lList.push(8);
		lList.push(7);
		lList.push(6);
		lList.push(5);
		lList.push(4);
		lList.push(3);
		lList.push(2);
		lList.push(1);

		lList.printList();

		lList.linkdelete(M, N);

		lList.printList();

	}

}
