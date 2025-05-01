package DSA.Bucket4._07_tree._02_binarySearchTree.medium;

//https://youtu.be/X0oXMdtUDwo?list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&t=345
public class _25_02_LargestBST_ON {

	static Node root;
	static int maxBST;

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = null;
			right = null;
		}
	}

	static class Info {

		boolean isBST;
		int size, min, max;

		Info(boolean isBST, int size, int min, int max) {
			this.isBST = isBST;
			this.size = size;
			this.min = min;
			this.max = max;
		}
	}

	public static Node insert() {

		root = new Node(50);
		root.left = new Node(30);
		root.right = new Node(70);
		// root.right = new Node(20);
		root.left.left = new Node(20);
		root.left.right = new Node(40);
		root.right.left = new Node(60);
		root.right.right = new Node(80);

		return root;
	}

	/*
	 * Algo :
	 * 
	 * follow bottom-up approach : for a given node to be BST, both its LST & RST
	 * must be BST & current node.data > largest val of LST & < smallest val of RST.
	 * 
	 * And a null node is by default BST.
	 * 
	 * if current node is BST then cal its size based on LST size & RST size & check
	 * if its greater than current max size
	 * 
	 * If current node is BST then need to return this node with Info containing
	 * isBST & its minVal as min(LST min, its val) & its maxVal as max(RST max, its
	 * val) back to its parent
	 * 
	 * if current node is not BST then return Info containing isBST=false, size, min
	 * & max=0 as its not BST
	 * 
	 */

	public static Info largestBST(Node node) {

		if (node == null)
			return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);

		Info left = largestBST(node.left);
		Info right = largestBST(node.right);

		if (left.isBST && right.isBST && node.data > left.max && node.data < right.min) {

			int size = 1 + left.size + right.size;
			maxBST = Math.max(maxBST, size);

			return new Info(true, size, Math.min(node.data, left.min), Math.max(node.data, right.max));
		}

		return new Info(false, 0, 0, 0);

	}

	public static void main(String[] args) {

		insert();
		System.out.println(largestBST(root));
	}

}
