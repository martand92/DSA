package DSA.Bucket3._06_stacks;

//Using LinkedList
public class _07_MergeableStack_UsingLL_O1 {

	Node head1;
	Node head2;
	Node tailNode1;
	final int MAX = 5;
	int size1 = 0;
	int size2 = 0;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void push(int stackNum, int data) {

		if (stackNum == 1) {

			if (size1 > MAX) {
				System.out.println("Stack 1 Overflow");
			} else {
				Node newNode = new Node(data);

				if (head1 == null)
					tailNode1 = newNode;

				newNode.next = head1;
				head1 = newNode;
				size1++;
			}
		} else {
			if (size2 > MAX) {
				System.out.println("Stack 2 Overflow");
			} else {
				Node newNode = new Node(data);
				newNode.next = head2;
				head2 = newNode;
				size2++;
			}
		}
	}

	public void merge(_07_MergeableStack_UsingLL_O1 s2) {
		Node n = head1;
		while (n.next != null) {
			n = n.next;
		}
		n.next = s2.head2;
	}

	public void printList() {
		Node n = head1;

		while (n != null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.print("null");
	}

	public static void main(String[] args) {
		_07_MergeableStack_UsingLL_O1 s1 = new _07_MergeableStack_UsingLL_O1();
		_07_MergeableStack_UsingLL_O1 s2 = new _07_MergeableStack_UsingLL_O1();

		s1.push(1, 0);
		s1.push(1, 1);
		s1.push(1, 2);
		s1.push(1, 3);
		s1.push(1, 4);

		s2.push(2, 0);
		s2.push(2, 1);
		s2.push(2, 2);
		s2.push(2, 3);
		s2.push(2, 4);

		s1.merge(s2);

		s1.printList();
	}

}
