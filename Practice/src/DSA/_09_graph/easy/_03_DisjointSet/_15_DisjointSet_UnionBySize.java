package DSA._09_graph.easy._03_DisjointSet;

public class _15_DisjointSet_UnionBySize {

	int[] size;
	int[] parent;

	_15_DisjointSet_UnionBySize(int v) {

		size = new int[v + 1];// 1 based indexing
		parent = new int[v + 1]; // 1 based indexing

		for (int i = 1; i <= v; i++) {
			parent[i] = i;
			size[i] = 1;
		}
	}

	public int findUltimateParent(int node) {

		if (node == parent[node])
			return parent[node]; // when parent = current node,then this node is ultimate parent

		return parent[node] = findUltimateParent(parent[node]);// path compression
		//return parent[node];
	}

	public void findUnionBySize(int u, int v) { // Here you need to update ultimate parent and size of 2 nodes being
												// connected as we go by

		int ultimateParentOfU = findUltimateParent(u);// When node u -> v, find ultimate parent of u & v.
		int ultimateParentOfV = findUltimateParent(v);

		if (ultimateParentOfU == ultimateParentOfV) // If ultimate parents are same then both u & v are from same
													// component so no need to do anything
			return;

		// if ultimate parents are not same then attach node with lower size to node
		// with higher size & size of ultimate parent is increased
		if (size[ultimateParentOfU] < size[ultimateParentOfV]) {
			parent[ultimateParentOfU] = ultimateParentOfV;
			size[ultimateParentOfV] += size[ultimateParentOfU];
		}

		else if (size[ultimateParentOfU] > size[ultimateParentOfV]) {
			parent[ultimateParentOfV] = ultimateParentOfU;
			size[ultimateParentOfU] += size[ultimateParentOfV];
		}

		else {// if both node's sizes are same, then attach any node to any other node and
				// increase size of parent. This else and above else if can be merged
			parent[ultimateParentOfV] = ultimateParentOfU;
			size[ultimateParentOfU] += size[ultimateParentOfV];
		}
	}

	public static void main(String[] args) {

		_15_DisjointSet_UnionBySize disJointSet = new _15_DisjointSet_UnionBySize(7);

		disJointSet.findUnionBySize(1, 2);
		disJointSet.findUnionBySize(2, 3);
		disJointSet.findUnionBySize(4, 5);
		disJointSet.findUnionBySize(6, 7);
		disJointSet.findUnionBySize(5, 6);

		// Check if 1, 7 belong to same component / have same ultimate parent
		if (disJointSet.findUltimateParent(1) == disJointSet.findUltimateParent(7))
			System.out.println("Same component");
		else
			System.out.println("Not Same component");

		// Now connect 3 and 7, this will make ultimate parent of 1 and 7 to be 4
		disJointSet.findUnionBySize(3, 7);

		// Check if 1, 7 belong to same component / have same ultimate parent
		if (disJointSet.findUltimateParent(1) == disJointSet.findUltimateParent(7))
			System.out.println("Same component");
		else
			System.out.println("Not Same component");

	}

}
