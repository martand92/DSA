package DSA.Bucket4._09_graph.easy._01_BasicGraph;

import java.util.*;

public class _01_2_Graph_AdjList_LL {

	static class Graph {

		LinkedList<LinkedList<Integer>> adjList;

		Graph(int v) {
			adjList = new LinkedList<LinkedList<Integer>>(); // initializing array length

			for (int i = 0; i < v; i++)
				adjList.add(new LinkedList<Integer>());
		}

		void addEdge(int u, int v) {
			adjList.get(u).add(v);
			adjList.get(v).add(u); // if undirected
		}

		public static void main(String args[]) {
			Graph g = new Graph(4);

			g.addEdge(0, 1);// 0-> 1 && 1-> 0(if undirected)
			g.addEdge(0, 2);
			g.addEdge(1, 2);
			g.addEdge(2, 0);
			g.addEdge(2, 3);
			g.addEdge(3, 3);

			// System.out.println(g.adj);
		}

	}

}
