package DSA.Bucket5._09_graph.medium._05_DetectCycle.Directed;

import java.util.*;

//If any SCC has more than one node, a cycle exists
//Ex: 1->2->3->4 This is DAG where each node is its own SCC. Hence each SCC contains only single node
//So above DAG has no cycle cz each SCC contains only 1 node

//If any of the SCC contains more than 1 node, then by definition of SCC from every node all other nodes can be reached. i,e, u->v & v->u. Hence contains cycle
public class _13_UsingSCC {

	static class Graph {
		private final int V;
		private final List<List<Integer>> adj;

		public Graph(int V) {
			this.V = V;
			adj = new ArrayList<>();
			for (int i = 0; i < V; i++)
				adj.add(new ArrayList<>());
		}

		public void addEdge(int v, int w) {
			adj.get(v).add(w);
		}

		private void dfs1(int v, boolean[] visited, Stack<Integer> stack) {
			visited[v] = true;
			for (int n : adj.get(v)) {
				if (!visited[n]) {
					dfs1(n, visited, stack);
				}
			}
			stack.push(v);
		}

		private Graph getTranspose() {
			Graph g = new Graph(V);
			for (int v = 0; v < V; v++) {
				for (int n : adj.get(v))
					g.addEdge(n, v);
			}
			return g;
		}

		private void dfs2(int v, boolean[] visited, List<Integer> nodesList) {
			visited[v] = true;
			nodesList.add(v);
			for (int n : adj.get(v)) {
				if (!visited[n]) {
					dfs2(n, visited, nodesList);
				}
			}
		}

		public boolean hasCycle() {

			Stack<Integer> stack = new Stack<>();
			boolean[] visited = new boolean[V];

			for (int i = 0; i < V; i++) {
				if (!visited[i]) {
					dfs1(i, visited, stack);
				}
			}

			Graph transposedGraph = getTranspose();
			Arrays.fill(visited, false);

			while (!stack.isEmpty()) {

				int v = stack.pop();

				if (!visited[v]) {
					// While doing 2nd dfs, checking if any of the SCC contains more than 1 node
					List<Integer> nodesList = new ArrayList<>();
					transposedGraph.dfs2(v, visited, nodesList);
					if (nodesList.size() > 1)
						return true;
				}
			}

			return false;
		}
	}

	public static void main(String[] args) {
		Graph graph = new Graph(6);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 3);

		if (graph.hasCycle())
			System.out.println("Graph contains a cycle");
		else
			System.out.println("Graph does not contain a cycle");

	}

}
