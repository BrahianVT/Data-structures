
package TreeTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import brahianVT.tree.Tree;

public class TreeTest {
	
	Tree<Integer> test;
	
	@BeforeEach
	public void setup(){
		test = new Tree<>();
	}
	
	@Test
	public void addOne(){
		
		Tree<Integer> add = new Tree<Integer>(10);
		Tree<Integer> one = test.addChild(add);
		assertEquals(10, one.getData());
	}
	
	@Test 
	public void adding(){
		
		Tree<Integer> add = new Tree<Integer>(10);
		Tree<Integer> one = test.addChild(add);
		
		assertEquals(10, one.getData());
		
		Tree<Integer> two = test.addChild(new Tree(5));
		assertEquals(5, two.getData());
		
		Tree<Integer> three = test.addChild(new Tree(20));
		assertEquals(20, three.getData());
	}
	
	@Test 
	public void addingDeleting(){
		
		Tree<Integer> one = test.addChild(new Tree(10));
		Tree<Integer> two = test.addChild(new Tree(5));
		Tree<Integer> three = test.addChild(new Tree(20));
		
		
		assertEquals(3, test.getChildren().size());
		
		
		three.removeChild();
		assertEquals(2, test.getChildren().size());
		
		two.removeChild();
		assertEquals(1, test.getChildren().size());
		
		one.removeChild();
		assertEquals(0, test.getChildren().size());
		
	}
	
	@Test 
	public void removeAllLeafNodes(){
		Tree<Integer> root = new Tree(1);
			
		Tree<Integer> child1 = root.addChild(new Tree(2));
		Tree<Integer> child2 = root.addChild(new Tree(3));
		Tree<Integer> child3 = root.addChild(new Tree(4));
		Tree<Integer> child4 = child2.addChild(new Tree(5));
								
		assertEquals(3,root.getChildren().size());
		

		assertEquals(1,child2.getChildren().size());
		
		root.removeAllLeafNode();

		assertEquals(1,root.getChildren().size());
		
		root.removeChild();
		
		assertEquals(3, child2.getData());
		
		assertEquals(null, child2.getParent());
	
	}
}