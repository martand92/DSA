package DSA.Bucket4._09_graph.easy;

import java.util.LinkedList;

//https://practice.geeksforgeeks.org/problems/b64485d3994958cca8748991bb58668204b3e4c0/1

//By explicitly creating graph
public class _08_01_MaxWeightNode {

	static class Graph {

		static LinkedList<Integer>[] adjList;

		Graph(int v) {
			adjList = new LinkedList[v];

			for (int i = 0; i < v; i++)
				adjList[i] = new LinkedList<Integer>();
		}

		public static void addEdge(int u, int v) {
			if (v != -1)
				adjList[u].add(v);
		}

		public static int maxWeight() {

			int[] weight = new int[adjList.length];

			for (int i = 0; i < adjList.length; i++) {
				if (adjList[i].size() > 0)
					weight[adjList[i].get(0)] += i;
			}

			int max = 0, maxi = 0;
			for (int i = 1; i < weight.length; i++) {
				if (weight[i] >= max) {
					max = weight[i];
					maxi = i;
				}
			}

			return maxi;
		}

		public static void main(String[] args) {

			int[] Edge = { 2, 0, -1, 2 };
			new Graph(Edge.length);

			for (int i = 0; i < Edge.length; i++) {
				if (Edge[i] != -1)
					addEdge(i, Edge[i]);
			}

			System.out.println(maxWeight());

		}
	}
}