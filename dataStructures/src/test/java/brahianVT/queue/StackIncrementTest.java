
package brahianVT.queue;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.Arrays;
import brahianVT.stack.StackIncrement;

public class StackIncrementTest{

	StackIncrement test;
	
	@Test
	public void empty(){
		int maxSize = 0;
		test = new StackIncrement(0);
		test.push(3);
		
		assertEquals(-1, test.pop());
	}
	
	@Test
	public void  test1(){
		int maxSize = 3;
		test = new StackIncrement(maxSize);
		
		test.push(3);
		assertEquals(3, test.pop());
		
		test.push(4);
		assertEquals(4, test.pop());
		
		test.push(5);
		assertEquals(5, test.pop());
	}
	
		@Test
	public void  test2(){
		int maxSize = 5;
		test = new StackIncrement(maxSize);
		
		test.push(3);
		test.push(4);
		test.push(5);
		test.push(6);
		test.push(7);
		test.push(8);
	
		assertEquals(7, test.pop());
		assertEquals(6, test.pop());
		assertEquals(5, test.pop());
		
		test.increment(3, 10);
		
		assertEquals(14, test.pop());
		assertEquals(13, test.pop());
		assertEquals(-1, test.pop());
		
	}
	
	@Test
	public void  test3(){
		int maxSize = 8;
		test = new StackIncrement(maxSize);
		
		test.push(3);
		test.push(4);
		test.push(5);
		test.push(6);
		test.push(7);
		test.push(8);
		test.push(7);
		test.push(9);
	
		test.increment(23, 100);
	
		assertEquals(109, test.pop());
		assertEquals(107, test.pop());
		assertEquals(108, test.pop());
		
		test.push(5);
		test.push(1);
		test.push(9);
		
		test.pop(); test.pop(); test.pop();
		
		
		assertEquals(107, test.pop());
		
		test.pop(); test.pop(); test.pop();
		test.pop(); test.pop(); test.pop();
		
		assertEquals(-1, test.pop());
		
	}
}