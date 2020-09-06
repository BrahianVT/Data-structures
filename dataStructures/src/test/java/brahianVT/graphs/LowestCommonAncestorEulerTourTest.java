
package brahianVT.graphs;

import brahianVT.graphs.LowestCommonAncestorEulerTour;
import static brahianVT.graphs.LowestCommonAncestorEulerTour.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;

public class LowestCommonAncestorEulerTourTest{
	
	LowestCommonAncestorEulerTour test;
	List<List<Integer>> tree;
	int n = 17;
	TreeNode root;
	
	@BeforeEach
	public void setup(){
		tree = LowestCommonAncestorEulerTour.createEmptyGraph(n);
		
		LowestCommonAncestorEulerTour.addUndirectedEdge(tree, 0, 1);
		LowestCommonAncestorEulerTour.addUndirectedEdge(tree, 0, 2);
		LowestCommonAncestorEulerTour.addUndirectedEdge(tree, 1, 3);
		LowestCommonAncestorEulerTour.addUndirectedEdge(tree, 1, 4);
		LowestCommonAncestorEulerTour.addUndirectedEdge(tree, 2, 5);
		LowestCommonAncestorEulerTour.addUndirectedEdge(tree, 2, 6);
		LowestCommonAncestorEulerTour.addUndirectedEdge(tree, 2, 7);
		LowestCommonAncestorEulerTour.addUndirectedEdge(tree, 3, 8);
		LowestCommonAncestorEulerTour.addUndirectedEdge(tree, 3, 9);
		LowestCommonAncestorEulerTour.addUndirectedEdge(tree, 5, 10);
		LowestCommonAncestorEulerTour.addUndirectedEdge(tree, 5, 11);
		LowestCommonAncestorEulerTour.addUndirectedEdge(tree, 7, 12);
		LowestCommonAncestorEulerTour.addUndirectedEdge(tree, 7, 13);
		LowestCommonAncestorEulerTour.addUndirectedEdge(tree, 11, 14);
		LowestCommonAncestorEulerTour.addUndirectedEdge(tree, 11, 15);
		LowestCommonAncestorEulerTour.addUndirectedEdge(tree, 11, 16);
		
		root = TreeNode.rootTree(tree, 0);		
	}
	
	
	@Test
	public void test(){
		
		LowestCommonAncestorEulerTour solver = new LowestCommonAncestorEulerTour(root);
		TreeNode lca = solver.lca(13, 14);
		assertEquals(lca.index(), 2);

		TreeNode lca2 = solver.lca(9, 11);
		assertEquals(lca2.index(), 0);
	}
}