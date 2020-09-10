package brahianVT.graphs;

/**
	Implementation of the Tarjans's Strongly Connected Components algorithm using
	an adjacency list;
	
*/
import java.util.*;

public class TarjanSccSolverAdjacencyList{
	
	private int n;
	private List<List<Integer>> graph;
	private boolean solved;
	private int sccCount, id;
	private boolean[] onStack;
	private int[] ids, low;
	private Deque<Integer> stack;
	
	private static final int UNVISITED = -1;
	
	public TarjanSccSolverAdjacencyList(List<List<Integer>> graph){
		
		if(graph == null) throw new IllegalArgumentException("Graph cannot be null");
		n = graph.size();
		
		this.graph = graph;
	}
	
	public int sccCount(){
		if(!solved) solve();
		return sccCount;
	}
	
	public int[] getSccs(){
		if(!solved) solve();
		return low;
	}
	
	public void solve(){
		if(solved) return;
		
		ids = new int[n];
		low = new int[n];
		onStack = new boolean[n];
		stack = new ArrayDeque();
		Arrays.fill(ids, UNVISITED);
		
		for(int i = 0; i < n; i++)
			if(ids[i] == UNVISITED)dfs(i);
		
		solved = true;
	}
	
	private void dfs(int at){
		stack.push(at);
		onStack[at] = true;
		
		ids[at] = low[at] = id++;
		
		for(int to: graph.get(at)){
			if(ids[to] == UNVISITED) dfs(to);
			if(onStack[to]) low[at] = Math.min(low[at], low[to]);
		}
		
		if(ids[at] == low[at]){
			for(int node = stack.pop(); ; node = stack.pop()){
				onStack[node] = false;
				low[node] = ids[at];
				if(node == at)break;
			}
			sccCount++;
		}
	}
	
	public static List<List<Integer>> createGraph(int n){
		List<List<Integer>> graph = new ArrayList(n);
		for(int i = 0; i < n; i++) graph.add(new ArrayList());
		
		return graph;
	}
	
	public static void addEdge(List<List<Integer>> graph, int from, int to){
		graph.get(from).add(to);
	}
}