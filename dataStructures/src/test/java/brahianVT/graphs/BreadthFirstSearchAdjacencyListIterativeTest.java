package brahianVT.graphs;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayOutputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.io.PrintStream;
import java.util.*;

import brahianVT.graphs.BreadthFirstSearchAdjacencyListIterative;

public class BreadthFirstSearchAdjacencyListIterativeTest{
	
	BreadthFirstSearchAdjacencyListIterative test;
	
	@BeforeEach
	public void setup(){
		test = new BreadthFirstSearchAdjacencyListIterative();
	}
	
	@Test
	public void testBFS(){
		
		final int n = 13;
		test.createEmptyGraph(n);
		
		test.addUnweightedUndirectedEdge(0, 9);
		test.addUnweightedUndirectedEdge(0, 7);
		test.addUnweightedUndirectedEdge(0, 11);
		test.addUnweightedUndirectedEdge(7, 11);
		test.addUnweightedUndirectedEdge(7, 6);
		test.addUnweightedUndirectedEdge(7, 3);	
		test.addUnweightedUndirectedEdge(6, 5);
		test.addUnweightedUndirectedEdge(2, 3);
		test.addUnweightedUndirectedEdge(3, 4);
		test.addUnweightedUndirectedEdge(2, 12);
		test.addUnweightedUndirectedEdge(12, 8);
		test.addUnweightedUndirectedEdge(8, 1);
		test.addUnweightedUndirectedEdge(1, 10);
		test.addUnweightedUndirectedEdge(10, 9);
		test.addUnweightedUndirectedEdge(9, 8);	
		test.addUnweightedUndirectedEdge(9, 10);		
		
		ByteArrayOutputStream out = null;
		PrintStream streamTest = System.out;
		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		test.bfs(0);
		
		assertEquals(" 0 9 7 11 10 8 6 3 1 12 5 2 4", out.toString());
		
		System.setOut(streamTest);
	}
	
	@Test
	public void testReconstructPath(){
		int start = 10, end = 5 ;
		test.createEmptyGraph(13);
		
		test.addUnweightedUndirectedEdge(0, 9);
		test.addUnweightedUndirectedEdge(0, 7);
		test.addUnweightedUndirectedEdge(0, 11);
		test.addUnweightedUndirectedEdge(7, 11);
		test.addUnweightedUndirectedEdge(7, 6);
		test.addUnweightedUndirectedEdge(7, 3);	
		test.addUnweightedUndirectedEdge(6, 5);
		test.addUnweightedUndirectedEdge(2, 3);
		test.addUnweightedUndirectedEdge(3, 4);
		test.addUnweightedUndirectedEdge(2, 12);
		test.addUnweightedUndirectedEdge(12, 8);
		test.addUnweightedUndirectedEdge(8, 1);
		test.addUnweightedUndirectedEdge(1, 10);
		test.addUnweightedUndirectedEdge(10, 9);
		test.addUnweightedUndirectedEdge(9, 8);
		test.addUnweightedUndirectedEdge(9, 10);	
		
		List<Integer> path = test.reconstructPath(start,end);
		int[] res = {10, 9, 0, 7, 6, 5};
		
		int[] pathArray = path.stream().mapToInt( i -> i).toArray();
		
		assertArrayEquals(res, pathArray);
		
	}
}