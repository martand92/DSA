package DSA._09_graph.easy._02_GraphTraversal._01_NumberOfIsland;

import java.util.*;

public class _01_02_Graph_BFS_NoOfDistinctIslands_Incomp {

	static class Vertex {
		int i;
		int j;

		Vertex(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

//	static class Base {
//		int i;
//		int j;
//
//		Base(int i, int j) {
//			this.i = i;
//			this.j = j;
//		}
//	}

	static class Graph {

		public static HashSet<ArrayList> connectedIslands(int[][] adjMatrix, boolean[][] visited, Queue<Vertex> q,
				int baseRow, int baseCol, String base, ArrayList<String> list, HashSet<ArrayList> hs) {

			// add current indicated land to q & mark it as visited
			visited[baseRow][baseCol] = true;
			q.add(new Vertex(baseRow, baseCol));

			// adding this land coordinates to list
			list.add(new String(0 + "," + 0));

			while (!q.isEmpty()) {

				// take current land from Q and check for all 4 side neighbors
				Vertex currentVertex = q.poll();

				// define 4 values that rows and columns could have for given vertex
				int[] deltaRow = { -1, 0, 1, 0 };
				int[] deltaCol = { 0, -1, 0, 1 };

				// Visit all land neighbors in all 4 directions, mark as visited & add to queue
				for (int k = 0; k < deltaRow.length; k++) {
					int newRow = currentVertex.i + deltaRow[k];
					int newCol = currentVertex.j + deltaCol[k];

					if (newRow < adjMatrix.length && newRow >= 0 && newCol < adjMatrix[0].length && newCol >= 0
							&& adjMatrix[newRow][newCol] == 1 && !visited[newRow][newCol]) {

						visited[newRow][newCol] = true;
						q.add(new Vertex(newRow, newCol));
						list.add(new String((newRow - baseRow) + "," + (newCol - baseCol)));

					}

				}

			}
			if (!hs.contains(list))
				hs.add(list);

			return hs;

		}

	}

	public static void main(String[] args) {

		// in adjMatrix 1 rep land and 0 rep water
		int[][] adjMatrix = { { 1, 1, 0, 1, 1 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 1, 1 }, { 1, 1, 0, 1, 0 } };
		boolean[][] visited = new boolean[adjMatrix.length][adjMatrix[0].length];
		Queue<Vertex> q = new LinkedList<Vertex>();
		HashSet<ArrayList> hs = new HashSet<ArrayList>();

		// to do bfs for every index of grid with land (value = 1)
		for (int i = 0; i < adjMatrix.length; i++) {

			for (int j = 0; j < adjMatrix[0].length; j++) {

				// consider land that's not visited
				if (!visited[i][j] && adjMatrix[i][j] == 1) {
					String base = new String();// Storing list elements as String as hashSet can recognise duplicates
					ArrayList<String> list = new ArrayList<String>(); // this list stores all the coordinates of the
																		// cells in connected island
					hs = Graph.connectedIslands(adjMatrix, visited, q, i, j, base, list, hs);
				}

			}

		}

		System.out.println(hs.size());
	}

}
