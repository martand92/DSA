package DSA._07_tree._01_binaryTree;

//https://practice.geeksforgeeks.org/problems/leaf-at-same-level/1
public class _08_LeafNodesAtSameLevel {

	Node root;
	int height = Integer.MIN_VALUE, currHeight = -1;
	boolean isLevel = true;

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

	public boolean findHeight(Node node) {

		if (!isLevel)
			return isLevel;

		if (node == null)
			return isLevel;
		
		//Nodes where both left & right children are null are leaf nodes and verify if these are at same level
		if (node.left == null && node.right == null) {

			if (height == Integer.MIN_VALUE)
				height = currHeight;

			else if (height != currHeight)
				return false;

			return isLevel;

		}

		currHeight++;
		isLevel = findHeight(node.left);
		isLevel = findHeight(node.right);
		currHeight--;

		return isLevel;
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

		System.out.println(tree.findHeight(tree.root));

	}
}
