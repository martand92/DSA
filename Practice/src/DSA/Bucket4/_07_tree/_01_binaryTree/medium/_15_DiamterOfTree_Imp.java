package DSA.Bucket4._07_tree._01_binaryTree.medium;

public class _15_DiamterOfTree_Imp {

	Node root;
	int max = 0;

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = null;
			right = null;
		}
	}

	public void insert(int d) {
		root = insert(root, d);
	}

	public Node insert(Node root, int d) {

		if (root == null) {
			root = new Node(d);
			return root;
		}

		if (d < root.data)
			root.left = insert(root.left, d);

		else if (d > root.data)
			root.right = insert(root.right, d);

		return root;
	}

	// diameter : longest path between any 2 nodes in the tree which need not pass
	// through root. The length of a path between two nodes is represented by the
	// number of edges between them.

	// bruteforce:find height of leftsubtree and height of rightsubtree & find max.
	// O(N^2)

	public int findHeight(Node node) {

		if (node == null)
			return 0;

		return Math.max(findHeight(node.left) + 1, findHeight(node.right) + 1);
	}

	public int findDiameter_brute(Node node) {

		if (node == null)
			return 0;

		int diameterThroughRoot = findHeight(node.left) + findHeight(node.right);

		int diameterInLeftSubtree = findDiameter_brute(node.left);
		int diameterInRightSubtree = findDiameter_brute(node.right);
		return Math.max(diameterThroughRoot, Math.max(diameterInLeftSubtree, diameterInRightSubtree));
	}

	// Optimal : Instead of finding height of left & right subtrees separately,
	// first find height of a node from bottom-up and while finding height as it
	// calculates height of left & right subtrees take sum of them and store max of
	// it in global var : O(N)

	public int findDiameter(Node node) {

		if (node == null)
			return 0;

		int leftHeight = findDiameter(node.left);
		int rightHeight = findDiameter(node.right);

		// Update the diameter if the path through the current node is longer
		max = Math.max(max, leftHeight + rightHeight);

		// Return the height of the current subtree
		return 1 + Math.max(leftHeight, rightHeight);
	}

	public static void main(String[] args) {

		_15_DiamterOfTree_Imp tree = new _15_DiamterOfTree_Imp();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		System.out.println("Sum of edges between longest path = diameter : " + tree.findDiameter_brute(tree.root));

		tree.findDiameter(tree.root);
		System.out.println("Sum of edges between longest path = diameter : " + tree.max);

	}

}
