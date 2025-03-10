package DSA.Bucket4._07_tree._02_binarySearchTree.traversal;

public class _05_BST_LevelOrder_BFS {

	Node root;
	int leftHeight = 0, currHeight = -1, maxHeight = -1;

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

	// Overloaded method
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

	public int findHeight() {
		return findHeight(root);
	}

	// Overloaded method
	public int findHeight(Node root) {

		if (root == null) {

			if (maxHeight < currHeight)
				maxHeight = currHeight;

			return maxHeight;
		}

		currHeight++;
		findHeight(root.left);
		findHeight(root.right);
		currHeight--;
		return maxHeight;
	}

	public void levelOrderTraversal() {
		int h = findHeight();

		for (int i = 0; i <= h; i++)
			printGivenLevelNodeEle(root, i);

	}

	public void printGivenLevelNodeEle(Node root, int level) {
		
		if(root == null)
			return;

		if (level == 0) {
			System.out.print(root.key + " ");
			return;
		}

		printGivenLevelNodeEle(root.left, level - 1);
		printGivenLevelNodeEle(root.right, level - 1);
	}

	public static void main(String[] args) {
		_05_BST_LevelOrder_BFS tree = new _05_BST_LevelOrder_BFS();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.levelOrderTraversal();
	}

}
