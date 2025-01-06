package DSA._09_graph.medium._02_DetectCycle.Directed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//https://www.youtube.com/watch?v=iTBaI90lpDQ

// As Topo sort is applied for DAG where final result will have all vertices ordered linearly
// if its applied for Directed Cyclic Graph, then final result will not have all vertices & queue will empty. Basically it will not finish topological sorting if it has cycle.

public class _12_DetectCycleInDirectedGraph_BFS_KahnAlgo {

	public static class Graph {

		static LinkedList<Integer>[] adjList;
		static int[] flag;

		Graph(int v) {

			adjList = new LinkedList[v];

			for (int i = 0; i < v; i++)
				adjList[i] = new LinkedList<Integer>();
		}

		public void addEdge(int srcVertex, int destVertex) {
			adjList[srcVertex].add(destVertex);
		}

		public boolean isGraphCyclic() {

			// Using topo sort

			// First find in-degree of vertices
			int[] indegree = new int[adjList.length];
			for (int i = 0; i < adjList.length; i++) {
				for (int j : adjList[i])
					indegree[j]++;
			}

			Queue<Integer> q = new LinkedList<Integer>();
			ArrayList<Integer> topoSort = new ArrayList<Integer>();

			// Find vertices with zero in-degree & add to q
			for (int i = 0; i < indegree.length; i++) {
				if (indegree[i] == 0)
					q.add(i);
			}

			while (!q.isEmpty()) {

				int v = q.poll();

				// dequeue to topo sort result
				topoSort.add(v);

				for (int i : adjList[v]) {

					// loop through all adj vertices & -1 in-degree
					indegree[i]--;

					if (indegree[i] == 0)
						q.add(i);
				}

			}

			// while finding topoSort, if you emptied Queue and couldn't find next vertex
			// with indegree = 0 as these adj vertices are having cycle resulting in final
			// topoSort length != no of vertices
			if (topoSort.size() != adjList.length)
				return true;

			return false;

		}

		public static void main(String[] args) {
			Graph g = new Graph(4);
			g.addEdge(0, 1);
			// addEdge(0, 2);
			g.addEdge(1, 2);
			// g.addEdge(2, 0);
			g.addEdge(2, 3);
			// g.addEdge(3, 3);

			System.out.println(g.isGraphCyclic());
		}

	}

}
