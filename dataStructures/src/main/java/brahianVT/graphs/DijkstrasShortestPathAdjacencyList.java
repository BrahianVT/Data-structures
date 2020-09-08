package brahianVT.graphs;

/**
	Implementation of Dijkstra's shortest path algorithm from  a start node 
	to a specific ending node.
*/
import java.util.*;

public class DijkstrasShortestPathAdjacencyList{
	
	private static final double EPS = 1e-6;
	
	public static class Edge {
		int from, to;
		double cost;
		
		public Edge(int from, int to, double c){
			this.from = from;
			this.to = to;
			cost = c;
		}
	}
	
	public static class Node{
		int id;
		double value;
		public Node(int id, double value){
			this.id = id;
			this.value = value;
			
		}
	}
	private int n;
	private double[] dist;
	private Integer[] prev;
	private List<List<Edge>> graph;
	
	private Comparator<Node> comparator = new Comparator<Node>(){
		@Override
		public int compare(Node node1, Node node2){
			if(Math.abs(node1.value - node2.value) < EPS) return 0;
			return (node1.value - node2.value) >0 ? +1: -1;
		}
	};
	
	public DijkstrasShortestPathAdjacencyList(int n){
		this.n = n;
		createEmptyGraph();
	}
	
	public DijkstrasShortestPathAdjacencyList(int n, Comparator<Node> comparator){
		this(n);
		if(comparator == null) throw new IllegalArgumentException("Comparator can not be null");
		this.comparator = comparator;
	}
	
	private void createEmptyGraph(){
		graph = new ArrayList<>(n);
		for(int i = 0; i < n; i++)graph.add(new ArrayList<>());
	}
	public void addEdge(int from, int to, int cost){
		graph.get(from).add(new Edge(from, to, cost));
	}
	
	public List<List<Edge>> getGraph(){return graph; }
	
	public List<Integer> recostructPath(int start, int end){
		if(end  < 0 || end >= n) throw new IllegalArgumentException("Invalid node index end");
		if(start < 0 || start >= n) throw new IllegalArgumentException(" Invalid node index start");
		
		double dist = dijkstra(start, end);
		List<Integer> path = new ArrayList();
				if(dist == Double.POSITIVE_INFINITY) return path;
		for(Integer at = end; at != null; at = prev[at])path.add(at);
		Collections.reverse(path);
		return path;
	}
	
	public double dijkstra(int start, int end){
		dist = new double[n];
		Arrays.fill(dist, Double.POSITIVE_INFINITY);
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>(2* n, comparator);
		
		pq.offer(new Node(start, 0));
		boolean[] visited = new boolean[n];
		prev = new Integer[n];
		
		while(!pq.isEmpty()){
			Node node = pq.poll();
			visited[node.id] = true;
			
			if(dist[node.id] < node.value)continue;
			
			List<Edge> edges = graph.get(node.id);
			for(int i = 0; i < edges.size(); i++){
				Edge e = edges.get(i);
				
				if(visited[e.to])continue;
				
				double newDist = dist[e.from] + e.cost;
				if(newDist < dist[e.to]){
					prev[e.to] = e.from;
					dist[e.to] = newDist;
					pq.offer(new Node(e.to, newDist));
				}
			}
			
			if(node.id == end)return dist[end];
			
		}
		
		return Double.POSITIVE_INFINITY;
	}
}