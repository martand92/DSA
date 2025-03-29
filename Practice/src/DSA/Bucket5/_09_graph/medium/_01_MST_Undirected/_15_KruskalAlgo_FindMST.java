package DSA.Bucket5._09_graph.medium._01_MST_Undirected;

import java.util.*;
import java.util.Collections;
import java.util.Comparator;

public class _15_KruskalAlgo_FindMST {

	static class Edge {

		int u, v, w;

		Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}

	static List<Edge> al = new ArrayList<Edge>();

	public static int findUltParent(int node, int[] parent) {
		if (node == parent[node])
			return parent[node];

		parent[node] = findUltParent(parent[node], parent);// path compression
		return parent[node];
	}

	public static int findMST(int v) {

		Collections.sort(al, new Comparator<Edge>() {
			public int compare(Edge u, Edge v) {
				return u.w - v.w;
			}
		});

		int[] rank = new int[v];
		int[] parent = new int[v];
		for (int i = 0; i < v; i++)
			parent[i] = i;

		int mstSum = 0;
		for (int i = 0; i < al.size(); i++) {

			int ultParentOfU = findUltParent(al.get(i).u, parent);
			int ultParentOfV = findUltParent(al.get(i).v, parent);

			if (ultParentOfU != ultParentOfV) {// this is how Kruskal prevents adding vertex that belongs to same
												// component. Basically prevents unnecessary nodes

				if (rank[ultParentOfU] < rank[ultParentOfV])
					parent[ultParentOfU] = ultParentOfV;

				else if (rank[ultParentOfV] < rank[ultParentOfU])
					parent[ultParentOfV] = ultParentOfU;

				else {
					parent[ultParentOfV] = ultParentOfU;
					rank[ultParentOfU]++;
				}

				// Add edge weight to final sum
				mstSum += al.get(i).w;
			}
		}

		return mstSum;
	}

	public static void main(String[] args) {

		int v = 6;// no of vertices

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

		System.out.println(findMST(v));
	}
}