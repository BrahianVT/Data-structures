
package brahianVT.graphs;

/**
	An implementation of a  weighted graph recursive approach to DFS 
	in a 
	TC: O(V + E)
	@author Brahian VT
*/

import java.util.*;

public class DepthFirstSearchAdjacencyListRecursive{
		
	private int size;
	
	static class Edge{
		int from, to, cost;
		
		public Edge(int from, int to, int cost){
			this.cost = cost;
			this.to = to;
			this.from = from;
		}
	}

	public void addDirectedEdge(Map<Integer, List<Edge>> graph, int from, int to, int cost){
		
		List<Edge> list = graph.get(from);
		
		if(list == null){
			list = new ArrayList<>();
			graph.put(from, list);
		}
		
		list.add(new Edge(from, to, cost));
		size++;
	}
	
	public int size(){ return size; }
	public void dfs(int at, boolean[] visited, Map<Integer, List<Edge>> graph){
		if(visited[at]) return ;
		
		visited[at] = true;
		
		
		List<Edge> edges = graph.get(at);
		

		if(edges != null){
			for(Edge edge: edges){
				System.out.print(" " + edge.from);
				dfs(edge.to, visited, graph);
			}
		}
	}
	
}