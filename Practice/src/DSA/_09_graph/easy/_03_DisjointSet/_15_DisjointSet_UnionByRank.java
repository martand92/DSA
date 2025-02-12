package DSA._09_graph.easy._03_DisjointSet;

public class _15_DisjointSet_UnionByRank {

	int[] rank;
	int[] parent;

	_15_DisjointSet_UnionByRank(int v) {

		rank = new int[v + 1];// 1 based indexing
		parent = new int[v + 1]; // 1 based indexing

		for (int i = 1; i <= v; i++)
			parent[i] = i;
	}

	public int findUltimateParent(int node) {

		if (node == parent[node])
			return node; // when parent = current node,then this node is ultimate parent

		parent[node] = findUltimateParent(parent[node]);// path compression
		return parent[node];
	}

	public void unionByRank(int u, int v) {

		int ultimateParentOfU = findUltimateParent(u);
		int ultimateParentOfV = findUltimateParent(v);

		// If ult parents are same then u,v are from same component, so union is not
		// required as they belong to same set / component
		if (ultimateParentOfU == ultimateParentOfV)
			return;

		// if ultimate parents are not same then attach node with lower rank to node
		// with higher rank. Here rank of ultimate parent doesnt change
		if (rank[ultimateParentOfU] < rank[ultimateParentOfV])
			parent[ultimateParentOfU] = ultimateParentOfV;

		else if (rank[ultimateParentOfU] > rank[ultimateParentOfV])
			parent[ultimateParentOfV] = ultimateParentOfU;

		else {// if both node's ranks are same, then attach any 1 node to another resulting in
				// addition of a node to component and increasing parent's rank
			parent[ultimateParentOfV] = ultimateParentOfU;
			rank[ultimateParentOfU]++;
		}
	}

	public static void main(String[] args) {

		_15_DisjointSet_UnionByRank disJointSet = new _15_DisjointSet_UnionByRank(7);

		disJointSet.unionByRank(1, 2);
		disJointSet.unionByRank(2, 3);
		disJointSet.unionByRank(4, 5);
		disJointSet.unionByRank(6, 7);
		disJointSet.unionByRank(5, 6);

		// Check if 1, 7 belong to same component / have same ultimate parent
		if (disJointSet.findUltimateParent(1) == disJointSet.findUltimateParent(7))
			System.out.println("Same component");
		else
			System.out.println("Not Same component");

		// Now connect 3 and 7, this will make ultimate parent of 1 and 7 to be 4
		disJointSet.unionByRank(3, 7);

		// Check if 1, 7 belong to same component / have same ultimate parent
		if (disJointSet.findUltimateParent(1) == disJointSet.findUltimateParent(7))
			System.out.println("Same component");
		else
			System.out.println("Not Same component");

	}

}
