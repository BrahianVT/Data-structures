
package brahianVT.examples;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import brahianVT.examples.MaximumArea;
public class MaximumAreaTest{
	
	MaximumArea  test;

	@BeforeEach
	public void setup(){ test = new MaximumArea(); }
	
	@Test
	public void testNoElements(){
		int array[] = new int[0];
		assertEquals(test.findMaximumArea(array), 0);
	}
	
	@Test public void testSuccess(){
		int array[] = {1,8,6,2,5,4,8,3,7};
		assertEquals(test.findMaximumArea(array), 49);
	}
	
	@Test public void testSuccess2(){
		int array[] = {4,3,2,30,30,2,3,4};
		assertEquals(test.findMaximumArea(array), 30);
	}
	
	@Test public void testSuccess3(){
		int array[] = {4,3,2,1,1,2,30,30};
		assertEquals(test.findMaximumArea(array), 30);
	}
	
	@Test public void testSuccess4(){
		int array[] = {4,3,2,1,1,2,45,30};
		assertEquals(test.findMaximumArea(array), 30);
	}
	
	@Test public void testSuccess5(){
		int array[] = {100,100,2,1,1,2,2,2};
		assertEquals(test.findMaximumArea(array), 100);
	}
	
	@Test public void testSuccess6(){
		int array[] = {1,1};
		assertEquals(test.findMaximumArea(array), 1);
	}
	
	@Test public void testSuccess7(){
		int array[] = {1,9,2,1};
		assertEquals(test.findMaximumArea(array), 3);
	}
	
		@Test public void testOneelement(){
		int array[] = {1};
		assertEquals(test.findMaximumArea(array), 0);
	}
}