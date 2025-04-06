package DSA.Bucket4._04_linkedlist._02_doublyLinkedList.medium;

//In below implementation, steps marked as /**/ are extra compared to merge sort of linkedlist
public class _06_MergeSort {

	Node head;

	static class Node {
		int data;
		Node next;
		Node prev;

		public Node(int data) {
			this.data = data;
		}
	}

	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next = head;

		if (head != null)
			head.prev = newNode;

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

		Node sortedList = null;

		if (left == null)
			return right;

		if (right == null)
			return left;

		if (left.data <= right.data) {
			sortedList = left;
			sortedList.next = mergeSort(left.next, right);

		} else {
			sortedList = right;
			sortedList.next = mergeSort(left, right.next);
		}

		// while recurring back ll, need to map prev pointer of curr node to prev node
		sortedList.next.prev = sortedList; /**/

		return sortedList;
	}

	public Node divide(Node head) {

		int len = findLen(head);

		if (len < 2)
			return head;

		Node mid = findMid(head, len);
		Node nextToMid = mid.next;

		nextToMid.prev = null; /**/
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
		_06_MergeSort ll = new _06_MergeSort();
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
