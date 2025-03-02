package DSA.Bucket1._05_Create_Stack_Queue._02_Create_Stack_Q_UsingLinkedList;

public class _02_Stack_UsingLL {
	Node head;
	final int MAX = 100;
	int size;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void push(int d) {
		if (size == MAX) {
			System.out.println("Stack Overflow");
		} else {
			Node newNode = new Node(d);
			newNode.next = head;
			head = newNode;
			size++;
		}
	}

	public void printList() {
		Node n = head;

		while (n != null) {
			System.out.println(n.data);
			n = n.next;
		}
	}

	public void top() {
		if (head == null)
			System.out.println("Stack Underflow");
		else
			System.out.println("Top : " + head.data);
	}

	public void pop() {
		if (head == null)
			System.out.println("Stack Underflow");
		else {
			System.out.println("Removing top element : " + head.data);
			head = head.next;
		}
	}

	public void isEmpty() {
		if (head == null) {
			System.out.println("Stack is empty");
		} else
			System.out.println("Stack is not empty");
	}

	public static void main(String[] args) {
		_02_Stack_UsingLL s = new _02_Stack_UsingLL();
		s.push(10);
		s.push(20);
		s.push(30);
		s.printList();
		s.top();
		s.pop();
		s.printList();
		s.top();
		s.isEmpty();
	}
}
