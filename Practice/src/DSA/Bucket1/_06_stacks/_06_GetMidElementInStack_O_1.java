package DSA.Bucket1._06_stacks;

//Deleting an element from the middle is not O(1)
//In a singly linked list, moving the middle pointer in both directions is not possible cz for pop the middle pointer would change
//So will go with Doubly linked list
public class _06_GetMidElementInStack_O_1 {

	Node head;
	Node mid;
	int size = 0;

	static class Node {
		int data;
		Node next;
		Node prev;

		Node(int d) {
			data = d;
			next = null;
			prev = null;
		}
	}

	public void push(int data) {
		Node newNode = new Node(data);

		if (head != null)
			head.prev = newNode;

		newNode.next = head;
		head = newNode;
		if (size == 0)
			mid = newNode;

		// size++;

		if (size % 2 != 0)
			mid = mid.prev;

		size++;
	}

	public void pop() {
		System.out.println("Popped : " + head.data);

		head = head.next;
		if (head != null)
			head.prev = null;

		size--;

		if (size % 2 == 0)
			mid = mid.next;
	}

	public void getMid() {
		if (mid != null)
			System.out.println("Mid : " + mid.data);
	}

	public void printList() {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

	public static void main(String[] args) {
		_06_GetMidElementInStack_O_1 s = new _06_GetMidElementInStack_O_1();
		s.push(5);
		s.push(4);
		s.push(3);
		s.push(2);
		s.push(1);
		s.getMid();

		s.printList();

		s.pop();
		s.getMid();
		s.pop();
		s.getMid();
		s.pop();
		s.getMid();
		s.pop();
		s.getMid();
		s.pop();
		s.getMid();
	}

}
