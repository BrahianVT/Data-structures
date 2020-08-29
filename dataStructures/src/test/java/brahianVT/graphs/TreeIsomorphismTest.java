
package brahianVT.graphs;

import brahianVT.graphs.TreeIsomorphism;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.*;

public class TreeIsomorphismTest {
	
	@Test
	public void test(){
		List<List<Integer>> tree1 = TreeIsomorphism.createEmptyGraph(5);
		
		TreeIsomorphism.addUndirectedEdge(tree1, 2, 0);
		TreeIsomorphism.addUndirectedEdge(tree1, 3, 4);
		TreeIsomorphism.addUndirectedEdge(tree1, 2, 1);
		TreeIsomorphism.addUndirectedEdge(tree1, 2, 3);
		
		List<List<Integer>> tree2 = TreeIsomorphism.createEmptyGraph(5);
		
		TreeIsomorphism.addUndirectedEdge(tree2, 1, 0);
		TreeIsomorphism.addUndirectedEdge(tree2, 2, 4);
		TreeIsomorphism.addUndirectedEdge(tree2, 1, 3);
		TreeIsomorphism.addUndirectedEdge(tree2, 1, 2);
		
		assertTrue(TreeIsomorphism.treesAreIsomorphic(tree1, tree2));
	}
	
}