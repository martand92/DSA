package DSA.Bucket4._04_linkedlist._01_singlyLinkedList.important;

//https://www.youtube.com/watch?v=ysytSSXpAI0
public class _09_FlatteningLL {

	Node head;

	static class Node {
		int data;
		Node next;
		Node bottom;

		Node(int data) {
			this.data = data;
			this.next = null;
			this.bottom = null;
		}
	}

	public void addNode() {

		Node n = null;
		Node n1 = null;

		head = new Node(5);
		n1 = head;
		n = head;
		n1.bottom = new Node(7);
		n1 = n1.bottom;
		n1.bottom = new Node(8);
		n1 = n1.bottom;
		n1.bottom = new Node(30);

		n.next = new Node(10);
		n = n.next;
		n1 = n;
		n1.bottom = new Node(20);

		n.next = new Node(19);
		n = n.next;
		n1 = n;
		n1.bottom = new Node(22);
		n1 = n1.bottom;
		n1.bottom = new Node(50);

		n.next = new Node(28);
		n = n.next;
		n1 = n;
		n1.bottom = new Node(35);
		n1 = n1.bottom;
		n1.bottom = new Node(40);
		n1 = n1.bottom;
		n1.bottom = new Node(45);
	}

	private void printlist(Node n) {

		while (n != null) {
			System.out.print(n.data + " ");
			n = n.bottom;
		}
	}

	// here you merge last and last second ll and return. Recursion
	public Node merge(Node currLLRoot, Node rightLLRoot) {

		// follow previous merge sorted LL in place to merge both LLs
		Node n1 = currLLRoot;
		Node n2 = rightLLRoot;
		Node prev1 = null, prev2 = null;

		while (n1 != null && n2 != null) {

			if (n1.data < n2.data) {

				while (n1 != null && (n1.data < n2.data)) {
					prev1 = n1;
					n1 = n1.bottom;// instead of merging next, merge bottom
				}
				prev1.bottom = n2;

			} else {

				while (n2 != null && (n2.data < n1.data)) {
					prev2 = n2;
					n2 = n2.bottom;
				}

				prev2.bottom = n1;
			}
		}

		return currLLRoot.data < rightLLRoot.data ? currLLRoot : rightLLRoot;
	}

	// first goto end of all vertical lls by traversing to right most using
	// recursion, then merge last second & last ll with their root ref
	public Node flattenLL(Node root) {

		if (root.next == null)
			return root;

		Node rightLL = flattenLL(root.next);
		Node mergedLLRoot = merge(root, rightLL);// merged 2 LLs are returned as 1 to merge again with its left ll
		mergedLLRoot.next = null;
		return mergedLLRoot;
	}

	public static void main(String[] args) {
		_09_FlatteningLL ll = new _09_FlatteningLL();
		ll.addNode();
		Node res = ll.flattenLL(ll.head);
		ll.printlist(res);
	}
}
