
package brahianVT.binaryTree;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import brahianVT.binaryTree.BST;

public class BSTTest {
	
	BST test;
	
	@BeforeEach
	public void setup(){
		test = new BST();
	}
	
	@Test
	public void addOne(){
		
		boolean result = test.add(4);
		assertTrue(result);	
	}

	@Test
	public void adding(){
		
		boolean result = test.add(7);
		assertTrue(result);	
		
		boolean result2 = test.add(39);
		assertTrue(result2);	
		
		boolean result3 = test.add(1);
		assertTrue(result3);	
		
		boolean result4 = test.add(1);
		assertFalse(result4);	
		
		assertEquals(3, test.size());
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
		
		test.printPreOrder(test.getRoot());
		
		assertEquals(" 5 3 1 7 6 8", out.toString());
		System.setOut(streamTest);
	}
	
	@Test 
	public void inOrder(){
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
		
		test.printInOrder(test.getRoot());
		
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
		
		test.printPostOrder(test.getRoot());
		
		assertEquals(" 1 3 6 8 7 5", out.toString());
		System.setOut(streamTest);
	}

	@Test 
	public void preOrder2(){		
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
		
		test.printPreOrder2();
		
		assertEquals("5 3 1 7 6 8 ", out.toString());
		System.setOut(streamTest);
	}
	
	@Test 
	public void inOrder2(){
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
		
		test.printInOrder2();
		
		assertEquals("1 3 5 6 7 8 ", out.toString());
		System.setOut(streamTest);
	}
	
	@Test 
	public void postOrder2(){
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
		
		test.printPostOrder2();
		
		assertEquals("1 3 6 8 7 5 ", out.toString());
		System.setOut(streamTest);
	}
	
	@Test 
	public void printLevelOrder(){		
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
		
		test.printLevelOrder();
		
		assertEquals(" 5 3 7 1 6 8", out.toString());
		System.setOut(streamTest);
	}
}