package DSA.Bucket3._03_linkedlist._01_singlyLinkedList.important;

//https://www.youtube.com/watch?v=-DtNInqFUXs
public class LL_13_02_CheckPalindrome_O1 {

	static Node head;

	static class Node {
		char data;
		Node next;

		Node(char d) {
			data = d;
			next = null;
		}
	}

	private void push(char data) {
		Node n = new Node(data);
		n.next = head;
		head = n;
	}

	private boolean isPalindrome() {

		// Step 1 : Find middle of the LinkedList
		Node fast = head;
		Node slow = head;

		while (fast.next != null && fast.next.next != null) {// stop at last node(if length is odd) or last second node
																// (if length is even) so that slow points to middle
			fast = fast.next.next;
			slow = slow.next;
		}
		Node right = slow.next;// right side of middle node

		// Step 2 : Reverse right side linkedList as a separate linkedlist
		Node prev = null;
		Node next = right;
		Node n = right;

		while (n != null) {
			next = n.next;
			n.next = prev;
			prev = n;
			n = next;
		}

		slow.next = prev; // point reversed linkedList head to left side

		// Step 3 : check left and right portion from middle for palindrome
		Node n1 = head;
		Node n2 = slow.next;
		while (n2 != null) {
			if (n1.data != n2.data)
				return false;
			n1 = n1.next;
			n2 = n2.next;
		}

		return true;
	}

	public static void main(String[] args) {

		LL_13_02_CheckPalindrome_O1 lList = new LL_13_02_CheckPalindrome_O1();
		lList.push('a');
		lList.push('b');
		lList.push('1');
		// alList.push('1');
		lList.push('b');
		lList.push('a');

		System.out.println(lList.isPalindrome());

	}

}

//TC : O(N/2) for traversing first half + O(N/2) for reversing second half + O(N/2) again traversing first and second half simultaneously
//SC : O(1)