package brahianVT.stack;

import brahianVT.stack.FindMinElement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;


public class FindMinElementTest{
	FindMinElement test;
	
	@BeforeEach
	public void setup(){
		test = new FindMinElement();
	}
	
	@Test
	public void stackEmpty(){
		assertEquals(test.pop(), -1);
	}
	
	@Test
	public void stack1(){
		test.push(1); test.push(2); test.push(3); test.push(4);
		assertEquals(test.pop(), 4);
		assertEquals(test.findMin(), 1);
	}
	
	@Test
	public void stack2(){
		test.push(4); test.push(3); test.push(2); test.push(1);
		assertEquals(test.findMin(), 1);
		
		assertEquals(test.pop(), 1);
		assertEquals(test.findMin(), 2);
	}
}