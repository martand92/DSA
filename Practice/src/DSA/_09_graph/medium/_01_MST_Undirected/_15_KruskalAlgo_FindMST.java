package DSA._09_graph.medium._01_MST_Undirected;

import java.util.*;
import java.util.Collections;
import java.util.Comparator;

public class _15_KruskalAlgo_FindMST {

	public static int findUltimateParent(int node, int[] parent) {
		if (node == parent[node])
			return parent[node];

		parent[node] = findUltimateParent(parent[node], parent);// path compression
		return parent[node];
	}

	public static void unionByRank(int u, int v, int[] parent, int[] rank, int ultParentOfU, int ultParentOfV) {

		if (rank[ultParentOfU] < rank[ultParentOfV])
			parent[ultParentOfU] = ultParentOfV;

		else if (rank[ultParentOfU] > rank[ultParentOfV])
			parent[ultParentOfV] = ultParentOfU;

		else {
			parent[ultParentOfV] = ultParentOfU;
			rank[ultParentOfU]++;
		}
	}

	static class Edge {

		int u, v, weight;

		Edge(int u, int v, int weight) {
			this.u = u;
			this.v = v;
			this.weight = weight;
		}
	}

	public static void main(String[] args) {

		int v = 6;// no of vertices
		List<Edge> al = new ArrayList<Edge>();// List of edges
		al.add(new Edge(0, 1, 7));
		al.add(new Edge(0, 2, 8));
		al.add(new Edge(1, 2, 3));
		al.add(new Edge(1, 3, 8));
		al.add(new Edge(1, 3, 6));
		al.add(new Edge(2, 3, 4));
		al.add(new Edge(2, 4, 3));
		al.add(new Edge(3, 4, 2));
		al.add(new Edge(4, 5, 2));
		al.add(new Edge(3, 5, 5));
		al.add(new Edge(5, 5, 1));

		// Sort Edges in ascending order of weight
		Collections.sort(al, new Comparator<Edge>() {
			public int compare(Edge a, Edge b) {
				return a.weight - b.weight;
			}
		});

		int[] rank = new int[v];
		int[] parent = new int[v];
		for (int i = 0; i < v; i++)
			parent[i] = i;

		int mstSum = 0;
		for (int i = 0; i < al.size(); i++) {

			int ultParentOfU = findUltimateParent(al.get(i).u, parent);
			int ultParentOfV = findUltimateParent(al.get(i).v, parent);

			if (ultParentOfU != ultParentOfV) {

				// Add edge weight to final sum
				mstSum += al.get(i).weight;
				unionByRank(al.get(i).u, al.get(i).v, parent, rank, ultParentOfU, ultParentOfV);
			}
		}

		System.out.println(mstSum);
	}
}