package brahianVT.graphs;

/**
	Implementation of the Bellman-Ford algorithm and it finds the shortest path
	between a starting node and all other nodes in the graph.
	The algorithm also detects negatives cycles.
*/
public class BellmanFordEdgeList{
	
	
	public static class Edge{
		double cost;
		int from, to;
		
		public Edge(int from, int to, double cost){
			this.to = to;
			this.from = from;
			this.cost = cost;
		}
	}
	
	public static double[] bellmanFord(Edge[] edges, int V, int start){
		
		double[] dist = new double[V];
		
		java.util.Arrays.fill(dist, Double.POSITIVE_INFINITY);
		
		dist[start] = 0;
		
		boolean relaxedAnEdge = true;
		
		for(int v = 0; v < V - 1 && relaxedAnEdge; v++){
			relaxedAnEdge = false;
			for(Edge edge: edges){
				if(dist[edge.from] + edge.cost < dist[edge.to]){
					dist[edge.to] = dist[edge.from] + edge.cost;
					relaxedAnEdge = true;
				}
			}
		}
		
		relaxedAnEdge = true;
		
		for(int v = 0; v < V -1 && relaxedAnEdge; v++){
			relaxedAnEdge = false;
			for(Edge edge: edges){
				if(dist[edge.from] + edge.cost < dist[edge.to]){
					dist[edge.to] = Double.NEGATIVE_INFINITY;
					relaxedAnEdge = true;
				}
			}
			
		}
		
		return dist;
	}
}