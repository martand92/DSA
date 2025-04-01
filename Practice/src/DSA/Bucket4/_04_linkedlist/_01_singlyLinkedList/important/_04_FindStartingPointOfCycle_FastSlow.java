package DSA.Bucket4._04_linkedlist._01_singlyLinkedList.important;

//https://youtu.be/2Kd0KKmmHFc?t=943
public class _04_FindStartingPointOfCycle_FastSlow {

	Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public void createCycle() {
		Node n = head;
		while (n.next != null) {
			n = n.next;
		}

		n.next = head;
	}

	public Node StartingPointOfCycle() {
		Node fast = head;
		Node slow = head;
		fast = fast.next.next;
		slow = slow.next;

		// Step1 : first detect for cycle. If present then first find node where fast
		// and slow pointer intersect. This intersection point need not be first node in
		// cycle

		// Step 2 : Have another pointer say entry pointing to head and start moving
		// both entry and slow pointer(from intersection point) by 1 till they meet at
		// starting node of cycle
		while (fast != null && fast.next != null) {

			if (fast == slow) {

				Node entry = head;

				while (entry != slow) {
					entry = entry.next;
					slow = slow.next;
				}

				return entry;
			}

			fast = fast.next.next;
			slow = slow.next;
		}
		return null;
	}

	public void addNode(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public static void main(String[] args) {
		_04_FindStartingPointOfCycle_FastSlow ll = new _04_FindStartingPointOfCycle_FastSlow();
		ll.addNode(5);
		ll.addNode(4);
		ll.addNode(3);
		ll.addNode(2);
		ll.addNode(1);

		ll.createCycle();

		Node ans = ll.StartingPointOfCycle();
		if (ans != null)
			System.out.println(ans.data);
		else
			System.out.println(ans);
	}

}
