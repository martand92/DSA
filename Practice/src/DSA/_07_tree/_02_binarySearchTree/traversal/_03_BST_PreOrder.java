package DSA._07_tree._02_binarySearchTree.traversal;

public class _03_BST_PreOrder {

	Node root;

	static class Node {
		int key;
		Node left, right;

		Node(int d) {
			key = d;
			left = null;
			right = null;
		}
	}

	void insert(int key) {
		root = insert(root, key);
	}
	
	//Overloaded method
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
	
	
	public void preorder() {
		preorder(root);
	}
	
	//Overloaded method
	public void preorder(Node root) {
		
		if(root == null)
			return;
		
		System.out.print(root.key + " ");
		preorder(root.left);
		preorder(root.right);
		
	}

	public static void main(String[] args) {
		_03_BST_PreOrder tree = new _03_BST_PreOrder();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.preorder();
	}

}
