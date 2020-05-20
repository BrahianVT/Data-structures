package brahianVT.stack;

import brahianVT.stack.NextLargerElement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class NextLargerElementTest{

	NextLargerElement test;

	@BeforeEach
	public void setup(){
		test = new NextLargerElement();
	}	
	
	@Test
	public void testEmptyArray(){
		int[] array = new int[0];
		assertArrayEquals(array, test.findNextLargerElement(array));
	}
	
	@Test
	public void testSuccess(){
		int[] array = {1,3,2,4};
		int[] expectedOutput = {3,4,4,-1};
		assertArrayEquals(expectedOutput, test.findNextLargerElement(array));
	}
	
	@Test
	public void testSuccess2(){
		int[] array = {4,3,2,1};
		int[] expectedOutput = {-1,-1,-1,-1};
		assertArrayEquals(expectedOutput, test.findNextLargerElement(array));
	}
	
	@Test
	public void testSuccess3(){
		int[] array = {4,3,2,1,2,3,4,5,6,7};
		int[] expectedOutput = {5,4,3,2,3,4,5,6,7,-1};
		assertArrayEquals(expectedOutput, test.findNextLargerElement(array));
	}
}