package DSA.Bucket4._04_linkedlist._01_singlyLinkedList.important;

//https://practice.geeksforgeeks.org/problems/arrange-consonants-and-vowels/1
public class LL_33_ArrangeConsonantsAndVowels {

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

		System.out.println();
	}

	public Node arrangeVowel() {
		Node n = head;
		Node vowelHead = null, consonantHead = null, vowelPtr = null, consonantPtr = null;

		while (n != null) {

			if (n.data == 'a' || n.data == 'e' || n.data == 'i' || n.data == 'o' || n.data == 'u') {

				if (vowelHead == null)
					vowelHead = n;
				else
					vowelPtr.next = n;

				vowelPtr = n;

			} else {

				if (consonantHead == null)
					consonantHead = n;
				else
					consonantPtr.next = n;

				consonantPtr = n;

			}

			n = n.next;
		}

		// Making sure no unnecessary tail exist
		vowelPtr.next = null;
		consonantPtr.next = null;

		vowelPtr.next = consonantHead;
		return vowelHead;

	}

	public static void main(String[] args) {

		LL_33_ArrangeConsonantsAndVowels lList = new LL_33_ArrangeConsonantsAndVowels();

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
		lList.printList(head);

	}

}
