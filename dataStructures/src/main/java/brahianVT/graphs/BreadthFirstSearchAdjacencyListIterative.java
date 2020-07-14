
package brahianVT.graphs;

/**
	
	An implementation of BFS with an adjacency list	
	@author BrahianVT 
**/


import java.util.*;


public class BreadthFirstSearchAdjacencyListIterative{

	public static class Edge {
		int from, to, cost;
		
		public Edge(int from, int to, int cost){
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}	
	
	private int n;
	private Integer[] prev;
	private List<List<Edge>> graph;
		
	// initialize an empty adjacency list that can hold up to n nodes
		
	public void createEmptyGraph(int n){
		List<List<Edge>> graph = new ArrayList<>(n);
			
		for(int i = 0; i < n; i++)graph.add(new ArrayList<>());
			
		return graph;
	}
	
	public void addDirectedEdge(int u, int v, int cost){
		graph.get(u).add(new Edge(u, v, cost));
	}
	
	public void addUndirectedEdge( int u, int v, int cost){
		addDirectedEdge(u, v, cost);
		addDirectedEdge(v, u, cost);
		
	}
	
	public void addUnweigtedUndirectedEdge(int u, int v){
		addUndirectedEdge(u, v, 1);
	}
	
		
	// Breadth first search on a graph 

	public void dfs(int start){
		prev = new Integer[n];
		boolean[] visited = new boolean[n];
		
		Deque<Integer> queue = new ArrayDeque<>(n);
		
		queue.offer(start);
		
		visited[start] = true;
		
		while(!queue.isEmpty()){
			int node = queue.poll();
			
			
			System.out.print(" " + node);
			List<Edge> edges = graph.get(node);
			
			if(edges != null){
				for(Edge edge: edges){
					
					if(!visited[edge.to]){
						queue.offer(edge.to);
						visited[edge.to] = true;
						prev[edge.to] = node;
					}
				}
			}
		}
	}
		
	public String formatPath(List<Integer> path){
		return String.join(
			" -> ", path.stream().map(Object::toString).collect(java.util.stream.Collectors.toList())	
		);
	}
}