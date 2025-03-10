package DSA.Bucket4._04_linkedlist._01_singlyLinkedList.important;

//https://practice.geeksforgeeks.org/problems/arrange-consonants-and-vowels/1
public class LL_33_ArrangeConstantsVowels {

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
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public void printList(Node head) {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

	public Node arrangeVowel() {
		Node n = head;
		Node vowelHead = null;
		Node prev = null;

		while (n != null) {

			if (n.data == 'a' || n.data == 'e' || n.data == 'i' || n.data == 'o' || n.data == 'u') {

				if (prev != null) {
					prev.next = n.next;

					if (vowelHead == null) {
						n.next = head;
						head = n;
					} else {
						n.next = vowelHead.next;
						vowelHead.next = n;
					}
					vowelHead = n;
					n = prev;

				} else {
					vowelHead = n;
				}

			} else
				prev = n;

			n = n.next;
		}

		return head;

	}

	public static void main(String[] args) {

		LL_33_ArrangeConstantsVowels lList = new LL_33_ArrangeConstantsVowels();

//		lList.push('m');
//		lList.push('i');
//		lList.push('h');
//		lList.push('g');
//		lList.push('e');
//		lList.push('a');

//		lList.push('u');
//		lList.push('o');
//		lList.push('i');
//		lList.push('e');
//		lList.push('a');

		lList.push('i');
		lList.push('h');
		lList.push('g');
		lList.push('f');
		lList.push('e');
		lList.push('d');
		lList.push('c');
		lList.push('b');
		lList.push('a');
		lList.printList(head);

//		
//		lList.push('m');
//		lList.push('h');
//		lList.push('g');

//		lList.push('m');
//		lList.push('e');
//		lList.push('a');
//		lList.push('h');
//		lList.push('g');

		head = lList.arrangeVowel();
		System.out.println();

		lList.printList(head);
	}

}
