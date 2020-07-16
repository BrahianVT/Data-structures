
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
		
		graph = new ArrayList<>();
		this.n = n;	
		
		for(int i = 0; i < n; i++)graph.add(new ArrayList<>());
		
	}
	
	public void addDirectedEdge(int u, int v, int cost){
		graph.get(u).add(new Edge(u, v, cost));
	}
	
	public void addUndirectedEdge( int u, int v, int cost){
		addDirectedEdge(u, v, cost);
		addDirectedEdge(v, u, cost);
		
	}
	
	public void addUnweightedUndirectedEdge(int u, int v){
		addUndirectedEdge(u, v, 1);
	}
	
		
	// Breadth first search on a graph 

	public void bfs(int start){
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
					}
				}
			}
		}
	}
	
	public void bfsReconstruct(int start){	
		prev = new Integer[n];
		boolean[] visited = new boolean[n];
		
		Deque<Integer> queue = new ArrayDeque<>(n);
		
		queue.offer(start);
		
		visited[start] = true;
		
		while(!queue.isEmpty()){
			int node = queue.poll();
			
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
	/* Reconstruct the path  from start to end inclusive. If the edges are unweighted	
	   then this method return the shortest path from start to end.
	   
	   if start and end are not connected then an empty array is returned
	   
	*/
	
	public List<Integer> reconstructPath(int start, int end){
		
		bfsReconstruct(start);
		List<Integer> path = new ArrayList<>();
		for(Integer at = end; at!= null; at = prev[at])
			path.add(at);
		Collections.reverse(path);
		if(path.get(0) == start) return path;
		path.clear();
		
		return path;
	}
	public String formatPath(List<Integer> path){
		return String.join(
			" -> ", path.stream().map(Object::toString).collect(java.util.stream.Collectors.toList())	
		);
	}
}