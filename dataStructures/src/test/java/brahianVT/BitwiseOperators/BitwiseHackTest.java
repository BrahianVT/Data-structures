package brahianVT.BitwiseOperators;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BitwiseHackTest {
	private BitwiseHack test;
	
	@BeforeEach
	public void setup(){
		test = new BitwiseHack();
	} 

	@Test
	public void testCountBit(){
		int val = 5;
		assertEquals(2, test.countBit(val));
		
		assertEquals(1, test.countBit(2));
	}
	
	@Test
	public void nextPowerOfTwo(){
		int val = 5;
		assertEquals(8, test.nextPowerOfTwo(val));
		
		assertEquals(2048, test.nextPowerOfTwo(1025));
	}
	
	@Test 
	public void swap(){
		int a = 1, b = 5;
		assertEquals("5,1", test.swap(1,5));
		
		assertEquals("10,56", test.swap(56,10));
	}
	
	@Test
	public void absoluteValue(){
		int a = -24;
		assertEquals(24, test.absoluteValue(a));
		assertEquals(34634, test.absoluteValue(-34634));		
	}
}