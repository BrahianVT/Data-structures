package brahianVT.graphs;


/**
	An implementation of a iterative DFS with an adjacency list using a custom stack
	
	@author Brahian VT
	

*/

import java.util.*;



/* Implementation of an integer only stack which is extremely quick and lightweight 
   However, the downside is you need to know an upper bound on the number of elements
   that will be inside the stack at any given time for it to work correctly
*/
public class DepthFirstSearchAdjacencyListIterativeFastStack{

	class IntStack{
		private int[] ar;
		private int pos = 0, sz;
		
		public IntStack(int maxSize){
			ar = new int[(sz = maxSize)];
		}
		
		public boolean isEmpty(){
			return pos == 0;
		}
		
		public int peek(){
			return ar[pos -1];
		}
		
		public void push(int value){
			ar[pos++] = value;
		}
		public int pop(){ 
			return ar[--pos];
		}
	}

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
		IntStack stack = new IntStack(n);
		
		stack.push(start);
		
		while(!stack.isEmpty()){
			int node = stack.pop();
			
			if(!visited[node]){
				

				visited[node] = true;
				List<Edge> edges = graph.get(node);
				if(edges != null){
					System.out.print(" "+ edges.get(0).from);
					for(Edge edge: edges){
						if( !visited[edge.to]){
							stack.push(edge.to);
						}
					}
				}
			}
		}
	}
	
	private void addDirectedEdge(Map<Integer, List<Edge>> graph, int from, int to, int cost){
		List<Edge> list = graph.get(from);
		
		if(list == null){
			list = new ArrayList<Edge>();
			graph.put(from, list);
		}
		
		list.add(new Edge(from, to, cost));
	}
	
}