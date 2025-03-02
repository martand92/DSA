package DSA.Bucket3._04_linkedlist._01_singlyLinkedList.basic;

//deleting node will always (except deleting head) have an extra pointer prev 
public class LL_07_DeleteNodeContainingGivenData {
	Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void push(int d) {
		Node newNode = new Node(d);
		newNode.next = head;
		head = newNode;
	}

	public static void main(String[] args) {

		LL_07_DeleteNodeContainingGivenData linkedList = new LL_07_DeleteNodeContainingGivenData();

		linkedList.push(0);
		linkedList.push(1);
		linkedList.push(2);
		linkedList.push(3);
		linkedList.push(4);

		linkedList.deleteNode(0);
		Node n = linkedList.head;
		while (n != null) {
			System.out.println(n.data);
			n = n.next;
		}
	}

	void deleteNode(int data) {
		Node n = head;
        Node prev = n;

        while(n.data != data){
            prev = n;
            n = n.next;
        }

        if(n == head)
            head = n.next;
        else
            prev.next = n.next;

	}
}
