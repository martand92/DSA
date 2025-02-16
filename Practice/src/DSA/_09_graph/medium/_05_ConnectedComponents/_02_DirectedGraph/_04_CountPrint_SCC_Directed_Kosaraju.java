package DSA._09_graph.medium._05_ConnectedComponents._02_DirectedGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

//https://www.geeksforgeeks.org/connectivity-in-a-directed-graph/
public class _04_CountPrint_SCC_Directed_Kosaraju {

	public static class Graph {

		LinkedList<Integer> adjList[];
		boolean[] visited;

		public Graph(int v) {

			adjList = new LinkedList[v];

			for (int i = 0; i < v; i++)
				adjList[i] = new LinkedList<Integer>();

			visited = new boolean[v];
		}

		public void addEdge(int u, int v) {
			adjList[u].add(v);// Directed Graph
		}

		// check if all the vertices are visited
		public ArrayList<Integer> dfs(int vertex, ArrayList<Integer> list) {

			visited[vertex] = true;

			list.add(vertex);
			for (int v : adjList[vertex]) {
				if (!visited[v])
					dfs(v, list);
			}

			return list;
		}

		public Graph getTranspose() {

			// create new transposed graph
			Graph transposeGraph = new Graph(adjList.length);

			for (int u = 0; u < adjList.length; u++) {
				for (int v : adjList[u])
					transposeGraph.adjList[v].add(u);
			}

			return transposeGraph;
		}

		public ArrayList<ArrayList<Integer>> getSCC(int vertex) {

//			// first check if all the vertices are strongly connected in given graph
//			dfs(vertex);
//			for (boolean v : visited) {
//				if (!v)
//					return false;
//			}

			// Get transpose of given graph
			Graph transposeGraph = getTranspose();

			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

			for (int i = 0; i < transposeGraph.adjList.length; i++) {

				if (!transposeGraph.visited[i]) {

					ArrayList<Integer> list = new ArrayList<Integer>();
					list = transposeGraph.dfs(i, list);

					if (!list.isEmpty())
						result.add(list);
				}
			}

			return result;
		}

		public static void main(String[] args) {

			Graph g1 = new Graph(5);
			g1.addEdge(0, 1);
			g1.addEdge(1, 2);
			g1.addEdge(2, 3);
			g1.addEdge(3, 0);
			g1.addEdge(2, 4);
			g1.addEdge(4, 2);
			System.out.println("SCC are : " + g1.getSCC(0));

			Graph g2 = new Graph(4);
			g2.addEdge(0, 1);
			g2.addEdge(1, 2);
			g2.addEdge(2, 3);
			System.out.println("SCC are : " + g2.getSCC(0));

			Graph g3 = new Graph(8);
			g3.addEdge(0, 1);
			g3.addEdge(1, 2);
			g3.addEdge(2, 0);
			g3.addEdge(2, 3);
			g3.addEdge(3, 4);
			g3.addEdge(4, 5);
			g3.addEdge(4, 7);
			g3.addEdge(5, 6);
			g3.addEdge(6, 4);
			g3.addEdge(6, 7);
			System.out.println("SCC are : " + g3.getSCC(0));
		}

	}

}
