package DSA.Bucket5._09_graph.medium._04_DetectCycle.Directed;

import java.util.Arrays;
import java.util.LinkedList;

//https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
public class _12_Using_DFS {

	public static class Graph {

		static LinkedList<Integer>[] adjList;
		static int[] flag;

		Graph(int v) {

			adjList = new LinkedList[v];

			for (int i = 0; i < v; i++)
				adjList[i] = new LinkedList<Integer>();

			// flag[] holds 3 values :
			// -1 : indicating vertices are unvisited
			// 0 : indicating that vertex is visited and added to stack
			// 1 : indicating that vertex is popped out of stack while backtracking
			// while backtracking this vertex gets visited again, but it shouldn't confuse
			// that its part of cycle)
			flag = new int[v];
			Arrays.fill(flag, -1);

		}

		public void addEdge(int srcVertex, int destVertex) {
			adjList[srcVertex].add(destVertex);
		}

		public boolean isGraphCyclic(int vertex) {

			if (flag[vertex] == 0)
				return true;

			flag[vertex] = 0;

			for (int i : adjList[vertex]) {
				if (isGraphCyclic(i))
					return true;

				flag[vertex] = 1;
			}

			return false;
		}

		public static void main(String[] args) {
			Graph g = new Graph(4);
			g.addEdge(0, 1);
			// addEdge(0, 2);
			g.addEdge(1, 2);
			// addEdge(2, 0);
			g.addEdge(2, 3);
			g.addEdge(3, 3);

			System.out.println(g.isGraphCyclic(0));
		}

	}

}
