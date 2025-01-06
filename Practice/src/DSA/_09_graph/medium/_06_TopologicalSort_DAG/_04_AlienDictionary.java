package DSA._09_graph.medium._06_TopologicalSort_DAG;

import java.util.*;

//https://www.youtube.com/watch?v=U3N_je7tWAs
//https://www.geeksforgeeks.org/problems/alien-dictionary/1
public class _04_AlienDictionary {

	static class Graph {

		static LinkedList<Integer>[] adjList;

		Graph(int v) {
			adjList = new LinkedList[v];
			for (int i = 0; i < adjList.length; i++)
				adjList[i] = new LinkedList<Integer>();

		}

		// Creating directed graph
		public void createGraph(String[] dict) {

			// find which letter comes before the other in 2 strings and construct graph
			// with respective numbers. i.e, if b comes before a then graph will have 1 -> 0
			for (int i = 0; i < dict.length - 1; i++) {

				String s1 = dict[i];
				String s2 = dict[i + 1];

				int j = 0;
				while (j < s1.length() && j < s2.length()) {
					if (s1.charAt(j) != s2.charAt(j)) {
						// s1 char comes before s2 char. Hence respective num rep should be mapped &
						// ordered to form directed graph

						// As relation between alphabets should be stored as Graph vertices i.e, u -> v
						// in adjList, need to map alphabets to numbers
						// i.e, a -> 0, b -> 1, c -> 2, d-> 3
						adjList[s1.charAt(j) - 'a'].add(s2.charAt(j) - 'a');// basically substracting 'a'-'a'=0,
																			// 'b'-'a'=1, 'c'-'a'=2 etc..
						break;
					}
					j++;
				}
			}

		}

		public ArrayList<Character> getTopoSort() {

			int[] indegree = new int[adjList.length];

			for (int i = 0; i < adjList.length; i++) {
				for (int j : adjList[i])
					indegree[j]++;
			}

			// Now check if there is cyclic
			Queue<Integer> q = new LinkedList<Integer>();
			ArrayList<Character> topoSort = new ArrayList<Character>();

			// Find vertices with indegree = 0 & add to Q
			for (int i = 0; i < indegree.length; i++)
				if (indegree[i] == 0)
					q.add(i);

			while (!q.isEmpty()) {

				int i = q.poll();

				topoSort.add((char) (i + 'a'));// while getting order, get sorted vertex's char rep

				for (int j : adjList[i]) {
					indegree[j]--;

					if (indegree[j] == 0)
						q.add(j);
				}
			}

			return topoSort;
		}

		public static void main(String[] args) {

			String[] dict = { "baa", "abcd", "abca", "cab", "cad" };
			int k = 4;// Alphabets that are available in given dictionary i.e, first 4 alphabets are
						// available a,b,c,d

			Graph g = new Graph(k);
			g.createGraph(dict);
			System.out.println(g.getTopoSort());
		}
	}

}
