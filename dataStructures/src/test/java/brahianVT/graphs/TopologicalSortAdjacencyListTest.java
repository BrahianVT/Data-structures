

package brahianVT.graphs;
import brahianVT.graphs.TopologicalSortAdjacencyList.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;

public class TopologicalSortAdjacencyListTest{
	
	
	@Test
	public void testTopologicalSort(){
		Map<Integer, List<Edge>> graph = new HashMap<>();
		int n = 7;
		
		for(int i = 0; i < n; i++) graph.put(i, new ArrayList<>());
		
		graph.get(0).add(new Edge(0, 1, 3));
		graph.get(0).add(new Edge(0, 2, 2));
		graph.get(0).add(new Edge(0, 5, 3));
		graph.get(1).add(new Edge(1, 3, 1));
		graph.get(1).add(new Edge(1, 2, 6));
		graph.get(2).add(new Edge(2, 3, 1));
		graph.get(2).add(new Edge(2, 4, 10));
		graph.get(3).add(new Edge(3, 4, 5));
		graph.get(5).add(new Edge(5, 4, 7));
		
		int[] ordering = TopologicalSortAdjacencyList.topologicalSort(graph, n);
		
		assertEquals("[6, 0, 5, 1, 2, 3, 4]", Arrays.toString(ordering));

		Integer[] dists = TopologicalSortAdjacencyList.dagShortestPath(graph, 0, n);
		
		// Find the shortest path from 0 to 4 which is 8
		assertEquals(8, dists[4]);
	}
	
}
