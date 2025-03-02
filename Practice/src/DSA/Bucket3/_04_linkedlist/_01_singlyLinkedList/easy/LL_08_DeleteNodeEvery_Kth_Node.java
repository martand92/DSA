package DSA.Bucket3._04_linkedlist._01_singlyLinkedList.easy;

//https://practice.geeksforgeeks.org/problems/remove-every-kth-node/1
public class LL_08_DeleteNodeEvery_Kth_Node {
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

	public static void main(String[] args) {
		LL_08_DeleteNodeEvery_Kth_Node lList = new LL_08_DeleteNodeEvery_Kth_Node();
		lList.push(10);
		lList.push(9);
		lList.push(8);
		lList.push(7);
		lList.push(6);
		lList.push(5);
		lList.push(4);
		lList.push(3);
		lList.push(2);
		lList.push(1);

		int k = 3; // delete every 3rd node

		lList.deleteNode(k);
	}

	void deleteNode(int k) {

		Node n = head;
		int ptr = k - 1;
		Node prev = n;

		while (n != null) {

			if (k == 1) { // all nodes should be deleted
				head = null;
				return;
			}

			if (ptr == 0) {
				prev.next = n.next;
				ptr = k;
				n = prev;

			} else {
				ptr--;
				prev = n;
				n = n.next;
			}
		}

		printList();

	}
}
