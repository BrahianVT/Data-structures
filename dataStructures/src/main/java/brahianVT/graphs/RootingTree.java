

package brahianVT.graphs;

/**
	Converts a graph with undirected edges to a rooted tree
	TC: O(V + E)
	@author Brahian VT
*/

import java.util.*;

public class RootingTree{
	private static class TreeNode{
		private int id;
		private TreeNode parent;
		private List<TreeNode> children;
		
		public TreeNode(int id){ this(id, null); }
		
		public TreeNode(int id, TreeNode parent){
			this.id = id;
			this.parent = parent;
			children = new LinkedList<>();
		}
		
		public void addChilden(TreeNode... nodes){
			for(TreeNode node: nodes){
				children.add(node);
			}
		}
		
		public int id(){ return id; }
		
		public TreeNode parent(){ return parent; }
		
		public List<TreeNode> children(){
			return children;
		}
		
		@Override
		public String toString(){ return String.valueOf(id); }
		
		@Override
		public boolean equals(Object obj){
			if(obj instanceof TreeNode){
				return id() == ((TreeNode)obj).id();
			}
			return false;
		}
	}
	
	
	public static TreeNode rootTree(List<List<Integer>> graph, int rootId){
		TreeNode root = new TreeNode(rootId);
		return buildTree(graph, root);
	}
	
	public static TreeNode buildTree(List<List<Integer>> graph, TreeNode node){
		for(int childId: graph.get(node.id)){
			
			if(node.parent() != null && childId == node.parent().id()){
				continue;
			}
			
			TreeNode child = new TreeNode(childId, node);
			node.addChilden(child);
			buildTree(graph, child);
		}
		
		return node;
	}
	
	public static List<List<Integer>> createGraph(int n){
		List<List<Integer>> graph = new ArrayList(n);
		for(int i = 0; i < n; i++) graph.add(new LinkedList<>());
		
		return graph;
	}
	
	public void addUndirectedEdge(List<List<Integer>> graph, int from, int to){
		graph.get(from).add(to);
		graph.get(to).add(from);
	}
}