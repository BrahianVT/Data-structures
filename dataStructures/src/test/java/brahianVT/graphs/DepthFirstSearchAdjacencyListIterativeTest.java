

package brahianVT.graphs;

import brahianVT.graphs.DepthFirstSearchAdjacencyListIterative;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayOutputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.PrintStream;
import java.util.*;

public class DepthFirstSearchAdjacencyListIterativeTest{
	
	DepthFirstSearchAdjacencyListIterative test;
	
	@BeforeEach
	public void setup(){
		test = new DepthFirstSearchAdjacencyListIterative();
	}
	
	
	@Test
	public void add(){
		test.addDirectedEdge(1,2,5);
		
		assertEquals(2, test.size());
	}
	
	@Test
	public void addAndDfs(){
		int edges = 5;
		
		// Create a fully connected graph
    //           (0)
    //           / \
    //        5 /   \ 4
    //         /     \
    // 10     <   -2  >
    //   +->(2)<------(1)      (4)
    //   +--- \       /
    //         \     /
    //        1 \   / 6
    //           > <
    //           (3)
	
		test.addDirectedEdge(0,1,4);
		test.addDirectedEdge(0,2,5);
		test.addDirectedEdge(1,2,-2);
		test.addDirectedEdge(1,3,6);
		test.addDirectedEdge(2,3,1);
		test.addDirectedEdge(2,2,10); // self loop
		
		assertEquals(4, test.size());
		
		ByteArrayOutputStream out = null;
		PrintStream streamTest = System.out;
		
		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		test.dfs(0, edges);
		
		assertEquals(" 0 1 2 3", out.toString());
		
		System.setOut(streamTest);
	}
}