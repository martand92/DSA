package DSA.Bucket3._03_linkedlist._02_doublyLinkedList;

//https://practice.geeksforgeeks.org/problems/insert-in-sorted-way-in-a-sorted-dll/1
public class _07_InsertValueInSortedList {

	Node head;
	Node temp;

	static class Node {
		int data;
		Node next;
		Node prev;

		Node(int d) {
			data = d;
		}
	}

	public void printlist() {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}

	public void push(int data) {
		Node newNode = new Node(data);
		if (head != null)
			head.prev = newNode;

		newNode.next = head;
		head = newNode;
	}

	public void insertElement(int x) {

		Node n = head;

		while (n.data < x && n.next != null) {
			n = n.next;
		}

		Node newNode = new Node(x);
		
		//if given value is less than head
		if (n == head) {
			
			newNode.next = n;
			n.prev = newNode;
			head = newNode;
			
		} 
		//if given value is greater than tail
		else if (n.data < x) {
			n.next = newNode;
			newNode.prev = n;
			
		} 
		//if given value to be inserted in middle
		else {
			newNode.next = n;
			newNode.prev = n.prev;
			n.prev.next = newNode;
			n.prev = newNode;
		}

	}

	public static void main(String[] args) {
		_07_InsertValueInSortedList lList = new _07_InsertValueInSortedList();

		lList.push(5);
		lList.push(4);
		lList.push(2);
		lList.push(1);

		lList.printlist();

		lList.insertElement(0);

		lList.printlist();
	}

}
