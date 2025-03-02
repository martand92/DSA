package DSA.Bucket3._07_tree._02_binarySearchTree;

//https://www.youtube.com/watch?v=otiDcwZbCo4
public class _08_AVL_Insert {

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

	public void inorder() {
		inorder(root);
	}

	public void inorder(Node root) {
		if (root == null)
			return;

		inorder(root.left);
		System.out.print(root.key + " ");
		inorder(root.right);
	}

	public int findHeight(Node root) {
		return findHeight(root, -1, -1); // initializing currHeight = -1, maxHeight = -1
	}

	// Overloaded method
	public int findHeight(Node root, int currHeight, int maxHeight) {

		if (root == null) {
			if (maxHeight < currHeight)
				maxHeight = currHeight;

			return maxHeight;
		}

		currHeight++;
		maxHeight = findHeight(root.left, currHeight, maxHeight);// assigning to maxHeight is imp
		maxHeight = findHeight(root.right, currHeight, maxHeight);
		currHeight--;
		return maxHeight;
	}

	// AVL INSERTION
	void avlInsert(int key) {
		root = avlInsert(root, key);
	}

	// Overloaded method
	public Node avlInsert(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			return root;

		} else if (key < root.key)
			root.left = avlInsert(root.left, key);

		else if (key > root.key)
			root.right = avlInsert(root.right, key);
		else {// When key already present in tree
			System.out.println("No Duplicate values");
			return root;
		}

		//System.out.print(root.key);

		// Once new node is added with key, all its parent node's bf should be
		// calculated till root node
		int bf = getBalanceFactor(root); // (height of Left Sub Tree) - (height of Right Sub Tree)

		// Check if parent of currently added new node has bf > 1(left imbalance) or bf
		// < 1 (right imbalance)

		// if bf > 1(then its left imbalance), then next check if its left-left
		// imbalance by checking if new node continue to align to left

		// if bf < 1(then its right imbalance), then next check if its right-right
		// imbalance by checking if new node continue to align to right

		// if bf > 1(left imbalance), then next check if its left-right imbalance by
		// checking if new node aligns to right

		// if bf < 1(right imbalance), then next check if its right-left imbalance by
		// checking if new node aligns to left

		// If tree becomes Left-Left Imbalance once new Node gets added, do right
		// rotation
		if (bf > 1 && key < root.left.key)
			return rightRotate(root);

		// If tree becomes Right-Right Imbalance once new Node gets added, do left
		// rotation
		if (bf < -1 && key > root.right.key)
			return leftRotate(root);

		// If tree becomes Left - Right Imbalance once new Node gets added, do
		// left-right rotation
		if (bf > 1 && key > root.left.key) {
			root.left = leftRotate(root.left);// after rotating left, you have to assign new root to initially
												// unbalanced root.left
			return rightRotate(root);
		}

		// If tree becomes Right - Left Imbalance once new Node gets added, do
		// right-left rotation
		if (bf < -1 && key < root.right.key) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}

		// If none of the above if conditions are executed, then continue to check bf of
		// all previous nodes
		return root;
	}

	public int getBalanceFactor(Node root) {
		if (root == null)
			return -1;
		return findHeight(root.left) - findHeight(root.right);
	}

	public Node leftRotate(Node root) {
		Node newRoot = root.right;
		Node temp = newRoot.left;

		newRoot.left = root;
		root.right = temp;
		return newRoot;
	}

	public Node rightRotate(Node root) {
		Node newRoot = root.left;
		Node temp = newRoot.right;

		newRoot.right = root;
		root.left = temp;
		return newRoot;
	}

	public static void main(String[] args) {
		_08_AVL_Insert tree = new _08_AVL_Insert();
		tree.avlInsert(55);
		tree.avlInsert(66);
		tree.avlInsert(77);
		tree.avlInsert(15);
		tree.avlInsert(11);
		tree.avlInsert(33);
		tree.avlInsert(22);
		tree.avlInsert(35);
		tree.avlInsert(25);
		tree.avlInsert(44);
		tree.avlInsert(88);

		tree.inorder();
	}

}
