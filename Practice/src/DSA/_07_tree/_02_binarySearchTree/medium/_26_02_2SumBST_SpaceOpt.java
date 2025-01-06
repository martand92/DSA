package DSA._07_tree._02_binarySearchTree.medium;

//https://www.youtube.com/watch?v=ssL3sHwPeb4
import java.util.*;

//Here solution will continue to use 2 pointers on each end of sorted elements and move 1 step based on condition
// but instead of storing elements in new DS, we use BST iterator to move next() or before() from iterator

//This will reduce SC to O(H) for iterator. TC will remain O(N) as all nodes need to be traversed in worst case
public class _26_02_2SumBST_SpaceOpt {

	Node root;
	Node l;
	Node r;
	Stack<Node> stNext = new Stack<Node>();
	Stack<Node> stBefore = new Stack<Node>();

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = null;
			right = null;
		}
	}

	public void insert(int data) {
		root = insert(root, data);
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

	public void nextInitialization(Node root) {
		while (root != null) {
			stNext.add(root);
			root = root.left;
		}
	}

	public void beforeInitialization(Node root) {
		while (root != null) {
			stBefore.add(root);
			root = root.right;
		}
	}

	public int next() {
		Node a = stNext.pop();
		Node right = a.right;
		Node left = null;

		if (right != null) {
			stNext.add(right);
			left = right.left;
		}

		while (left != null) {
			stNext.add(left);
			left = left.left;
		}
		return a.data;
	}

	public boolean hasNext() {
		return !stNext.isEmpty();
	}

	public int before() {
		Node a = stBefore.pop();
		Node left = a.left;
		Node right = null;

		if (left != null) {
			stBefore.add(left);
			right = left.right;
		}

		while (right != null) {
			stBefore.add(right);
			right = right.right;
		}
		return a.data;
	}

	public boolean hasBefore() {
		return !stBefore.isEmpty();
	}

	public boolean find2Sum(int target) {

		nextInitialization(root);
		beforeInitialization(root);

		int l = next(), r = before();

		while (l < r) {

			if ((l + r) < target)
				l = next();

			else if ((l + r) > target)
				r = before();

			else
				return true;
		}

		return false;
	}

	public static void main(String[] args) {

		_26_02_2SumBST_SpaceOpt tree = new _26_02_2SumBST_SpaceOpt();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		int target = 50;

		System.out.println(tree.find2Sum(target));
	}

}
