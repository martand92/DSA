package DSA.Bucket4._09_graph.easy._03_DisjointSet;

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
	}

	public void unionBySize(int u, int v) {

		int ultimateParentOfU = findUltimateParent(u);
		int ultimateParentOfV = findUltimateParent(v);

		// If ultimate parents are same then both u & v are from same component
		if (ultimateParentOfU == ultimateParentOfV)
			return;

		// if ultimate parents are not same then attach lower size of ult parent node to
		// higher sized ult parent node & increase size of this ult parent node
		if (size[ultimateParentOfU] < size[ultimateParentOfV]) {
			parent[ultimateParentOfU] = ultimateParentOfV;
			size[ultimateParentOfV] += size[ultimateParentOfU];

		} else if (size[ultimateParentOfU] > size[ultimateParentOfV]) {
			parent[ultimateParentOfV] = ultimateParentOfU;
			size[ultimateParentOfU] += size[ultimateParentOfV];

		} else {// if both node's sizes are same, then attach any ult parent node to any other
				// ult parent node and increase size of parent
			parent[ultimateParentOfV] = ultimateParentOfU;
			size[ultimateParentOfU] += size[ultimateParentOfV];
		}
	}

	public static void main(String[] args) {

		_15_DisjointSet_UnionBySize disJointSet = new _15_DisjointSet_UnionBySize(7);

		disJointSet.unionBySize(1, 2);
		disJointSet.unionBySize(2, 3);
		disJointSet.unionBySize(4, 5);
		disJointSet.unionBySize(6, 7);
		disJointSet.unionBySize(5, 6);

		// Check if 1, 7 belong to same component / have same ultimate parent
		if (disJointSet.findUltimateParent(1) == disJointSet.findUltimateParent(7))
			System.out.println("Same component");
		else
			System.out.println("Not Same component");

		// Now connect 3 and 7, this will make ultimate parent of 1 and 7 to be 4
		disJointSet.unionBySize(3, 7);

		// Check if 1, 7 belong to same component / have same ultimate parent
		if (disJointSet.findUltimateParent(1) == disJointSet.findUltimateParent(7))
			System.out.println("Same component");
		else
			System.out.println("Not Same component");
	}
}