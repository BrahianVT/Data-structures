
package brahianVT.heap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import brahianVT.heap.Heap;
import java.util.List;
import java.util.ArrayList;

public class HeapTest{
	
	private Heap<Integer> test;
	@BeforeEach
	public void setup(){
		test = new Heap<>();
	}
	
	@Test
	public void createAndAdd (){
		
		test.add(4);
		assertEquals(test.poll(), 4);
	}
	
	@Test
	public void add (){
		
		test.add(4);
		test.add(8);
		test.add(10);
		assertEquals(4, test.peek());
		
		assertEquals(test.size(), 3);
	}
	
	@Test
	public void addAndDelete(){
		test.add(4);
		test.add(8);
		test.add(10);
		test.add(1);
		
		assertEquals(1, test.peek());
		
		assertEquals(1, test.poll());
		assertEquals(4, test.poll());
		assertEquals(test.size(), 2);
		
		test.poll(); test.poll();
		
		assertEquals(test.size(), 0);
	}
	
	@Test 
	public void remove(){
		test.add(4);
		test.add(8);
		
		assertTrue(test.remove(8));
		assertEquals(test.size(), 1);
		
		test.add(10);
		test.add(1);
		
		assertEquals(test.size(), 3);
		
		assertTrue(test.remove(10));
		
		assertEquals(test.poll(), 1);
		
		test.clear();
		assertEquals(test.size(), 0);	
	}
	
	@Test 
	public void secondConstructor(){
		Integer [] input =  new Integer[6];
		input[0] = 5; input[1] = 3;
		input[2] = 6; input[3] = 5;
		input[4] = 23; input[5] = 1;
		Heap<Integer> test = new Heap<>(input); 
		
		assertEquals(test.size(), 6);
		
		assertEquals(1, test.peek());
		assertEquals(1, test.poll());
		
		assertTrue(test.remove(6));
		
		test.poll(); test.poll();
		test.poll();
		
		assertEquals(23, test.peek());
	}
}