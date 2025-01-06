package DSA._07_tree._02_binarySearchTree;

//https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1
public class _13_LowestCommonAncestor_BST_Nice {

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

	// As its BST, check if given numbers lie on left or right side
	Node LCA(Node root, int n1, int n2) {
		// code here.
		if (root == null)
			return root;

		// While traversing if root.data = any of the value then return this root
		if (root.data == n1 || root.data == n2)
			return root;

		else if (root.data < n1 && root.data < n2)
			return LCA(root.right, n1, n2);

		else if (root.data > n1 && root.data > n2)
			return LCA(root.left, n1, n2);

		else // if n1 & n2 are found on left & right subtree of current node, then return
				// this node
			return root;
	}

	public static void main(String[] args) {
		_13_LowestCommonAncestor_BST_Nice tree = new _13_LowestCommonAncestor_BST_Nice();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		System.out.println(tree.LCA(tree.root, 20, 40).data);
	}
}
