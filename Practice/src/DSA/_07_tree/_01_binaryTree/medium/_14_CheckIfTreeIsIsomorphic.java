package DSA._07_tree._01_binaryTree.medium;

//https://practice.geeksforgeeks.org/problems/check-if-tree-is-isomorphic/1
public class _14_CheckIfTreeIsIsomorphic {

	Node root1;
	Node root2;

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = null;
			right = null;
		}
	}

	public boolean isIsomorphic(Node root1, Node root2) {

		if (root1 == null && root2 == null)
			return true;

		if (root1 == null || root2 == null)
			return false;

		if (root1.data != root2.data)
			return false;

		return (isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right)
				|| isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left));

	}

	public static void main(String[] args) {
		_14_CheckIfTreeIsIsomorphic tree = new _14_CheckIfTreeIsIsomorphic();

		tree.root1 = new Node(1);
		tree.root1.left = new Node(2);
		tree.root1.right = new Node(3);
		tree.root1.left.left = new Node(4);
		tree.root1.left.right = new Node(5);
		tree.root1.left.right.left = new Node(7);
		tree.root1.left.right.right = new Node(8);

		tree.root2 = new Node(1);
		tree.root2.left = new Node(3);
		tree.root2.right = new Node(2);
		tree.root2.left.right = new Node(6);
		tree.root2.right.left = new Node(4);
		tree.root2.right.right = new Node(5);
		tree.root2.right.right.left = new Node(8);
		tree.root2.right.right.right = new Node(7);

		System.out.println(tree.isIsomorphic(tree.root1, tree.root2));

	}
}
