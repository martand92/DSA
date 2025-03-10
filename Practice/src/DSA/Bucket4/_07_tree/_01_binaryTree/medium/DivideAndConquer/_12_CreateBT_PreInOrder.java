package DSA.Bucket4._07_tree._01_binaryTree.medium.DivideAndConquer;

//https://www.youtube.com/watch?v=aZNaLrVebKQ
public class _12_CreateBT_PreInOrder {

	static class Node {

		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public void printList(Node node) {
		if (node == null)
			return;

		printList(node.left);
		System.out.print(node.data + " ");
		printList(node.right);
	}

	public Node constructBT(int[] inorder, int[] preorder, int preorderIndex) {

		if (inorder.length == 0)
			return null;

		if (inorder.length == 1)
			return new Node(preorder[0]);

		// need to find index of root to be in inorder as preorder start element = root
		int rootIndex = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == preorder[preorderIndex]) {
				rootIndex = i;
				break;
			}

		}

		// recurse left by dividing inorder further by root element and then right
		int[] inOrderLeft = new int[rootIndex];
		int[] inOrderRight = new int[inorder.length - rootIndex - 1];

		// fill inorder left and right
		for (int i = 0; i < inOrderLeft.length; i++)
			inOrderLeft[i] = inorder[i];

		for (int i = 0; i < inOrderRight.length; i++)
			inOrderRight[i] = inorder[rootIndex + 1 + i];

		int[] preOrderLeft = new int[rootIndex];
		int[] preOrderRight = new int[preorder.length - rootIndex - 1];

		// fill preorder left and right
		for (int i = 0; i < preOrderLeft.length; i++)
			preOrderLeft[i] = preorder[preorderIndex + 1 + i];

		for (int i = 0; i < preOrderRight.length; i++)
			preOrderRight[i] = preorder[rootIndex + 1 + i];

		Node root = new Node(inorder[rootIndex]);

		root.left = constructBT(inOrderLeft, preOrderLeft, preorderIndex);
		root.right = constructBT(inOrderRight, preOrderRight, preorderIndex);

		return root;
	}

	public static void main(String[] args) {

		_12_CreateBT_PreInOrder tree = new _12_CreateBT_PreInOrder();

		int[] inorder = { 40, 20, 50, 10, 60, 30 };
		int[] preorder = { 10, 20, 40, 50, 30, 60 };

		Node root = tree.constructBT(inorder, preorder, 0);
		tree.printList(root);
	}

}
