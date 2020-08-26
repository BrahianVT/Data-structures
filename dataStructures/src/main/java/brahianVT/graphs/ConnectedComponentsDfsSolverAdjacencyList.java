package brahianVT.graphs;

import java.util.*;
/**
	This class contains an algorithm to find all connected components of an  undirected graph. If the 
	graph you are dealing with is directed have a look at Tarjan's algorithm to find strongly connected
	components.
	TC: O(V + E)
	@author Brahian VT
*/
public class ConnectedComponentsDfsSolverAdjacencyList {

	private final int n;
	private int componentCount;
	private int[] components;
	private boolean[] visited;
	private List<List<Integer>> graph;
	private boolean solved;
	
	
	public ConnectedComponentsDfsSolverAdjacencyList(List<List<Integer>> graph){
		if(graph == null) throw new NullPointerException();
		this.n = graph.size();
		this.graph = graph;
	}
	
	public int[] getComponents(){
		solve();
		return components;
	}
	
	public int countComponents(){
		solve();
		return componentCount;
	}
	
	private void solve(){
		if(solved) return;
		
		visited = new boolean[n];
		components = new int[n];
		
		for(int i = 0; i < n; i++){
			if(!visited[i]){
				componentCount++;
				dfs(i);
			}
		}
		
		solved = true;
	}
	
	private void dfs(int at){
		visited[at] = true;
		components[at] = componentCount;
		for(int to: graph.get(at)) if(!visited[to]) dfs(to);
	}
	
	public static List<List<Integer>> createGraph(int n){
		List<List<Integer>> graph = new ArrayList(n);
		for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
		return graph;
	}
	
	public static void addUndirectedEdge(List<List<Integer>> graph, int from, int to){
		graph.get(from).add(to);
		graph.get(to).add(from);
	}
	
	
}