package DSA.Bucket3._06_stacks;

//getMin() is O(1) and O(N) for time and space resp
// Can make space as O(1) too -- need to work on it

public class _04_SpecialDataStructure {
	Node head;
	Node head1;
	final int MAX = 5;
	int size, min;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void push(int d) {
		if (size == MAX)
			System.out.println("Stack Overflow");
		else {

			if (head == null) {
				min = d;
			}

			Node newNode = new Node(d);
			newNode.next = head;
			head = newNode;

			if (min > d) {
				min = d;
				Node newNode1 = new Node(d);
				newNode1.next = head1;
				head1 = newNode1;
			} else {
				Node newNode1 = new Node(min);
				newNode1.next = head1;
				head1 = newNode1;
			}

			size++;
		}
	}

	public void pop() {
		head = head.next;
		head1 = head1.next;
		size--;
	}

	public void getMin() {
		System.out.println(head1.data);
	}

	public void isEmpty() {
		if (head != null)
			System.out.println("Stack is not empty");
		else
			System.out.println("Stack is empty");
	}

	public void isFull() {
		if (size == MAX)
			System.out.println("Stack is full");
		else
			System.out.println("Stack is not full");
	}

	public static void main(String[] agrs) {
		_04_SpecialDataStructure sds = new _04_SpecialDataStructure();
		sds.push(1);
		sds.push(2);
		sds.push(1);
		sds.push(4);
		sds.push(-1);

		// sds.pop();

		sds.isEmpty();
		sds.isFull();

		sds.getMin();
	}
}
