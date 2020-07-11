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
	Map<Integer, List<Edge>> graph;
	static class Edge{
		int from, to, cost;
		
		public Edge(int from, int to, int cost){
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	
	public DepthFirstSearchAdjacencyListIterative(){
		graph = new HashMap<Integer, List<Edge>>();
	}
	
	public void dfs(int start, int n){
		
		boolean[] visited = new boolean[n];
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(start);
		visited[start] = true;
		System.out.print(" " + start);
		while(!stack.isEmpty()){
			int node = stack.pop();
			
			List<Edge> edges = graph.get(node);

			if(edges != null){
	
				for(Edge edge: edges){
					if(!visited[edge.to]){
						System.out.print(" " + edge.to);
						stack.push(edge.to);
						visited[edge.to] = true;
					}
				}
			}
		
		}
	}
	
	public void addDirectedEdge(int from, int to, int cost){
		updateSize(from, to);
		
		List<Edge> list = graph.get(from);
		if(list == null){
			list = new ArrayList<>();
			graph.put(from, list);
		}
		list.add(new Edge(from, to, cost));
	}
	
	private void updateSize(int from, int to){
		if(!graph.containsKey(from)){
			size++;
			
			outer: 
			for(Map.Entry<Integer, List<Edge>> entry: graph.entrySet()){
				for(Edge i : entry.getValue()){
					if(i.to == to){  size--; break outer; }
				}
			}
			
			size++;
		}
	}
	
	public int size(){ return size; }
}