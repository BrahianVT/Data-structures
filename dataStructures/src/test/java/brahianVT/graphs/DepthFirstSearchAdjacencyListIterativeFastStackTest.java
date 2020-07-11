
package brahianVT.graphs;

import brahianVT.graphs.DepthFirstSearchAdjacencyListIterativeFastStack;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayOutputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.PrintStream;
import java.util.*;


public class DepthFirstSearchAdjacencyListIterativeFastStackTest{

	DepthFirstSearchAdjacencyListIterativeFastStack test;
	
	@BeforeEach
	public void setup(){
		test = new DepthFirstSearchAdjacencyListIterativeFastStack();
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
		
		
		ByteArrayOutputStream out = null;
		PrintStream streamTest = System.out;
		
		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		test.dfs(0, edges);
		
		assertEquals(" 0 1 2 3", out.toString());
		
		System.setOut(streamTest);
	}	
}