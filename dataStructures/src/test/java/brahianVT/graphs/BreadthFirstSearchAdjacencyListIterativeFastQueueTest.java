package brahianVT.graphs;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayOutputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.PrintStream;
import java.util.*;

import brahianVT.graphs.BreadthFirstSearchAdjacencyListIterativeFastQueue;


public class BreadthFirstSearchAdjacencyListIterativeFastQueueTest{
	
	BreadthFirstSearchAdjacencyListIterativeFastQueue test;
	
	@BeforeEach
	public void setup(){
		test = new BreadthFirstSearchAdjacencyListIterativeFastQueue();
	}
	
	@Test
	public void testBFS(){
		
		
		// Create a fully connected graph
		int numNodes = 8;
		
		test.addDirectedEdge(1,2,1);
		test.addDirectedEdge(1,2,1);  // double edge
		test.addDirectedEdge(1,3,1);
		test.addDirectedEdge(2,4,1);
		test.addDirectedEdge(2,5,1);
		test.addDirectedEdge(3,6,1);
		test.addDirectedEdge(3,7,1);
		test.addDirectedEdge(2,2,1);  // Self loop
		test.addDirectedEdge(2,3,1);
		test.addDirectedEdge(6,2,1);
		test.addDirectedEdge(1,6,1);
		
		ByteArrayOutputStream out = null;
		PrintStream streamTest = System.out;
		
		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		test.bfs(1, numNodes);
		
		assertEquals(" 1 2 3 6 4 5 7", out.toString());
		
		
		
	}
	
}