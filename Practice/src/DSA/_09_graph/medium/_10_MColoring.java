package DSA._09_graph.medium;

import java.util.*;

//https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
//https://www.youtube.com/watch?v=wuVwUK25Rfc
public class _10_MColoring {

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

	public static boolean isMColoringPossible(int n, int m) {

		int[] color = new int[n];
		Arrays.fill(color, -1);

		for (int vertex = 0; vertex < n; vertex++) {

			if (color[vertex] == -1) {

				// coloring options available for m = 3 are {1,2,3}
				for (int vertexColor = 1; vertexColor <= m; vertexColor++) {
					if (isColoringPossible(vertex, vertexColor, color))
						color[vertex] = vertexColor;
				}

				// if not possible to color current vertex with any available colors, then
				// return false
				if (color[vertex] == -1)
					return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {

		int n = 5, m = 2;

		List<int[]> edges = new ArrayList<int[]>();

//		Success Test case :
//		edges.add(new int[] { 0, 1 });
//		edges.add(new int[] { 1, 2 });
//		edges.add(new int[] { 2, 3 });
//		edges.add(new int[] { 3, 0 });
//		edges.add(new int[] { 0, 2 });

		// Failure Test case :
		edges.add(new int[] { 0, 3 });
		edges.add(new int[] { 1, 2 });
		edges.add(new int[] { 1, 4 });
		edges.add(new int[] { 2, 1 });
		edges.add(new int[] { 3, 0 });
		edges.add(new int[] { 3, 4 });
		edges.add(new int[] { 4, 1 });
		edges.add(new int[] { 4, 3 });

		createAdjListGraph(n, edges);

		System.out.println(isMColoringPossible(n, m));
	}

}
