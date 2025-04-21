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
	// through root

	// bruteforce:find height of leftsubtree and height of rightsubtree & find max.
	// O(N^2)

	// Optimal : Instead of finding height of left & right subtrees separately,
	// first find height of a node from bottom-up and while finding height as it
	// calculates height of left & right subtrees take sum of them and store max of
	// it in global var : O(N)

	public int findDiameter(Node node, int height) {

		if (node == null)
			return 0;

		int left = findDiameter(node.left, height);
		int right = findDiameter(node.right, height);

		max = Math.max(max, left + right);
		return 1 + Math.max(left, right);
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

		tree.findDiameter(tree.root, 0);
		System.out.println(tree.max);
	}

}
