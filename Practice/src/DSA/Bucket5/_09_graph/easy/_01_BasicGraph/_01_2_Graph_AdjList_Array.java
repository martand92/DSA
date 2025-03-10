package DSA.Bucket5._09_graph.easy._01_BasicGraph;

import java.util.*;

public class _01_2_Graph_AdjList_Array {

	static class Graph {

		LinkedList<Integer>[] adjList;

		@SuppressWarnings("unchecked")
		Graph(int v) {

			adjList = new LinkedList[v]; // initializing array with v vertices

			for (int i = 0; i < v; i++)
				adjList[i] = new LinkedList<>(); // Create a new list for each vertex and don't use Arrays.fill as same
													// instance of LinkedList is shared with all the array indices
		}

		void addEdge(int u, int v) {
			adjList[u].add(v);
			adjList[v].add(u); // if undirected
		}

		public static void main(String args[]) {
			Graph g = new Graph(4);

			g.addEdge(0, 1);// 0-> 1 && 1-> 0(if undirected)
			g.addEdge(0, 2);
			g.addEdge(1, 2);
			g.addEdge(2, 3);
			g.addEdge(3, 3);

			System.out.println(Arrays.toString(g.adjList));
		}

	}

}
