import brahianVT.graphs.BellmanFordEdgeList.*;
import brahianVT.graphs.BellmanFordEdgeList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;

public class BellmanFordEdgeListTest{
	
	int E = 10, V = 9, start = 0;
	Edge[] edges = new Edge[E];
	
	@BeforeEach
	public void setup(){
		edges = new Edge[E];
		
		edges[0] = new Edge(0, 1, 1);
		edges[1] = new Edge(1, 2, 1);
		edges[2] = new Edge(2, 4, 1);
		edges[3] = new Edge(4, 3, -3);
		edges[4] = new Edge(3, 2, 1);
		edges[5] = new Edge(1, 5, 4);
		edges[6] = new Edge(1, 6, 4);
		edges[7] = new Edge(5, 6, 5);
		edges[8] = new Edge(6, 7, 4);
		edges[9] = new Edge(5, 7, 3);
	}
	
	@Test
	public void testBellmanFord(){
		
		double[] res = BellmanFordEdgeList.bellmanFord(edges, V, start);
		// from 0 to 0 
		assertEquals(0.0, res[0]);
		
		// from 0 to 2  a cycle found
		assertEquals(Double.NEGATIVE_INFINITY, res[2]);
		
		// from 0 to 7  a cycle found
		assertEquals(8.0, res[7]);
	}
}

