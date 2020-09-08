
package brahianVT.graphs;

import brahianVT.graphs.DijkstrasShortestPathAdjacencyList;
import brahianVT.graphs.DijkstrasShortestPathAdjacencyList.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;

public class DijkstrasShortestPathAdjacencyListTest{
	
	DijkstrasShortestPathAdjacencyList test;
	int n = 7;
	
	@BeforeEach
	public void setup(){
		test = new DijkstrasShortestPathAdjacencyList(n);
	}
	
	
	@Test
	public void testDijkstra(){
		
		test.addEdge(0, 1, 3);
		test.addEdge(0, 2, 2);
		test.addEdge(0, 5, 3);
		test.addEdge(1, 3, 1);
		test.addEdge(1, 2, 6);
		test.addEdge(2, 3, 1);
		test.addEdge(2, 4, 10);
		test.addEdge(3, 4, 5);
		test.addEdge(5, 4, 7);
		
		List<List<Edge>> graph = test.getGraph();
		double res = test.dijkstra(0, 4);
	
		assertEquals(8.0, res);
		
		List<Integer> path = test.recostructPath(0,4);
		
		assertEquals("[0, 2, 3, 4]", Arrays.toString(path.toArray()));
		
	} 
}