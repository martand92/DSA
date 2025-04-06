package DSA.Bucket4._04_linkedlist._01_singlyLinkedList.important;

public class LL_18_02_MergeSort {

	Node head;

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public int findLen(Node head) {

		Node n = head;
		int count = 0;
		while (n != null) {
			count++;
			n = n.next;
		}

		return count;
	}

	public Node findMid(Node head, int len) {
		Node n = head;
		len = (len / 2) - 1;

		while (len > 0) {
			n = n.next;
			len--;
		}

		return n;
	}

	public Node mergeSort(Node left, Node right) {
		//creation of dummy linkedlist
		Node sortedList = null;

		if (left == null)
			return right;

		if (right == null)
			return left;

		if (left.data <= right.data) {
			sortedList = left; // assign left node to sorted LL
			sortedList.next = mergeSort(left.next, right);
		} else {
			sortedList = right; // assign right node to sorted LL
			sortedList.next = mergeSort(left, right.next);
		}

		return sortedList;
	}

	public Node divide(Node head) {

		int len = findLen(head);

		if (len < 2)
			return head;

		Node mid = findMid(head, len);
		Node nextToMid = mid.next;
		mid.next = null;

		Node left = divide(head);
		Node right = divide(nextToMid);

		Node sortedList = mergeSort(left, right);
		return sortedList;
	}

	public void printList(Node head) {
		Node n = head;

		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

	public Node sort(Node head) {
		return divide(head);
	}

	public static void main(String[] args) {
		LL_18_02_MergeSort ll = new LL_18_02_MergeSort();
		ll.push(2);
		ll.push(1);
		ll.push(5);
		ll.push(3);
		ll.push(6);
		ll.push(4);
		ll.push(7);

		Node sortedList = ll.sort(ll.head);
		ll.printList(sortedList);
	}

}
