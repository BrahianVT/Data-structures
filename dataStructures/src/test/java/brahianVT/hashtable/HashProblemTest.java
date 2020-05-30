package brahianVT.hashtable;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import brahianVT.hashtable.HashProblem;

class HashProblemTest{
	
	private HashProblem test;
	
	@BeforeEach
	public void setup(){
		test = new HashProblem();
	}
	
	@Test
	public void test(){
		int[] a = new int[0];
		int[] b = new int[0];
		
		int[] res = new int[2];
		assertArrayEquals(res, test.getSwap(a, b));
		
	}

	@Test
	public void test1() {
		
		int[] a = {1,1};
		int[] b = {2,2};
		
		int[] res = {1,2};
		assertArrayEquals(res, test.getSwap(a, b));
	}
	
	@Test
	public void test2() {
		int[] a = {1,2};
		int[] b = {2,3};
		
		int[] res = {2,3};
		assertArrayEquals(res, test.getSwap(a, b));
	}
	@Test
	public void test3() {
		int[] a = {2};
		int[] b = {1,3};
		
		int[] res = {2,3};
		assertArrayEquals(res, test.getSwap(a, b));
	}
	@Test
	public void test4() {
		int[] a = {1,2,5};
		int[] b = {2,4};
		
		int[] res = {5,4};
		assertArrayEquals(res, test.getSwap(a, b));
	}
	@Test
	public void test5() {
		int[] a = {1,1,2,5,3};
		int[] b = {3,2,4,1};
		
		int[] res = {3,2};
		assertArrayEquals(res, test.getSwap(a, b));
	}
}