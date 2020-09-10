
import brahianVT.graphs.FloydWarshallSolver.*;
import brahianVT.graphs.FloydWarshallSolver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;


public class FloydWarshallSolverTest{
	int n = 7;
	double[][] m;
	FloydWarshallSolver solver; 
	@BeforeEach
	public void setup(){
		m = FloydWarshallSolver.createGraph(n);
		
		m[0][1] = 2;
		m[0][2] = 5;
		m[0][6] = 10;
		m[1][2] = 2;
		m[1][4] = 11;
		m[2][6] = 2;
		m[6][5] = 11;
		m[4][5] = 1;
		m[5][4] = -2;
			
				
		solver = new FloydWarshallSolver(m);
	}
	
	@Test
	public void testFloydWarshall(){
		int n = 7;
		double[][] m = FloydWarshallSolver.createGraph(n);
		
		m[0][1] = 2;
		m[0][2] = 5;
		m[0][6] = 10;
		m[1][2] = 2;
		m[1][4] = 11;
		m[2][6] = 2;
		m[6][5] = 11;
		m[4][5] = 1;
		m[5][4] = -2;

		
		double[][] dist = solver.getApspMatrix();
		
		assertEquals(2.0, dist[0][1]);
		assertEquals(Double.POSITIVE_INFINITY, dist[0][3]);
		assertEquals(0.0, dist[1][1]);
		assertEquals(Double.POSITIVE_INFINITY, dist[1][3]);
	}
	
	
	@Test 
	public void testShortestPath(){
		List<Integer> path =  solver.reconstructShortestPath(1, 6);
		
		
		assertEquals("[1, 2, 6]",Arrays.toString(path.toArray()));
		
	}
}