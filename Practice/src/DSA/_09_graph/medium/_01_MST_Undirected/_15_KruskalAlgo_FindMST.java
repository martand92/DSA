package DSA._09_graph.medium._01_MST_Undirected;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class _15_KruskalAlgo_FindMST {

	public static class DisjointSet {

		int[] rank;
		int[] parent;

		DisjointSet(int v) {

			rank = new int[v + 1];// 1 based indexing
			parent = new int[v + 1]; // 1 based indexing

			for (int i = 1; i <= v; i++)
				parent[i] = i;
		}

		public int findUltimateParent(int node) {

			if (node == parent[node])
				return parent[node]; // when parent = current node,then this node is ultimate parent

			parent[node] = findUltimateParent(parent[node]);// path compression
			return parent[node];
		}

		public void findUnionByRank(int u, int v) { // Here you need to update ultimate parent and rank of 2 nodes
													// getting connected as we go by

			int ultimateParentOfU = findUltimateParent(u);// When node u -> v, find ultimate parent of u & v.
			int ultimateParentOfV = findUltimateParent(v);

			// If ult parents are same then u,v are from same component, so union is not
			// required as they belong to same set / component
			if (ultimateParentOfU == ultimateParentOfV)
				return;

			// if ultimate parents are not same then attach node with lower rank to node
			// with higher rank
			// Here rank of ultimate parent doesnt change
			if (rank[ultimateParentOfU] < rank[ultimateParentOfV])
				parent[ultimateParentOfU] = ultimateParentOfV;

			else if (rank[ultimateParentOfU] > rank[ultimateParentOfV])
				parent[ultimateParentOfV] = ultimateParentOfU;

			else {// if both node's ranks are same, then attach any 1 node to another node leading
					// to addition of a node to component and increasing parent's rank
				parent[ultimateParentOfV] = ultimateParentOfU;
				rank[ultimateParentOfU]++;
			}
		}
	}

	static int v;
	static int[][] adjMatrix;

	static class Edge {
		int u, v, weight;

		Edge(int u, int v, int weight) {
			this.u = u;
			this.v = v;
			this.weight = weight;
		}
	}

	static class Graph {

		int mstSet;
		ArrayList<Edge> al = new ArrayList<>();

		Graph(int vertex) {
			v = vertex;
			adjMatrix = new int[v][v];
		}

		public void addEdge(int srcVertex, int destVertex, int weight) {
			adjMatrix[srcVertex][destVertex] = weight;
			adjMatrix[destVertex][srcVertex] = weight;
		}

		public ArrayList<Edge> getListOfEdges() {

			for (int i = 0; i < adjMatrix.length; i++) {
				for (int j = 0; j < adjMatrix[0].length; j++) {
					if (adjMatrix[i][j] != 0)
						al.add(new Edge(i, j, adjMatrix[i][j]));
				}
			}
			return al;
		}

		public static void main(String[] args) {
			Graph g = new Graph(6);
			g.addEdge(0, 1, 2);
			g.addEdge(0, 3, 1);
			g.addEdge(0, 4, 4);
			g.addEdge(1, 2, 3);
			g.addEdge(1, 5, 7);
			g.addEdge(1, 3, 3);
			g.addEdge(3, 4, 9);
			g.addEdge(2, 3, 5);

			System.out.println(Arrays.deepToString(adjMatrix));

			// Get list of Edges of AdjMatrix graph
			ArrayList<Edge> al = g.getListOfEdges();

			// Sort Edges in ascending order of weight
			Collections.sort(al, new Comparator<Edge>() {
				public int compare(Edge a, Edge b) {
					return a.weight - b.weight;
				}
			});

			System.out.println(al);

			DisjointSet ds = new DisjointSet(6);

			for (int i = 0; i < al.size(); i++) {
				if (ds.findUltimateParent(al.get(i).u) != ds.findUltimateParent(al.get(i).v)) {
					g.mstSet += al.get(i).weight;
					ds.findUnionByRank(al.get(i).u, al.get(i).v);
				}
			}

		}
	}

}