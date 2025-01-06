package DSA._07_tree._02_binarySearchTree;

//https://www.youtube.com/watch?v=3UivJWAFaI4&list=PLIY8eNdw5tW_zX3OCzX7NJ8bL1p6pWfgG&index=87
public class _10_RedBlack_Insert_Incomp {

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

	// ------- Utility functions Start----------------//
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
		maxHeight = findHeight(root.left, currHeight, maxHeight);
		maxHeight = findHeight(root.right, currHeight, maxHeight);
		currHeight--;
		return maxHeight;
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

	// ------- Utility functions End ----------------//
	//
	//
	//
	//
	//
	// ------- AVL INSERTION START ----------------//
	void avlInsert(int key) {
		root = avlInsert(root, key);
	}

	// Overloaded method
	public Node avlInsert(Node root, int key) {

		// Normal BST insertion
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

		// Below Addition steps to make BST as AVL

		// System.out.println(root.key);
		int bf = getBalanceFactor(root); // (height of Left Sub Tree) - (height of Right Sub Tree)

		// If tree becomes Left Imbalance once new Node gets added, do right rotation
		if (bf > 1 && key < root.left.key)
			return rightRotate(root);

		// If tree becomes Right Imbalance once new Node gets added, do left rotation
		if (bf < -1 && key > root.right.key)
			return leftRotate(root);

		// If tree becomes Left - Right Imbalance once new Node gets added, do
		// left-right rotation
		if (bf > 1 && key > root.left.key) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}

		// If tree becomes Right - Left Imbalance once new Node gets added, do
		// right-left rotation
		if (bf < -1 && key < root.right.key) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}

		// If none of the above if conditions for rotations are executed then it means
		// tree is already AVL

		return root;
	}

	// ------- AVL INSERTION END ----------------//
	//
	//
	//
	//
	// ------- AVL DELETION START -------------------//
	public void avlDelete(int key) {
		avlDelete(root, key);
	}

	public Node avlDelete(Node root, int key) {

		if (root == null)
			return root;

		if (key < root.key)
			avlDelete(root.left, key);
		else if (key > root.key)
			avlDelete(root.right, key);

		// Found key to be deleted
		else {
			Node temp;

			// Below 2 conditions are for no child or single child
			if (root.left == null) {
				temp = root.right;
				return temp;
			} else if (root.right == null) {
				temp = root.left;
				return temp;
			}

			// Below condition when node to be deleted is with 2 children
			else {
				temp = findMinRightSubTreeValue(root.right);
				root.key = temp.key;
				root.right = avlDelete(root.right, temp.key);
			}
		}

		int bf = getBalanceFactor(root); // (height of Left Sub Tree) - (height of Right Sub Tree)

		//Right Rotation to balance root node after deletion
		if (bf == 2 && getBalanceFactor(root.left) >= 0)
			return rightRotate(root);
		
		//Left-Right Rotation to balance root node after deletion
		else if (bf == 2 && getBalanceFactor(root.left) == -1) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		} 
		
		//Left Rotation to balance root node after deletion
		else if (bf == -2 && getBalanceFactor(root.right) <= 0)
			return leftRotate(root);
		
		//Right-Left Rotation to balance root node after deletion
		else if (bf == -2 && getBalanceFactor(root.right) == 1) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}

		return root;
	}

	public Node findMinRightSubTreeValue(Node node) {
		// TODO Auto-generated method stub
		if (node.left == null)
			return node;

		return findMinRightSubTreeValue(node.left);
	}

	// ------- AVL DELETION END -------------------//

	public static void main(String[] args) {
		_10_RedBlack_Insert_Incomp tree = new _10_RedBlack_Insert_Incomp();

		// First creating AVL tree
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

		// Printing AVL tree
		tree.inorder();

		tree.avlDelete(88);
		tree.avlDelete(22);
		tree.avlDelete(33);
		tree.avlDelete(11);

	}

}
