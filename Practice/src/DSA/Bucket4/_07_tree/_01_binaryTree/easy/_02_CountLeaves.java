package DSA.Bucket4._07_tree._01_binaryTree.easy;

/* For below tree, count leaves (OP: 2)
  	  1    
	/   \
   2     3  
  /   
 4                                     */

public class _02_CountLeaves {
	Node root;

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	public int countLeaves(Node root) {

		if (root == null)
			return 0;

		if (root.left == null && root.right == null)
			return 1;

		return countLeaves(root.left) + countLeaves(root.right);
	}

	public static void main(String[] args) {

		_02_CountLeaves tree = new _02_CountLeaves();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);

		System.out.println(tree.countLeaves(tree.root));

	}
}
