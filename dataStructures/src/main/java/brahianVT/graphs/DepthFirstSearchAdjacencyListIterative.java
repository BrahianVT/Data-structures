package brahianVT.graphs;
/**

	Implementation of a iterative DFS with an adjacency list
	without recursion 
	TC: O(V + E)
	@author Brahian VT
*/

import java.util.*;

public class DepthFirstSearchAdjacencyListIterative{
		
	int size;
	static class Edge{
		int from, to, cost;
		
		public Edge(int from, int to, int cost){
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	
	public void dfs(Map<Integer, List<Edge>> graph, int start, int n){
		
		boolean[] visited = new boolean[n];
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(start);
		
		while(!stack.isEmpty()){
			int node = stack.pop();
			
			List<Edge> edges = graph.get(node);

			if(edges != null){
				for(Edge edge: edges){
					if(!visited[edge.to]){
						if(!visited[edge.from])System.out.print(" " + edge.from);
						
						stack.push(edge.to);
						visited[edge.to] = true;
					}
				}
			}
		
		}
	}
	
	private void addDirectedEdge(Map<Integer, List<Edge>> graph, int from, int to, int cost){
		List<Edge> list = graph.get(from);
		
		if(list == null){
			list = new ArrayList<>();
			graph.put(from, list);
		}
		
		list.add(new Edge(from, to, cost));
		size++;
	}
	
	public int size(){ return size; }
}