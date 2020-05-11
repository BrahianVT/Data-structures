
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;

import brahianVT.queue.QueueV;

public class QueueTest{
		QueueV<Integer> queue = null;
	
	@BeforeEach
	public void setup(){
		queue = new QueueV<>();
	}
	
	@Test
	public void testNullCases(){
		assertAll("Testing RuntimeException with a empty queue ",
			() -> assertThrows(RuntimeException.class, () -> queue.peek()),
			() -> assertThrows(RuntimeException.class, () -> queue.poll()),
			() -> assertThrows(RuntimeException.class, () -> new QueueV(-10))
		);
	}
	
	@Test
	public void testEmptyQueue(){
		assertTrue(queue.isEmpty());
		assertEquals(queue.size(),0);
	}
	
	@Test 
	void testAdd(){
		queue.add(new Integer(10));
		assertEquals(1, queue.size());
	}
	
	@Test
	void  testAdd2(){
		queue.add(new Integer(10)); queue.add(new Integer(2));
		queue.add(new Integer(11)); queue.add(new Integer(61));
		assertEquals(4, queue.size());
		
		java.util.Iterator<Integer> iterar = queue.iterator();
		
		while(iterar.hasNext()){
			Integer index = iterar.next();
			System.out.print(" " + index);
		}
		assertEquals(10, queue.peek());
		
		assertEquals(10, queue.poll());
		assertEquals(3, queue.size());
	}
	
	@Test
	public void testIterator(){
		queue.add(new Integer(11));
		queue.add(new Integer(-33));
		queue.add(new Integer(356));
		queue.add(new Integer(578));
		queue.add(new Integer(605));
		
		java.util.Iterator<Integer> iterar = queue.iterator();
		QueueV<Integer> queue2 = new QueueV<>();
		
		while(iterar.hasNext()){
			Integer index = iterar.next();
			queue2.add(index);
		}
		
		assertEquals(queue.peek(), queue2.peek());
		
		assertEquals(queue.size(), queue2.size());
	}
}