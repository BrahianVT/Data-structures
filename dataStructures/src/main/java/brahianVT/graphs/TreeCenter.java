
package brahianVT.graphs;

/**
	Algorithm that find the center(s) of a tree
	TC: O(V + E)
	@author Brahian VT
*/

import java.util.*;


public class TreeCenter	{

	public static List<Integer> findTreeCenter( List<List<Integer>> tree){
		final int = n = tree.size();
		int[] degree = new int[n];
		
		List<Integer> leaves = new ArrayList<>();
		
		for(int i = 0; i < n; i++){
			List<Integer> edges = tree.get(i);
			degree[i] = edges.size();
			if(degree[i] <= 1){
				leaves.add(i);
				degree[i] = 0;
			}
		}
		
		int processedLeafs = leaves.size();
		
		while(processedLeafs < n){
			List<Integer> newLeaves = new ArrayList<>();
			for(int node : leaves){
				for(int neighbor : tree.get(node)){
					if(--degree[neighbor] == 1){
						newLeaves.add(neighbor);
					}
				}
				degree[node] = 0;
			}
			processedLeafs += newLeaves.size();
			leaves = newLeaves;
		}
		
		return leaves;
	}

	public static List<List<Integer>> createEmptyTree(int n){
		List<List<Integer>> tree = new ArrayList(n);
		for(int i = 0; i < n; i++) tree.add(new LinkedList<>());
		
		return tree;
	}
	
	public static void addUndirectedEdge(List<List<Integer>> tree, int from, int to){
		tree.get(from).add(to);
		tree.get(to).add(from);
	}
}