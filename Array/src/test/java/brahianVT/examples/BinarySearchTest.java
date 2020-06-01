import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import brahianVT.examples.BinarySearch;


public class BinarySearchTest{
	
	
	@Test
	public void emptyArray(){
		int array[] = new int[0];
		BinarySearch test = new BinarySearch();
		
		assertEquals(-1, test.binarySearch(array, 1));
		assertEquals(-1, test.binarySearchR(array, 1, 0, 0));
	}
		
	@Test
	public void testOneElement(){
		int array[] = {4};
		BinarySearch test = new BinarySearch();
		int k = 4;
		assertEquals(0, test.binarySearch(array, k));	
		assertEquals(0, test.binarySearchR(array, k, 0, array.length-1));
	}
	
	@Test
	public void test1(){
		int array[] = {1,2,3,4,4};
		BinarySearch test = new BinarySearch();
		int k = 3;
		assertEquals(2, test.binarySearch(array, k));	
		assertEquals(2, test.binarySearchR(array, k, 0, array.length-1));
	}
	
	@Test
	public void test2(){
		int array[] = {1,2,3,5,7,10};
		BinarySearch test = new BinarySearch();
		int k = 7;
		assertEquals(4, test.binarySearch(array, k));	
		assertEquals(4, test.binarySearchR(array, k, 0, array.length-1));
	}
	
	@Test
	public void test3(){
		int array[] = {1,2,3,5,7,10};
		BinarySearch test = new BinarySearch();
		int k = 10;
		assertEquals(5, test.binarySearch(array, k));	
		assertEquals(5, test.binarySearchR(array, k, 0, array.length-1));
	}
	
	@Test
	public void test4(){
		int array[] = {1,2};
		BinarySearch test = new BinarySearch();
		int k = 2;
		assertEquals(1, test.binarySearch(array, k));	
		assertEquals(1, test.binarySearchR(array, k, 0, array.length-1));
	}
	
	@Test
	public void test5(){
		int array[] = {1,2,3,5,7,10,11,12};
		BinarySearch test = new BinarySearch();
		int k = 3;
		assertEquals(2, test.binarySearch(array, k));	
		assertEquals(2, test.binarySearchR(array, k, 0, array.length-1));
	}
}