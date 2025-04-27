package DSA.Bucket4._07_tree._01_binaryTree.medium;

import java.util.ArrayList;

//https://www.youtube.com/watch?v=_-QHfMDde90

//this is different than lowest common ancestor in bst

// Bruteforce :
// Find ancestors of both numbers using algo and then check for its lowest common ancestor
// TC : O(2N) -> to find ancestor of both the nums. SC : O(2N) to find store ancestors of both nums

//Optimized:
//Start DFS from root and keep traversing, if you find null return null else if found num then return num

// if first num / second num is seen on 1 path, then it would be the num from this path. Now search for other num in 2nd path
// if another num is not seen on 2nd path then current obtained num will be the result as another num will be on same 1st path
// if another num is obtained on 2nd path then root that produces 2 paths (left & right) will be the result
public class _17_LowestCommonAncestor {

	Node root;
	ArrayList<Integer> al = new ArrayList<Integer>();
	boolean found = false;

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

	public Node lca(Node node, int n1, int n2) {

		if (node == null || node.data == n1 || node.data == n2)
			return node;

		Node left = lca(node.left, n1, n2);
		Node right = lca(node.right, n1, n2);

		if (left != null && right != null)
			return node;

		if (left != null && right == null)
			return left;

		else if (left == null && right != null)
			return right;

		else
			return null;
	}

	public static void main(String[] args) {

		_17_LowestCommonAncestor tree = new _17_LowestCommonAncestor();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		System.out.println(tree.lca(tree.root, 30, 20).data);

	}

}
