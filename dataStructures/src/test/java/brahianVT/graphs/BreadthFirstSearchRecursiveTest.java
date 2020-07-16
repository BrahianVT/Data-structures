package brahianVT.graphs;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayOutputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.PrintStream;
import java.util.*;

import brahianVT.graphs.BreadthFirstSearchRecursive;
public class BreadthFirstSearchRecursiveTest{
	
	BreadthFirstSearchRecursive test;
	

	@Test
	public void testBFS(){
		int n = 14;
		test = new BreadthFirstSearchRecursive(n);
		
		test.addUndirectedEdge(0, 1);
		test.addUndirectedEdge(0, 2);
		test.addUndirectedEdge(0, 3);
		test.addUndirectedEdge(2, 9);
		test.addUndirectedEdge(8, 2);
		test.addUndirectedEdge(3, 4);
		test.addUndirectedEdge(10, 11);
		test.addUndirectedEdge(12, 13);
		test.addUndirectedEdge(3, 5);
		test.addUndirectedEdge(5, 7);
		test.addUndirectedEdge(5, 6);
		test.addUndirectedEdge(0, 10);
		test.addUndirectedEdge(11, 12);
		
		ByteArrayOutputStream out = null;
		PrintStream streamTest = System.out;
		
		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		test.bfs(0, n);
		
		assertEquals(" 0 1 2 3 10 9 4 5 11 7 6 12 13", out.toString());
	}
}