package DSA.Bucket3._03_linkedlist._01_singlyLinkedList.easy;

//https://practice.geeksforgeeks.org/problems/remove-every-kth-node/1
public class LL_08_DeleteEveryKthNode {
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

		LL_08_DeleteEveryKthNode lList = new LL_08_DeleteEveryKthNode();
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

		int k = 2;

		lList.deleteNode(k);
	}

	void deleteNode(int k) {

		if (k == 1) { // all nodes should be deleted
			head = null;
			return;
		}

		Node n = head;
		Node prev = n;
		int count = 1;

		while (n != null) {

			if (count % k == 0)
				prev.next = n.next;

			count++;
			prev = n;
			n = n.next;
		}

		printList();

	}
}
