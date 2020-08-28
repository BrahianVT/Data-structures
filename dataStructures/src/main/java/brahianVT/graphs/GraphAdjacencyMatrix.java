
package brahianVT.graphs;

/**
	An implementation of a unweighted undirected graph using an adjacencyMatrix 
	in a 
	TC: O(n^2)
	@author Brahian VT
*/

import java.util.*;

public class GraphAdjacencyMatrix {
		
	private int nodes;
	private int matrix[][];
	
	public GraphAdjacencyMatrix(int nodes){
		this.nodes = nodes;
		matrix = new int[nodes][nodes];
	}

	public void addEdge(int from, int to){
		matrix[from][to] = 1;
		
		matrix[to][from] = 1;
	}
	
	public List<List<Integer>>getAdjacencyList(){
		
		List<List<Integer>> adjacencyList = new ArrayList();
		
		for(int i = 0; i < nodes; i++){
		
			List<Integer> aux = new ArrayList();
			for(int j = 0; j < nodes; j++){
				if(matrix[i][j] == 1){
					aux.add(j);
				}
			}
		
			adjacencyList.add(new ArrayList(aux));
		}
		
		return adjacencyList;
	}
	
	public void dfs(int start, boolean visited[]){
		int j;
		
		System.out.print(" " + start);
		
		visited[start] = true;
		
		for( j = 0; j < nodes; j++){
			if(!visited[j] && matrix[start][j] == 1)
				dfs(j , visited);
		}
	}
	
	public void bfs(int start){
		
		Queue<Integer> queue = new LinkedList();
		
		boolean visited[] = new boolean[nodes];
		
		queue.add(start);
		visited[start] = true;		
		
		while(!queue.isEmpty()){
			int node = queue.remove();
	
			System.out.print(" " + node);
			for(int j = 0; j < nodes; j++){
				if(!visited[j] && matrix[node][j] == 1){
					queue.add(j);
					visited[j] = true;	
				}
				
			}
		}
		
	}
}