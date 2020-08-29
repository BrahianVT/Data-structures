
package brahianVT.graphs;

/**
	Test if two unrooted trees are isomorphic 
	TC: O(V + E) for each tree
	@author Brahian VT
*/

import java.util.*;

public class TreeIsomorphism{
	
	
	public static class TreeNode{
		private int id;
		private TreeNode parent;
		private List<TreeNode> children;
		
		public TreeNode(int id){ this(id, null); }
		
		public TreeNode(int id, TreeNode parent){
			this.id = id;
			this.parent = parent;
			children = new LinkedList<>();
		}
		
		public void addChildren(TreeNode... nodes){
			for(TreeNode node: nodes){
				children.add(node);
			}
		}
		
		public int id(){ return id; }
		
		public TreeNode parent(){ return parent; }
		
		public List<TreeNode> children(){ return children; }
		
		@Override public String toString(){ return String.valueOf(id); }
	}
	
	
	
	public static boolean treesAreIsomorphic(List<List<Integer>> tree1, List<List<Integer>> tree2){
		if(tree1.isEmpty() || tree2.isEmpty()){
			throw new IllegalArgumentException("Empty tree in the input");
		}
		
		List<Integer> centers1 = findTreeCenter(tree1);
		List<Integer> centers2 = findTreeCenter(tree2);
		
		TreeNode rootedTree1 = rootTree(tree1, centers1.get(0));
		String tree1Encoding = encode(rootedTree1);
		
		for(int center: centers2){
			
			TreeNode rootedTree2 = rootTree(tree1, center);
			
			String tree2Enconding = encode(rootedTree1);
			if(tree1Encoding.equals(tree2Enconding)){ return true; }
			
			
		}
		
		
		return false;
	}
	
	private static List<Integer> findTreeCenter(List<List<Integer>> tree){
		int n = tree.size();
		
		int[] degree = new int[n];
		
		List<Integer> leaves = new ArrayList();
		
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
			List<Integer> newLeaves  = new ArrayList();
			for(int node: leaves){
				for(int neighbor: tree.get(node)){
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
	
	private static TreeNode rootTree(List<List<Integer>> graph, int rootId){
		
		TreeNode root = new TreeNode(rootId);
		
		return buildTree(graph, root);
	}
	
	private static TreeNode buildTree(List<List<Integer>> graph, TreeNode node){
		
		for(int neighbor: graph.get(node.id())){
			
			if(node.parent() != null && neighbor == node.parent().id()){ continue; }
			
			TreeNode child = new TreeNode(neighbor, node);
			node.addChildren(child);
			
			buildTree(graph, child);
		}
		
		return node;
	}
	
	
	public static String encode(TreeNode node){
		if(node == null){ return ""; }
		
		List<String> labels = new LinkedList();
		
		for(TreeNode child: node.children()){
			labels.add(encode(child));
		}
		
		Collections.sort(labels);
		StringBuilder sb = new StringBuilder();
		for(String label: labels){
			sb.append(label);
		}
		
		return "(" + sb.toString() + ")";
	}


	public static List<List<Integer>> createEmptyGraph(int n){
		List<List<Integer>> graph = new ArrayList();
		for(int i = 0; i < n; i++) graph.add(new LinkedList());
		
		return graph;
	}
	
	public static void addUndirectedEdge(List<List<Integer>> graph, int from, int to){
		
		graph.get(from).add(to);
		graph.get(to).add(from);
	}
}