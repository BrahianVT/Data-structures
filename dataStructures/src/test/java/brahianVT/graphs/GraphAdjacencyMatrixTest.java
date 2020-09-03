
package brahianVT.graphs;

import brahianVT.graphs.GraphAdjacencyMatrix;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;

public class GraphAdjacencyMatrixTest{
	
	int nodes = 5;
	private GraphAdjacencyMatrix test;
	
	@BeforeEach
	public void setup(){
		test = new GraphAdjacencyMatrix(nodes); 
	}
	
	
	@Test
	public void testGraphAdjacencyMatrix(){
		List<List<Integer>> adjacencyMatrix = new ArrayList();
		

		
		List aux = new ArrayList();
				// First list will represent node 0 and so on and so forth
		aux = Arrays.asList(1,4);   adjacencyMatrix.add(new ArrayList(aux));
		aux = Arrays.asList(2,3,4);   adjacencyMatrix.add(new ArrayList(aux));
		aux = Arrays.asList(3);   adjacencyMatrix.add(new ArrayList(aux));
		aux = Arrays.asList(4);   adjacencyMatrix.add(new ArrayList(aux));


		for(int i = 0; i < adjacencyMatrix.size(); i++){
			
			for(Integer indx : adjacencyMatrix.get(i)){
				test.addEdge(i, indx);
			}
		}
		
		
		List<List<Integer>> resAdjacency = new ArrayList();
		
		aux = Arrays.asList(1,4);   resAdjacency.add(new ArrayList(aux));
		aux = Arrays.asList(0,2,3,4);   resAdjacency.add(new ArrayList(aux));
		aux = Arrays.asList(1,3);   resAdjacency.add(new ArrayList(aux));
		aux = Arrays.asList(1,2,4);   resAdjacency.add(new ArrayList(aux));
		aux = Arrays.asList(0,1,3);   resAdjacency.add(new ArrayList(aux));
		
		List<List<Integer>> resAdjacencyList = test.getAdjacencyList();
		
		for(int i = 0; i < resAdjacencyList.size(); i++){
			
			for(int j = 0; j < resAdjacencyList.get(i).size(); j++){
				assertEquals(resAdjacency.get(i).get(j), resAdjacencyList.get(i).get(j));
			
			}
		}
	}
}