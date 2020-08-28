
package brahianVT.graphs;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayOutputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.PrintStream;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import brahianVT.graphs.ConnectedComponentsDfsSolverAdjacencyList;


public class ConnectedComponentsDfsSolverAdjacencyListTest{
	
	ConnectedComponentsDfsSolverAdjacencyList test;
	List<List<Integer>> graph;
	int n;
	@BeforeEach
	public void setup(){

		int n = 11;
		graph = ConnectedComponentsDfsSolverAdjacencyList.createGraph(n);
		// Setup a graph with five connected components:
		// {0,1,7}, {2,5}, {4,8}, {3,6,9}, {10}
		ConnectedComponentsDfsSolverAdjacencyList.addUndirectedEdge(graph, 0, 1);
		ConnectedComponentsDfsSolverAdjacencyList.addUndirectedEdge(graph, 1, 7);
		ConnectedComponentsDfsSolverAdjacencyList.addUndirectedEdge(graph, 7, 0);
		ConnectedComponentsDfsSolverAdjacencyList.addUndirectedEdge(graph, 2, 5);
		ConnectedComponentsDfsSolverAdjacencyList.addUndirectedEdge(graph, 4, 8);
		ConnectedComponentsDfsSolverAdjacencyList.addUndirectedEdge(graph, 3, 6);
		ConnectedComponentsDfsSolverAdjacencyList.addUndirectedEdge(graph, 6, 9);
	}
	
	@Test
	public void test1(){
		test = new ConnectedComponentsDfsSolverAdjacencyList(graph);
		int count  = test.countComponents();
		
		assertEquals(count, 5);
		
		int[] res = { 1, 1, 2, 3, 4, 2, 3, 1, 4, 3, 5};
		
		int[] output = test.getComponents();
		
		assertArrayEquals(res, output);
	}
	
}