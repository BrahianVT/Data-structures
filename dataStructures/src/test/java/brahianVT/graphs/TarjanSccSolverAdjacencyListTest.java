

import brahianVT.graphs.TarjanSccSolverAdjacencyList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;



public class TarjanSccSolverAdjacencyListTest{
	
	List<List<Integer>> graph;
	int n = 8;
	
	TarjanSccSolverAdjacencyList solver;
	
	@BeforeEach
	public void setup(){
		graph = TarjanSccSolverAdjacencyList.createGraph(n);
		
		TarjanSccSolverAdjacencyList.addEdge(graph, 6, 0);
		TarjanSccSolverAdjacencyList.addEdge(graph, 6, 2);
		TarjanSccSolverAdjacencyList.addEdge(graph, 3, 4);
		TarjanSccSolverAdjacencyList.addEdge(graph, 6, 4);
		TarjanSccSolverAdjacencyList.addEdge(graph, 2, 0);
		TarjanSccSolverAdjacencyList.addEdge(graph, 0, 1);
		TarjanSccSolverAdjacencyList.addEdge(graph, 4, 5);
		TarjanSccSolverAdjacencyList.addEdge(graph, 5, 6);
		TarjanSccSolverAdjacencyList.addEdge(graph, 3, 7);
		TarjanSccSolverAdjacencyList.addEdge(graph, 7, 5);
		TarjanSccSolverAdjacencyList.addEdge(graph, 1, 2);
		TarjanSccSolverAdjacencyList.addEdge(graph, 7, 3);
		TarjanSccSolverAdjacencyList.addEdge(graph, 5, 0);
		
		solver = new TarjanSccSolverAdjacencyList(graph);
	}
	
	@Test
	public void testTarjanScc(){
		
		int[] sccs = solver.getSccs();
		
		

		assertEquals(0, sccs[0]);
		assertEquals(0, sccs[1]);
		assertEquals(0, sccs[2]);
		
		assertEquals(3, sccs[3]);
		assertEquals(3, sccs[7]);
		
		assertEquals(4, sccs[4]);
		assertEquals(4, sccs[5]);
		assertEquals(4, sccs[6]);
	}
}