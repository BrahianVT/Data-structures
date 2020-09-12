


import brahianVT.graphs.TspDynamicProgrammingIterative;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;


public class TspDynamicProgrammingIterativeTest{
	
	TspDynamicProgrammingIterative test;
	
	
	@Test
	public void testTravelSalesmanProblem(){
		int n = 6;
		
		double[][] distanceMatrix = new double[n][n];
		
		for(double[] row: distanceMatrix)Arrays.fill(row, Double.POSITIVE_INFINITY);
		
		distanceMatrix[5][0] = 10;
		distanceMatrix[1][5] = 12;
		distanceMatrix[4][1] = 2;
		distanceMatrix[2][4] = 4;
		distanceMatrix[3][2] = 6;
		distanceMatrix[0][3] = 8;
		
		int startNode = 0;
		test = new TspDynamicProgrammingIterative(startNode, distanceMatrix);
		
		assertEquals("[0, 3, 2, 4, 1, 5, 0]", Arrays.toString(test.getTour().toArray()));
	}
}