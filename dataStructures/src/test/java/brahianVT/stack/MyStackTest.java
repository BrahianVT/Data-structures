package brahianVT.stack;

import brahianVT.stack.MyStack;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

public class MyStackTest{
	
	MyStack<Integer> stack = null;
	
	@BeforeEach
	public void setup(){
		stack = new MyStack<>();
	}

	@Test
	public void testEmptyStack(){
		assertTrue(stack.isEmpty());
	}

	@Test
	public void test1(){
		stack.push(5);
		assertEquals(1, stack.size());
	}
	
	@Test
	public void test2(){
		stack.push(10); stack.push(2); stack.push(7); stack.push(6);
		assertEquals(6, stack.peek());
		
		stack.pop(); 
		assertEquals(7 , stack.pop());
		assertEquals(2, stack.size());
	}
	
	@Test
	public void testIterator(){
		stack.push(1); stack.push(26); stack.push(71); stack.push(6);
		
		java.util.Iterator<Integer> iterar = stack.iterator();
		MyStack<Integer> stack2 = new MyStack<>();
		while(iterar.hasNext()){
				Integer index = iterar.next();
				stack2.push(index);
		}
		
		assertEquals(stack.peek(), stack2.peek());
		
	}
}