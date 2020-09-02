

package brahianVT.graphs;

/**
	Implementation of topological sort, taking an adjaceny list of an acyclic graph
	https://www.youtube.com/watch?v=eL-KzMXSXXI&list=PLDV1Zeh2NRsDGO4--qE8yH72HFL1Km93P&index=15
*/
import java.util.*;

public class TopologicalSortAdjacencyList{
	
	static class Edge{
		int from, to ,weight;
		
		public Edge(int f, int t, int w) {
			from = f;
			to = t;
			weight = w;
		}
	}
	
	private static int dfs(
	int i, int at, boolean[] visited, int[] ordering, Map<Integer, List<Edge>> graph){
		visited[at] = true;
		List<Edge> edges = graph.get(at);
		if(edges != null)
			for(Edge edge: edges)
				if(!visited[edge.to])
					i =  dfs(i, edge.to, visited, ordering, graph);
		
		ordering[i] = at;
		
		return i -1;
	}
	
	public int[] topologicalSort(Map<Integer, List<Edge>> graph, int numNodes){
		int[] ordering = new int[numNodes];
		boolean[] visited = new boolean[numNodes];
		int i = numNodes - 1;
		
		for(int at = 0; at < numNodes; at++)
			if(!visited[at])
				i = dfs(i , at, visited, ordering, graph);
			
		return ordering;
	}
	
	
}