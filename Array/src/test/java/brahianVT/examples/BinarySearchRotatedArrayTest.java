
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import brahianVT.examples.BinarySearchRotatedArray;

public class BinarySearchRotatedArrayTest{
	

	@Test
	public void basicSuccess(){
		int array[] = {1,2,3,4,5,6};
		BinarySearchRotatedArray test = new BinarySearchRotatedArray(array, 3);
		assertEquals(2, test.findElement());
	}
	
	@Test
	public void test(){
		int array[] = {6,1,2,3,4,5};
		BinarySearchRotatedArray test = new BinarySearchRotatedArray(array, 6);
		assertEquals(0, test.findElement());
	}	
	
	@Test
	public void test2(){
		int array[] = {5,6,1,2,3,4};
		BinarySearchRotatedArray test = new BinarySearchRotatedArray(array, 1);
		assertEquals(2, test.findElement());
	}	
	
	@Test
	public void test3(){
		int array[] = {1,2};
		BinarySearchRotatedArray test = new BinarySearchRotatedArray(array, 1);
		assertEquals(0, test.findElement());
	}	
	@Test
	public void test4(){
		int array[] = {1,2};
		BinarySearchRotatedArray test = new BinarySearchRotatedArray(array, 2);
		assertEquals(1, test.findElement());
	}

	@Test
	public void test5(){
		int array[] = new int[0];
		BinarySearchRotatedArray test = new BinarySearchRotatedArray(array, 2);
		assertEquals(-1, test.findElement());
	}	
	
	@Test
	public void test6(){
		int array[] = {10,24,40,1,2};
		BinarySearchRotatedArray test = new BinarySearchRotatedArray(array, 40);
		assertEquals(2, test.findElement());
	}	

		@Test
	public void test7(){
		int array[] = {10};
		BinarySearchRotatedArray test = new BinarySearchRotatedArray(array, 1);
		assertEquals(-1, test.findElement());
	}	
}