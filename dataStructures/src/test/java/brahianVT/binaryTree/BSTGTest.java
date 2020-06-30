
package brahianVT.binaryTree;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import brahianVT.binaryTree.BSTG;

public class BSTGTest{
	
	BSTG<Integer> test;
	
	@BeforeEach
	public void setup(){
		test = new BSTG();
	}
	
	@Test
	public void addOne(){
		
		Integer result = test.add(4);
		assertEquals(4, result);	
	}
	
	@Test
	public void adding(){
		
		Integer result = test.add(4);
		assertEquals(4, result);	
		
		Integer result2 = test.add(6);
		assertEquals(6, result2);	
		Integer result3 = test.add(1);
		assertEquals(1, result3);	
		Integer result4 = test.add(9);
		assertEquals(9, result4);	
		
		assertEquals(4, test.size());
	}
	
	@Test
	public void find(){
		
		test.add(7);
		test.add(39);
		test.add(1);
		
		boolean res1 = test.find(7);
		assertTrue(res1);
		
		boolean res2 = test.find(1);		
		assertTrue(res2);
		
		boolean res3 = test.find(3);		
		assertFalse(res3);
	}	
	
	@Test
	public void remove(){
		
		test.add(7);
		test.add(39);
		test.add(1);
		
		boolean res1 = test.remove(7);
		assertTrue(res1);
		
		boolean res2 = test.remove(1);		
		assertTrue(res2);
		
		boolean res3 = test.remove(3);		
		assertFalse(res3);
		
		assertEquals(1, test.size());
	}	
	
	@Test
	public void height(){
		test.add(7);
		test.add(39);
		test.add(1);
		
		assertEquals(2, test.height());
	
	}
	
	@Test 
	public void preOrder(){
		ByteArrayOutputStream out = null;
		PrintStream streamTest = System.out;
		test.add(5);
		test.add(7);
		test.add(3);
		test.add(1);
		test.add(6);
		test.add(8);
		
		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		java.util.Iterator<Integer> preOrder = test.preOrderTraversal();
		
		while(preOrder.hasNext()){
			System.out.print(" " + preOrder.next());
		}
		
		assertEquals(" 5 3 1 7 6 8", out.toString());
		System.setOut(streamTest);
	}
	
		@Test 
	public void inOrderTraversal(){
		ByteArrayOutputStream out = null;
		PrintStream streamTest = System.out;
		test.add(5);
		test.add(7);
		test.add(3);
		test.add(1);
		test.add(6);
		test.add(8);
		
		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		java.util.Iterator<Integer> inOrder = test.inOrderTraversal();
		
		while(inOrder.hasNext()){
			System.out.print(" " + inOrder.next());
		}
		
		assertEquals(" 1 3 5 6 7 8", out.toString());
		System.setOut(streamTest);
	}
	
	@Test 
	public void postOrder(){
		ByteArrayOutputStream out = null;
		PrintStream streamTest = System.out;
		test.add(5);
		test.add(7);
		test.add(3);
		test.add(1);
		test.add(6);
		test.add(8);
		
		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		java.util.Iterator<Integer> postOrder = test.postOrderTraversal();
		
		while(postOrder.hasNext()){
			System.out.print(" " + postOrder.next());
		}
		
		assertEquals(" 1 3 6 8 7 5", out.toString());
		System.setOut(streamTest);
	}
	
	@Test 
	public void levelOrder(){
		ByteArrayOutputStream out = null;
		PrintStream streamTest = System.out;
		test.add(5);
		test.add(7);
		test.add(3);
		test.add(1);
		test.add(6);
		test.add(8);
		
		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		java.util.Iterator<Integer> levelOrder = test.levelOrderTraversal();
		
		while(levelOrder.hasNext()){
			System.out.print(" " + levelOrder.next());
		}
		
		assertEquals(" 5 3 7 1 6 8", out.toString());
		System.setOut(streamTest);
	}
	
}