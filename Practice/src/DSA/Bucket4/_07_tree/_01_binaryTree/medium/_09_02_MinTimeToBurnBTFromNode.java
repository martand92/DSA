package DSA.Bucket4._07_tree._01_binaryTree.medium;

import java.util.*;

//https://www.youtube.com/watch?v=2r5wLmQfD6g 
public class _09_02_MinTimeToBurnBTFromNode {

	Node root;

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = null;
			right = null;
		}
	}

	static class NodeTime {
		Node node;
		int time;

		NodeTime(Node node, int time) {
			this.node = node;
			this.time = time;
		}
	}

	public void insert() {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.left.right = new Node(7);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
	}

	public Node findTargetNode(Node node, int target, Node targetNode) {

		if (targetNode != null)
			return targetNode;

		if (node == null)
			return null;

		if (node.data == target)
			return node;

		targetNode = findTargetNode(node.left, target, targetNode);
		targetNode = findTargetNode(node.right, target, targetNode);

		return targetNode;
	}

	public HashMap<Node, Node> storeAllNodesParent(Node node, HashMap<Node, Node> parentMap) {

		if (node == null)
			return parentMap;

		// for both left and right children we are marking current node as parent
		if (node.left != null)
			parentMap.put(node.left, node);

		if (node.right != null)
			parentMap.put(node.right, node);

		parentMap = storeAllNodesParent(node.left, parentMap);
		parentMap = storeAllNodesParent(node.right, parentMap);
		return parentMap;
	}

	public HashMap<Node, Boolean> visitedMap(Node node, HashMap<Node, Boolean> visitedMap) {

		if (node == null)
			return visitedMap;

		visitedMap.put(node, false);
		visitedMap = visitedMap(node.left, visitedMap);
		visitedMap = visitedMap(node.right, visitedMap);

		return visitedMap;
	}

	public int minTimeToBurn(Node node, int givenNodeData) {

		Node targetNode = findTargetNode(node, givenNodeData, null);

		// store all the nodes and its parents
		HashMap<Node, Node> parentMap = new HashMap<Node, Node>();// current node > its parent node
		parentMap = storeAllNodesParent(node, parentMap);

		// now from target node, queue up left, right and its parent nodes (neighbors)
		// with unit time +1

		// should also hold visited list to not consider node whose time unit is already
		// calculated
		HashMap<Node, Boolean> visitedMap = new HashMap<Node, Boolean>();
		visitedMap = visitedMap(node, visitedMap);

		Queue<NodeTime> nodeTime = new LinkedList<NodeTime>();
		nodeTime.add(new NodeTime(targetNode, 0));// current node is at distance k
		int maxTime = 0;

		while (!nodeTime.isEmpty()) {

			// start finding all neighboring nodes of current node
			NodeTime currentNodeTime = nodeTime.poll();
			Node currentNode = currentNodeTime.node;
			maxTime = Math.max(maxTime, currentNodeTime.time);

			// marking current node as visited as it shouldn't be considered as neighbor if
			// its distance is already calculated
			visitedMap.put(currentNode, true);

			if (currentNode.left != null && !visitedMap.get(currentNode.left))
				nodeTime.add(new NodeTime(currentNode.left, currentNodeTime.time + 1));

			if (currentNode.right != null && !visitedMap.get(currentNode.right))
				nodeTime.add(new NodeTime(currentNode.right, currentNodeTime.time + 1));

			Node parentNode = parentMap.get(currentNode);
			if (parentNode != null && !visitedMap.get(parentNode))
				nodeTime.add(new NodeTime(parentNode, currentNodeTime.time + 1));
		}

		return maxTime;
	}

	public static void main(String[] args) {
		_09_02_MinTimeToBurnBTFromNode tree = new _09_02_MinTimeToBurnBTFromNode();
//		tree.insert(50);
//		tree.insert(30);
//		tree.insert(20);
//		tree.insert(40);
//		tree.insert(70);
//		tree.insert(60);
//		tree.insert(80);
		tree.insert();
		System.out.println(tree.minTimeToBurn(tree.root, 2));
	}
}
