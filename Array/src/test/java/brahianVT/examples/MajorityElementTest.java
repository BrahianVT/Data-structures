//
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import brahianVT.examples.MajorityElement;

public class MajorityElementTest{
	
	@Test
	public void testMajorityNotFound(){
		int[] array = {1111,1,2,3,4};
		MajorityElement test = new MajorityElement(array);
		assertEquals(-1, test.findMajority());
	}
	
	@Test
	public void testsuccess(){
		int[] array = {1,1,1,2,2,1,1,1};
		MajorityElement test = new MajorityElement(array);
		assertEquals(1, test.findMajority());
	}
	
	@Test
	public void testsuccess2(){
		int[] array = {1,2,1};
		MajorityElement test = new MajorityElement(array);
		assertEquals(1, test.findMajority());
	}
	
		@Test
	public void testsuccess3(){
		int[] array = {1,0,0,1,1};
		MajorityElement test = new MajorityElement(array);
		assertEquals(1, test.findMajority());
	}
	
	@Test
	public void testNotFound(){
		int[] array = new int[0];
		MajorityElement test = new MajorityElement(array);
		assertEquals(-1, test.findMajority());
	}
	
	@Test
	public void testsuccess4(){
		int[] array = {1,2,1,3,1,4,1,1};
		MajorityElement test = new MajorityElement(array);
		assertEquals(1, test.findMajority());
	}
}
