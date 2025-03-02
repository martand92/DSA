package DSA.Bucket3._07_tree._02_binarySearchTree;

public class _07_BST_DeleteNode {

	Node root;

	static class Node {
		int key;
		Node left, right;

		Node(int d) {
			key = d;
			left = right = null;
		}
	}

	public void insert(int key) {
		root = insert(root, key);
	}

	public Node insert(Node root, int key) {

		if (root == null) {
			root = new Node(key);
			return root;
		}

		else if (key < root.key)
			root.left = insert(root.left, key);

		else if (key > root.key)
			root.right = insert(root.right, key);

		return root;
	}

	public void inorder(Node root) {
		if (root == null)
			return;

		inorder(root.left);
		System.out.println(root.key);
		inorder(root.right);

		return;
	}

	public int findMinInRightSubTree(Node root) {
		if (root.left == null)
			return root.key;

		return findMinInRightSubTree(root.left);
	}

	public Node delete(Node root, int data) {

		if (root == null)
			return root;

		else if (data < root.key) {
			root.left = delete(root.left, data);

		} else if (data > root.key)
			root.right = delete(root.right, data);

		else {

			if (root.left == null)
				return root.right;

			else if (root.right == null)
				return root.left;

			else {
				root.key = findMinInRightSubTree(root.right);
				root.right = delete(root.right, root.key);
			}
		}

		return root;

	}

	public static void main(String[] args) {

		_07_BST_DeleteNode tree = new _07_BST_DeleteNode();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.inorder(tree.root);

		tree.delete(tree.root, 30);

		tree.inorder(tree.root);
	}

}
