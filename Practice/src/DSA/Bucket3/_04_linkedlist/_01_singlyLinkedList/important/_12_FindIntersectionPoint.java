package DSA.Bucket3._04_linkedlist._01_singlyLinkedList.important;

import java.util.HashSet;

//https://www.youtube.com/watch?v=u4FWXfgS8jw
public class _12_FindIntersectionPoint {

	Node head1;
	Node head2;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public void addNode1(int data) {
		Node newNode = new Node(data);
		newNode.next = head1;
		head1 = newNode;
	}

	public void addNode2(int data) {
		Node newNode = new Node(data);
		newNode.next = head2;
		head2 = newNode;
	}

	public void printList(int num) {

		if (num == 1) {

			Node n1 = head1;
			while (n1 != null) {
				System.out.print(n1.data + " ");
				n1 = n1.next;
			}

		} else {
			Node n2 = head2;
			while (n2 != null) {
				System.out.print(n2.data + " ");
				n2 = n2.next;
			}
		}

		System.out.println();
	}

	public void intersect() {
		Node n1 = head1;
		Node n2 = head2;

		n1 = n1.next.next;
		n2 = n2.next.next.next;
		n2.next = n1;
	}

	public Node findIntersectionPointUsingHash() {

		HashSet<Node> hs = new HashSet<Node>();
		Node n1 = head1;
		while (n1 != null) {
			hs.add(n1);
			n1 = n1.next;
		}

		Node n2 = head2;
		while (n2 != null) {
			if (!hs.add(n2))
				return n2;

			hs.add(n2);
			n2 = n2.next;
		}

		return null;
	}

	public Node findIntersectionPoint_Option1() {

		// first find length of both LL and find their differences. This says how much
		// pointer should move in lenghtier ll to align with shorter ll.
		// then again start moving by 1 till both pointers meet at a point

		Node n1 = head1;
		Node n2 = head2;

		int count1 = 0, count2 = 0;

		while (n1 != null) {
			n1 = n1.next;
			count1++;
		}

		while (n2 != null) {
			n2 = n2.next;
			count2++;
		}

		int diff = Math.abs(count1 - count2);
		n1 = head1;
		n2 = head2;

		if (count1 < count2) {
			for (int i = 0; i < diff; i++)
				n2 = n2.next;
		} else {
			for (int i = 0; i < diff; i++)
				n1 = n1.next;
		}

		while (n1 != null && n2 != null) {
			if (n1 == n2)
				return n1;

			n1 = n1.next;
			n2 = n2.next;
		}

		return null;

	}

	public Node findIntersectionPoint_Option2() {

		// keep traversing till either of the pointers reaches end, then point the ended
		// pointer to another LL and continue till both pointers align on both ll. Now
		// continue to traverse till they meet

		Node n1 = head1;
		Node n2 = head2;

		int itr = 0; // need to iterate only max 2 times and if you cannot find intersecting node
						// then return null
		while (n1 != n2) {

			if (itr == 2)
				return null;

			if (n1 == null)
				n1 = head2;
			if (n2 == null)
				n2 = head1;

			if (n1 == null || n2 == null)// 1 iteration completes when any pointer reaches null
				itr++;

			n1 = n1.next;
			n2 = n2.next;
		}

		return n1;
	}

	public static void main(String[] args) {

		_12_FindIntersectionPoint ll = new _12_FindIntersectionPoint();
		ll.addNode1(6);
		ll.addNode1(7);
		ll.addNode1(8);
		ll.addNode1(2);
		ll.addNode1(1);

		ll.addNode2(3);
		ll.addNode2(1);
		ll.addNode2(8);
		ll.addNode2(2);

		// ll.intersect();

		ll.printList(1);
		ll.printList(2);

//		Node ans = ll.findIntersectionPointUsingHash();
//		Node ans = ll.findIntersectionPoint_Option1();
		Node ans = ll.findIntersectionPoint_Option2();

		if (ans != null)
			System.out.println(ans.data);
		else
			System.out.println(ans);

	}

}
