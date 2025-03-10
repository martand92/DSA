package DSA.Bucket4._07_tree._01_binaryTree.medium;

public class _21_MaxWidthBT_Incomp {

	Node root;

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = null;
			right = null;
		}
	}

	public void insert() {
		root = new Node(50);
		root.left = new Node(20);
		root.right = new Node(70);
		root.left.left = new Node(30);
		root.left.right = new Node(40);
		root.right.left = new Node(60);
		root.right.right = new Node(80);
	}

	public void maxWidth(Node node) {

	}

	public static void main(String[] args) {

		_21_MaxWidthBT_Incomp tree = new _21_MaxWidthBT_Incomp();
		tree.insert();
	}

}
