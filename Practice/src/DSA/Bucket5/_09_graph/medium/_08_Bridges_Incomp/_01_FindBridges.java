package DSA.Bucket5._09_graph.medium._08_Bridges_Incomp;

import java.util.ArrayList;
import java.util.LinkedList;

public class _01_FindBridges {

	static class Graph {

		LinkedList<Integer>[] adjList;

		Graph(int v) {
			adjList = new LinkedList[v];
			for (int i = 0; i < v; i++)
				adjList[i] = new LinkedList<Integer>();

		}

		public void addEdge(int u, int v) {
			adjList[u].add(v);
			adjList[v].add(u);
		}

		public void dfs(int vertex, boolean[] visited, int initTimer, int[] initTime, int[] lowTime) {

		}

		public void findBridges(int v) {
			int[] initTime = new int[adjList.length];
			int[] lowTime = new int[adjList.length];
			int initTimer = 1;
			boolean[] visited = new boolean[adjList.length];
			dfs(v, visited, initTimer, initTime, lowTime);
		}

		public static void main(String[] args) {

			Graph g = new Graph(15);

			// a:0,b:1,c:2,d:3, e:4,f:5,g:6,h:7,i:8,j:9,k:10,l:11,m:12,n:13,o:14

			g.addEdge(0, 1); // a<->b
			g.addEdge(1, 2); // b<->c
			g.addEdge(2, 3); // c<->d
			g.addEdge(3, 4); // d<->e
			g.addEdge(1, 5); // b<->f
			g.addEdge(5, 6); // f<->g
			g.addEdge(2, 6); // c<->g
			g.addEdge(2, 7); // c<->h
			g.addEdge(7, 8); // h<->i
			g.addEdge(7, 9); // h<->j
			g.addEdge(8, 9); // i<->j
			g.addEdge(8, 10); // i<->k
			g.addEdge(9, 11); // j<->l
			g.addEdge(10, 11);// k<->l
			g.addEdge(10, 12);// k<->m
			g.addEdge(12, 13);// m<->n
			g.addEdge(12, 14);// m<->o
			g.addEdge(13, 14);// o<->n

			g.findBridges(3);

		}

	}

}
