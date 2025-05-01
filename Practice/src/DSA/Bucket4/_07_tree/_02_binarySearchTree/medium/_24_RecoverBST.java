package DSA.Bucket4._07_tree._02_binarySearchTree.medium;

//https://www.youtube.com/watch?v=ZWGW7FminDM
public class _24_RecoverBST {

	static Node root, prev, first, middle, second;

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = null;
			right = null;
		}
	}

	public static Node insert() {

		root = new Node(8);
		root.left = new Node(25);
		root.left.left = new Node(3);
		root.left.right = new Node(7);

		root.right = new Node(15);
		root.right.left = new Node(10);
		root.right.right = new Node(5);
		root.right.right.left = new Node(20);

		return root;
	}

	public static void print(Node node) {

		if (node == null)
			return;

		print(node.left);
		System.out.print(node.data + " ");
		print(node.right);
	}

	public static Node findSwappedNodes(Node node) {

		if (node == null)
			return null;

		findSwappedNodes(node.left);

		if (prev != null && node.data < prev.data && first == null) {
			first = prev;
			middle = node;
		}

		else if (prev != null && node.data < prev.data && first != null)
			second = node;

		prev = node;

		findSwappedNodes(node.right);

		return root;
	}

	public static Node recoverBST(Node node) {

		root = findSwappedNodes(node);

		if (second == null) {
			middle.data = middle.data ^ first.data;
			first.data = middle.data ^ first.data;
			middle.data = middle.data ^ first.data;
		} else {
			first.data = first.data ^ second.data;
			second.data = first.data ^ second.data;
			first.data = first.data ^ second.data;
		}

		return root;
	}

	public static void main(String[] args) {
		insert();
		print(root);
		recoverBST(root);
		print(root);
	}
}
