package DSA._09_graph.easy._01_BasicGraph;

import java.util.*;

public class _02_GraphOperations_AdjList {

	static class Edge {
		int destVertexId;
		int weight;

		Edge(int destVertexId, int weight) {
			this.destVertexId = destVertexId;
			this.weight = weight;
		}
	}

	static class Vertex {
		int stateId;
		String stateName;
		List<Edge> edgeList;

		Vertex(int stateId, String stateName, Edge edge) {
			this.stateId = stateId;
			this.stateName = stateName;
			this.edgeList.add(edge);
		}
	}

	static class Graph {
		static ArrayList<Vertex> vertices = new ArrayList<Vertex>();

		// Check if Vertex is present using vertexStateID
		public static boolean checkIfVertexIdAlreadyPresent(int vertexStateId) {
			for (Vertex v : vertices) {
				if (v.stateId == vertexStateId)
					return true;
			}

			return false;
		}

		// Check if Edge exist between source and destination vertex
		public static boolean checkIfEdgeExistsBetweenGivenVertices(int srcVertexId, int destVertexId) {
			for (Vertex v : vertices) {

				if (v.stateId == srcVertexId) {
					for (Edge e : v.edgeList) {
						if (e.destVertexId == destVertexId)
							return true;
					}
				}
			}
			return false;
		}

		// Add new Vertex into Graph (vertices) after checking vertexID for duplicates
		public static void addVertex(Vertex vertex) {

			if (checkIfVertexIdAlreadyPresent(vertex.stateId))
				System.out.println("Vertex with given ID already present");
			else
				vertices.add(vertex);
		}

		// To add edge between src and dest vertex with weight
		public static void addEdge(int srcVertexId, int destVertexId, int weight) {

			boolean containsSourceId = checkIfVertexIdAlreadyPresent(srcVertexId);
			boolean containsDestId = checkIfVertexIdAlreadyPresent(srcVertexId);

			if (containsSourceId && containsDestId) {

				// Assuming only single edge should exist between 2 vertices and should be
				// undirected (src to dest and dest to src edges are not 2 separate entities)

				if (!checkIfEdgeExistsBetweenGivenVertices(srcVertexId, destVertexId)) {

					for (Vertex v : vertices) {
						// adding 2 edges, 1st in edgeList of src vertex and 2nd in edgeList of dest
						// vertex

						// adding edge between src vertex and dest vertex
						if (v.stateId == srcVertexId)
							v.edgeList.add(new Edge(destVertexId, weight));
						// adding edge between dest vertex and src vertex
						else if (v.stateId == destVertexId)
							v.edgeList.add(new Edge(srcVertexId, weight));
					}
				}
			}
		}

		// To modify weight of the Edge
		public static void updateEdgeWeight(int srcVertexId, int destVertexId, int newWeight) {
			boolean containsSourceId = checkIfVertexIdAlreadyPresent(srcVertexId);
			boolean containsDestId = checkIfVertexIdAlreadyPresent(srcVertexId);

			if (containsSourceId && containsDestId) {

				// Checking if edge exist between given vertex, if exists then proceed
				if (checkIfEdgeExistsBetweenGivenVertices(srcVertexId, destVertexId)) {

					for (Vertex v : vertices) {

						// Updating Edge's weight between source and destination
						if (v.stateId == srcVertexId) {
							for (Edge e : v.edgeList) {
								if (e.destVertexId == destVertexId) {
									e.weight = newWeight;
									break;
								}
							}
						}

						// Updating Edge's weight between destination and source
						else if (v.stateId == destVertexId) {
							for (Edge e : v.edgeList) {
								if (e.destVertexId == srcVertexId) {
									e.weight = newWeight;
									break;
								}
							}
						}

					}
				}

			}
		}

		// Delete Edge between given vertices
		public static void deleteEdege(int srcVertexId, int destVertexId) {
			boolean containsSourceId = checkIfVertexIdAlreadyPresent(srcVertexId);
			boolean containsDestId = checkIfVertexIdAlreadyPresent(srcVertexId);

			if (containsSourceId && containsDestId) {

				// Checking if edge exist between given vertex, if exists then proceed
				if (checkIfEdgeExistsBetweenGivenVertices(srcVertexId, destVertexId)) {

					for (Vertex v : vertices) {
						if (v.stateId == srcVertexId) {
							
							
							for (Edge e : v.edgeList) {
								if (e.destVertexId == destVertexId) {
									v.edgeList.remove(e);
									break;
								}
							}
						} else if (v.stateId == destVertexId) {
							for (Edge e : v.edgeList) {
								if (e.destVertexId == srcVertexId) {
									v.edgeList.remove(e);
									break;
								}
							}

						}
					}
				}
			}

		}

		// Here only stateName / vertexName need to be updated
		// Will not let vertex id to be updated as it will then require associated
		// neighbors to update their edge's destVertexId
		// Also vertex' edge no need to implement as already this method exists as
		// separate method
		public static void updateVertex(int vertexStateId, String newVertexStateName) {
			for (Vertex v : vertices) {
				if (v.stateId == vertexStateId)
					v.stateName = newVertexStateName;
			}
		}

		// before deleting vertex, first edge between this vertex and its neighbors
		// should be deleted
		public static void deleteVertex(int vertexId) {
			for (Vertex v : vertices) {
				if (v.stateId == vertexId) {

					for (Edge e : v.edgeList) {
						deleteEdege(vertexId, e.destVertexId);
					}

					// After deleting all associated edges in this vertice's neighbors, now delete
					// vertex
					vertices.remove(v);
					break;
				}
			}
		}

		public static void printGraph() {
			for (Vertex v : vertices)
				System.out.println(v.stateId + "," + v.stateName + "," + v.edgeList);
		}

	}

	public static void main(String[] args) {

		Vertex MH = new Vertex(1, "MH", null);
		Vertex Goa = new Vertex(2, "Goa", null);
		Vertex MP = new Vertex(3, "MP", null);
		Graph.addVertex(MH);
		Graph.addVertex(MH);// should throw error
		Graph.addVertex(Goa);
		Graph.addVertex(MP);
		Graph.printGraph();

		Graph.addEdge(1, 2, 700);
		Graph.addEdge(1, 3, 900);
		Graph.printGraph();

		Graph.updateEdgeWeight(1, 2, 600);
		Graph.printGraph();

		Graph.deleteEdege(1, 2);
		Graph.printGraph();

		Graph.updateVertex(1, "KA");
		Graph.printGraph();

		Graph.deleteVertex(3);
		Graph.printGraph();

	}

}
