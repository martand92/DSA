package DSA.Bucket4._07_tree._01_binaryTree.easy;

//https://practice.geeksforgeeks.org/problems/leaf-at-same-level/1
public class _08_LeafNodesAtSameLevel {

	Node root;
	int height = -1;

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
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

	public boolean findHeight(Node node, int currHeight) {

		if (node == null)
			return true;

		if (node.left == null && node.right == null) {

			// store first leaf height
			if (height == -1)
				height = currHeight;

			else if (height != currHeight)
				return false;
		}

		return findHeight(node.left, currHeight + 1) && findHeight(node.right, currHeight + 1);
	}

	public static void main(String[] args) {

		_08_LeafNodesAtSameLevel tree = new _08_LeafNodesAtSameLevel();

		tree.insert(50);
		tree.insert(30);
		// tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		System.out.println(tree.findHeight(tree.root, 0));

	}

}
