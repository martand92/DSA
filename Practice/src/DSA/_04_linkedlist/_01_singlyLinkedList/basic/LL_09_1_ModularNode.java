package DSA._04_linkedlist._01_singlyLinkedList.basic;

//https://practice.geeksforgeeks.org/problems/modular-node/1
public class LL_09_1_ModularNode {

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

	public void modularNode(int k) {

		int count = 1;
		int value = -1;
		Node n = head;

		while (n != null) {

			if (count % k == 0)
				value = n.data;

			count++;
			n = n.next;
		}

		System.out.println("value : " + value);
	}

	public static void main(String[] args) {

		LL_09_1_ModularNode lList = new LL_09_1_ModularNode();

		lList.push(7);
		lList.push(6);
		lList.push(5);
		lList.push(4);
		lList.push(3);
		lList.push(2);
		lList.push(1);

		lList.modularNode(3);
	}

}
