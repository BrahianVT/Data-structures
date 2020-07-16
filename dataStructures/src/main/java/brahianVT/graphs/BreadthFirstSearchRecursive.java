
package brahianVT.graphs;

/** 

	Implementation of a breadth first search recursively
	
	TC : O(V + E)
	@author Brahian VT
**/
import java.util.*;

public class BreadthFirstSearchRecursive{
		
		
	static class Edge{
		int from, to, cost;
		
		public Edge(int from, int to, int cost){
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	
	private List<List<Integer>> graph;
	
	public BreadthFirstSearchRecursive(int n){
		for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
	}
	public static int DEPH_TOKEN = -1;
	
	public void bfs(int start, int n){
		boolean[] visited = new boolean[n];
		Queue<Integer> queue = new LinkedList();
		
		queue.offer(start);
		queue.offer(DEPH_TOKEN);
		 bfs(visited, queue);
	}
	
	private void bfs (boolean[] visited, Queue<Integer> queue){
		
		int at = queue.poll();
		
		if(at == DEPH_TOKEN){
			queue.offer(DEPH_TOKEN);
			return;
		}
		
		if(visited[at]) return;
		
		visited[at] = true;
		
		List<Integer> neightbors = graph.get(at);
		if(neightbors != null){
			for( int next: neightbors)
				if(!visited[next])
					queue.add(next);
				
			while(true){
				if(queue.size() == 1 && queue.peek() == DEPH_TOKEN) break;
				
				bfs(visited, queue);
			}
		}
		
	}
	public void addUndirectedEdge(int from ,int to){
		
		graph.get(from).add(to);
		graph.get(to).add(from);
	}
	
}