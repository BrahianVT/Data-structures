
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
	private Map<Integer, List<Edge>> graph;
	static class Edge{
		int from, to, cost;
		
		public Edge(int from, int to, int cost){
			this.cost = cost;
			this.to = to;
			this.from = from;
		}
	}
	
	
	public DepthFirstSearchAdjacencyListRecursive(){
		graph = new HashMap<>();
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
		// First Check it the elements are already in the list
		if(!graph.containsKey(from)){ 
			size++;
			if(!graph.containsKey(to)){
				for(Map.Entry<Integer, List<Edge>> entry: graph.entrySet()){
					for(Edge i : entry.getValue()){
						if(i.to == to) size--;
					}
				}
				size++;
			}
		}		
		
	}
	public int size(){ return size; }
	
	public void dfs(int at, boolean[] visited){
		if(visited[at]) return;
		
		visited[at] = true;
		
		List<Edge> edges = graph.get(at);


		if(edges != null){
			System.out.print(" " + edges.get(0).from);
			for(Edge edge: edges){
				dfs(edge.to, visited);
			}
		}else{
			// if the at variable is not a key that means is a to 
			System.out.print(" " + at);
		}
	}
	
}