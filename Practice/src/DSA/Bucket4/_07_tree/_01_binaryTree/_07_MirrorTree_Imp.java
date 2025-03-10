package DSA.Bucket4._07_tree._01_binaryTree;

//https://practice.geeksforgeeks.org/problems/mirror-tree/1
public class _07_MirrorTree_Imp {

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

	// Mirror original tree
	void mirror(Node root) {
		if (root == null)
			return;

		Node temp = root.left;
		root.left = root.right;
		root.right = temp;

		mirror(root.left);
		mirror(root.right);
	}

	void inorder(Node root) {

		if (root == null)
			return;

		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);

		return;
	}

	public static void main(String[] args) {
		_07_MirrorTree_Imp tree = new _07_MirrorTree_Imp();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.inorder(tree.root);

		tree.mirror(tree.root);
		
		System.out.println();
		tree.inorder(tree.root);
	}
}
