package brahianVT.queue;
import brahianVT.queue.MyQueue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;


public class MyQueueTest{
	
	MyQueue<Integer> queue = null;
	
	@BeforeEach
	public void setup(){
		queue = new MyQueue<>();
	}
	
	@Test
	public void testNullCases(){
		assertAll("Testing RuntimeException with a empty queue ",
			() -> assertThrows(RuntimeException.class, () -> queue.peek()),
			() -> assertThrows(RuntimeException.class, () -> queue.poll())
		);
	}
	
	@Test
	public void testEmptyQueue(){
		assertTrue(queue.isEmpty());
		assertEquals(queue.size(),0);
	}
	
	@Test 
	void testAdd(){
		queue.add(10);
		assertEquals(1, queue.size());
	}
	
	@Test
	void  testAdd2(){
		queue.add(10); queue.add(2);
		queue.add(11);  queue.add(45);
		assertEquals(4, queue.size());
		
		assertEquals(10, queue.peek());
		
		assertEquals(10, queue.poll());
		assertEquals(3, queue.size());
	}
	
	@Test
	public void testIterator(){
		queue.add(-3); queue.add(-304); queue.add(235);
		queue.add(-2);queue.add(-2);
		
		java.util.Iterator<Integer> iterar = queue.iterator();
		MyQueue<Integer> queue2 = new MyQueue<>();
		
		while(iterar.hasNext()){
			Integer index = iterar.next();
			queue2.add(index);
		}
		
		assertEquals(queue.peek(), queue2.peek());
		
		assertEquals(queue.size(), queue2.size());
	}
}