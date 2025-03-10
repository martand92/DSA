package DSA.Bucket4._07_tree._01_binaryTree.medium;

import java.util.*;

//https://www.youtube.com/watch?v=i9ORlEy6EsI
//main issue here is in tree we can't go back, so first store parent of a node to find nodes in all directions at distance k 
public class _09_01_PrintAllNodesAtDistanceK {

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

	static class NodeDist {
		Node node;
		int dist;

		NodeDist(Node node, int dist) {
			this.node = node;
			this.dist = dist;
		}
	}

	public void insert() {
		root = new Node(3);
		root.left = new Node(5);
		root.right = new Node(1);
		root.left.left = new Node(6);
		root.left.right = new Node(2);
		root.left.right.left = new Node(7);
		root.left.right.right = new Node(4);
		root.right.left = new Node(0);
		root.right.right = new Node(8);
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

	public List<Integer> printAllNodesAtDistanceK(Node node, int target, int k) {

		// find target node from which all other nodes should be found at distance k
		Node targetNode = findTargetNode(node, target, null);

		// store all the nodes and its parents
		HashMap<Node, Node> parentMap = new HashMap<Node, Node>();// current node - its parent node
		parentMap = storeAllNodesParent(node, parentMap);
//		for (Map.Entry<Node, Node> e : parentMap.entrySet())
//			System.out.println("current:" + e.getKey().data + " parent:" + e.getValue().data);

		// now from target node, queue up left, right and its parent nodes and reduce
		// distance(k) by 1. Repeat above step for all the q elements till distance(k)
		// is reduced to 0.

		// should also hold visited list to not consider node whose distance is
		// previously calculated
		HashMap<Node, Boolean> visitedMap = new HashMap<Node, Boolean>();
		visitedMap = visitedMap(node, visitedMap);
//		for (Map.Entry<Node, Boolean> e : visitedMap.entrySet())
//			System.out.println("Node:" + e.getKey().data + " isVisited:" + e.getValue());

		Queue<NodeDist> nodeDist = new LinkedList<NodeDist>();
		nodeDist.add(new NodeDist(targetNode, k));// current node is at original distance k
		ArrayList<Integer> list = new ArrayList<Integer>();

		while (!nodeDist.isEmpty()) {

			// start finding all neighboring nodes of current node
			NodeDist currentNodeDist = nodeDist.poll();
			Node currentNode = currentNodeDist.node;

			// marking current node as visited as it shouldn't be considered as neighbor if
			// its distance is already calculated
			visitedMap.put(currentNode, true);

			if (currentNodeDist.dist == 0)
				list.add(currentNodeDist.node.data);

			else {
				if (currentNode.left != null && !visitedMap.get(currentNode.left))
					nodeDist.add(new NodeDist(currentNode.left, currentNodeDist.dist - 1));

				if (currentNode.right != null && !visitedMap.get(currentNode.right))
					nodeDist.add(new NodeDist(currentNode.right, currentNodeDist.dist - 1));

				Node parentNode = parentMap.get(currentNode);
				if (parentNode != null && !visitedMap.get(parentNode))
					nodeDist.add(new NodeDist(parentNode, currentNodeDist.dist - 1));
			}

		}

		return list;
	}

	public static void main(String[] args) {
		_09_01_PrintAllNodesAtDistanceK tree = new _09_01_PrintAllNodesAtDistanceK();
//		tree.insert(50);
//		tree.insert(30);
//		tree.insert(20);
//		tree.insert(40);
//		tree.insert(70);
//		tree.insert(60);
//		tree.insert(80);
		tree.insert();
		System.out.println(tree.printAllNodesAtDistanceK(tree.root, 5, 2));
	}
}
