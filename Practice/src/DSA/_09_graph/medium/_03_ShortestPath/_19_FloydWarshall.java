package DSA._09_graph.medium._03_ShortestPath;

import java.util.Arrays;

public class _19_FloydWarshall {

	static class Graph {
		int[][] adjMatrix;

		Graph(int v) {
			adjMatrix = new int[v][v];
		}

		// directed edge addition to graph
		public void addEdge(int u, int v, int w) {
			adjMatrix[u][v] = w;
		}

		public void floydWarshall() {

			// Step 1 : have edge weight as Integer.MAX_VALUE for disconnected vertices
			for (int i = 0; i < adjMatrix.length; i++) {
				for (int j = 0; j < adjMatrix[0].length; j++) {
					if (i != j && adjMatrix[i][j] == 0)
						adjMatrix[i][j] = (int) 1e9;
				}
			}

			// Step 2 : if current val is greater than via value then update
			for (int via = 0; via < adjMatrix.length; via++) {
				for (int i = 0; i < adjMatrix.length; i++) {
					for (int j = 0; j < adjMatrix[0].length; j++) {
						adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][via] + adjMatrix[via][j]);

					}
				}
			}

			System.out.println(Arrays.deepToString(adjMatrix));

			// Step 3 : If you want to check if there are negative cycles
			for (int i = 0; i < adjMatrix.length; i++) {
				if (adjMatrix[i][i] < 0) {
					System.out.println("Neg cycle");
					break;
				}
			}
		}

		public static void main(String[] args) {
			Graph g = new Graph(4);
			g.addEdge(0, 1, 9);
			g.addEdge(1, 0, 6);
			g.addEdge(0, 2, -4);
			g.addEdge(2, 1, 5);
			g.addEdge(1, 3, 2);
			g.addEdge(3, 2, 1);

			g.floydWarshall();

		}

	}

}
