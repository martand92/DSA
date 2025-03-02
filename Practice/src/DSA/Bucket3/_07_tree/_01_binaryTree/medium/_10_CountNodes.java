package DSA.Bucket3._07_tree._01_binaryTree.medium;

//https://www.youtube.com/watch?v=u-yWemKGWO0
public class _10_CountNodes {

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
		root = new Node(1);

		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);

		root.left.right.left = new Node(10);
		root.left.right.right = new Node(11);

		root.right.left = new Node(6);
		root.right.right = new Node(7);
	}

	// here left height is found by traversing only left children. Its not same as
	// finding height of tree where max of left and right subtrees are considered
	public int findLeftHeight(Node node) {
		if (node == null)
			return 0;

		return findLeftHeight(node.left) + 1;
	}

	public int findRightHeight(Node node) {
		if (node == null)
			return 0;

		return findRightHeight(node.right) + 1;
	}

	public int countNodes(Node node) {

		int lh = findLeftHeight(node.left);
		int rh = findRightHeight(node.right);

		if (lh == rh)
			return (2 << lh) - 1; // 2^n - 1
		else
			return 1 + countNodes(node.left) + countNodes(node.right);
	}

	public static void main(String[] args) {
		_10_CountNodes tree = new _10_CountNodes();
//		tree.insert(50);
//		tree.insert(30);
//		tree.insert(20);
//		tree.insert(40);
//		tree.insert(70);
//		tree.insert(60);
//		tree.insert(80);
		tree.insert();
		System.out.println(tree.countNodes(tree.root));
	}
}
