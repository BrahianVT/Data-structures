

package brahianVT.graphs;

import brahianVT.graphs.TreeCenterTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;

public class TreeCenterTest{
	
	TreeCenter test;
	List<List<Integer>> graph;
	@BeforeEach
	public void setup(){
		graph = TreeCenter.createEmptyTree(9);
	}
	
	
	@Test
	public void test(){
		TreeCenter.addUndirectedEdge(graph, 0, 1);
		TreeCenter.addUndirectedEdge(graph, 2, 1);
		TreeCenter.addUndirectedEdge(graph, 2, 3);
		TreeCenter.addUndirectedEdge(graph, 3, 4);
		TreeCenter.addUndirectedEdge(graph, 5, 3);
		TreeCenter.addUndirectedEdge(graph, 2, 6);
		TreeCenter.addUndirectedEdge(graph, 6, 7);
		TreeCenter.addUndirectedEdge(graph, 6, 8);
		
		List<Integer> rootTree =  Arrays.asList(2);
		List<Integer> res = TreeCenter.findTreeCenter(graph);
		
		for(int i = 0; i < res.size(); i++){
			assertEquals(rootTree.get(i), res.get(i));
		}
	}
}