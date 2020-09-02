package brahianVT.graphs;

/**
	Implementation of finding the Lowest Common Acestor (LCA) of a tree.This impl first
	finds an Euler tour from the root node which visits all the nodes in the tree.
	The node height values obtained from the Euler tour can then be used in combination with
	a sparse table to find the  LCA.
*/
import java.util.*;


public class LowestCommonAncestorEulerTour{
	
	public static class TreeNode {
		
		private int n;
		private int index;
		private TreeNode parent;
		private List<TreeNode> children;

		
		public TreeNode(int index){
			this(index, null);
		}
		
		public TreeNode(int index, TreeNode parent){
			this.index = index;
			this.parent = parent;
			children = new LinkedList<>();
		}
		
		public void addChildren(TreeNode... nodes){
			for(TreeNode i : nodes){
				children.add(i);
			}
		}
		
		public int index(){ return index; }
		public void setSize(int n){ this.n = n; }
		
		public int getSize(){ return n; }
		
		public TreeNode getParent(){ return parent; }
		
		public List<TreeNode> children(){
			return children;
		}
		
		public static TreeNode rootTree(List<List <Integer>> graph, int rootId){
			
			TreeNode root = new TreeNode(rootId);
			TreeNode rootedTree = buildTree(graph, root);
			
			if(rootedTree.getSize() < graph.size()){ System.out.println(" Something goes wrong ! "); }
			
			return rootedTree;
		}
		
		private static TreeNode buildTree(List<List<Integer>> graph, TreeNode node){
			
			int subtreeNodeCount = 1;
			
			for(int neighbor: graph.get(node.index())){
				
				if(node.getParent() != null && neighbor == node.getParent().index()){
					continue;
				}
				
				TreeNode child = new TreeNode(neighbor, node);
				node.addChildren(child);
				
				buildTree(graph, child);
				subtreeNodeCount += child.getSize();
			}
			node.setSize(subtreeNodeCount);
			
			return node;
		}
	}
	
	private final int n;
	
	private int tourIndex = 0;
	
	private long[] nodeDepth;
	private TreeNode[] nodeOrder;
	
	private int[] last;
	
	private MinSparseTable sparseTable;
	
	public static List<List<Integer>> createEmptyGraph(int n){
		List<List<Integer>> graph = new ArrayList(n);
		
		for(int i = 0; i < n; i++)graph.add(new LinkedList<>());
		return graph;
	}
	
	
	public static void addUndirectedEdge(List<List<Integer>> graph, int from, int to){
		graph.get(from).add(to);
		graph.get(to).add(from);
	}
	
	public LowestCommonAncestorEulerTour(TreeNode root){
		n = root.getSize(); 
		setup(root);
	}
	
	private void setup(TreeNode root){
		int eulerTourSize = 2 * n -1;
		nodeOrder = new TreeNode[eulerTourSize];
		nodeDepth = new long[eulerTourSize];
		
		last =  new int[n];
		
		// Do depth first search to construct euler tour
		dfs(root, 0);
		
		sparseTable = new MinSparseTable(nodeDepth);
	}
	
	
	private void dfs(TreeNode node, long depth){
		if( node == null){ return; }
		
		visit(node, depth);
		for(TreeNode child: node.children()){
			dfs(child, depth + 1);
			visit(node, depth);
		}
	}
	
	private void visit(TreeNode node, long depth){
		nodeOrder[tourIndex] = node;
		nodeDepth[tourIndex] = depth;
		last[node.index()] = tourIndex;
		tourIndex++;
	}
	
	public TreeNode lca(int index1, int index2){
		int l = Math.min(last[index1], last[index2]);
		int r = Math.max(last[index1], last[index2]);
		
		int i = sparseTable.queryIndex(l, r);
		
		return nodeOrder[i];
	}
	
	
	// Sparse table for efficient minimum range queries in O(1) with O(nlogn) space
private static class MinSparseTable{
	
	// Number of elements in the original input array
	private int n;
	
	// The maximum power of 2 needed. This value is floor(log(n))
	private int P;
	
	//fast log base 2 logarithm lookup table , 1 <= i <= n
	private int[] log2;
	
	// sparse table
	private long[][] dp;
	
	//Index table (IT) associated with the values in the sparse table
	private int[][] it;
	
	public MinSparseTable(long[] values){
		init(values);
	}
	
	private void init(long[] v){
		n = v.length;
		P = (int) (Math.log(n)/ Math.log(2));
		dp = new long[P + 1][n];
		it = new int[P + 1][n];	
		
		for(int i = 0; i < v.length; i++){
			dp[0][i] = v[i];
			it[0][i] = i;
		}
		
		log2 = new int[n + 1];
		for(int i = 2; i <= n; i++){
			log2[i] = log2[i / 2] + 1;
			
		}
		
		//Build sparse table combining the values of the previous intervals
		
		for(int p = 1; p <= P; p++){
			for(int i = 0; i + (1 << p) <= n; i++){
				
				long leftInterval = dp[p -1][i];
				long rightInterval = dp[p - 1][i + (1 << (p -1))];
				dp[p][i] = Math.min(leftInterval, rightInterval);
				
				if(leftInterval <= rightInterval){
					it[p][i] = it[p - 1][i];
					
				} else {
					it[p][i] = it[p -1][i + (1 << (p - 1))];
				}
			}
		}
	}
	
	public int queryIndex(int l ,int r){
		int len = r -1 + 1;
		int p = log2[r - l + 1];
		long leftInterval = dp[p][l];
		long rightInterval = dp[p][r - (1 << p) + 1];
		if(leftInterval <= rightInterval){
			return it[p][l];
		} else {
			return it[p][r - (1 << p) + 1];
		}
	}
	
	}
	
	
}

