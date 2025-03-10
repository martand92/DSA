package DSA.Bucket4._04_linkedlist._01_singlyLinkedList.important;

import java.util.Stack;

public class LL_13_01_CheckPalindrome_Stack {
	static Node head;

	static class Node {
		char data;
		Node next;

		Node(char d) {
			data = d;
			next = null;
		}
	}

	public void push(char data) {
		Node n = new Node(data);
		n.next = head;
		head = n;
	}

	public static void main(String[] args) {

		LL_13_01_CheckPalindrome_Stack lList = new LL_13_01_CheckPalindrome_Stack();
		lList.push('a');
		lList.push('b');
		lList.push('1');
		lList.push('b');
		lList.push('a');

		Stack<Character> st = new Stack<Character>();
		Node n = lList.head;
		while (n != null) {
			st.push(n.data);
			n = n.next;
		}

		n = lList.head;
		while (n != null) {
			if (st.pop() != n.data) {
				System.out.println("Not Palindrome");
				return;
			}
			n = n.next;
		}
		System.out.println("Palindrome");

	}
}

//TC : O(N) + O(N). First for adding all elements to stack and next for checking if its palindrome
//SC : O(N) for stack 