package DSA.Bucket4._09_graph.medium._02_TopologicalSort_DAG;

import java.util.*;

//https://www.youtube.com/watch?v=WAOfKpxYHR8
//https://www.geeksforgeeks.org/problems/course-schedule/1
public class _03_CourseSchedule {

	static class Graph {

		static LinkedList<Integer>[] adjList;

		Graph(int v) {
			adjList = new LinkedList[v];
			for (int i = 0; i < adjList.length; i++)
				adjList[i] = new LinkedList<Integer>();

		}

		// Creating directed graph
		public void createGraph(ArrayList<ArrayList<Integer>> prerequisites) {
			for (int i = 0; i < prerequisites.size(); i++)
				adjList[prerequisites.get(i).get(0)].add(prerequisites.get(i).get(1));
		}

		public boolean checkCycleUsingTopoSort() {
			int[] indegree = new int[adjList.length];

			for (int i = 0; i < adjList.length; i++) {
				for (int j : adjList[i])
					indegree[j]++;
			}

			// Now do BFS and
			Queue<Integer> q = new LinkedList<Integer>();
			ArrayList<Integer> topoSort = new ArrayList<Integer>();

			// Find vertices with indegree = 0 & add to Q
			for (int i = 0; i < indegree.length; i++)
				if (indegree[i] == 0)
					q.add(i);

			while (!q.isEmpty()) {

				int i = q.poll();
				topoSort.add(i);

				for (int j : adjList[i]) {
					indegree[j]--;

					if (indegree[j] == 0)
						q.add(j);
				}
			}

			// Directed graph contains cycle, hence pre-requisite condition is not met
			if (topoSort.size() != adjList.length)
				return false;

			// Directed graph doesn't contain any cycle, hence its DAG with topo sorted.
			// Hence required pre-requiste is met
			return true;
		}

		public static void main(String[] args) {

			ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> list = new ArrayList<Integer>();

			// Working pre-requisite data
//			list.add(1);
//			list.add(0);
//			prerequisites.add(list);
//
//			list = new ArrayList<Integer>();
//			list.add(2);
//			list.add(0);
//			prerequisites.add(list);
//
//			list = new ArrayList<Integer>();
//			list.add(3);
//			list.add(1);
//			prerequisites.add(list);
//
//			list = new ArrayList<Integer>();
//			list.add(3);
//			list.add(2);
//			prerequisites.add(list);

			// Not-Working pre-requisite data
			list.add(1);
			list.add(2);
			prerequisites.add(list);

			list = new ArrayList<Integer>();
			list.add(4);
			list.add(3);
			prerequisites.add(list);

			list = new ArrayList<Integer>();
			list.add(2);
			list.add(4);
			prerequisites.add(list);

			list = new ArrayList<Integer>();
			list.add(4);
			list.add(1);
			prerequisites.add(list);

			int n = 5;
			Graph g = new Graph(n);
			g.createGraph(prerequisites); // first try to create directed graph

			// check if directed graph has cycle
			// if it has, then given order of courses is not correct
			// else given order of courses is correct
			System.out.println(g.checkCycleUsingTopoSort());
		}
	}

}
