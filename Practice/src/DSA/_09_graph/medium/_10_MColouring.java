package DSA._09_graph.medium;

import java.util.*;

//https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
//https://www.youtube.com/watch?v=wuVwUK25Rfc
public class _10_MColouring {

	static LinkedList<Integer>[] adjList;

	public static void createAdjListGraph(int n, List<int[]> edges) {

		adjList = new LinkedList[n];

		for (int i = 0; i < adjList.length; i++)
			adjList[i] = new LinkedList<Integer>();

		for (int i = 0; i < edges.size(); i++) {
			// for each edge, 1st index stores src vertex and 2nd index stores dest vertex
			adjList[edges.get(i)[0]].add(edges.get(i)[1]);
			adjList[edges.get(i)[1]].add(edges.get(i)[0]); // undirected
		}
	}

	public static boolean isColoringPossible(int vertex, int vertexColor, int[] color) {

		for (int v : adjList[vertex]) {
			if (color[v] == vertexColor)
				return false;
		}

		return true;
	}

	public static boolean isMColoringPossible(int vertex, int[] color, int n, int m) {

		if (vertex == n)
			return true;

		if (color[vertex] == -1) {

			// coloring options available for m = 3 are {1,2,3}
			for (int vertexColor = 1; vertexColor <= m; vertexColor++) {

				if (isColoringPossible(vertex, vertexColor, color)) {

					color[vertex] = vertexColor;

					if (isMColoringPossible(vertex + 1, color, n, m))
						return true;

				}
			}

			// if not possible to color vertex with all available colors, then return false
			// as final answer
			return false;

		}

		return false;
	}

	public static void main(String[] args) {
		List<int[]> edges = new ArrayList<int[]>();
		int n = 4, m = 2;

		edges.add(new int[] { 0, 1 });
		edges.add(new int[] { 1, 2 });
		edges.add(new int[] { 2, 3 });
		edges.add(new int[] { 3, 0 });
		edges.add(new int[] { 0, 2 });

		createAdjListGraph(n, edges);

		int[] color = new int[n];
		Arrays.fill(color, -1);

		isMColoringPossible(0, color, n, m);
	}

}
